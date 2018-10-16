package com.apap.tugas1.service;

import java.util.List;

import com.apap.tugas1.model.JabatanModel;
import com.apap.tugas1.model.JabatanPegawaiModel;

public interface JabatanService {
	List<JabatanModel> getAllJabatan();
	JabatanModel getJabatanDetailById(Long id);
	List<JabatanModel> getJabatanListByJabatanPegawaiList(List<JabatanPegawaiModel> jabatanPegawaiList);
	void addJabatan(JabatanModel jabatan);
	JabatanModel ubahJabatanDetailById(Long id, String nama, String deskripsi, Double gaji_pokok);
	JabatanModel deleteJabatanById(Long id);
	Double getGajiTerbesar(List<JabatanModel> jabatan, Double presentase_tunjangan);
}