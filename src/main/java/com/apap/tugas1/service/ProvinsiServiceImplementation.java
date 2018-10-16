package com.apap.tugas1.service;

import com.apap.tugas1.model.InstansiModel;
import com.apap.tugas1.model.ProvinsiModel;
import com.apap.tugas1.repository.ProvinsiDB;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProvinsiServiceImplementation implements ProvinsiService {
	@Autowired
	private ProvinsiDB provinsiDb;

	@Override
	public List<ProvinsiModel> getAllProvinsi() {
		return provinsiDb.findAll();
	}

	@Override
	public ProvinsiModel getProvinsiDetailByIdProvinsi(Long id_provinsi) {
		Optional<ProvinsiModel> temp = provinsiDb.findById(id_provinsi);
		return temp.get();
	}
	
}