# Desenvolvimento de Software para Web (1001504) - Trabalho 1

Universidade Federal de São Carlos – UFSCar \
Departamento de Computação \
1001504 - Desenvolvimento de Software para Web 1 – Trabalho 1 \
Prof. Dr. Delano Medeiros Beder

### Grupo:
- João Victor Mendes Freire, 758943
- Matheus Victorello, 758606
- Renan Dantas Pasquantonio, RA

### Instruções:
O projeto maven está contido na pasta `LocacaoBicicletas/`. Para executar a aplicação, é necessário ter instalado o `apache` e um servidor `mysql` com usuário e senha `root`.

A partir da pasta `LocacaoBicicletas/` e com o `mysql.server` rodando, podemos criar o banco executando:
```
mysql -uroot -p < src/db/create.sql
```

Para preencher com alguns cliente:
```
mysql -uroot -p < src/db/insert_clientes.sql
```

Para preencher com algumas locadoras:

```
mysql -uroot -p < src/db/insert_locadoras.sql
```

Para preencher com algumas locações:
```
mysql -uroot -p < src/db/insert_locacoes.sql
```

Então, com o `apache` e o `mysql.server` rodando, basta executar:
```
mvn tomcat7:deploy
```

E acessar a url [localhost:8080/LocacaoBicicletas/](http://localhost:8080/LocacaoBicicletas/).
