package com.fsts.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fsts.entities.Compte;

public interface CompteRepository extends JpaRepository<Compte,Long> {

}
