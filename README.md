# 🗳️ Votação Big Brother (Simulação com Spring Boot, RabbitMQ e MySQL)

## 🧠 Projeto de aprendizado

Este projeto foi criado com o objetivo principal de aprender a integrar **RabbitMQ**, **MySQL** e **Spring Boot**, simulando um sistema de votação similar ao programa **Big Brother Brasil**.

### Funcionalidades principais

- Simula votos em candidatos (representados por IDs).
- Usa **RabbitMQ (versão 4.1.2 via Docker)** para processar os votos de forma assíncrona.
- Persiste os dados em **MySQL**, também executado via Docker.
- Mostra experiência prática com mensageria + persistência.

---

## 🚀 Tecnologias utilizadas

- **Java + Spring Boot**: backend com endpoints REST e lógica de envio e consumo de mensagens.
- **RabbitMQ (4.1.2-management)** via container Docker: fila de votos.
- **MySQL** via Docker: armazenamento persistente dos resultados.
- **Docker-compose** (facultativo): facilita a orquestração dos containers.

---

## 📦 Setup local (via Docker)

1. Execute o RabbitMQ:
   ```bash
   docker run -d --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:4.1.2-management
   ```
2. Execute o MySQL:
   ```bash
   docker run -d --name mysql -e MYSQL_ROOT_PASSWORD=senha -e MYSQL_DATABASE=votacao -p 3306:3306 mysql:8
   ```
3. Ajuste `application.properties` ou `.yml` no Spring Boot com:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/votacao
   spring.datasource.username=root
   spring.datasource.password=senha

   spring.rabbitmq.host=localhost
   spring.rabbitmq.port=5672
   ```
4. Build & run:
   ```bash
   mvn spring-boot:run
   ```
   ou
   ```bash
   ./mvnw spring-boot:run
   ```

---

## 🎯 Como funciona

1. A aplicação recebe um *payload* contendo o **ID do candidato**.
2. O voto é publicado em uma **fila RabbitMQ**.
3. Um consumidor assíncrono processa esse voto e persiste no banco MySQL.
4. É possível acumular quantos votos quiser, em sequência rápida ou programada.
5. Permite simular cenários de votação automatizada e testar a robustez da arquitetura.

---

## 📝 Requisitos e instruções

### Pré-requisitos

- Docker (para RabbitMQ e MySQL)
- Java 17+ (ou compatível)
- Maven

### Executando localmente

- Suba os containers Docker (RabbitMQ e MySQL)
- Ajuste as credenciais no arquivo de configuração
- Execute a aplicação Spring Boot

### Exemplos de payload

Você pode testar via Postman ou `curl`:

```json
{ "id": 1 }
```

### Futuras melhorias

- Suporte à múltiplos candidatos e totals agregados.
- Dashboard de resultados (frontend).
- Segurança (autenticação/autorização).
- Docker Compose para orquestração completa.
- Testes unitários e de integração.

---

## ✅ Por que usar este projeto?

- Simples de rodar localmente com Docker.
- Excelente para aprendizado de **mensageria (RabbitMQ)** e **persistência (MySQL)** no ecossistema Spring Boot.
- Permite prototipar rapidamente casos de uso reais envolvendo votação ou sistema de eventos.

---
