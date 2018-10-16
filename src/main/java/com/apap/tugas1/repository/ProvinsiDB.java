package com.apap.tugas1.repository;

import com.apap.tugas1.model.ProvinsiModel;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvinsiDB extends JpaRepository<ProvinsiModel, Long> {

}