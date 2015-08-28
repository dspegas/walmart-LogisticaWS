package br.com.walmart.service;

import br.com.walmart.model.MalhaLogistica;
import br.com.walmart.model.MenorValorResponse;

public interface LogisticaService {

	// metodo que calcula o menor caminho
	public MenorValorResponse menorValor(String nomeMapa, String pontoOrigem,
			String pontoDestino, float autonomia, float valorLitroCombustivel);

	// metodo para salvar linha em mapa
	public String salvaMalhaLogistica(MalhaLogistica malha);
	
	
}
