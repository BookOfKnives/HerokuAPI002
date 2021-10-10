package com.herokuapi001.Controllers;

import com.herokuapi001.model.PenModelClass;
import com.herokuapi001.repository.PenRepositoryClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//startet 1010 2021
//sidst 1010 2021
@RestController
public class PenControllerClass {

    @Autowired
    PenRepositoryClass penRepositoryClassInstance;

    @GetMapping(value={"/index", "/", "/first"}) @ResponseBody
    public String first() {
        return "hello world, yall motherfuckers";
    }
    @GetMapping("/pen") public Iterable<PenModelClass> pens() {
        return penRepositoryClassInstance.findAll();
    }

    @PostMapping("/pen")
    public PenModelClass makeNewPenEntryInPenDb(@RequestBody PenModelClass penToCreate){
        return penRepositoryClassInstance.save(penToCreate);
    }

}
