package br.com.walmart.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.walmart.algoritmo.Dijkstra;
import br.com.walmart.algoritmo.Edge;
import br.com.walmart.algoritmo.Vertex;
import br.com.walmart.model.MalhaLogistica;
import br.com.walmart.model.MenorValorResponse;
import br.com.walmart.repository.LogisticaRepository;
import br.com.walmart.service.LogisticaService;

@Service
public class LogisticaServiceImpl implements LogisticaService {

	 @Autowired
	 private LogisticaRepository repositorio;

	@Override
	public String salvaMalhaLogistica(MalhaLogistica malha) {
		return repositorio.salvaMalhaLogistica(malha);
	}

	@Override
	public MenorValorResponse menorValor(String nomeMapa, String pontoOrigem,
			String pontoDestino, float autonomia, float valorLitroCombustivel) {
	
		// recupera mapa
		List<MalhaLogistica> mapa = repositorio.buscaMapa(nomeMapa);
		HashMap<String, Vertex> vertices = new HashMap<String, Vertex>();
		
		// percorre a malha preenchendo os vertices em branco
		for (MalhaLogistica malhaLogistica : mapa) {
			vertices.put(malhaLogistica.getPonto_Origem(), new Vertex(malhaLogistica.getPonto_Origem()));
		}
		
		// preenche adjacencia de cada malha
		for(Entry<String, Vertex> entry : vertices.entrySet()) {
		    String key = entry.getKey();
		    Vertex v = entry.getValue();
		    
		    ArrayList<Edge> edge = new ArrayList<Edge>();

			// percorre a malha preenchendo as adjacencias
			for (MalhaLogistica malhaLogistica : mapa) {
				// se ponto de origem eh o vertice
				if (malhaLogistica.getPonto_Origem().equals(key)) {
					Float f = malhaLogistica.getDistancia();
					edge.add(new Edge(vertices.get(malhaLogistica.getPonto_Destino()),f.doubleValue()));
				}
			}
			
			v.adjacencies = edge.toArray(new Edge[edge.size()]);

		}
		
		// faz o calculo pelo algoritmo
		Dijkstra dijkstra = new Dijkstra();
		dijkstra.computePaths(vertices.get(pontoOrigem));
		List<Vertex> path = dijkstra.getShortestPathTo(vertices.get(pontoDestino));
				
		// Preenche caminho
		String caminho = "";
		for (Vertex vertex : path) {
			caminho += vertex.name;
		}
		
		MenorValorResponse response = new MenorValorResponse();
		
		// calcula custo
		response.setCaminho(caminho);
		float dist = (float) path.get(path.size()-1).minDistance;
		response.setCusto( dist/autonomia * valorLitroCombustivel);
		
		return response;
		
		
	}
	
		
	  
}
