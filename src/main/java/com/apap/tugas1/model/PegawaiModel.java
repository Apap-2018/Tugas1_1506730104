package com.apap.tugas1.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "pegawai")
public class PegawaiModel implements Serializable {	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@Size(max = 255)
	@Column(name = "nip", nullable = false, unique = true)
	private String nip;
	
	@NotNull
	@Size(max = 255)
	@Column(name = "nama", nullable = false)
	private String nama;
	
	@NotNull
	@Size(max = 255)
	@Column(name = "tempat_lahir", nullable = false)
	private String tempat_lahir;
	
	@NotNull
	@Column(name = "tanggal_lahir", nullable = false)
	private Date tanggal_lahir;
	
	@NotNull
	@Size(max = 255)
	@Column(name = "tahun_masuk", nullable = false)
	private String tahun_masuk;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "instansi_id", referencedColumnName = "id", nullable = false)
	@OnDelete(action = OnDeleteAction.NO_ACTION)
	@JsonIgnore
	private InstansiModel instansi;

	@OneToMany(mappedBy="pegawai", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	private List<JabatanPegawaiModel> daftar_jabatan;

	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setNip(String nip) {
		this.nip = nip;
	}

	public String getNip() {
		return nip;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public String getNama() {
		return nama;
	}

	public void setTempatLahir(String tempat_lahir) {
		this.tempat_lahir = tempat_lahir;
	}

	public String getTempatLahir() {
		return tempat_lahir;
	}

	public void setTanggalLahir(Date tanggal_lahir) {
		this.tanggal_lahir = tanggal_lahir;
	}

	public Date getTanggalLahir() {
		return tanggal_lahir;
	}

	public void setTahunMasuk(String tahun_masuk) {
		this.tahun_masuk = tahun_masuk;
	}

	public String getTahunMasuk() {
		return tahun_masuk;
	}

	public void setInstansi(InstansiModel instansi) {
		this.instansi = instansi;
	}

	public InstansiModel getInstansi() {
		return instansi;
	}
	
	public void setDaftarJabatan(List<JabatanPegawaiModel> daftar_jabatan) {
		this.daftar_jabatan = daftar_jabatan;
	}

	public List<JabatanPegawaiModel> getDaftarJabatan() {
		return daftar_jabatan;
	}
	
}