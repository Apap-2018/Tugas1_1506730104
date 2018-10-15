package com.apap.tugas1.controller;

import com.apap.tugas1.model.InstansiModel;
import com.apap.tugas1.service.InstansiService;
import com.apap.tugas1.model.JabatanPegawaiModel;
import com.apap.tugas1.service.JabatanPegawaiService;
import com.apap.tugas1.model.JabatanModel;
import com.apap.tugas1.service.JabatanService;
import com.apap.tugas1.model.PegawaiModel;
import com.apap.tugas1.service.PegawaiService;
import com.apap.tugas1.model.ProvinsiModel;
import com.apap.tugas1.service.ProvinsiService;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PegawaiController {
	@Autowired
	private PegawaiService pegawaiService;
	
	@Autowired
	private InstansiService instansiService;
	
	@Autowired
	private JabatanPegawaiService jabatanPegawaiService;
	
	@Autowired
	private JabatanService jabatanService;
	
	@Autowired
	private ProvinsiService provinsiService;

	@RequestMapping("/")
	private String home(Model model) {
		List<JabatanModel> jabatan = jabatanService.getAllJabatan();
		List<InstansiModel> instansi = instansiService.getAllInstansi();
		model.addAttribute("jabatan", jabatan);
		model.addAttribute("instansi", instansi);
		return "index";
	}
	
	@RequestMapping(value = "pegawai", method = RequestMethod.GET)
	public String viewPegawai(@RequestParam("nip") String nip, Model model){
		PegawaiModel pegawai = pegawaiService.getPegawaiDetailByNip(nip);
		InstansiModel instansi = instansiService.getInstansiDetailById(pegawai.getIdInstansi());
		JabatanPegawaiModel jabatanPegawai = jabatanPegawaiService.getJabatanPegawaiDetailByIdPegawai(pegawai.getId());
		JabatanModel jabatan = jabatanService.getJabatanDetailById(jabatanPegawai.getIdJabatan());
		model.addAttribute("pegawai", pegawai);
		model.addAttribute("jabatan", jabatan);
		model.addAttribute("instansi", instansi);
		return "pegawai";
	}
	
	@RequestMapping(value = "pegawai/tambah", method = RequestMethod.GET)
	public String tambahPegawai(Model model){
		List<ProvinsiModel> provinsi = provinsiService.getAllProvinsi();
		List<InstansiModel> instansi = instansiService.getAllInstansi();
		List<JabatanModel> jabatan = jabatanService.getAllJabatan();
		model.addAttribute("provinsi", provinsi);
		model.addAttribute("instansi", instansi);
		model.addAttribute("jabatan", jabatan);
		return "tambah-pegawai";
	}
	  
	@RequestMapping(value="/pegawai/tambah-submit", method = RequestMethod.POST)
	private String tambahPegawaiSubmit(@ModelAttribute PegawaiModel pegawai, Model model) {
		pegawaiService.addPegawai(pegawai);
		model.addAttribute("nip", pegawai.getNip());
		model.addAttribute("success", "ditambahkan");
		return "success";
	}
	
	@RequestMapping(value = "pegawai/ubah", method = RequestMethod.GET)
	public String ubahPegawai(@RequestParam("nip") String nip, Model model){
		PegawaiModel pegawai = pegawaiService.getPegawaiDetailByNip(nip);
		List<ProvinsiModel> provinsi = provinsiService.getAllProvinsi();
		List<InstansiModel> instansi = instansiService.getAllInstansi();
		List<JabatanModel> jabatan = jabatanService.getAllJabatan();
		model.addAttribute("pegawai", pegawai);
		model.addAttribute("provinsi", provinsi);
		model.addAttribute("instansi", instansi);
		model.addAttribute("jabatan", jabatan);
		return "ubah-pegawai";
	}
	
	@RequestMapping(value = "pegawai/ubah-submit", method = RequestMethod.POST)
	public String ubahPegawaiSubmit(@RequestParam("nip") String nip, @RequestParam("nama") String nama, @RequestParam("tempat_lahir") String tempat_lahir, @RequestParam("tanggal_lahir") Date tanggal_lahir, @RequestParam("tahun_masuk") String tahun_masuk, @RequestParam("id_instansi") Long id_instansi, Model model) {
		PegawaiModel updated = pegawaiService.ubahPegawai(nip, nama, tempat_lahir, tanggal_lahir, tahun_masuk, id_instansi);
		model.addAttribute("pegawai", updated);
		model.addAttribute("nip", updated.getNip());
		model.addAttribute("success", "diubah");
		return "success";
	}
	
	@RequestMapping(value = "pegawai/cari", method = RequestMethod.GET)
	public String cariPegawai(Model model){
		List<ProvinsiModel> provinsi = provinsiService.getAllProvinsi();
		List<InstansiModel> instansi = instansiService.getAllInstansi();
		List<JabatanModel> jabatan = jabatanService.getAllJabatan();
		List<PegawaiModel> pegawai = pegawaiService.getAllPegawai();
		model.addAttribute("pegawai", pegawai);
		model.addAttribute("jabatan", jabatan);
		model.addAttribute("instansi", instansi);
		model.addAttribute("jabatan", jabatan);
		return "cari-pegawai";
	}
	
	@RequestMapping(value = "pegawai/termuda-tertua", method = RequestMethod.GET)
	public String viewPegawai(@RequestParam("id_instansi") Long id_instansi, Model model){
		InstansiModel instansi = instansiService.getInstansiDetailById(id_instansi);
		model.addAttribute("instansi", instansi);
		
		PegawaiModel pegawaiMuda = pegawaiService.getPegawaiMudaByInstansi(id_instansi);
		JabatanPegawaiModel jabatanPegawaiMuda = jabatanPegawaiService.getJabatanPegawaiDetailByIdPegawai(pegawaiMuda.getId());
		JabatanModel jabatanMuda = jabatanService.getJabatanDetailById(jabatanPegawaiMuda.getIdJabatan());
		model.addAttribute("pegawaiMuda", pegawaiMuda);
		model.addAttribute("jabatanPegawaiMuda", jabatanPegawaiMuda);
		model.addAttribute("jabatanMuda", jabatanMuda);
		
		PegawaiModel pegawaiTua = pegawaiService.getPegawaiTuaByInstansi(id_instansi);
		JabatanPegawaiModel jabatanPegawaiTua = jabatanPegawaiService.getJabatanPegawaiDetailByIdPegawai(pegawaiTua.getId());
		JabatanModel jabatanTua = jabatanService.getJabatanDetailById(jabatanPegawaiTua.getIdJabatan());
		model.addAttribute("pegawaiTua", pegawaiMuda);
		model.addAttribute("jabatanPegawaiTua", jabatanPegawaiMuda);
		model.addAttribute("jabatanTua", jabatanMuda);
		
		return "pegawai";
	}
}