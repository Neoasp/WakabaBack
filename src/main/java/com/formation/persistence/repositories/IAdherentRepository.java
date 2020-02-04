package com.formation.persistence.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.formation.persistence.entities.Adherent;

@Repository
public interface IAdherentRepository extends JpaRepository<Adherent, Long> {

	@Query(nativeQuery = true, value = "SELECT * FROM adherents WHERE name LIKE ?1%")
	public List<Adherent> findByName(String name);
	@Query(value = "SELECT * FROM adherents WHERE email = ?1", nativeQuery=true)
	Adherent findByMail(String username);
}
