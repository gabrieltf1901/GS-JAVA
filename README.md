# NOME: GABRIEL TORRES FERNANDES - RM553635
## VIDEO PITCH --> https://youtu.be/c8zKYAyTgkI
## VIDEO DEMONSTRAÇÃO --> https://youtu.be/p1viLC-j2kg

### LINK DO DEPLOY NA AZURE --> http://webapp-java-58.azurewebsites.net/


# Gestão de Abrigos e Recursos

## Visão Geral

Aplicação web desenvolvida em Java 17 com Spring Boot e Thymeleaf para gerenciamento em tempo real de abrigos temporários e estoques de recursos em cenários de emergência (enchentes, tempestades, terremotos). Integra OAuth2 para autenticação, internacionalização (i18n), comunicação assíncrona via RabbitMQ, assistente inteligente com Spring AI e testes automatizados.

## Funcionalidades Principais

* **CRUD** completo para Entidades: Abrigo, Recurso e User, com validação de dados.
* **Autenticação**: OAuth2 Client para login via provedor externo.
* **Internacionalização**: Suporte a pt\_BR e en\_US.
* **Templates Dinâmicos**: Layout reutilizável via Thymeleaf Fragments.
* **RabbitMQ**: Produtor e Consumidor para alertas de reabastecimento.
* **Spring AI**: Assistente que sugere ações baseadas em níveis críticos.
* **Arquitetura em Camadas**: controller, service, repository, model, dto, config, event.
* **Testes**: Unitários (JUnit5, Mockito) e Integração (Testcontainers Oracle & RabbitMQ).

## Tecnologias

* Java 17
* Spring Boot 3.5.0
* Thymeleaf 3.1
* Spring Security OAuth2
* Spring Data JPA (Oracle)
* Spring AMQP (RabbitMQ)
* Spring AI (OpenAI)
* Gradle Kotlin DSL
* Testcontainers
* JUnit 5, Mockito

## Estrutura do Projeto

```
src/main/java/com/gestaoabrigos/
├── config       # Configurações de segurança, OAuth2, i18n, RabbitMQ, Spring AI
├── controller   # Endpoints REST e mapeamento de views
├── service      # Regras de negócio e integração com filas/AI
├── repository   # Interfaces Spring Data JPA
├── model        # Entidades JPA (Abrigo, Recurso, EstoqueAbrigo, User)
├── dto          # Data Transfer Objects para API e views
├── event        # Eventos de domínio e listeners
└── GestaoAbrigosApplication.java
```

## Dependências (build.gradle.kts)

```kotlin
plugins {
	id 'java'
	id 'org.springframework.boot' version '3.5.0'
	id 'io.spring.dependency-management' version '1.1.7'
}

group = 'com.gestaoabrigos'
version = '0.0.1-SNAPSHOT'

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(17)
	}
}

repositories {
	mavenCentral()
	maven { url 'https://repo.spring.io/milestone' }
}

dependencies {
	implementation 'org.springframework.boot:spring-boot-starter-amqp'
	implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
	implementation 'org.springframework.boot:spring-boot-starter-oauth2-client'
	implementation 'org.springframework.boot:spring-boot-starter-security'
	implementation 'org.springframework.boot:spring-boot-starter-thymeleaf'
	implementation 'org.springframework.boot:spring-boot-starter-validation'
	implementation 'org.springframework.boot:spring-boot-starter-web'
	implementation 'org.thymeleaf.extras:thymeleaf-extras-springsecurity6'



	implementation platform("org.springframework.ai:spring-ai-bom:1.0.0")
	implementation "org.springframework.ai:spring-ai-starter-model-openai:1.0.0"

	runtimeOnly "com.oracle.database.jdbc:ojdbc8:19.3.0.0"

	developmentOnly 'org.springframework.boot:spring-boot-devtools'
	testImplementation 'org.springframework.boot:spring-boot-starter-test'
	testImplementation 'org.springframework.amqp:spring-rabbit-test'
	testImplementation 'org.springframework.security:spring-security-test'
	testImplementation 'org.springframework.boot:spring-boot-starter-test'
	testRuntimeOnly 'org.junit.platform:junit-platform-launcher'
}

tasks.named('test') {
	useJUnitPlatform()
}

```

## Configuração

1. Clone o repositório:

   ```bash
   ```

git clone https://github.com/gabrieltf1901/GS-JAVA.git
cd gestaoabrigos

````
2. Ajuste `src/main/resources/application.properties`:
   ```properties
spring.datasource.url=jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL
spring.datasource.username=rm553635
spring.datasource.password=190101

spring.rabbitmq.host=localhost
spring.rabbitmq.port=5672
````

3. Defina variáveis de ambiente para OAuth2, RabbitMQ e OPENAI se necessário.

## Executando a Aplicação

```bash
./gradlew bootRun
```

Acesse http://localhost:8080.

## Banco de Dados

Tabelas Oracle (3FN):

* ABRIGO
* RECURSO
* ESTOQUE\_ABRIGO
* USER

Exemplo de criação e inserção no diretório `db/`.

## Testes

Para rodar todos os testes:

```bash
./gradlew test
```

* **Unitários**: Cobertura de serviços e controllers com Mockito.
* **Integração**: Testcontainers Oracle e RabbitMQ.

