# Sistema de Aluguel de Carros - API Spring Boot 🚗
Este projeto é um Sistema de Aluguel de Carros implementado utilizando Spring Boot, Hibernate, JPA e PostgreSQL. Ele oferece uma API REST para gerenciar o cadastro de clientes, seleção de veículos e reserva de aluguel.

## Recursos 🔧
- Cadastro de Clientes
- Seleção de Veículos
- Reserva de Aluguel
- Documentação da API com Swagger
- Banco de Dados PostgreSQL

## Tecnologias Utilizadas 👨‍💻
- Spring Boot
- Hibernate
- Java Persistence API (JPA)
- Swagger UI para Documentação da API
- Banco de Dados PostgreSQL

## Como Começar
Para colocar o projeto em funcionamento na sua máquina local, siga os seguintes passos:

- Clone este repositório: git clone https://github.com/Squad-10-Projects/desafio-locadora-carros.git
- Navegue até o diretório do projeto: cd desafio-locadora-carros
- Configure as configurações do banco de dados PostgreSQL em src/main/resources/application.properties
- Compile o projeto: mvn clean install
- Execute a aplicação: mvn spring-boot:run

## Documentação da API 📚
Os endpoints da API e a documentação são gerados usando o Swagger. Para acessar o Swagger UI, execute a aplicação e visite http://localhost:8080/swagger-ui/index.html no seu navegador.

## Configuração do Banco de Dados 📙
### Com docker
- Rode essa linha de comando na raiz do projeto: docker-compose up -d
### Manual
- Instale o PostgreSQL e crie um banco de dados.
- Configure as configurações do banco de dados em src/main/resources/application.properties.
<pre>
spring.datasource.url=jdbc:postgresql://localhost:5432/banco_de_dados_aluguel_carros
spring.datasource.username=seu-nome-de-usuário
spring.datasource.password=sua-senha
</pre>
- Execute a aplicação para gerar automaticamente as tabelas necessárias no banco de dados.

## Diagrama de relacionamento


![locadoraVeiculos@localhost](https://github.com/Squad-10-Projects/desafio-locadora-carros/assets/125394284/87f833e9-dab0-4d3a-8d5c-d9973e5e45e4)


## Caso de uso


![Car Rental Reservation System (4)](https://github.com/Squad-10-Projects/desafio-locadora-carros/assets/125394284/0ddfc82c-46e7-4ace-80f1-ff65dc6b9388)

  
