package com.alcole.services;

import com.alcole.model.Record;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Created by alex on 25/11/16.
 */
public class LoadRecords {

    private static IdGenerator idGenerator = IdGenerator.getInstance();


    public static Map<Long, Record> readRecords() throws IOException {
        Map<Long, Record> records = new HashMap<>();
        try (Stream<String> lines = Files.lines(Paths.get("src/main/resources/recordData.txt"))) {
            lines.forEach(line -> {
                String[] fields = line.split(", ");
                records.put(idGenerator.getId(), Record.builder()
                        .title(fields[0])
                        .artist(fields[1])
                        .releaseYear(Integer.parseInt(fields[2]))
                        .songs(Arrays.asList(fields).subList(3, fields.length)).build());
            });
        } catch (IOException e) {
            System.out.println("records not loaded" + e);
        }

        return records;
    }

//    public static void main(String[] args) {
//        RecordManagerImpl records = new RecordManagerImpl();
//        try {
//            LoadRecords.readRecords(records);
//        }
//        catch (IOException e) {
//            System.out.println("Check data file" + e);
//        }
//        System.out.println(records.get(1L));
//        System.out.println(records.get(2L));
//        System.out.println(records.get(3L));
//    }
}
