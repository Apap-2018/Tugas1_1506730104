package com.apap.tugas1.service;

import com.apap.tugas1.model.JabatanModel;
import com.apap.tugas1.repository.JabatanDB;
import java.sql.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class JabatanServiceImplementation implements JabatanService {
	@Autowired
	private JabatanDB jabatanDb;

	@Override
	public JabatanModel getJabatanDetailById(Long id) {
		return jabatanDb.findByIdJabatan(id);
	}

	@Override
	public List<JabatanModel> getAllJabatan() {
		return jabatanDb.findAll();
	}
	
}