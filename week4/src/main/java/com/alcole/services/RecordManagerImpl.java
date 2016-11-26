package com.alcole.services;

import com.alcole.model.Record;
import com.alcole.services.IdGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by alex on 25/11/16.
 */
@Service
public class RecordManagerImpl implements RecordManager{

    private Map<Long, Record> records;
    private IdGenerator idGenerator = IdGenerator.getInstance();

    public RecordManagerImpl() {
        try {
            records = LoadRecords.readRecords();
        }
        catch (IOException e) {
            System.out.println("failed to load" + e);
        }
//        try {
//            LoadRecords.readRecords(records);
//        }
//        catch {
//        put(Record.builder().title("album1").artist("bad seeds").releaseYear(1999).build());
        //this.put(Record.builder().title("album2").artist("gun club").releaseYear(1984).build());
    }

     public Record put(Record record) {
         return records.put(idGenerator.getId(), record);
     }

     public Record get(Long id) {
         return records.get(id);
     }

     public Record remove(Long id) {
         return records.remove(id);
     }


}
