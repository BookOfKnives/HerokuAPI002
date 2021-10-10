package com.herokuapi001.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "pens")
@Entity
public class PenModelClass {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column @ApiModelProperty(name = "First swagger name in PenModel tekst.")
    private String penName;

    @Column
    private String color;

    public PenModelClass() {
    }

    public Long getId() {
        return id;
    }

    public String getPenName() {
        return penName;
    }

    public String getColor() {
        return color;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPenName(String penName) {
        this.penName = penName;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
