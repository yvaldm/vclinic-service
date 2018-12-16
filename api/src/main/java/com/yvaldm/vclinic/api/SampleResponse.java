package com.yvaldm.vclinic.api;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * @author valeryyakovlev
 */
public class SampleResponse {

    private String result;

    @JsonCreator
    public SampleResponse(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }
}
