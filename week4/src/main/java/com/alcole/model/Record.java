package com.alcole.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by alex on 19/11/16.
 */
@Setter
@Getter
@Builder
@AllArgsConstructor
public class Record {

    private String title;
    private String artist;
    private int releaseYear;
    private List<String> songs;

}
