package com.apap.tugas1.service;

import com.apap.tugas1.model.JabatanModel;
import com.apap.tugas1.model.PegawaiModel;
import com.apap.tugas1.repository.JabatanDB;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

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
		Optional<JabatanModel> temp = jabatanDb.findById(id);
		return temp.get();
	}

	@Override
	public List<JabatanModel> getAllJabatan() {
		return jabatanDb.findAll();
	}

	@Override
	public void addJabatan(JabatanModel jabatan) {
		jabatanDb.save(jabatan);
	}

	@Override
	public JabatanModel ubahJabatan(Long id, String nama, String deskripsi, Double gaji_pokok) {
		jabatanDb.findById(id).get().setNama(nama);
		jabatanDb.findById(id).get().setDeskripsi(deskripsi);
		jabatanDb.findById(id).get().setGajiPokok(gaji_pokok);
		JabatanModel updated = jabatanDb.findById(id).get();
		return updated;
	}

	@Override
	public JabatanModel deleteJabatan(Long id) {
		JabatanModel deleted = jabatanDb.findById(id).get();
		jabatanDb.delete(jabatanDb.findById(id).get());
		return deleted;
	}
	
	
}