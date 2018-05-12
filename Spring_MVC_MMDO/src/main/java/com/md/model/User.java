package com.md.model;

import org.springframework.stereotype.Component;


@Component
public class User {

    private String cols;
    private String rows;

    public String getCols() {
        return cols;
    }

    public void setCols(String cols) {
        this.cols = cols;
    }

    public String getRows() {
        return rows;
    }

    public void setRows(String rows) {
        this.rows = rows;
    }
}
