package com.apap.tugas1.service;

import java.util.List;

import com.apap.tugas1.model.InstansiModel;
import com.apap.tugas1.model.PegawaiModel;
import com.apap.tugas1.model.ProvinsiModel;

public interface ProvinsiService {
	ProvinsiModel getProvinsiDetailByIdProvinsi(Long id_provinsi);
	List<ProvinsiModel> getAllProvinsi();
}