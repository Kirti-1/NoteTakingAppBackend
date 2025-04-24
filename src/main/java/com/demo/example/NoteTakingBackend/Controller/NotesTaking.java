package com.demo.example.NoteTakingBackend.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.demo.example.NoteTakingBackend.Entity.Notes;
import com.demo.example.NoteTakingBackend.Response.NotesResponse;
import com.demo.example.NoteTakingBackend.Service.NotesService;


@RestController
@RequestMapping("/note")
public class NotesTaking {
	@Autowired
	NotesService noteService;
	
	@GetMapping("/list/{id}")
	public NotesResponse notesList(@PathVariable("id") int id) {
		return noteService.getNote(id);
	}
	
	@PostMapping("/add")
	public NotesResponse addNote(@RequestBody Notes note) {
		return noteService.addNote(note);
	}
	
	@GetMapping("/lists")
	public NotesResponse getNotes(){
		return noteService.getNotes();
	}
	
	
	
	
	
}
