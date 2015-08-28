package br.com.walmart.webservice.impl;

import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlElement;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.walmart.model.MalhaLogistica;
import br.com.walmart.model.MalhaLogisticaPK;
import br.com.walmart.model.MenorValorResponse;
import br.com.walmart.service.impl.LogisticaServiceImpl;
import br.com.walmart.webservice.LogisticaWS;

@WebService(endpointInterface = "br.com.walmart.webservice.LogisticaWS")
public class LogisticaWSImpl implements LogisticaWS {

	@Autowired
	private LogisticaServiceImpl servico;
	
	@Override
	public String insereMalha(
			@WebParam(name="nomeMapa") @XmlElement(required=true,nillable=false) String nomeMapa,
			@WebParam(name="pontoOrigem") @XmlElement(required=true,nillable=false) String pontoOrigem, 
			@WebParam(name="pontoDestino") @XmlElement(required=true,nillable=false) String pontoDestino,
			@WebParam(name="distancia") @XmlElement(required=true,nillable=false) float distancia) {
		
		// Popula objeto Malha Logistica que será persistido
		MalhaLogistica malha = new MalhaLogistica();
		malha.setNome_Mapa(nomeMapa);
		malha.setPonto_Origem(pontoOrigem);
		malha.setPonto_Destino(pontoDestino);
		malha.setDistancia(distancia);
		
		// chama o serviço para persisitir a malha
		return servico.salvaMalhaLogistica(malha);
	}

	@Override
	public MenorValorResponse menorValor(
			@WebParam(name="nomeMapa") @XmlElement(required=true,nillable=false) String nomeMapa,
			@WebParam(name="pontoOrigem") @XmlElement(required=true,nillable=false) String pontoOrigem,
			@WebParam(name="pontoDestino") @XmlElement(required=true,nillable=false) String pontoDestino, 
			@WebParam(name="autonomia") @XmlElement(required=true,nillable=false) float autonomia,
			@WebParam(name="valorLitroCombustivel") @XmlElement(required=true,nillable=false) float valorLitroCombustivel) {

		
		
		return servico.menorValor(nomeMapa, pontoOrigem, pontoDestino, autonomia, valorLitroCombustivel);
	}
 
  
}