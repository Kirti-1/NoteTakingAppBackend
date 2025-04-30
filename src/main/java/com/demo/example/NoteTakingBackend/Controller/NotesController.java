package com.demo.example.NoteTakingBackend.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.demo.example.NoteTakingBackend.Entity.Notes;
import com.demo.example.NoteTakingBackend.Response.NotesResponse;
import com.demo.example.NoteTakingBackend.Service.NotesService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/note")
public class NotesController{
	@Autowired
	NotesService noteService;
	
	@GetMapping("/list/{id}")
	public NotesResponse notesList(@PathVariable("id") int id) {
		return noteService.getNote(id);
	}
	
	@PutMapping("/list/{id}")
	public NotesResponse updateNote(@PathVariable("id") int id, @RequestBody Notes note) {
		return noteService.updateNote(id, note);
	}
	@DeleteMapping("/list/{id}")
	public String deleteNote(@PathVariable("id") int id) {
		return noteService.deleteNote(id);
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
