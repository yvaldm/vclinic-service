package com.yvaldm.vclinic.controller;

import com.yvaldm.vclinic.api.SampleResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for registration of new users
 *
 * @author valeryyakovlev
 */
@RestController
public class RegistrationController {

    @PostMapping("/registration/apply")
    public SampleResponse test() {
        return new SampleResponse("some");
    }

}
