package com.formation.persistence.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.formation.persistence.entities.Session;

@Repository
public interface ISessionRepository extends JpaRepository<Session, Long> {
	@Query(value = "SELECT * FROM sessions WHERE id_activite = ?1", nativeQuery=true)
	public List<Session> findByActivity(Long id);

}
