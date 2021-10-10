package com.herokuapi001.Controllers;

import com.herokuapi001.model.PenModelClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.herokuapi001.repository.PenRepositoryClass;

//startet  1010 2021
//sidst 1010 2021
@Controller

public class HelloControlClass {

    @Autowired
    PenRepositoryClass penRepositoryClassInstance;

    @GetMapping("/first") @ResponseBody public String first() {
        return "hello world, yall motherfuckers";
    }




}
