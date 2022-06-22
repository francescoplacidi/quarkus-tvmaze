package it.fra.test.model;

import java.net.URL;

import lombok.Data;

@Data
public class Episode {

    private Long id;
    private URL url;
    private String name;
    private Integer season;
    private Integer number;
    private String summary;

}
