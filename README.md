 # Sistema Bancário Java - Simulador de Operações Financeiras 💰🤖

## 📌 **Sobre o Projeto**  
Sistema Bancário Java é um projeto de exemplo desenvolvido para simular as principais operações de uma conta bancária como forma de avaliação A3 na faculdade Anhembi Morumbi. A aplicação demonstra, de forma prática, o cadastro de clientes, a criação de contas e operações financeiras como depósito, saque, compra com cashback e consulta de extrato, utilizando os conceitos da programação orientada a objetos. Além disso, o código contém comentários explicativos que descrevem a lógica e o funcionamento dos principais métodos, com o objetivo de facilitar a compreensão e documentação do sistema.

## 🚀 Instruções de Execução
Pré-requisitos:
- Java JDK 11+ instalado
- Um terminal ou IDE como IntelliJ, Eclipse ou VS Code

## 🛠️ **Ferramentas Utilizadas**  
- **Java:** Linguagem de programação utilizada para o desenvolvimento do sistema.  

##  **Funcionalidades**  
- 📋 **Cadastro de Clientes:** Registra dados como nome, CPF, email e ano de nascimento, validando a condição de maioridade.  
- 🏦 **Criação de Conta:** Gera automaticamente uma conta bancária para cada cliente cadastrado.  
- 💵 **Depósito e Saque:** Permite operações financeiras básicas, atualizando o saldo e registrando cada transação.  
- 🛒 **Compra com Cashback:** Simula a realização de uma compra e aplica um cashback de 5% sobre o valor gasto.  
- 📃 **Consulta de Extrato:** Exibe o histórico completo de todas as transações realizadas na conta, com detalhes de data, tipo e valor.

## 💻 Exemplo de Uso
Cadastro e operação em conta:

```plaintext
Digite:
(1) Cadastrar um cliente
(2) Realizar um deposito
(3) Realizar um saque
(4) Realizar uma compra
(5) Visualizar extrato
(6) Para sair

> 1
Nome: João
CPF: 123.456.789-00
Email: joao@email.com
Ano de nascimento: 1990
Cadastro realizado com sucesso!
Cliente: João
Número da Conta: C1
Saldo Inicial: 0.0

> 2
Digite o número da conta para depósito: C1
Digite o valor para depósito: 1000
Depósito de R$: 1000.0 realizado com sucesso.
Saldo atual: 1000.0

> 4
Digite o número da conta para compra: C1
Nome do produto: Headphone
Valor do produto: 200
Cashback concedido: Cashback de compra: Headphone - R$ 10.0

> 5
Extrato da conta C1 :
DEPOSITO de R$ 1000.0 - 16/06/2025 09:27:00
COMPRA de R$ 200.0 - Headphone - 16/06/2025 09:28:00
CASHBACK de R$ 10.0 - Cashback de compra: Headphone - 16/06/2025 09:28:00
Saldo atual: R$ 810.0
```

## 📂 **Estrutura do Projeto**  
```plaintext
SistemaBancario/
├── Main.java
├── Menu.java
├── SistemaBancario.java
├── Cliente.java
├── Conta.java
├── Transacao.java
├── TipoTransacao.java
└── Cashback.java


