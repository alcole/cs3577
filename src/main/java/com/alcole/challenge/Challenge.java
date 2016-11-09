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
import java.util.Optional;
import java.util.stream.Stream;


import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;


/**
 * Created by alex on 05/11/16.
 */
public class Challenge {

    static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("d/MM/yyyy");

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

    /**
     * read the lines and create an ArrayList of PeopleRecords
     * @param peopleLines List of lines of people information must not contain nulls
     * @return an ArrayList of PersonRecord read
     */
    public static ArrayList<PersonRecord> getPerson(List<String> peopleLines) {
        ArrayList<PersonRecord> people = new ArrayList<>();
        peopleLines.stream().forEach(line -> {
                    String[] field = line.split(", ");
                    people.add(new PersonRecord(field[0].trim(),
                            field[1].trim(),
                            LocalDate.parse(field[2].trim(), DATE_FORMAT),
                            field[3].trim(),
                            field[4].trim(),
                            field[5].trim()));
                }
        );
        return people;
    }

    /**
     * Ordered by country of origin
     *
     * @param people an ArrayList of Person Records
     * @return a List of PersonRecords sorted by the Country Field
     */
    public static List<PersonRecord> sortedByCountry(ArrayList<PersonRecord> people) {
        return people.stream()
                .sorted(comparing(PersonRecord::getCountry))
                .collect(toList());
    }

    /**
     * prints the header values and the actual values for
     * all people supplied in the list
     *
     * @param people a List of Person Records
     */
    public static void printPeople(List<PersonRecord> people) {
        PersonRecord.printHeaders();
        people.forEach(PersonRecord::prettyPrint);
    }

    /**
     * Print out a new list
     * Where you print the name, surname and the age of the each person
     * Paris, Apostolopoulos, 29
     *
     * @param people an ArrayList of the PersonRecords
     */
    public static void reducedFieldList(ArrayList<PersonRecord> people) {
        people.stream()
                .forEach(t -> System.out.println(Optional.of(t.getName()).orElse("unknown") +
                        ", " + Optional.of(t.getSurname()).orElse("unknown") +
                        ", " + Optional.of(Integer.toString(t.getAge())).orElse("unknown")));
    }

    public static void main(String[] args) throws IOException {
        ArrayList<PersonRecord> people = getPerson(getInput());
        printPeople(sortedByCountry(people));
        System.out.println();
        System.out.println("Printing a reduced field list, comma separated");
        reducedFieldList(people);
    }
}
