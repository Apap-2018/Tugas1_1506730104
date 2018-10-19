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
	
	@RequestMapping(value = "/pegawai", method = RequestMethod.GET)
	public String viewPegawai(@RequestParam("nip") String nip, Model model){
		PegawaiModel pegawai = pegawaiService.getPegawaiDetailByNip(nip);
		InstansiModel instansi = instansiService.getInstansiDetailById(pegawai.getInstansi().getId());
		ProvinsiModel provinsi = provinsiService.getProvinsiDetailByIdProvinsi(instansi.getProvinsi().getId());
		List<JabatanModel> jabatan = jabatanService.getJabatanListByJabatanPegawaiList(pegawai.getDaftarJabatan());
		Double gajiPegawai = jabatanService.getGajiTerbesar(jabatan, provinsi.getPresentaseTunjangan());
		
		model.addAttribute("pegawai", pegawai);
		model.addAttribute("jabatan", jabatan);
		model.addAttribute("instansi", instansi);
		model.addAttribute("provinsi", provinsi);
		model.addAttribute("gajiPegawai", gajiPegawai.intValue());
		
		return "pegawai";
	}
	
	@RequestMapping(value = "pegawai/termuda-tertua", method = RequestMethod.GET)
	public String viewPegawai(@RequestParam("id") Long id, Model model){
		InstansiModel instansi = instansiService.getInstansiDetailById(id);
		ProvinsiModel provinsi = provinsiService.getProvinsiDetailByIdProvinsi(instansi.getProvinsi().getId());
		PegawaiModel pegawaiMuda = pegawaiService.getPegawaiMudaByInstansi(id);
		List<JabatanModel> jabatanMuda = jabatanService.getJabatanListByJabatanPegawaiList(pegawaiMuda.getDaftarJabatan());
		PegawaiModel pegawaiTua = pegawaiService.getPegawaiTuaByInstansi(id);
		List<JabatanModel> jabatanTua = jabatanService.getJabatanListByJabatanPegawaiList(pegawaiTua.getDaftarJabatan());
		model.addAttribute("instansi", instansi);
		model.addAttribute("provinsi", provinsi);
		model.addAttribute("pegawaiMuda", pegawaiMuda);
		model.addAttribute("jabatanMuda", jabatanMuda);
		model.addAttribute("pegawaiTua", pegawaiTua);
		model.addAttribute("jabatanTua", jabatanTua);
		
		return "pegawai-termuda-tertua";
	}
	
	@RequestMapping(value = "/pegawai/tambah", method = RequestMethod.GET)
	public String tambahPegawai(Model model){
		List<ProvinsiModel> provinsi = provinsiService.getAllProvinsi();
		List<InstansiModel> instansi = instansiService.getAllInstansi();
		List<JabatanModel> jabatan = jabatanService.getAllJabatan();
		
		model.addAttribute("provinsi", provinsi);
		model.addAttribute("instansi", instansi);
		model.addAttribute("jabatan", jabatan);
		return "tambah-pegawai";
	}
	  
	@RequestMapping(value="/pegawai/tambah", method = RequestMethod.POST)
	private String tambahPegawaiSubmit(@ModelAttribute PegawaiModel pegawai, @RequestParam("id_jabatan") Long id_jabatan, Model model) {
		String nipTahunMasuk = pegawaiService.getPegawaiTahunMasukSama(pegawai.getTahunMasuk());
		InstansiModel instansi = instansiService.getInstansiDetailById(pegawai.getInstansi().getId());
		String nipTanggalLahir = ""+ pegawai.getTanggalLahir().getDay() + pegawai.getTanggalLahir().getMonth() + pegawai.getTanggalLahir().getYear(); 
		pegawai.setNip("" + pegawai.getInstansi().getId() + nipTanggalLahir + pegawai.getTahunMasuk() + nipTahunMasuk); 
		pegawaiService.addPegawai(pegawai);
		
		JabatanPegawaiModel jabatanPegawai = new JabatanPegawaiModel();
		JabatanModel jabatan = jabatanService.getJabatanDetailById(id_jabatan);
		jabatanPegawai.setJabatan(jabatan);
		jabatanPegawai.setPegawai(pegawai);
		jabatanPegawaiService.addJabatanPegawai(jabatanPegawai);
		
		model.addAttribute("nip", pegawai.getNip());
		model.addAttribute("success", "ditambahkan");
		return "success";
	}

	@RequestMapping(value = "/pegawai/ubah", method = RequestMethod.GET)
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
	
	@RequestMapping(value = "/pegawai/ubah", method = RequestMethod.POST)
	public String ubahPegawaiSubmit(@RequestParam("nip") String nip, @RequestParam("nama") String nama, @RequestParam("tempat_lahir") String tempat_lahir, @RequestParam("tanggal_lahir") Date tanggal_lahir, @RequestParam("tahun_masuk") String tahun_masuk, @RequestParam("id_instansi") Long id_instansi, @RequestParam("id_instansi") Long id_jabatan, Model model) {
		InstansiModel instansi = instansiService.getInstansiDetailById(id_instansi);
		PegawaiModel updated = pegawaiService.ubahPegawai(nip, nama, tempat_lahir, tanggal_lahir, tahun_masuk, instansi);
		JabatanModel jabatan = jabatanService.getJabatanDetailById(id_jabatan);
		jabatanPegawaiService.ubahJabatanPegawai(pegawaiService.getPegawaiDetailByNip(nip).getId(), jabatan);
		
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
		model.addAttribute("provinsi", pegawai);
		model.addAttribute("instansi", instansi);
		return "cari-pegawai";
	}
	
}