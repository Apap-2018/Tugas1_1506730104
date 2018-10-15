package com.apap.tugas1.controller;

import com.apap.tugas1.model.InstansiModel;
import com.apap.tugas1.model.JabatanModel;
import com.apap.tugas1.model.JabatanPegawaiModel;
import com.apap.tugas1.model.PegawaiModel;
import com.apap.tugas1.model.ProvinsiModel;
import com.apap.tugas1.service.JabatanService;

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
public class JabatanController {
	@Autowired
	private JabatanService jabatanService;
	
	@RequestMapping(value = "jabatan/tambah", method = RequestMethod.GET)
	public String tambahJabatan(Model model){
		return "tambah-jabatan";
	}
	  
	@RequestMapping(value="jabatan/tambah-submit", method = RequestMethod.POST)
	private String tambahJabatanSubmit(@ModelAttribute JabatanModel jabatan, Model model) {
		jabatanService.addJabatan(jabatan);
		return "index";
	}
	
	@RequestMapping(value = "jabatan", method = RequestMethod.GET)
	public String viewJabatan(@RequestParam("id") Long id, Model model){
		JabatanModel jabatan = jabatanService.getJabatanDetailById(id);
		model.addAttribute("jabatan", jabatan);
		return "pegawai";
	}
	
	@RequestMapping(value = "jabatan/ubah", method = RequestMethod.GET)
	public String ubahJabatan(@RequestParam("id") Long id, Model model){
		JabatanModel jabatan = jabatanService.getJabatanDetailById(id);
		model.addAttribute("jabatan", jabatan);
		return "ubah-jabatan";
	}
	
	@RequestMapping(value = "jabatan/ubah-submit", method = RequestMethod.POST)
	public String ubahPegawaiSubmit(@RequestParam("id") Long id, @RequestParam("nama") String nama, @RequestParam("deskripsi") String deskripsi, @RequestParam("gaji_pokok") Double gaji_pokok, Model model) {
		JabatanModel updated = jabatanService.ubahJabatan(id, nama, deskripsi, gaji_pokok);
		model.addAttribute("jabatan", updated);
		return "index";
	}
	
	@RequestMapping(value = "jabatan/delete", method = RequestMethod.POST)
	public String deleteJabatan(@RequestParam("id") Long id, Model model) {
		JabatanModel deleted = jabatanService.deleteJabatan(id);
		model.addAttribute("jabatan", deleted);
		return "home";
	}
	
	@RequestMapping(value = "jabatan/viewall", method = RequestMethod.GET)
	public String viewAllJabatan(Model model){
		List<JabatanModel> jabatan = jabatanService.getAllJabatan();
		model.addAttribute("jabatan", jabatan);
		return "daftar-jabatan";
	}
}