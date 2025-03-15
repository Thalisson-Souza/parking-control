 # Parking Control API
 
![Static Badge](https://img.shields.io/badge/Java-v17-blue.svg) 
![Static Badge](https://img.shields.io/badge/SpringBoot-3.4.2-green.svg) 
![Static Badge](https://img.shields.io/badge/Jpa-3.4.2-orange.svg)
![Static Badge](https://img.shields.io/badge/Validation-3.4.2-yellow.svg) 
![Static Badge](https://img.shields.io/badge/MapStruct-1.5.3-8E44AD.svg) 


Este projeto é um sistema de gerenciamento de vagas de estacionamento desenvolvido com **Java** e **Spring Boot**. 
O objetivo é aplicar os conhecimentos adquiridos e construir uma solução para gerenciar reservas e liberação de vagas, 
utilizando **MySQL** para armazenamento e **Docker** para facilitar a execução dos serviços.

- **MySQL**: Armazena os dados das vagas e reservas.
- **Docker**: Facilita o gerenciamento e execução da aplicação.
- **Validation**: Garante a integridade dos dados nas requisições.
- **MapStruct**: Facilita o mapeamento entre entidades e DTOs.
- **JPA:** Gerencia a persistência de dados com o banco.

## **Instalação** 

1. Clone o repositório: e acesse a pasta do projeto:
```bash
git clone https://github.com/Thalisson-Souza/parking-control
cd nome-do-repositorio
```


2. **Instale as dependências necessárias** 
```bash 
./mvnw clean package
```


3. **Configure o Banco de Dados**  

Executando localmente com **MySQL**

- Edite o arquivo `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/"seu_banco_de_dados"
spring.datasource.username= "seu_user"
spring.datasource.password= "sua_passoword"
```
  
Executando com **MySQL** via **Docker**

- Edite o arquivo `docker-compose.yaml`:
```yaml
'MYSQL_DATABASE= "seu_banco_de_dados"'
'MYSQL_PASSWORD= "sua_password"'
'MYSQL_ROOT_PASSWORD= "sua_password"'
'MYSQL_USER= "seu_user"'
```

**Nota:**  Use os mesmos valores de `MYSQL_USER` e `MYSQL_PASSWORD` no 
`docker-compose.yaml` e no `application.properties` para evitar problemas de conexão.


- Para iniciar o container com o **Docker**, execute o comando `docker-compose up` no diretório do projeto: 

```bash
docker-compose up 
```

4. **Execute o projeto** 
```bash
mvn spring-boot::run
```

## Endpoints da API

| Método  | Endpoint                | Descrição                                |
|---------|-------------------------|------------------------------------------|
| `GET`   | `/parking-spot`          | Lista todas as vagas do estacionamento.  |
| `POST`  | `/parking-spot`          | Cria uma nova vaga de estacionamento.    |
| `PUT`   | `/parking-spot/{id}`     | Atualiza os dados de uma vaga existente. |
| `DELETE` | `/parking-spot/{id}`   | Deleta uma vaga especificada por ID.       


### Exemplo de Requisição 

- **POST** 

Criação de uma vaga de estacionamento:

```json
{
  "parkingSpotNumber": "NUMERO_DA_VAGA",
  "responsibleName": "RESPONSAVEL_PELA_VAGA",
  "block": "BLOCO_DA_VAGA",
  "car": {
    "plateCar": "PLACA_DO_CARRO",
    "modelCar": "MODELO_CARRO",
    "colorCar": "COR_CARRO"
  }
}
```

- **PUT**
    - Endpoint: `/parking-spot/{id}`
    - Campos permitidos a atualização: `responsibleName, modelCar, plateCar, colorCar`

Atualização de dados de uma vaga existente:
```json
{
  "parkingSpotNumber": "",
  "responsibleName": "ATUALIZE_NOME",
  "block": "",
  "car": {
    "plateCar": "ATUALIZE_PLACA",
    "modelCar": "ATUALIZE_MODELO",
    "colorCar": "ATUALIZE_COR"
  }
}
```


- **GET**
  - `/parking-spot` - Lista todas as vagas.
  - `/parking-spot/{id}` - Busca vaga por ID.
  - `/parking-spot/name/{name}` - Busca vaga pelo nome do responsável.
  - `/parking-spot/by-number/{spot-number}` - Busca vaga pelo número da vaga.

  

- **DELETE**

Remoção de uma vaga por ID:
  - Endpoint: `/parking-spot/{id}`



