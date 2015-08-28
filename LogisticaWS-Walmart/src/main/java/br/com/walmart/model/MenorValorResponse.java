package br.com.walmart.model;

import javax.xml.bind.annotation.XmlType;

@XmlType(name = "MenorValorResponse")
public class MenorValorResponse {
	
	String caminho;
	
	float custo;

	public String getCaminho() {
		return caminho;
	}

	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}

	public float getCusto() {
		return custo;
	}

	public void setCusto(float custo) {
		this.custo = custo;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MenorValorResponse other = (MenorValorResponse) obj;
		if (caminho == null) {
			if (other.caminho != null)
				return false;
		} else if (!caminho.equals(other.caminho))
			return false;
		if (Float.floatToIntBits(custo) != Float.floatToIntBits(other.custo))
			return false;
		return true;
	}
	
	

}
