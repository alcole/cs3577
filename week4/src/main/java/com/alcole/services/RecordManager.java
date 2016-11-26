package com.alcole.services;

import com.alcole.model.Record;

/**
 * Created by alex on 26/11/16.
 */
public interface RecordManager {

    Record put(Record record);

    Record get(Long id);

    Record remove(Long id);
}
