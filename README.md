# NOME: GABRIEL TORRES FERNANDES - RM553635
## VIDEO PITCH --> https://youtu.be/c8zKYAyTgkI
## VIDEO DEMONSTRAÇÃO --> https://youtu.be/p1viLC-j2kg


# Gestão de Abrigos e Recursos

**Descrição:**
Aplicação web desenvolvida em Java 17 com Spring Boot e Thymeleaf para gerenciar abrigos temporários e estoques de recursos em cenários de emergências. Fornece informações em tempo real, com autenticação via OAuth2, internacionalização, comunicação assíncrona via RabbitMQ e integração com Spring AI para assistentes inteligentes.

---

## Contexto Geral

Em cenários de desastres naturais (enchentes, tempestades ou terremotos), a coordenação rápida de abrigos e recursos é vital para o socorro humanitário. Esta aplicação centraliza dados de abrigos, estoques e alerta sobre níveis críticos de suprimentos.

---

## Tecnologias e Dependências (Gradle)

**build.gradle.kts**:

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

---

## Arquitetura em Camadas

* **controller**: endpoints REST e mapeamento de páginas Thymeleaf.
* **service**: regras de negócio, orquestração de fluxo e integração com RabbitMQ/Spring AI.
* **repository**: interfaces Spring Data JPA para Oracle.
* **model**: entidades JPA (`Abrigo`, `Recurso`, `User`).
* **dto**: objetos de transferência para views e APIs.
* **config**: configurações de segurança, OAuth2, i18n, RabbitMQ e Spring AI.
* **event**: eventos da aplicação.

---

## Funcionalidades Principais

1. **CRUD** de abrigos, recursos e estoques com validação.
2. **Internacionalização** (pt\_BR e en\_US).
3. **OAuth2**: login via provedor externo.
4. **RabbitMQ**: produtor envia mensagens sobre filas; consumidor processa e atualiza relatórios.
5. **Spring AI**: assistente que sugere reabastecimento baseado em níveis críticos.
6. **Testes**: JUnit 5 + Mockito (unitários) e Testcontainers (integração).

---

## Modelagem de Dados

Esquema Oracle (3FN): `ABRIGO`, `RECURSO`, `ESTOQUE_ABRIGO`.

---

## Configuração e Execução

1. **Clone** o repositório:

   ```bash
   ```

git clone https\://...
cd gestao-abrigos

````
2. **Configure** `src/main/resources/application.properties`:
   ```properties
spring.datasource.url=jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL
spring.datasource.username=rm553635
spring.datasource.password=190101

oauth2.client.client-id=...
oauth2.client.client-secret=...
````

3. **Ambiente**: variáveis para credenciais OAuth2 e RabbitMQ.
4. **Rodar**:

   ```bash
   ```

gradlew bootRun

````
Acesse em [http://localhost:8080](http://localhost:8080).

---

## Testes

```bash
gradlew test
````

* **Unitários**: cobertura de serviços e controllers.
* **Integração**: Testcontainers Oracle e RabbitMQ.

---
