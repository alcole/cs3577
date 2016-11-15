package com.alcole.challenge;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


import static java.util.Comparator.comparing;


/**
 * Created by alex on 05/11/16.
 */
public class Challenge {

    public static void main(String[] args) throws IOException {
        ArrayList<PersonRecord> people = ReadPeople.getPerson(ReadPeople.getInput());
        PersonList.printPeople(PersonList.sortedByCountry(people));
        System.out.println();
        System.out.println("Printing a reduced field list, comma separated");
        PersonList.reducedFieldList(people);
    }
}
