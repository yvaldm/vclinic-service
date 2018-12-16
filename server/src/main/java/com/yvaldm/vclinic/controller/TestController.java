package com.yvaldm.vclinic.controller;

import com.yvaldm.vclinic.api.SampleResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/test")
    public SampleResponse test() {
        return new SampleResponse("some");
    }
}
