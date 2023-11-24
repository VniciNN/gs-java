package br.com.fiap.healthinking.model.entity;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;

public class Cliente {

	private Long idCliente;
	@NotBlank
	private String userCliente;
	@NotBlank
	private String senhaCliente;
	@NotBlank
	private String nomeCLiente;
	@NotBlank
	private LocalDate dataNascimento;
	@NotBlank
	@PastOrPresent
	private float alturaCLiente;
	@NotBlank
	private float pesoCliente;
	@NotBlank
	private String classificacaoBmi;
	
	public Cliente() {
	
	}

	public Cliente(Long idCliente, @NotBlank String userCliente, @NotBlank String senhaCliente,
			@NotBlank String nomeCLiente, @NotBlank LocalDate dataNascimento,
			@NotBlank @PastOrPresent float alturaCLiente, @NotBlank float pesoCliente,
			@NotBlank String classificacaoBmi) {
		this.idCliente = idCliente;
		this.userCliente = userCliente;
		this.senhaCliente = senhaCliente;
		this.nomeCLiente = nomeCLiente;
		this.dataNascimento = dataNascimento;
		this.alturaCLiente = alturaCLiente;
		this.pesoCliente = pesoCliente;
		this.classificacaoBmi = classificacaoBmi;
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public String getUserCliente() {
		return userCliente;
	}

	public void setUserCliente(String userCliente) {
		this.userCliente = userCliente;
	}

	public String getSenhaCliente() {
		return senhaCliente;
	}

	public void setSenhaCliente(String senhaCliente) {
		this.senhaCliente = senhaCliente;
	}

	public String getNomeCLiente() {
		return nomeCLiente;
	}

	public void setNomeCLiente(String nomeCLiente) {
		this.nomeCLiente = nomeCLiente;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public float getAlturaCLiente() {
		return alturaCLiente;
	}

	public void setAlturaCLiente(float alturaCLiente) {
		this.alturaCLiente = alturaCLiente;
	}

	public float getPesoCliente() {
		return pesoCliente;
	}

	public void setPesoCliente(float pesoCliente) {
		this.pesoCliente = pesoCliente;
	}

	public String getClassificacaoBmi() {
		return classificacaoBmi;
	}

	public void setClassificacaoBmi(String classificacaoBmi) {
		this.classificacaoBmi = classificacaoBmi;
	}
	
	
}
