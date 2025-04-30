package com.demo.example.NoteTakingBackend.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.demo.example.NoteTakingBackend.Entity.Notes;

public interface NoteTakingJPA extends JpaRepository<Notes, Integer> {

	@Modifying
	@Transactional
	/*
	 * Important Note to remember
	 * Since your entity is Notes, you should use Notes (with an uppercase "N") in the JPQL query instead of notes.
	 */
	@Query("update Notes n set subjectLine=?1,body=?2 where id=?3")
	void updateQuery(String subject_line, String body, int id);
}
