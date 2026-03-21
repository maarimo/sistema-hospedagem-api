📄SRS – Sistema de Hospedagem 

1. 📌 Introdução 

Objetivo do sistema 

Este sistema tem como objetivo gerenciar o processo de hospedagem, incluindo o controle de hóspedes, pagamentos e distribuição de quartos. 

Escopo 
O que o sistema cobre (e o que não cobre). 

Exemplo: 
O sistema permitirá cadastro de hóspedes, controle de pagamentos e gerenciamento de quartos, não incluindo integração com sistemas externos. 

 

2. 👥 Stakeholders (interessados) 

Quem usa ou se beneficia do sistema: 

Coordenador de Hospedagem  

Administrador do sistema  

(Opcional) Recepcionista 

 

3. 🧩 Visão Geral do Sistema 

 
O sistema será uma aplicação web que permitirá o gerenciamento de hóspedes, controle de pagamentos, distribuição de quartos e visualização de informações relevantes para a administração da hospedagem. 

 

4. ✅ Requisitos Funcionais 

 

Gestão de Hóspedes 

RF01 - O sistema deve permitir cadastrar hóspedes  

RF02 - O sistema deve permitir editar dados do hóspede  

RF03 - O sistema deve permitir excluir hóspedes  

RF04 - O sistema deve listar hóspedes  

Pagamentos 

RF05 - O sistema deve registrar pagamentos  

RF06 - O sistema deve mostrar status de pagamento  

Quartos 

RF07 - O sistema deve permitir gerenciar a distribuição de quartos  

RF08 - O sistema deve permitir associar hóspedes a quartos 

 

 

5. ⚙️ Requisitos Não Funcionais 

RNF01 - O sistema deve responder às requisições em até 2 segundos  

RNF02 - O sistema deve ser acessível via navegadores modernos  

RNF03 - O sistema deve garantir a segurança dos dados dos usuários  

RNF04 - O sistema deve possuir interface simples e intuitiva  

RNF05 - O sistema deve garantir persistência dos dados (não perder informações) 

 

 

6. 📏 Regras de Negócio 

RN01 - Um hóspede só pode ser considerado ativo se houver pagamento registrado  

RN02 - O pagamento pode ser parcial ou total  

RN03 - Não pode haver dois hóspedes com o mesmo CPF  

RN04 - Um quarto só pode ser ocupado por um hóspede por vez  

RN05 - Um hóspede só pode estar associado a um quarto por vez 

 

 

7. 🗂️ Modelo de Dados 

Hóspede 

id  

nome  

CPF  

telefone  

status  

 

Pagamento 

id  

valor  

data  

status (PAGO, PENDENTE, PARCIAL)  

hospede_id  

 

Quarto 

id  

numero  

status (DISPONÍVEL, OCUPADO)  

 

Relacionamento 

Um hóspede pode ter vários pagamentos  

Um hóspede pode estar associado a um quarto  

Um quarto pode ter no máximo um hóspede 

 