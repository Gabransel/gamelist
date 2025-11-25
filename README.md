# 🎲 DSList - Game Collection API

![Java](https://img.shields.io/badge/Java-17-orange) ![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.0-green) ![PostgreSQL](https://img.shields.io/badge/PostgreSQL-Enabled-blue)

## 🚀 Sobre o Projeto (The "Why")
O **DSList** é uma API Backend desenvolvida para gerenciar coleções de jogos de forma dinâmica. Diferente de catálogos estáticos convencionais, este sistema resolve o problema de **curadoria personalizada**, permitindo que listas de jogos (ex: "Jogos de Plataforma", "RPGs") sejam não apenas visualizadas, mas **reordenadas arbitrariamente** pelo usuário.

O sistema foi arquitetado para suportar interfaces *Drag & Drop*, onde a persistência da nova ordem é processada de forma eficiente no banco de dados, garantindo integridade posicional sem a necessidade de reescrever toda a lista.

## 🛠 Tech Stack
* **Linguagem:** Java 17
* **Framework:** Spring Boot 3
* **ORM:** Spring Data JPA / Hibernate
* **Database:** H2 (Testes) / PostgreSQL (Produção)
* **Build Tool:** Maven

## ⚙️ Arquitetura e Padrões
O projeto segue uma arquitetura em camadas (Layered Architecture) para isolamento de responsabilidades:
1.  **Controller Layer:** Endpoints REST que expõem os dados via DTOs (Data Transfer Objects), evitando vazamento de entidades sensíveis do banco.
2.  **Service Layer:** Contém a regra de negócios, incluindo o algoritmo de reordenação.
3.  **Repository Layer:** Abstração de acesso a dados com **consultas nativas SQL** otimizadas para performance.

## 💡 O Grande Desafio Técnico: Algoritmo de Reordenação
O diferencial deste projeto é a feature de **troca de posições (Move)**.
Quando um usuário arrasta um jogo da posição `X` para a posição `Y` no Frontend, o Backend não faz apenas uma troca simples.

**A Solução de Engenharia:**
Implementei um método `move(listId, sourceIndex, destinationIndex)` que:
1.  Remove o item da posição de origem em memória.
2.  Reinsere na posição de destino.
3.  Calcula o intervalo exato (`min` e `max`) das posições afetadas.
4.  Executa uma query nativa otimizada para atualizar **apenas** os itens que tiveram sua posição alterada no banco de dados.

```java
// Excerpt from GameListService.java
public void move(Long listId, int sourceIndex, int destinationIndex) {
    // ... lógica de manipulação da lista em memória ...
    
    // Atualização eficiente no Banco de Dados
    for (int i = min; i <= max; i++) {
        gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
    }
}
Isso garante que a operação seja atômica e performática, mesmo em listas extensas.

🔌 Endpoints Principais
A API segue o padrão RESTful. Abaixo os principais recursos:

GET /games - Busca paginada de todos os jogos (com DTO resumido).

GET /games/{id} - Busca detalhada de um jogo específico (DTO completo).

GET /lists - Lista as categorias disponíveis.

GET /lists/{id}/games - Busca jogos de uma categoria específica.

POST /lists/{id}/replacement - Endpoint de Reordenação (Recebe índices de origem e destino para atualizar a lista).

🏁 Como Rodar o Projeto
Pré-requisitos
Java 17 JDK

Maven

Passos
Clone o repositório:

Bash

git clone [https://github.com/Gabransel/gamelist.git](https://github.com/Gabransel/gamelist.git)
Entre na pasta do projeto:

Bash

cd gamelist
Execute o projeto (O perfil de test usará o banco H2 em memória automaticamente):

Bash

./mvnw spring-boot:run
Acesse o banco de dados H2 Console para validar as tabelas:

URL: http://localhost:8080/h2-console

JDBC URL: jdbc:h2:mem:testdb

User: sa

Password: (vazio)

Desenvolvido por Gabriel Anselmo com foco em Engenharia de Software e Algoritmos.
