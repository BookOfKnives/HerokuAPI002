package com.herokuapi001.Controllers;

import com.herokuapi001.model.PenModelClass;
import com.herokuapi001.repository.PenRepositoryClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//startet 0910 2021
//sidst 1010 2021
@RestController
public class PenControllerClass {

    @Autowired
    PenRepositoryClass penRepositoryClassInstance;

    @GetMapping(value={"/index", "/", "/first"}) @ResponseBody
    public String first() {
        return "hello world, yall hjul, velkommen til Pen Server";
    }
    @GetMapping("/pen") public Iterable<PenModelClass> pens() {
        return penRepositoryClassInstance.findAll();
    }

    @PostMapping("/pen")
    public PenModelClass makeNewPenEntryInPenDb(@RequestBody PenModelClass penToCreate){
        return penRepositoryClassInstance.save(penToCreate);
    }

    @PutMapping("/pens/{id}")
    public String updatePenById(@PathVariable Long id,
                                @RequestBody PenModelClass penToUpdate) {
        if (penRepositoryClassInstance.existsById(id)) {
            penToUpdate.setId(id);
            penRepositoryClassInstance.save(penToUpdate);
            return "pen succesfully saved";
        }
        else return "Pen Not created succesful.";
    }

    @PatchMapping("/pens/{id}")
    public String patchPenById(@PathVariable Long id, @RequestBody PenModelClass penToUpdateWith) {
        return penRepositoryClassInstance.findById(id).map(foundPen -> {
            if (penToUpdateWith.getPenName() != null) foundPen.setPenName(penToUpdateWith.getPenName());
            if (penToUpdateWith.getColor() != null) foundPen.setColor(penToUpdateWith.getColor());

            penRepositoryClassInstance.save(foundPen);
            return "Penalhus updated";
        }).orElse("Penalhus not found");
    }
    @DeleteMapping("/pens/{id}")
    public String deletePenById(@PathVariable Long id) {
        if (penRepositoryClassInstance.existsById(id)) {
            penRepositoryClassInstance.deleteById(id);
            return "Pen Delete succesful at id: " + id;
        }
        return "Pen delete not succesful.";
    }
}
