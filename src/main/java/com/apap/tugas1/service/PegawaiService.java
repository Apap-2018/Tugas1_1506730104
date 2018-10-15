package com.apap.tugas1.service;

import java.sql.Date;

import com.apap.tugas1.model.InstansiModel;
import com.apap.tugas1.model.PegawaiModel;

public interface PegawaiService {
	PegawaiModel getPegawaiDetailByNip(String nip);
	void addPegawai(PegawaiModel pegawai);
	PegawaiModel ubahPegawai(String nip,String nama, String tempat_lahir, Date tanggal_lahir, String tahun_masuk, Long id_instansi);
}