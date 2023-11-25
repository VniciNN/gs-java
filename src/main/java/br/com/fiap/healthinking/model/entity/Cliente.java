package br.com.fiap.healthinking.model.entity;

import java.time.LocalDate;

import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;

public class Cliente {

	@JsonbProperty("id_cliente")
	private Long idCliente;
	@NotBlank
	@JsonbProperty("usuario_cliente")
	private String userCliente;
	@NotBlank
	@JsonbProperty("senha_cliente")
	private String senhaCliente;
	@NotBlank
	@JsonbProperty("nome_cliente")
	private String nomeCLiente;
	@NotBlank
	@PastOrPresent
	@JsonbProperty("data_nasc_cliente")
	private LocalDate dataNascimento;
	@NotBlank
	@JsonbProperty("altura_cliente")
	private float alturaCLiente;
	@NotBlank
	@JsonbProperty("peso_cliente")
	private float pesoCliente;
	@NotBlank
	@JsonbProperty("classificacao_bmi")
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

	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", userCliente=" + userCliente + ", senhaCliente=" + senhaCliente
				+ ", nomeCLiente=" + nomeCLiente + ", dataNascimento=" + dataNascimento + ", alturaCLiente="
				+ alturaCLiente + ", pesoCliente=" + pesoCliente + ", classificacaoBmi=" + classificacaoBmi + "]";
	}
	
	
}
