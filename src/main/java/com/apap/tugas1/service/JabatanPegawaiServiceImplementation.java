package com.apap.tugas1.service;

import com.apap.tugas1.model.JabatanModel;
import com.apap.tugas1.model.JabatanPegawaiModel;
import com.apap.tugas1.model.PegawaiModel;
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

	/**
	 * 
	 */
	
	@Override
	public List<JabatanPegawaiModel> getJabatanPegawaiListByIdPegawai(Long id_pegawai) {
		List<JabatanPegawaiModel> temp = jabatanPegawaiDb.findAll();
		
		return temp;
	}
	
	@Override
	public JabatanPegawaiModel getJabatanPegawaiDetailByIdPegawai(Long id_pegawai) {
		return jabatanPegawaiDb.findById(id_pegawai).get();
	}

	@Override
	public void addJabatanPegawai(JabatanPegawaiModel jabatanPegawai) {
		jabatanPegawaiDb.save(jabatanPegawai);
	}

	@Override
	public void ubahJabatanPegawai(Long id_pegawai, JabatanModel jabatan) {
		// TODO Auto-generated method stub
		List<JabatanPegawaiModel> temp = jabatanPegawaiDb.findAll();
		temp.clear();
		List<JabatanPegawaiModel> jabatanPegawai = jabatanPegawaiDb.findAll();
		for(int i = 0; i < jabatanPegawai.size(); i++) {
			if(jabatanPegawai.get(i).getPegawai().getId() == id_pegawai) {
				temp.add(jabatanPegawai.get(i));
			}
		}
		for(int i = 0; i < temp.size(); i++) {
			jabatanPegawaiDb.findById(temp.get(i).getId()).get().setJabatan(jabatan);
		}
		
	}
	
}