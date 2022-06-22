package it.fra.test.model;

import lombok.Data;

import java.net.URL;

@Data
public class Episode {

    private Long id;
    private URL url;
    private String name;
    private Integer season;
    private Integer number;
    private String summary;

}
