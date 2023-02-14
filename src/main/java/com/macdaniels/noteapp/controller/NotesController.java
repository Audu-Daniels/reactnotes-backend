package com.macdaniels.noteapp.controller;


import com.macdaniels.noteapp.entity.Notes;
import com.macdaniels.noteapp.repository.NotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class NotesController {

 @Autowired
    NotesRepository notesRepository;

    @GetMapping("/notes")
    public ResponseEntity<List<Notes>> readNotes(){
return new ResponseEntity<List<Notes>>(notesRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping("/notes")
    public ResponseEntity<Notes> createNote(@RequestBody Notes notes) {
        return new ResponseEntity<Notes>(notesRepository.save(notes), HttpStatus.CREATED);
    }
    @GetMapping("/notes/{id}")
    public ResponseEntity<Notes> readNote(@PathVariable Long id) {
    return new ResponseEntity<Notes>(notesRepository.findById(id).get(), HttpStatus.OK);
    }

    @DeleteMapping("/notes/{id}")
    public ResponseEntity<HttpStatus> deleteNote(@PathVariable Long id) {
        notesRepository.deleteById(id);
        return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
    }
    @PutMapping("/notes")
    public ResponseEntity<Notes> updateNote(@RequestBody Notes notes) {
       return new ResponseEntity<Notes>(notesRepository.save(notes), HttpStatus.OK);
    }
}
