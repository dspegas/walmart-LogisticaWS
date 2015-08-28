package br.com.walmart.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.walmart.model.MalhaLogistica;

@Repository
public class LogisticaRepository {

	// An EntityManager will be automatically injected from EntityManagerFactory
	// setup on applicantion-Context.xml
	@PersistenceContext
	private EntityManager em;

	// Metodo para buscar uma malha logistica pelo nome
	public List<MalhaLogistica> buscaMapa(String nome) {
		String query = "SELECT m FROM MalhaLogistica m WHERE nome_mapa = :nome";
		List<MalhaLogistica> result = em.createQuery(query, MalhaLogistica.class).setParameter("nome", nome).getResultList();
	    return result;
	}

	// metodo que salva uma linha de malha logistica no mapa
	// eh salvo o caminho inverso tambem devido ao algoritmo
	@Transactional
	public String salvaMalhaLogistica(MalhaLogistica malha) {

		String retorno = "Malha Logistica salva com sucesso.";
		try {
			 em.persist(malha);
			 
			 MalhaLogistica inversa = new MalhaLogistica();
			 inversa.setDistancia(malha.getDistancia());
			 inversa.setNome_Mapa(malha.getNome_Mapa());
			 inversa.setPonto_Destino(malha.getPonto_Origem());
			 inversa.setPonto_Origem(malha.getPonto_Destino());
			 
			 em.persist(inversa);
			 
			
		} catch (Exception e) {
			
			retorno = "Erro: " + e.getMessage();

		}
		return retorno;
	}
	
	// metodo que remove uma linha de malha logistica no mapa
	// remove o inverso tambem
	public void removeMalhaLogistica(MalhaLogistica malha) {
		try {
			em.remove(malha);
			MalhaLogistica inversa = new MalhaLogistica();
			inversa.setDistancia(malha.getDistancia());
			inversa.setNome_Mapa(malha.getNome_Mapa());
			inversa.setPonto_Destino(malha.getPonto_Origem());
			inversa.setPonto_Origem(malha.getPonto_Destino());

			em.remove(inversa);

		} catch (Exception e) {

		}
	}

}
