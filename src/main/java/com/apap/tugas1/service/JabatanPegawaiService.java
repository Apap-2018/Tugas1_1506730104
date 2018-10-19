package com.apap.tugas1.service;

import java.util.List;

import com.apap.tugas1.model.JabatanPegawaiModel;
import com.apap.tugas1.model.PegawaiModel;
import com.apap.tugas1.model.JabatanModel;

public interface JabatanPegawaiService {
	List<JabatanPegawaiModel> getJabatanPegawaiListByIdPegawai(Long id_pegawai);
	JabatanPegawaiModel getJabatanPegawaiDetailByIdPegawai(Long id_pegawai);
	void addJabatanPegawai(JabatanPegawaiModel jabatanPegawai);
	void ubahJabatanPegawai(Long id_pegawai, JabatanModel jabatan);
}