package com.formation.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.formation.persistence.entities.Activity;

@Repository
public interface IActivityRepository extends JpaRepository<Activity, Long> {

}
