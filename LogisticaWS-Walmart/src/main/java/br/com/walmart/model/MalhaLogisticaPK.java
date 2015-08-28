package br.com.walmart.model;

import java.io.Serializable;

public class MalhaLogisticaPK implements Serializable {

	String nome_Mapa;

	String ponto_Origem;

	String ponto_Destino;

	public String getNome_Mapa() {
		return nome_Mapa;
	}

	public void setNome_Mapa(String nome_Mapa) {
		this.nome_Mapa = nome_Mapa;
	}

	public String getPonto_Origem() {
		return ponto_Origem;
	}

	public void setPonto_Origem(String ponto_Origem) {
		this.ponto_Origem = ponto_Origem;
	}

	public String getPonto_Destino() {
		return ponto_Destino;
	}

	public void setPonto_Destino(String ponto_Destino) {
		this.ponto_Destino = ponto_Destino;
	}

	public MalhaLogisticaPK() {
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((nome_Mapa == null) ? 0 : nome_Mapa.hashCode());
		result = prime * result
				+ ((ponto_Destino == null) ? 0 : ponto_Destino.hashCode());
		result = prime * result
				+ ((ponto_Origem == null) ? 0 : ponto_Origem.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MalhaLogisticaPK other = (MalhaLogisticaPK) obj;
		if (nome_Mapa == null) {
			if (other.nome_Mapa != null)
				return false;
		} else if (!nome_Mapa.equals(other.nome_Mapa))
			return false;
		if (ponto_Destino == null) {
			if (other.ponto_Destino != null)
				return false;
		} else if (!ponto_Destino.equals(other.ponto_Destino))
			return false;
		if (ponto_Origem == null) {
			if (other.ponto_Origem != null)
				return false;
		} else if (!ponto_Origem.equals(other.ponto_Origem))
			return false;
		return true;
	}
	
	

}
