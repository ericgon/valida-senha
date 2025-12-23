markdown

# Valida Senha

Valida Senha é uma aplicação em Java que valida senhas de acordo com critérios pré-definidos. O objetivo é garantir que a senha informada pelo usuário atenda a requisitos mínimos de segurança.

## Funcionalidades

- Validação de senha conforme regras:
    - Mínimo de 9 caracteres
    - Pelo menos 1 dígito
    - Pelo menos 1 letra minúscula
    - Pelo menos 1 letra maiúscula
    - Pelo menos 1 caractere especial (ex: !@#$%^&*()-+)
    - Sem caracteres repetidos
- Retorno indicando se a senha é válida ou não

## Tecnologias Utilizadas
Java 21

Spring Boot 3 (Web, DevTools)

JUnit 5 & Mockito (Testes Unitários e de Integração)

Maven (Gerenciamento de dependências)

## Como instalar

1. **Clone o repositório:**
   ```bash
   git clone https://github.com/ericgon/valida-senha.git
   cd valida-senha

##  Como Executar
Bash
mvn spring-boot:run
Acesse a API: A aplicação estará disponível em http://localhost:8080.

##  Testando a API
Via cURL
Bash

curl -X POST http://localhost:8080/v1/passwords/validate \
-H "Content-Type: application/json" \
-d '{"password": "AbTp9!fok"}'
Via Testes Automatizados
O projeto conta com cobertura de testes unitários para cada regra e testes de integração.

##  API Documentation
Endpoint: POST /v1/passwords/validate
Recebe uma senha e retorna um booleano.

Payload:

JSON

{
"password": "SenhaValida1!"
}
Resposta: true (ou false caso não atenda aos critérios).

## Arquitetura


Contato
Dúvidas ou sugestões? Entre em contato:

Eric Gonçalves