package it.fra.test.model;

import java.net.URL;
import java.util.Set;

import lombok.Data;

@Data
public class TvSerie {

    private Long id;
    private URL url;
    private String name;
    private String language;
    private Set<String> genres;
    private URL officialSite;
    private String summary;
    
}
