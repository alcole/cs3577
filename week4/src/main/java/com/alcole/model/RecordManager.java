package com.alcole.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Created by alex on 25/11/16.
 */
public class RecordManager {

    private Map<Long, Record> records;
    private IdGenerator idGenerator = com.alcole.model.IdGenerator.getInstance();

    public RecordManager() {
        records = new HashMap<>();
        //this.put(Record.builder().title("album1").artist("bad seeds").releaseYear(1999).build());
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
