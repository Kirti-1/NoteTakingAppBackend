package com.demo.example.NoteTakingBackend.Response;

import com.demo.example.NoteTakingBackend.Entity.Notes;

import java.util.List;

import org.springframework.stereotype.*;
import com.fasterxml.jackson.annotation.*;

@Component
public class NotesResponse {
	
	@JsonProperty("result")
	private String result;
	
	@JsonProperty("notes")
	private List<Notes> notes;
	
	@JsonProperty("resultMessage")
	private String resultMessage;
	
	public NotesResponse() {
		
	}
	public NotesResponse(String result,List<Notes> note, String resultMessage) {
		this.result = result;
		this.notes = note;
		this.resultMessage = resultMessage;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public List<Notes> getNotes() {
		return notes;
	}
	public void setNotes(List<Notes> notes) {
		this.notes = notes;
	}
	public String getResultMessage() {
		return resultMessage;
	}
	public void setResultMessage(String resultMessage) {
		this.resultMessage = resultMessage;
	}
}
