package com.desafio.desafio.model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Trailer implements Serializable{
	
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long codigo;
    
	private static final int tipoRegistro = 9;
    
    private int totalRegistro;
    private String reservadoFuturo;
	public long getCodigo() {
		return codigo;
	}
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}
	public int getTotalRegistro() {
		return totalRegistro;
	}
	public void setTotalRegistro(int totalRegistro) {
		this.totalRegistro = totalRegistro;
	}
	public String getReservadoFuturo() {
		return reservadoFuturo;
	}
	public void setReservadoFuturo(String reservadoFuturo) {
		this.reservadoFuturo = reservadoFuturo;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public static int getTiporegistro() {
		return tipoRegistro;
	}
    
    

}
