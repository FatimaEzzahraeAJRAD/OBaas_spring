package com.fsts.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fsts.entities.Client;

public interface ClientRepository extends JpaRepository <Client,Long>{

}
