# Jogo da Velha

* Documentação da API + testes foram executados via postman:
https://documenter.getpostman.com/view/3327369/Szt8eqGv

* Endereço da API: http://ec2-18-220-188-233.us-east-2.compute.amazonaws.com/v1/jogovelha [POST]


# Descrição do problema proposto:
## Nível 1:
 Desenvolva uma função ou método que atenda a assinatura isVelha (Int[] jogo), e que seja
 capaz de identificar se tivemos um vencedor no jogo;

## Nível 2:
 Crie uma API REST com o endpoint “/jogovelha”, ele deverá responder a um input e a partir da
 validação responder se tivemos ou não um vencedor.
 Ex:
 POST -> /jogovelha
 {
   “jogo”: [“XXO”, “XOX”, “OOX”]*
 }
* Cada valor do array representa uma linha do jogo.
* Caso tenha um vencedor retorne HTTP 200, caso contrário HTTP 404.

## Nível 3:
 Hospede a API desenvolvida no nível 2 em algum provider de cloud pública (AWS, GCP ou
 Azure) e disponibilize o endpoint de maneira pública.

## Observações:
* Criar um repositório privado no Github (Compartilhar com usuário rpsantos90);
* O projeto deve conter 90% de testes unitários;
* A performance do algoritmo será validada;
* Diferenciais: API documentation, container;
