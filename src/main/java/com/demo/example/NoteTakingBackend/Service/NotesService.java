package com.demo.example.NoteTakingBackend.Service;

import org.springframework.stereotype.Service;


import org.springframework.beans.factory.annotation.*;

import com.demo.example.NoteTakingBackend.Entity.Notes;
import com.demo.example.NoteTakingBackend.Repository.NotesRepository;
import com.demo.example.NoteTakingBackend.Response.NotesResponse;

@Service
public class NotesService {

	@Autowired
	NotesRepository noteRepo;
	public NotesResponse getNote(int id) {
		
		return noteRepo.getNote(id);
	}
	public NotesResponse addNote(Notes note) {
		return noteRepo.addNote(note);
	}
	public NotesResponse getNotes() {
		return noteRepo.getNotes();
	}
	public NotesResponse updateNote(int id, Notes note) {
		
		return noteRepo.updateNote(id, note);
	}
	public String deleteNote(int id) {
		return noteRepo.deleteNote(id);
	}

}
