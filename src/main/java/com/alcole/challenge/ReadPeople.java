package com.alcole.challenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * Created by alex on 15/11/16.
 */
class ReadPeople {

    static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("d/MM/yyyy");
    /**
     * read the lines and create an ArrayList of PeopleRecords
     * @param peopleLines List of lines of people information must not contain nulls
     * @return an ArrayList of PersonRecord read
     */
    public static ArrayList<PersonRecord> getPerson(List<String> peopleLines) {
        ArrayList<PersonRecord> people = new ArrayList<>();
        peopleLines.stream().forEach(line -> {
                    String[] field = line.split(", ");
                    people.add(PersonRecord.builder()
                            .name(field[0].trim())
                            .surname(field[1].trim())
                            .dob(LocalDate.parse(field[2].trim(), DATE_FORMAT))
                            .country(field[3].trim())
                            .city(field[4].trim())
                            .gender(field[5].trim()).build());
                }
        );
        return people;
    }

    /**
     * Read in data from the url and remove the header and blank lines
     * @return List of lines from the file read in over the url
     * @throws IOException
     */
    public static List<String> getInput() throws IOException {
        List<String> peopleLines;
        try (InputStream is =
                     new URL("https://raw.githubusercontent.com/javapapo/cs3577/master/week1/names.txt")
                             .openConnection()
                             .getInputStream()) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            Stream<String> stream = reader.lines();
            peopleLines = stream.skip(2).collect(toList());
        }
        return peopleLines;
    }
}
