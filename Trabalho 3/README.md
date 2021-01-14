# Desenvolvimento de Software para Web (1001504) - Trabalho 3

Universidade Federal de São Carlos – UFSCar \
Departamento de Computação \
1001504 - Desenvolvimento de Software para Web 1 – Trabalho 3 \
Prof. Dr. Delano Medeiros Beder

### Grupo:
- João Victor Mendes Freire, 758943
- Matheus Victorello, 758606
- Renan Dantas Pasquantonio, 760549

### Instruções:
O projeto maven está contido na pasta `LocacaoBicicletas/`. Para executar a aplicação, é necessário ter instalado um servidor `mysql` com usuário e senha `root`.

A partir da pasta `LocacaoBicicletas/` e com o `mysql.server` rodando, podemos criar o banco chamado `LocacaoBicicletas` executando:
```
mysql -uroot -p
```

Dentro do SQL, basta executar:
```
create database LocacaoBicicletas;
```

O comando para executar é:
```
mvn spring-boot:run
```

E acessar a url [localhost:8080/](http://localhost:8080/). Dentre os clientes e locadoras cadastrados, temos:

|Email|Senha|Papel|
|---|---|---|
|admin|admin|ADMIN|
|alice@gmail.com|alice|USER|
|bob@gmail.com|bob|USER|
|locadora_a@gmail.com|locadora_a|Locadora|
|locadora_b@gmail.com|locadora_b|Locadora|
