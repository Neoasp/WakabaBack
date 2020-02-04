package com.formation.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.formation.persistence.entities.Inscription;

@Repository
public interface IInscriptionRepository extends JpaRepository<Inscription, Long> {

}
