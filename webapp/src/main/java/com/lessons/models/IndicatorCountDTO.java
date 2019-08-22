package com.lessons.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class IndicatorCountDTO {
    @JsonProperty("total")  //TODO: This property is how you can rename what the Frontend sees on the front in the Json
    private int total_records;

    public int getTotal_records() {
        return total_records;
    }

    public void setTotal_records(int total_records) {
        this.total_records = total_records;
    }
}
