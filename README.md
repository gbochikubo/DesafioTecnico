# DesafioTecnico

# <h3> Instalação mysql <h3>
  
  Baixar e instalar o mysql versão 8.0.19 
  
# <h3> Criação do banco <h3>
  
Abrir o terminal ou cmd e criar o banco de dados mysql, comandos:

  mysql -u root -p
  
  create database desafio;
  
  use desafio;
  
# <h3> Configurando Usuário e Senha <h3>
  
  Ainda no terminal utilizar o comando:
  
 ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY '302010';
 
 OU 
 
 modificar o usuário e senha no programa para o de sua preferência, como indicado na imagem abaixo:
 
 ![DataConfiguration](https://user-images.githubusercontent.com/37846911/72956655-4cfcd380-3d7f-11ea-8592-567aafdf897b.png)
 
 # <h3> Execução do Programa <h3>
  
Abrir o Eclipse e executar o programa na classe principal DesafioApplication.java

Abrir a página localhost:8080 no navegador web

Caso queira filtrar os dados a serem exibidos digitar a data no formato yyyy-mm-dd, exemplo: 2018-23-01, caso queira filtrar também pelo número do estabelecimento basta adicionar o mesmo no campo do estabelecimento. Se nenhuma data for preenchida será filtrado pelo estabelecimento, se nenhum estabelecimento for preenchido será filtrado pela data. Caso nenhuma data e nenhum estabelecimento sejam preenchidos serão exibidos todos os dados. 

![TelaRelatorio](https://user-images.githubusercontent.com/37846911/72956716-87667080-3d7f-11ea-9bc5-bedb975e56d5.png)

