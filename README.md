# TESTE_ACT_SALDO
API Construida em Java que realiza consulta em um BD MySQL para a consulta do saldo

O arquivo application.properties já está configurado para que a aplicação faça o gerenciamento do BD não havendo a necessidade de criar a tabela Transacoes.

Ob. Verifique a versão do MySQL instalado em sua máquina e altere a versão da dependência no arquivo pom.xml para a versão correspondente.

Exemplo:

		<dependency>
			<groupId>mysql</groupId>
			<artifactId>mysql-connector-java</artifactId>
			<version>8.0.17</version>
		</dependency>
		
============================================= ****************** ================================================================

Para acessar o microserviço que fará a inserção das transações de débito e crédito pelo browser utilisando o Swagger;

http://localhost:8085/ms-consulta-saldo/v1/swagger-ui.html
