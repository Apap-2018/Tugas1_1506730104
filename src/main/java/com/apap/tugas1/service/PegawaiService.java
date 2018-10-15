package com.apap.tugas1.service;

import java.sql.Date;
import java.util.List;

import com.apap.tugas1.model.InstansiModel;
import com.apap.tugas1.model.JabatanModel;
import com.apap.tugas1.model.PegawaiModel;

public interface PegawaiService {
	PegawaiModel getPegawaiDetailByNip(String nip);
	void addPegawai(PegawaiModel pegawai);
	PegawaiModel ubahPegawai(String nip,String nama, String tempat_lahir, Date tanggal_lahir, String tahun_masuk, Long id_instansi);
	List<PegawaiModel> getAllPegawai();
	PegawaiModel getPegawaiMudaByInstansi(Long id_instansi);
	PegawaiModel getPegawaiTuaByInstansi(Long id_instansi);
}