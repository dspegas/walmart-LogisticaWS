====== CALCULO DE MENOR CUSTO ========



* Implementacao do algoritmo de Dijkstra

	- A motivação para uso deste algoritmo é a simplicidade para implementação apesar do tempo de resposta ser proporcional ao numero de vértices. 
	  Como para este problema acredito que uma resposta não imediata é aceitável, torna-se viável o seu uso.


* Arquitetura simples (Service -> Repository)

	- Como a aplicação é relativamente simples optei por uma camada de servico para conter as regras de negócio e um repositório para acesso a dados

	- Utilizei o Spring para gerenciar as injeções, testes unitários e integração com JPA por ser mais simples e rápido o desenvolvimento visto o tempo para realização do teste



===== CONFIGURACAO DA APLICACAO ========



* Criar base de dados
	
	- No banco de dados rodar o script
 (Exemplo em MYSQL)
		
CREATE DATABASE IF NOT EXISTS nome_base;

		
USE nome_base;
 
		
CREATE TABLE malha_logistica (
	
			nome_Mapa VARCHAR(50),

			ponto_Origem VARCHAR(50),

			ponto_Destino VARCHAR(50),

			distancia float,

			PRIMARY KEY  (nome_Mapa,ponto_Origem,ponto_Destino)
);



* Acesso a banco
	
	- Configurar o arquivo META-INF/persistence.xml com dados da base a ser utilizada

			- Alterar apenas o dialeto hibernate.dialect
	
	- Configurar o datasource no arquivo WEB-INF/application-Context.xml alterando usuario, senha, url e driver do banco. Segue exemplo para MySQL
	
		 <!-- MySQL Datasource with Commons DBCP connection pooling -->
	
			<bean class="org.apache.commons.dbcp.BasicDataSource" id="dataSource">
	
				<property name="driverClassName" value="com.mysql.jdbc.Driver"/>

					<property name="url" value="jdbc:mysql://localhost:3306/nome_base"/>

					<property name="username" value="usuario"/>

					<property name="password" value="senha"/>

				</bean>




===== DEPLOY ========

	

	- Fazer o deploy do arquivo war que acompanha em um servidor web.



===== TESTES ========



	- Acessar a URL : http://host:porta/LogisticaWS-Walmart/LogisticaWS?wsdl

		* Se tudo estiver correto irá aparecer o WSDL do WebService



	- Execução dos serviços
	
		* Pode-se usar um cliente como o SOAP-UI

		* Para realizar testes:
	
			1. Cadastre um novo mapa pelo web service InsereMalha
	
	
			* Você deve fornecer toda a Malha Logistica
	
			* Não é necessário cadastrar caminho inverso, por exemplo, A->B e B->A. Cadastre somente um.
			  O web service automaticamente cadastra o outro (necessidade do algoritmo implementado)

			* É possivel cadastrar quantos mapas quiser


			2. Após o cadastro do mapa consulte o menor custo pelo Web Service menorValor

				

		* Exemplo de envelopes de entrada:
	
			
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:web="http://webservice.walmart.com.br/">

			  <soapenv:Header/>
 
			  <soapenv:Body>

			      <web:insereMalha>
 
				        <nomeMapa>nome</nomeMapa>
 
				        <pontoOrigem>pontoOrigem</pontoOrigem>
 
				        <pontoDestino>pontoDestino</pontoDestino>
  
				        <distancia>distancia</distancia>
    
				</web:insereMalha>
 
			  </soapenv:Body>

			</soapenv:Envelope>




			<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:web="http://webservice.walmart.com.br/">

			   <soapenv:Header/>

			   <soapenv:Body>
  
				   <web:menorValor>
				   	<nomeMapa>nomeMapa</nomeMapa>

				   	<pontoOrigem>pontoOrigem</pontoOrigem>

				   	<pontoDestino>pontoDestino</pontoDestino>
				   	<autonomia>autonomia</autonomia>

				   	<valorLitroCombustivel>valorLitroCombustivel</valorLitroCombustivel>

				   	</web:menorValor>

  			   </soapenv:Body>
			
</soapenv:Envelope>



===== IMPORTANDO PROJETO NO ECLISE ========

	

1. Descompactar o arquivo em um diretorio

	2. Na IDE escolha File -> Import -> Existing Projects into workspace

	3. Escolher a pasta contendo o arquivo descompactado

	4. Selecionar o projeto



===== REPOSITÓRIO GIT HUB ========

	

1. Acessar a URL https://github.com/dspegas/walmart-logisticaWS

