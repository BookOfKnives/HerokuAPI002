package com.herokuapi001.repository;

import com.herokuapi001.model.PenModelClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PenRepositoryClass extends JpaRepository<PenModelClass, Long> {


    @Query(
            value="select * from  pen.pens where color = ?",
            nativeQuery = true
    )
    public List<PenModelClass> findPensByColor(String color);


}
