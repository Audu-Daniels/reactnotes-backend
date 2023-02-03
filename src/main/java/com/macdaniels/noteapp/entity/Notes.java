package com.macdaniels.noteapp.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="tbl_note")
@Data
public class Notes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String body;
    private String category;

}
