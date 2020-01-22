package com.desafio.desafio.model;


import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import java.util.Date;


/** Classe que representa um Header **/

@Entity
public class Header implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long codigo;   
	private static final int tipoRegistro = 0;
	private int estabelecimento;
	@Temporal(TemporalType.DATE)
	private Date dataProcessamento;
	@Temporal(TemporalType.DATE)
	private Date periodoInicial;
	@Temporal(TemporalType.DATE)
	private Date periodoFinal;
	private int sequencia;
	private String empresaAdquirente;
	private int tipoExtrato;
	private String filler;
	private String versaoLayout;
	private String versaoRelease;
	private String reservadoFuturo;
	
	
	public long getCodigo() {
		return codigo;
	}
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}	
	public int getEstabelecimento() {
		return estabelecimento;
	}
	public void setEstabelecimento(int estabelecimento) {
		this.estabelecimento = estabelecimento;
	}
	public Date getDataProcessamento() {
		return dataProcessamento;
	}
	public void setDataProcessamento(Date dataProcessamento) {
		this.dataProcessamento = dataProcessamento;
	}
	public Date getPeriodoInicial() {
		return periodoInicial;
	}
	public void setPeriodoInicial(Date periodoInicial) {
		this.periodoInicial = periodoInicial;
	}
	public Date getPeriodoFinal() {
		return periodoFinal;
	}
	public void setPeriodoFinal(Date periodoFinal) {
		this.periodoFinal = periodoFinal;
	}
	public int getSequencia() {
		return sequencia;
	}
	public void setSequencia(int sequencia) {
		this.sequencia = sequencia;
	}
	public String getEmpresaAdquirente() {
		return empresaAdquirente;
	}
	public void setEmpresaAdquirente(String empresaAdquirente) {
		this.empresaAdquirente = empresaAdquirente;
	}
	public int getTipoExtrato() {
		return tipoExtrato;
	}
	public void setTipoExtrato(int tipoExtrato) {
		this.tipoExtrato = tipoExtrato;
	}
	public String getFiller() {
		return filler;
	}
	public void setFiller(String filler) {
		this.filler = filler;
	}
	public String getVersaoLayout() {
		return versaoLayout;
	}
	public void setVersaoLayout(String versaoLayout) {
		this.versaoLayout = versaoLayout;
	}
	public String getVersaoRelease() {
		return versaoRelease;
	}
	public void setVersaoRelease(String versaoRelease) {
		this.versaoRelease = versaoRelease;
	}
	public String getReservadoFuturo() {
		return reservadoFuturo;
	}
	public void setReservadoFuturo(String reservadoFuturo) {
		this.reservadoFuturo = reservadoFuturo;
	}
	public static int getTiporegistro() {
		return tipoRegistro;
	}	

}
