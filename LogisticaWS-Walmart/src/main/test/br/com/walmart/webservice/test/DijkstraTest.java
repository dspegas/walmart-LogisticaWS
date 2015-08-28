package br.com.walmart.webservice.test;

import java.util.List;

import org.junit.Test;

import junit.framework.Assert;
import br.com.walmart.algoritmo.Dijkstra;
import br.com.walmart.algoritmo.Edge;
import br.com.walmart.algoritmo.Vertex;

public class DijkstraTest {
	
	@Test
	// metodo para testar o algoritmo 
	public void melhorCaminhoDijkstra() {

		Dijkstra dijkstra = new Dijkstra();
		Vertex a = new Vertex("A");
		Vertex b = new Vertex("B");
		Vertex c = new Vertex("C");
		Vertex d = new Vertex("D");
		Vertex e = new Vertex("E");

		a.adjacencies = new Edge[] { new Edge(b, 10), new Edge(c, 20) };
		b.adjacencies = new Edge[] { new Edge(a, 10), new Edge(d, 15), 	new Edge(e, 50) };
		c.adjacencies = new Edge[] { new Edge(a, 20), new Edge(d, 30) };
		d.adjacencies = new Edge[] { new Edge(b, 15), new Edge(e, 30), 	new Edge(c, 30) };
		e.adjacencies = new Edge[] { new Edge(b, 50), new Edge(d, 30) };
		//Vertex[] vertices = { a, b, c, d, e };
		dijkstra.computePaths(a);
		List<Vertex> path = dijkstra.getShortestPathTo(d);
		
		String caminho = "";
				
		for (Vertex vertex : path) {
			caminho += vertex.name;
		}
		
		Assert.assertEquals(new Double(25), path.get(path.size()-1).minDistance);
		Assert.assertEquals("ABD", caminho);

	}

}
