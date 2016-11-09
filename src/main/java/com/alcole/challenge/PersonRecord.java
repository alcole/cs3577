package com.alcole.challenge;

import java.time.LocalDate;
import java.time.Period;
import java.util.Optional;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by alex on 05/11/16.
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Builder
public class PersonRecord {

    private String name;
    private String surname;
    private LocalDate dob;
    private String country;
    private String city;
    private String gender;

    /**
     * prints out the header values in the display format
     */
    public static void printHeaders() {
        System.out.printf("%-15s %-15s %-15s %-15s %-15s %-15s \n",
                "Name", "Surname", "Date of Birth",
                "Country", "City", "Gender");
    }

    /**
     * prints the field values for a record in fixed width format
     */
    public void prettyPrint() {
        System.out.printf("%-15s %-15s %-15s %-15s %-15s %-15s \n",
                Optional.of(getName()).orElse("unknown"),
                Optional.of(getSurname()).orElse("unknown"),
                Optional.of(getDobString()).orElse("unknown"),
                Optional.of(getCountry()).orElse("unknown"),
                Optional.of(getCity()).orElse("unknown"),
                Optional.of(getGender()).orElse("unknown"));
    }

    /**
     * @return the age in years of the person, based on their date of birth
     */
    public int getAge() {
        return Period.between(this.getDob(), LocalDate.now()).getYears();
    }

    /**
     * @return Date of Birth formatted as a String d/M/yyyy
     */
    public String getDobString() {
        return this.dob.getDayOfMonth() + "/" +
                this.dob.getMonthValue() + "/" + this.dob.getYear();
    }

}
