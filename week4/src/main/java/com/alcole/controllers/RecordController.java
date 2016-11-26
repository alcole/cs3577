package com.alcole.controllers;

import com.alcole.model.Record;
import com.alcole.services.RecordManager;

import org.springframework.beans.factory.annotation.Autowired;
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


/**
 * Created by alex on 19/11/16.
 */
@RestController
public class RecordController {

    @Autowired
    private RecordManager recordManager;

    public RecordController() {
            }

    @Async
    @RequestMapping(value = "/{recordId}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Record getRecord(@PathVariable Long recordId) {
        return recordManager.get(recordId);
    }

    @Async
    @RequestMapping(value = "/{recordId}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteRecord(@PathVariable Long recordId) {
        recordManager.remove(recordId);
    }

    @Async
    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public void create(@RequestBody Record recordBody) {
        recordManager.put(recordBody);
    }
}
