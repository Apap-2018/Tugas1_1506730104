package com.apap.tugas1.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "jabatan")
public class JabatanModel implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotNull
	@Size(max = 255)
	@Column(name = "nama", nullable = false)
	private String nama;

	@NotNull
	@Size(max = 255)
	@Column(name = "deskripsi", nullable = false)
	private String deskripsi;

	@NotNull
	@Column(name = "gaji_pokok", nullable = false)
	private Double gajiPokok;
	
	@OneToMany(mappedBy="jabatan", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	private List<JabatanPegawaiModel> daftarPegawai;

	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public String getNama() {
		return nama;
	}

	public void setDeskripsi(String deskripsi) {
		this.deskripsi = deskripsi;
	}

	public String getDeskripsi() {
		return deskripsi;
	}

	public void setGajiPokok(Double gajiPokok) {
		this.gajiPokok = gajiPokok;
	}

	public Double getGajiPokok() {
		return gajiPokok;
	}
	
	public void setDaftarPegawai(List<JabatanPegawaiModel> daftarPegawai) {
		this.daftarPegawai = daftarPegawai;
	}

	public List<JabatanPegawaiModel> getDaftarPegawai() {
		return daftarPegawai;
	}
	
}