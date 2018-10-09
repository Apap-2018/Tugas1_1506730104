package com.apap.tugas1.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "jabatan")
public class JabatanModel implements Serializable {
	@Id
	@Size(max = 20)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

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
	private Double gaji_pokok;

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
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

	public void setGajiPokok(Double gaji_pokok) {
		this.gaji_pokok = gaji_pokok;
	}

	public Double getGajiPokok() {
		return gaji_pokok;
	}
}