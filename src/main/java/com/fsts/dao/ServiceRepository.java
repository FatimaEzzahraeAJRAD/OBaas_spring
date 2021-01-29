package com.fsts.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fsts.entities.Service;
public interface ServiceRepository extends JpaRepository<Service,Long> {

}
