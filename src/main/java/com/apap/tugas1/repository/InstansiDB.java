package com.apap.tugas1.repository;

import com.apap.tugas1.model.InstansiModel;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstansiDB extends JpaRepository<InstansiModel, Long> {
	
}