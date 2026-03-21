# 📄 SRS – Sistema de Hospedagem

---

## 📌 Introdução

### 🎯 Objetivo do Sistema
Este sistema tem como objetivo gerenciar o processo de hospedagem, incluindo o controle de hóspedes, pagamentos e distribuição de quartos.

### 📦 Escopo
O sistema permitirá:
- Cadastro de hóspedes
- Controle de pagamentos
- Gerenciamento de quartos

**Fora do escopo:**
- Integração com sistemas externos

---

## 👥 Stakeholders (Interessados)

- Coordenador de Hospedagem  
- Administrador do sistema  
- (Opcional) Recepcionista  

---

## 🧩 Visão Geral do Sistema

O sistema será uma aplicação web que permitirá:
- Gerenciamento de hóspedes  
- Controle de pagamentos  
- Distribuição de quartos  
- Visualização de informações relevantes para administração  

---

## ✅ Requisitos Funcionais

### 👤 Gestão de Hóspedes
- **RF01** - O sistema deve permitir cadastrar hóspedes  
- **RF02** - O sistema deve permitir editar dados do hóspede  
- **RF03** - O sistema deve permitir excluir hóspedes  
- **RF04** - O sistema deve listar hóspedes  

### 💰 Pagamentos
- **RF05** - O sistema deve registrar pagamentos  
- **RF06** - O sistema deve mostrar status de pagamento  

### 🛏️ Quartos
- **RF07** - O sistema deve permitir gerenciar a distribuição de quartos  
- **RF08** - O sistema deve permitir associar hóspedes a quartos  

---

## ⚙️ Requisitos Não Funcionais

- **RNF01** - O sistema deve responder às requisições em até 2 segundos  
- **RNF02** - O sistema deve ser acessível via navegadores modernos  
- **RNF03** - O sistema deve garantir a segurança dos dados dos usuários  
- **RNF04** - O sistema deve possuir interface simples e intuitiva  
- **RNF05** - O sistema deve garantir persistência dos dados (não perder informações)  

---

## 📏 Regras de Negócio

- **RN01** - Um hóspede só pode ser considerado ativo se houver pagamento registrado  
- **RN02** - O pagamento pode ser parcial ou total  
- **RN03** - Não pode haver dois hóspedes com o mesmo CPF  
- **RN04** - Um quarto só pode ser ocupado por um hóspede por vez  
- **RN05** - Um hóspede só pode estar associado a um quarto por vez  

---

## 🗂️ Modelo de Dados

### 👤 Hóspede
- id  
- nome  
- CPF  
- telefone  
- status  

### 💰 Pagamento
- id  
- valor  
- data  
- status (**PAGO, PENDENTE, PARCIAL**)  
- hospede_id  

### 🛏️ Quarto
- id  
- numero  
- status (**DISPONÍVEL, OCUPADO**)  

---

## 🔗 Relacionamentos

- Um hóspede pode ter vários pagamentos  
- Um hóspede pode estar associado a um quarto  
- Um quarto pode ter no máximo um hóspede  
 
