package com.demo.example.NoteTakingBackend.Repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.demo.example.NoteTakingBackend.DAO.NoteTakingJPA;
import com.demo.example.NoteTakingBackend.Entity.Notes;
import com.demo.example.NoteTakingBackend.Response.NotesResponse;
@Repository
public class NotesRepository {
	@Autowired
	NoteTakingJPA notejpa;

	@SuppressWarnings("deprecation")
	public NotesResponse getNote(int id) {

		if(notejpa.existsById(id)) {

			NotesResponse noteResponse = new NotesResponse();
			List<Notes> note = new ArrayList<>();
			note.add(notejpa.getById(id));
			noteResponse.setResult("success");
			noteResponse.setNotes(note);
			noteResponse.setResultMessage("Note successfully fetched!");
			return noteResponse;
		}

		NotesResponse noteResponse = new NotesResponse("failure",new ArrayList<Notes>(), "No such Note present, pass on valid note id.");
		return noteResponse;

	}

	public NotesResponse addNote(Notes note) {
		
		//add the note first
		notejpa.save(note);
		
		NotesResponse noteResponse = new NotesResponse();
		List<Notes> notes = new ArrayList<>();
		notes.add(note);
		noteResponse.setResult("success");
		noteResponse.setNotes(notes);
		noteResponse.setResultMessage("Note successfully added!");

		
		//return all the notes after adding
		return noteResponse;
		
	}

	public NotesResponse getNotes() {
		NotesResponse noteResponse = new NotesResponse();
		List<Notes> notes = new ArrayList<>(notejpa.findAll());
		noteResponse.setResult("success");
		noteResponse.setNotes(notes);
		noteResponse.setResultMessage("Notes successfully fetched!");

		
		//return all the notes after adding
		return noteResponse;
		
	}

	@Transactional
	public NotesResponse updateNote(int id, Notes note) {
		NotesResponse noteResponse = new NotesResponse();
		//update the note
//		notejpa.updateQuery(note.getSubjectLine(), note.getBody(), id);
		String subjectLine = note.getSubjectLine();
		String body = note.getBody();
		 Notes existingNote = notejpa.findById(id).orElseThrow(() -> new RuntimeException("Note not found"));

	        if (subjectLine != null) {
	            existingNote.setSubjectLine(subjectLine);
	        }
	        if (body != null) {
	            existingNote.setBody(body);
	        }

	        // After updating the entity fields, it will be automatically saved because the entity is managed by the persistence context
	        notejpa.save(existingNote);
		noteResponse.setResult("success");
		List<Notes> n = new ArrayList<>();
		n.add(existingNote);
		noteResponse.setNotes(n);
		noteResponse.setResultMessage("Note updated Successfully!");
		
		return noteResponse;
	}

	public String deleteNote(int id) {
		try {
			notejpa.deleteById(id);
			return "success";
		}catch(IllegalArgumentException e) {
			
			return e.getMessage();
		}
	}
	
	
}
