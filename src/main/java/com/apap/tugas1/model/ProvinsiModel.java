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
@Table(name = "provinsi")
public class ProvinsiModel implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotNull
	@Size(max = 255)
	@Column(name = "nama", nullable = false)
	private String nama;

	@NotNull
	@Column(name = "presentaseTunjangan", nullable = false)
	private Double presentaseTunjangan;
	
	@OneToMany(mappedBy="provinsi", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	private List<InstansiModel> daftarInstansi;

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

	public void setPresentaseTunjangan(Double presentaseTunjangan) {
		this.presentaseTunjangan = presentaseTunjangan;
	}

	public Double getPresentaseTunjangan() {
		return presentaseTunjangan;
	}
	
	public void setDaftarInstansi(List<InstansiModel> daftarInstansi) {
		this.daftarInstansi = daftarInstansi;
	}

	public List<InstansiModel> getDaftarInstansi() {
		return daftarInstansi;
	}
}