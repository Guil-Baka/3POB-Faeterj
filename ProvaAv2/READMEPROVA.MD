FAETERJ-RIO

Programação Orientada a Objetos - 3POB
AV2 3POB Manhã 2023-2
Aluno:
O Sr. Almeida é proprietário de um albergue, ele aluga vagas em quartos para estudantes
e turistas.
Ele convidou a XPTOTec para desenvolver seu site para reservas de vagas via WEB. O
sistema deve permiƟr que o usuário reserve uma vaga durante um período de tempo. O
usuário deve poder consultar as vagas disponíveis num período, o sistema deverá listar
as disponibilidades para o cliente poder reservar. O usuário poderá reservar vagas ou
quartos.
Os quartos são diferentes, há quartos com quatro, oito e doze vagas. Os quartos com
quatro e doze vagas têm banheiro e os de oito vagas não. O cliente na hora de alugar
deve saber quais vagas estão disponíveis em quartos com banheiro, ou sem banheiro.
Há outras diversas peculiaridades quanto a cada vaga, se é em cama beliche, em cima ou
em baixo, é perto da porta, é perto da janela, sol da manhã, o quarto não pega sol e
outros mais. Essas informações devem estar disponíveis com o detalhamento de cada
vaga.
O usuário deve escolher quantos dias vai alugar a vaga, a parƟr de um determinado dia.
As diárias sempre começam e terminam ao meio-dia.
O pagamento será por cartão de crédito. Os cancelamentos só poderão ser efetuados até
três dias antes do início do período.
A classe Cliente possui os seguintes atributos: id, nome, endereço, postalCode, pais, cpf,
Passaporte, email, dataNascimento.
A classe reserva possui os seguintes atributos: id, idQuarto, idCama, idCliente,
dataEntrada, dataSaida.
A classe Quarto possui os seguintes atributos: id, nomeQuarto, qtdeCamas, temBanheiro
(boolean), descricao.
A classe Cama possui os seguintes atributos: id, codigoCama, ehBeliche (boolean),
posicao, descricao.
O código deverá ser em JAVA.
Então deverá ser criado:

1. Criar as funcionalidades de Incluir Cliente, alterar Cliente, Excluir Cliente e listar
   Cliente.
2. Criar as funcionalidades de Incluir Quarto, alterar Quarto, Excluir Quarto e listar Quarto.
3. Criar as funcionalidades de Incluir Cama, alterar Cama, Excluir Cama e listar Cama.
4. Criar as funcionalidades de Incluir Reserva, alterar Reserva, Excluir Reserva e listar
   Reserva.
5. Os dados devem ser validados no Java.
6. Os dados devem podem ser armazenados em arquivo ou uƟlizar listas criadas no inicio da
   aplicação.
