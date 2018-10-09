package com.apap.tugas1.service;

import com.apap.tugas1.model.JabatanPegawaiModel;
import com.apap.tugas1.repository.JabatanPegawaiDB;
import java.sql.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class JabatanPegawaiServiceImplementation implements JabatanPegawaiService {
	@Autowired
	private JabatanPegawaiDB jabatanPegawaiDb;
	
}