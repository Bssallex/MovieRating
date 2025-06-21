# 🎬 Avaliação de Filmes

API REST desenvolvida para que usuários possam criar seu próprio catálogo de filmes, avaliando-os com base em critérios personalizados como: nome, descrição, nota, gênero, crítica e experiência pessoal.

Projetada para ser escalável, com base em Arquitetura Limpa e preparada para produção com autenticação via OAuth2 (Google), documentação com Swagger/OpenAPI, versionamento com Flyway e deploy em nuvem (AWS - EC2).

## 📊 Tecnologias e Ferramentas

- Java 17  
- Spring Boot  
- Arquitetura Limpa  
- Spring Security + OAuth2 (Google)  
- Swagger / OpenAPI  
- Lombok  
- DTOs e Mapper  
- Maven  
- Flyway  
- Docker + PostgreSQL  
- AWS EC2  
- ResponseEntity  
- Exceções personalizadas (RuntimeException)  

---

## 🚀 Funcionalidades

- 🔍 Listar todos os filmes  
- 🔍 Buscar filme por ID ou nome  
- 📝 Criar um novo filme  
- ✏️ Alterar todos os dados de um filme  
- ✏️ Alterar um único atributo de um filme  
- 🗑️ Deletar um filme  
- 🔐 Autenticação com OAuth2 (Google)  

---

## 🧠 Regra de Negócio Principal (Entidade `Movies`)

| Atributo         | Descrição                                  |
|------------------|--------------------------------------------|
| MovieTitle       | Título do filme                            |
| Description      | Descrição do filme                         |
| Rating           | Nota (ex: 8.5)                            |
| ReleaseYear      | Ano de lançamento                         |
| DateWatched      | Data em que o usuário assistiu             |
| Genre            | Gênero do filme                           |
| Review           | Crítica pessoal                           |
| UserExperience   | Experiência do usuário ao assistir o filme |

---

## 📌 Endpoints

| Método HTTP | Caminho                  | Descrição                         | Status                   |
|-------------|--------------------------|----------------------------------|--------------------------|
| GET         | /movies                  | Listar todos os filmes            | 200 OK                   |
| GET         | /movies/{id}             | Buscar filme por ID               | 200 OK / 404 Not Found    |
| GET         | /movies                  | Buscar filme por nome             | 200 OK / 404 Not Found    |
| POST        | /movies                  | Criar novo filme                  | 201 Created              |
| PUT         | /movies/{id}             | Alterar todos os dados do filme  | 200 OK / 404 Not Found    |
| PATCH       | /movies/{id}             | Alterar um único atributo         | 200 OK / 404 Not Found    |
| DELETE      | /movies/{id}             | Deletar um filme                 | 200 OK / 404 Not Found    |

---

## 🔐 Segurança

Autenticação com OAuth2 Google via Spring Security:

- 🔐 Autorização baseada em token (JWT)  
- ⚙️ Possível implementação de perfis (admin/usuário)  
- 🔒 API voltada para uso pessoal/privado com proteção extra via Google  

---

## 📑 Documentação da API

- Documentação automática com **Swagger / OpenAPI**  
- Acesse via: `http://localhost:8080/swagger-ui.html`  

---

## 📅 Melhorias Futuras

- ✅ Testes automatizados (JUnit + Mockito)    
- 🔄 Atualização parcial de atributos (PATCH)  
- 🌐 Integração com Angular para front-end    
