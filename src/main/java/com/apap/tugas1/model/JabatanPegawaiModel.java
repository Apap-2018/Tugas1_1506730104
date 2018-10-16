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
@Table(name = "jabatan_pegawai")
public class JabatanPegawaiModel implements Serializable {
	@Id
	@NotNull
	@Size(max = 10)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	
	@NotNull
	@Size(max = 20)
	@OneToMany(mappedBy = "jabatan_pegawai", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	private List<PegawaiModel> id_pegawai;

	@NotNull
	@Size(max = 20)
	@OneToMany(mappedBy = "jabatan_pegawai", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	private List<JabatanModel> id_jabatan;

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setIdPegawai(List<PegawaiModel> id_pegawai) {
		this.id_pegawai = id_pegawai;
	}

	public List<PegawaiModel> getIdPegawai() {
		return id_pegawai;
	}

	public void setIdJabatan(List<JabatanModel> id_jabatan) {
		this.id_jabatan = id_jabatan;
	}

	public List<JabatanModel> getIdJabatan() {
		return id_jabatan;
	}
}