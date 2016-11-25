package com.alcole.model;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Created by alex on 25/11/16.
 */
public class LoadRecords {


    public static void readRecords(RecordManager records) throws IOException {
        try (Stream<String> lines = Files.lines(Paths.get("src/main/resources/recordData.txt"))) {
            lines.forEach(line -> {
                String[] fields = line.split(", ");
                records.put(Record.builder()
                        .title(fields[0])
                        .artist(fields[1])
                        .releaseYear(Integer.parseInt(fields[2]))
                        .songs(Arrays.asList(fields).subList(3, fields.length)).build());
            });
        } catch (IOException e) {
        }

    }

    public static void main(String[] args) {
        RecordManager records = new RecordManager();
        try {
            LoadRecords.readRecords(records);
        }
        catch (IOException e) {
            System.out.println("Check data file" + e);
        }
        System.out.println(records.get(1L));
        System.out.println(records.get(2L));
        System.out.println(records.get(3L));
    }
}
