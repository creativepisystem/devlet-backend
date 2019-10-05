package br.com.creative.devlet.query;

import javax.sql.DataSource;

public class QueryRepository <T> {
    private String query;
    protected void setQuery(String query){
        this.query = query;
    }
}
