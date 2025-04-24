package com.demo.example.NoteTakingBackend.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import com.demo.example.NoteTakingBackend.Entity.Notes;

public interface NoteTakingJPA extends JpaRepository<Notes, Integer> {

}
