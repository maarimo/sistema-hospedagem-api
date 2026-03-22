# 🏨 Sistema de Hospedagem API

API REST desenvolvida com **Spring Boot** para gerenciamento de hóspedes, quartos e pagamentos.

---

## 🚀 Tecnologias utilizadas

* Java 21
* Spring Boot
* Spring Web
* Spring Data JPA
* PostgreSQL
* Lombok
* Swagger (OpenAPI)

---

## 📌 Funcionalidades

### 👥 Hóspedes (Guests)

* Cadastrar hóspede
* Listar hóspedes
* Buscar por ID
* Deletar hóspede
* Associar hóspede a um quarto

### 🛏️ Quartos (Rooms)

* Criar quarto
* Listar quartos
* Buscar por ID
* Deletar quarto

### 💰 Pagamentos (Payments)

* Registrar pagamento
* Listar pagamentos
* Buscar por ID

---

## 🧠 Regras de negócio

* Um hóspede só pode ter **um pagamento**
* O status do hóspede depende do pagamento:

  * `PAID` → `ACTIVE`
  * `PENDING` ou `PARTIAL` → `PENDING`
* Não é permitido cadastrar dois hóspedes com o mesmo CPF
* Um hóspede deve estar vinculado a um quarto

---

## 📂 Estrutura do projeto

```
com.hospedagem.sistema
 ├── controller
 ├── service
 ├── repository
 ├── domain
 ├── dto
 └── exception
```

---

## ⚙️ Como rodar o projeto

### 1. Clonar o repositório

```bash
git clone https://github.com/seu-usuario/sistema-hospedagem-api.git
```

---

### 2. Configurar o banco de dados

No arquivo `application.yaml`:

```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/hospedagem
    username: postgres
    password: sua_senha

  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
```

---

### 3. Rodar a aplicação

```bash
./mvnw spring-boot:run
```

ou pela sua IDE.

---

## 📄 Documentação da API (Swagger)

Após iniciar o projeto, acesse:

```
http://localhost:8080/swagger-ui/index.html
```

---

## 🧪 Exemplos de requisições

### ➕ Criar hóspede

**POST /**
