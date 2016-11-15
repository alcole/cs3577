package com.alcole.challenge;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

/**
 * Created by alex on 15/11/16.
 */
class PersonList {

    static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("d/MM/yyyy");

    private List<PersonRecord> people;

    PersonList() {
        people = new ArrayList<>();
    }

    boolean add(PersonRecord Person) {
        return this.add(Person);
    }
    /**
     * Ordered by country of origin
     *
     * @param people an ArrayList of Person Records
     * @return a List of PersonRecords sorted by the Country Field
     */
    static List<PersonRecord> sortedByCountry(ArrayList<PersonRecord> people) {
        return people.stream()
                .sorted(comparing(PersonRecord::getCountry))
                .collect(toList());
    }

    /**
     * Print out a new list
     * Where you print the name, surname and the age of the each person
     * Paris, Apostolopoulos, 29
     *
     * @param people an ArrayList of the PersonRecords
     */
    static void reducedFieldList(ArrayList<PersonRecord> people) {
        people.stream()
                .forEach(t -> System.out.println(Optional.of(t.getName()).orElse("unknown") +
                        ", " + Optional.of(t.getSurname()).orElse("unknown") +
                        ", " + Optional.of(Integer.toString(t.getAge())).orElse("unknown")));
    }

    /**
     * prints the header values and the actual values for
     * all people supplied in the list
     *
     * @param people a List of Person Records
     */
    static void printPeople(List<PersonRecord> people) {
        PersonRecord.printHeaders();
        people.forEach(PersonRecord::prettyPrint);
    }
}
