package com.apap.tugas1.service;

import java.util.List;

import com.apap.tugas1.model.JabatanModel;
import com.apap.tugas1.model.PegawaiModel;
import com.apap.tugas1.model.ProvinsiModel;

public interface JabatanService {
	JabatanModel getJabatanDetailById(Long id);
	List<JabatanModel> getAllJabatan();
}