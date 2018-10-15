package com.apap.tugas1.service;

import com.apap.tugas1.model.InstansiModel;
import com.apap.tugas1.model.ProvinsiModel;
import com.apap.tugas1.repository.InstansiDB;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class InstansiServiceImplementation implements InstansiService {
	@Autowired
	private InstansiDB instansiDb;

	@Override
	public InstansiModel getInstansiDetailById(Long id) {
		Optional<InstansiModel> temp = instansiDb.findById(id);
		return temp.get();
	}

	@Override
	public List<InstansiModel> getAllInstansi() {
		return instansiDb.findAll();
	}
	
}