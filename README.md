# Projeto de Energia Sustentável

Este projeto é uma API desenvolvida em **Java**, utilizando **Spring Boot**, com o objetivo de gerenciar usuários, dispositivos, consumo energético e fornecer recomendações relacionadas a práticas sustentáveis. A aplicação utiliza um banco de dados Oracle e foi projetada seguindo boas práticas de arquitetura REST.

---

## **Funcionalidades**

1. Gerenciamento de usuários (Admin e Usuário).
2. Cadastro e monitoramento de dispositivos (reais ou simulados).
3. Registro de consumo energético em tempo real.
4. Configuração de tarifas e tempos de consumo.
5. Recomendação de práticas sustentáveis baseadas em consumo.

---

## **Tecnologias Utilizadas**

- **Java** com **Spring Boot** (framework principal).
- **Gradle** (gerenciador de dependências e build).
- **Spring Data JPA** (persistência de dados).
- **Oracle Database** (banco de dados relacional).
- **Swagger** (documentação e testes da API).
- **HATEOAS** (para atender ao nível 3 de maturidade REST).
- **Bean Validation** (validações de entrada).
- **Azure** (deploy na nuvem).

---

## **Configuração do Ambiente**

### **1. Pré-requisitos**
- **JDK 17** ou superior.
- **Gradle 7.0** ou superior.
- **Oracle Database** configurado e acessível.
- Ferramentas opcionais:
    - **Postman** para testes.
    - **Docker** (se desejar usar um contêiner para Oracle DB).

### **2. Configuração do Banco de Dados**
1. Crie as tabelas no banco Oracle utilizando o seguinte script:
   ```sql
   CREATE TABLE USUARIO_GS_JAVA (
       ID NUMBER PRIMARY KEY,
       NOME VARCHAR2(100) NOT NULL,
       EMAIL VARCHAR2(100) UNIQUE NOT NULL,
       SENHA VARCHAR2(50) NOT NULL,
       DATA_CADASTRO DATE DEFAULT SYSDATE,
       TIPO_USUARIO VARCHAR2(20) CHECK (Tipo_Usuario IN ('Admin', 'Usuario'))
   );

   CREATE TABLE DISPOSITIVO_GS_JAVA (
       ID NUMBER PRIMARY KEY,
       NOME VARCHAR2(100) NOT NULL,
       TIPO VARCHAR2(20) CHECK (Tipo IN ('Real', 'Simulado')),
       POTENCIA NUMBER,
       STATUS VARCHAR2(10) CHECK (Status IN ('Ativo', 'Inativo')),
       ID_USUARIO NUMBER,
       FOREIGN KEY (ID_USUARIO) REFERENCES USUARIO_GS(ID)
   );

   CREATE TABLE CONSUMO_GS_JAVA (
       ID NUMBER PRIMARY KEY,
       DATA_HORA TIMESTAMP DEFAULT SYSTIMESTAMP,
       VALOR_CONSUMO NUMBER NOT NULL,
       ID_DISPOSITIVO NUMBER,
       ID_USUARIO NUMBER,
       FOREIGN KEY (ID_DISPOSITIVO) REFERENCES DISPOSITIVO_GS(ID),
       FOREIGN KEY (ID_USUARIO) REFERENCES USUARIO_GS(ID)
   );

   CREATE TABLE CONFIGURACAO_GS_JAVA (
       ID NUMBER PRIMARY KEY,
       TARIFA_ENERGIA NUMBER NOT NULL,
       TEMPO_CONSUMO NUMBER NOT NULL,
       ID_USUARIO NUMBER,
       FOREIGN KEY (ID_USUARIO) REFERENCES USUARIO_GS(ID)
   );

   CREATE TABLE RECOMENDACAO_GS_JAVA (
       ID NUMBER PRIMARY KEY,
       DESCRICAO VARCHAR2(200) NOT NULL,
       DATA_CRIACAO DATE DEFAULT SYSDATE,
       TIPO_RECOMENDACAO VARCHAR2(20) CHECK (TIPO_RECOMENDACAO IN ('Geral', 'Baseado')),
       ID_USUARIO NUMBER,
       FOREIGN KEY (ID_USUARIO) REFERENCES USUARIO_GS(ID)
   );"


## Configuração do application.properties

    spring.datasource.url=jdbc:oracle:thin:@oracle.fiap.com.br:1521/orcl
    spring.datasource.username=(seu usuario aqui) #rm553635
    spring.datasource.password=(sua senha aqui) #190101
    spring.datasource.driver-class-name=oracle.jdbc.OracleDriver

    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true
    spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.Oracle12cDialect


## Como iniciar o projeto
### 1. Clone o repositório:
- git clone https://github.com/gabrieltf1901/GS-JAVA.git
### 2. Configure o banco de dados.
### 3. Compile e execute o projeto.
### 4. Acesse a aplicação pelo Swagger na seguinte URL:
- http://localhost:8080/swagger-ui.html


## Documentação e Testes com Swagger
### 1. Após iniciar o projeto, acesse o Swagger:
- http://localhost:8080/swagger-ui.html
### A interface do Swagger permitirá:
- Testar endpoints como GET, POST, PUT e DELETE.
- Visualizar os parâmetros necessários para cada endpoint.
- Examinar os códigos de status retornados pela API.

### Exemplo de Teste no Swagger
- Endpoint: POST /usuarios
- Request Body:

{
"nome": "João Silva",
"email": "joao.silva@example.com",
"senha": "123456",
"tipoUsuario": "Usuario"
}
- Resposta:
Status Code: 201 Created
- Body:

{
"id": 1,
"nome": "João Silva",
"email": "joao.silva@example.com",
"tipoUsuario": "Usuario",
"dataCadastro": "2024-11-21"
}


### LINK VÍDEO DEPLOY --> 
### LINK VÍDEO PROJETO FUNCIONANDO ---> https://youtu.be/MHkCL6Bx1D8
### LINK VÍDEO PITCH ---> https://youtu.be/kNfAU4zAZ5o



## Autores
- Gabriel Torres Fernandes - Desenvolvedor Principal
- RM: 553635

