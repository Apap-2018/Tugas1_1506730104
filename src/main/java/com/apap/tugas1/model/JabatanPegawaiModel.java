package com.apap.tugas1.model;

import java.io.Serializable;
import java.util.List;
import java.sql.Date;
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
	@Size(max = 10)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToMany(mappedBy = "jabatan_pegawai", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@Size(max = 20)
	private Long id_pegawai;

	@ManyToOne(fetch = FetchType.LAZY)
	@Size(max = 20)
	@JoinColumn(name = "jabatan", referencedColumnName = "id", nullable = false)
	@OnDelete(action = OnDeleteAction.NO_ACTION)
	@JsonIgnore
	private Long id_jabatan;

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setIdPegawai(Long id_pegawai) {
		this.id_pegawai = id_pegawai;
	}

	public Long getIdPegawai() {
		return id_pegawai;
	}

	public void setIdJabatan(Long id_jabatan) {
		this.id_jabatan = id_jabatan;
	}

	public Long getIdJabatan() {
		return id_jabatan;
	}
}