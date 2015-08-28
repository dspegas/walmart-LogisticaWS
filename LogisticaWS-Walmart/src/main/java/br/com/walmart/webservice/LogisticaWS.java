package br.com.walmart.webservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlElement;

import br.com.walmart.model.MenorValorResponse;

@WebService
public interface LogisticaWS {
	
	@WebMethod
	public String insereMalha(
			@WebParam(name="nomeMapa") @XmlElement(required=true,nillable=false) String nomeMapa,
			@WebParam(name="pontoOrigem") @XmlElement(required=true,nillable=false) String pontoOrigem, 
			@WebParam(name="pontoDestino") @XmlElement(required=true,nillable=false) String pontoDestino,
			@WebParam(name="distancia") @XmlElement(required=true,nillable=false) float distancia);
    
	@WebMethod
	public MenorValorResponse menorValor(
			@WebParam(name="nomeMapa") @XmlElement(required=true,nillable=false) String nomeMapa,
			@WebParam(name="pontoOrigem") @XmlElement(required=true,nillable=false) String pontoOrigem,
			@WebParam(name="pontoDestino") @XmlElement(required=true,nillable=false) String pontoDestino, 
			@WebParam(name="autonomia") @XmlElement(required=true,nillable=false) float autonomia,
			@WebParam(name="valorLitroCombustivel") @XmlElement(required=true,nillable=false) float valorLitroCombustivel);
    
}