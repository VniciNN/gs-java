package br.com.fiap.healthinking.model.entity;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;

public class SonoDiario {

	private Long idSono;
	@NotBlank
	private Long idCliente;
	@NotBlank
	private float duracaoSono;
	@NotBlank
	private LocalDate dataSono;
	@NotBlank
	private String qualidadeSono;
	@NotBlank
	@PastOrPresent
	private int atividadeFisica;
	@NotBlank
	private String nivelEstresse;
	
	public SonoDiario() {
		
	}

	public SonoDiario(Long idSono, Long idCliente, float duracaoSono, LocalDate dataSono, String qualidadeSono,
			int atividadeFisica, String nivelEstresse) {
		this.idSono = idSono;
		this.idCliente = idCliente;
		this.duracaoSono = duracaoSono;
		this.dataSono = dataSono;
		this.qualidadeSono = qualidadeSono;
		this.atividadeFisica = atividadeFisica;
		this.nivelEstresse = nivelEstresse;
	}

	public Long getIdSono() {
		return idSono;
	}

	public void setIdSono(Long idSono) {
		this.idSono = idSono;
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public float getDuracaoSono() {
		return duracaoSono;
	}

	public void setDuracaoSono(float duracaoSono) {
		this.duracaoSono = duracaoSono;
	}

	public LocalDate getDataSono() {
		return dataSono;
	}

	public void setDataSono(LocalDate dataSono) {
		this.dataSono = dataSono;
	}

	public String getQualidadeSono() {
		return qualidadeSono;
	}

	public void setQualidadeSono(String qualidadeSono) {
		this.qualidadeSono = qualidadeSono;
	}

	public int getAtividadeFisica() {
		return atividadeFisica;
	}

	public void setAtividadeFisica(int atividadeFisica) {
		this.atividadeFisica = atividadeFisica;
	}

	public String getNivelEstresse() {
		return nivelEstresse;
	}

	public void setNivelEstresse(String nivelEstresse) {
		this.nivelEstresse = nivelEstresse;
	}		
	
	
}
