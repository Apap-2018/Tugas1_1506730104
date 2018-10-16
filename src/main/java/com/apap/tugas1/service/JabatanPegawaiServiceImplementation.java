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

	@Override
	public List<JabatanPegawaiModel> getJabatanPegawaiListByIdPegawai(Long id_pegawai) {
		List<JabatanPegawaiModel> temp = jabatanPegawaiDb.findAll();
		for(int i = 0; i < temp.size(); i++) {
			if(!temp.get(i).getIdPegawai().equals(id_pegawai)) {
				temp.remove(i);
				i--;
			}
		}
		return temp;
	}

	@Override
	public JabatanPegawaiModel getJabatanPegawaiDetailByIdPegawai(Long id_pegawai) {
		// TODO Auto-generated method stub
		return jabatanPegawaiDb.findByIdPegawai(id_pegawai);
	}
	
}