package com.herokuapi001.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller

public class HelloControlClass {

    @GetMapping("/first") @ResponseBody public String first() {
        return "hello world, yall motherfuckers";
    }



}
