package com.alcole.controllers;

import com.alcole.model.LoadRecords;
import com.alcole.model.Record;
import com.alcole.model.RecordManager;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;


/**
 * Created by alex on 19/11/16.
 */
@RestController
public class RecordController {

    private RecordManager records;

    public RecordController() {
        records = new RecordManager();
        try {
            LoadRecords.readRecords(records);
        }
        catch (IOException e) {
            System.out.println("Check data file" + e);
        }


    }

    @Async
    @RequestMapping(value = "/{recordId}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Record getRecord(@PathVariable Long recordId) {
        return records.get(recordId);
    }

    @Async
    @RequestMapping(value = "/{recordId}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteRecord(@PathVariable Long recordId) {
        records.remove(recordId);
    }

    @Async
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public void create(@RequestBody Record recordBody) {
        records.put(recordBody);
    }
}
