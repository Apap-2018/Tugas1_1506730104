package com.apap.tugas1.service;

import com.apap.tugas1.model.InstansiModel;
import com.apap.tugas1.model.PegawaiModel;
import com.apap.tugas1.repository.PegawaiDB;
import com.apap.tugas1.repository.InstansiDB;
import java.sql.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PegawaiServiceImplementation implements PegawaiService {
	@Autowired
	private PegawaiDB pegawaiDb;

	@Override
	public PegawaiModel getPegawaiDetailByNip(String nip) {
		return pegawaiDb.findByNip(nip);
	}

	@Override
	public void addPegawai(PegawaiModel pegawai) {
		pegawaiDb.save(pegawai);
		
	}

	@Override
	public PegawaiModel ubahPegawai(String nip, String nama, String tempat_lahir, Date tanggal_lahir, String tahun_masuk, Long id_instansi) {
		pegawaiDb.findByNip(nip).setNama(nama);
		pegawaiDb.findByNip(nip).setTempatLahir(tempat_lahir);
		pegawaiDb.findByNip(nip).setTanggalLahir(tanggal_lahir);
		pegawaiDb.findByNip(nip).setTahunMasuk(tahun_masuk);
		pegawaiDb.findByNip(nip).setIdInstansi(id_instansi);
		PegawaiModel updated = pegawaiDb.findByNip(nip);
		return updated;
	}

	

}