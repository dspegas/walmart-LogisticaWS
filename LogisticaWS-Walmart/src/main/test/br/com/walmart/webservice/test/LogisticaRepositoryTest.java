package br.com.walmart.webservice.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.walmart.model.MalhaLogistica;
import br.com.walmart.repository.LogisticaRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/WEB-INF/application-Context.xml"})
public class LogisticaRepositoryTest {
	
	@Autowired
	LogisticaRepository repositorio;
	
	String nomeMapa = "JUNIT";

	 @Test
	 // teste para salvar linha no mapa
	 public void salvaMalhaLogistica() throws Exception {
	        
		 MalhaLogistica malha = new MalhaLogistica();
		 malha.setNome_Mapa(nomeMapa);
		 malha.setPonto_Origem("A");
		 malha.setPonto_Destino("B");
		 malha.setDistancia(10);
		 Assert.assertEquals("Malha Logistica salva com sucesso.", repositorio.salvaMalhaLogistica(malha));
		 
		 repositorio.removeMalhaLogistica(malha);
		 }
	 
	 
	 @Test
	 // teste de recuperar mapa
	 public void recuperaMapa() throws Exception {
		 Assert.assertNotNull(repositorio.buscaMapa(nomeMapa));
	 }
}
