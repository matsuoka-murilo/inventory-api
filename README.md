# Inventory API

API REST para gerenciamento de produtos com categorias fixas, desenvolvida em Java com Spring Boot.

## Descrição

Esta API permite:

* Criar, atualizar, listar e deletar produtos
* Validar dados de entrada usando `@Valid`
* Tratar exceções de forma padronizada com `@RestControllerAdvice`
* Relacionar produtos a categorias fixas
* Paginar resultados

Categorias são fixas e cadastradas diretamente no banco.

---

## Tecnologias Utilizadas

* Java 17
* Spring Boot
* Spring Data JPA / Hibernate
* MySQL
* MapStruct (Mapper DTO → Entity, usado para converter objetos de entrada em entidades JPA de forma automática)
* Bean Validation (`@Valid`)
* Lombok (opcional)
* Docker

---

## Como Rodar

### 1. Rodando localmente

1. Clone o repositório:

```bash
git clone https://github.com/matsuoka-murilo/inventory-api.git
```

2. Entre na pasta do projeto:

```bash
cd inventory-api
```

3. Configure o banco de dados MySQL em `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/inventory_db
spring.datasource.username=root
spring.datasource.password=1234
spring.jpa.hibernate.ddl-auto=update
```

4. Execute a aplicação:

```bash
mvn spring-boot:run
```

A API estará disponível em `http://localhost:8080`.

---

### 2. Rodando com Docker

1. Certifique-se de ter o **Docker** instalado.

2. Crie um `Dockerfile` na raiz do projeto:

```dockerfile
FROM openjdk:17-jdk-alpine
ARG JAR_FILE=target/inventory-api-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
```

3. (Opcional) Crie um `docker-compose.yml` para rodar a aplicação junto com MySQL:

```yaml
version: "3.8"
services:
  db:
    image: mysql:8
    environment:
      MYSQL_ROOT_PASSWORD: 1234
      MYSQL_DATABASE: inventory_db
    ports:
      - "3306:3306"
    volumes:
      - db_data:/var/lib/mysql

  app:
    build: .
    depends_on:
      - db
    ports:
      - "8080:8080"
    environment:
      SPRING_DATASOURCE_URL: jdbc:mysql://db:3306/inventory_db
      SPRING_DATASOURCE_USERNAME: root
      SPRING_DATASOURCE_PASSWORD: 1234

volumes:
  db_data:
```

4. Suba os containers:

```bash
docker-compose up --build
```

A API estará disponível em `http://localhost:8080`.

---

## Endpoints da API

### Produtos

| Método | Endpoint                   | Descrição                    |
| ------ | -------------------------- | ---------------------------- |
| GET    | `/products`                | Lista todos os produtos      |
| GET    | `/products?page=0&size=10` | Lista produtos com paginação |
| POST   | `/products`                | Cria um produto              |
| PUT    | `/products`                | Atualiza um produto          |
| DELETE | `/products/{id}`           | Deleta um produto            |

---

## Exemplo de Requisição

```http
POST /products
Content-Type: application/json

{
  "name": "Notebook Dell",
  "price": 3500.0,
  "quantity": 10,
  "categoryId": 1
}
```

Exemplo de resposta:

```json
{
  "id": 1,
  "name": "Notebook Dell",
  "price": 3500.0,
  "quantity": 10,
  "category": {
    "id": 1,
    "name": "Eletrônicos"
  }
}
```

---

## Autor

Murilo Matsuoka - [GitHub](https://github.com/matsuoka-murilo)
