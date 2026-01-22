# 🏦 Desafio Backend PicPay

<div align="center">

![Java](https://img.shields.io/badge/Java-21-orange?style=for-the-badge&logo=java)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.0.1-brightgreen?style=for-the-badge&logo=springboot)
![Maven](https://img.shields.io/badge/Maven-3.9+-red?style=for-the-badge&logo=apachemaven)
![H2 Database](https://img.shields.io/badge/H2-Database-blue?style=for-the-badge)

Solução backend para o desafio de vaga da [PicPay](https://www.picpay.com/) desenvolvida com Spring Boot

[Visão Geral](#visão-geral) • [Features](#features) • [Tecnologias](#tecnologias) • [Como Executar](#como-executar) • [Endpoints](#endpoints) • [Estrutura](#estrutura)

</div>

---

## 📋 Visão Geral

Sistema de transferência de dinheiro que implementa a transferência entre usuários, com validações de negócio, notificações e tratamento de exceções robustos.

---

## ✨ Features

- ✅ Gerenciamento de usuários com tipos diferenciados (comum, lojista)
- ✅ Sistema de transferências entre usuários
- ✅ Validações de negócio (saldo, tipo de usuário)
- ✅ Notificação de transferências
- ✅ Tratamento centralizado de exceções
- ✅ Banco de dados em memória (H2)
- ✅ API RESTful com padrão DTO
- ✅ Uso de Lombok para reduzir boilerplate

---

## 🛠️ Tecnologias

| Tecnologia | Versão | Descrição |
|-----------|--------|-----------|
| **Java** | 21 | Linguagem de programação |
| **Spring Boot** | 4.0.1 | Framework principal |
| **Spring Data JPA** | Latest | ORM para persistência |
| **H2 Database** | Latest | Banco de dados em memória |
| **Lombok** | Latest | Redução de boilerplate |
| **Maven** | 3.9+ | Gerenciador de dependências |

---

## 🚀 Como Executar

### Pré-requisitos

- Java 21+
- Maven 3.9+
- Git

### Instalação

1. **Clone o repositório**
```bash
git clone https://github.com/PominiGa/Desafio-PicPay?tab=readme-ov-file#visão-geral
cd desafiopicpay
```

2. **Instale as dependências**
```bash
mvn clean install
```

3. **Execute a aplicação**
```bash
mvn spring-boot:run
```

A aplicação estará disponível em: `http://localhost:8080`

### Acessar H2 Console

O banco de dados H2 pode ser acessado em:
```
http://localhost:8080/h2-console
```

**Credenciais padrão:**
- URL: `jdbc:h2:mem:testdb`
- Usuário: `sa`
- Senha: (vazia)

---

## 📡 Endpoints

### Transações

#### Criar Transferência
```http
POST /transactions
Content-Type: application/json

{
  "value": 100.00,
  "senderId": 1,
  "receiverId": 2,
  "description": "Pagamento de serviço"
}
```

**Response (200 OK)**
```json
{
  "id": 1,
  "value": 100.00,
  "senderId": 1,
  "receiverId": 2,
  "timestamp": "2024-01-21T10:30:00"
}
```

**Possíveis Erros:**
- `400` - Usuário remetente não encontrado ou não tem saldo
- `400` - Usuário remetente é do tipo lojista (não pode enviar)
- `400` - Usuário destinatário não encontrado
- `500` - Falha ao processar a transferência

---

### Usuários

#### Criar Usuário
```http
POST /users
Content-Type: application/json

{
  "firstName": "João",
  "lastName": "Silva",
  "document": "12345678900",
  "email": "joao@example.com",
  "password": "senha123",
  "balance": 1000.00,
  "userType": "COMMON"
}
```

**Response (201 Created)**
```json
{
  "id": 1,
  "firstName": "João",
  "lastName": "Silva",
  "document": "12345678900",
  "email": "joao@example.com",
  "balance": 1000.00,
  "userType": "COMMON"
}
```


### Padrões Utilizados

- **MVC**: Separação de controladores, serviços e repositórios
- **DTO**: Data Transfer Objects para desacoplamento
- **Exception Handler**: Tratamento centralizado de exceções
- **Repository Pattern**: Abstração da camada de dados com Spring Data JPA

---

## 💼 Regras de Negócio

### Transferências
- ✋ Apenas usuários COMMON podem enviar dinheiro
- 💰 Usuários devem ter saldo suficiente
- 🏪 Lojistas (MERCHANT) não podem enviar transferências
- 📬 Após transferência bem-sucedida, uma notificação é enviada

### Usuários
- 📄 Documento CPF/CNPJ deve ser único
- ✉️ Email deve ser único
- 💵 Saldo inicial não pode ser negativo

---

## 🧪 Testes

Para executar os testes unitários:

```bash
mvn test
```

Os testes cobrem:
- Criação e validação de usuários
- Processamento de transferências
- Tratamento de exceções
- Notificações

---

## 🔒 Segurança

- Validação de entrada em todos os endpoints
- Exceções tratadas de forma segura
- Senhas não expostas em responses
- DTOs usados para controlar dados expostos

---

## 📝 Configurações

### application.properties

```properties
# Banco de Dados
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.username=sa

# JPA/Hibernate
spring.jpa.hibernate.ddl-auto=create-drop
spring.jpa.show-sql=true

# H2 Console
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
```

---


## 👨‍💻 Contribuição

Contribuições são bem-vindas! Para contribuir:

1. Faça um Fork do projeto
2. Crie uma branch para sua feature (`git checkout -b feature/AmazingFeature`)
3. Commit suas mudanças (`git commit -m 'Add some AmazingFeature'`)
4. Push para a branch (`git push origin feature/AmazingFeature`)
5. Abra um Pull Request

---

## 📄 Licença

Este projeto está sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

---

## 📞 Contato

**Desenvolvedor**: Gabriel Pomini de Souza

- Email: seu.email@example.com
- LinkedIn: [Gabriel-Pomini](https://www.linkedin.com/in/gabriel-pomini-43aa731ba/)
- GitHub: [@PominiGa](https://github.com/PominiGa)
