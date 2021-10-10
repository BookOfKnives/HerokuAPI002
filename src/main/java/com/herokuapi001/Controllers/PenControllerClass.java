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
        return "hello world, yall hjul";
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

    //abandoned attempt at patch
//    @PatchMapping("/pens/{id}")
//    public ResponseEntity<PenModelClass> updatePenPartially(
//            @PathVariable Long id,
//            @RequestBody PenModelClass penDetails)
//           // throws ResourceNotFoundException
//    {
//        PenModelClass tempPenFetchedFromRepository = penRepositoryClassInstance.findById(id)
//                //.orElseThrow(() -> new ResourceNotFoundException("Pen not found on :: "+ id));
//                .orElse(ResponseEntity.badRequest(penDetails));
//
//        tempPenFetchedFromRepository.setColor(penDetails.getColor());
//        PenModelClass updatedPen = penRepositoryClassInstance.save(tempPenFetchedFromRepository);
//        return ResponseEntity.ok(updatedPen);
//    }
    @PatchMapping("/pens/{id}")
    public String patchGalleryById(@PathVariable Long id, @RequestBody PenModelClass penToUpdateWith) {
        return penRepositoryClassInstance.findById(id).map(foundPen -> {
            if (penToUpdateWith.getPenName() != null) foundPen.setPenName(penToUpdateWith.getPenName());
            if (penToUpdateWith.getColor() != null) foundPen.setColor(penToUpdateWith.getColor());

            penRepositoryClassInstance.save(foundPen);
            return "Penalhus updated";
        }).orElse("Penalhus not found");
    }
}
