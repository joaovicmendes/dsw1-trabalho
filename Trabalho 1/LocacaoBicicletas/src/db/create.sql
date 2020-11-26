create database LocacaoBicicletas;

use LocacaoBicicletas;

create table Cliente(
    cpf varchar(11) not null,
    nome varchar(256) not null,
    email varchar(256) not null,
    senha varchar(256) not null,
    genero varchar(256) not null,
    telefone varchar(13) not null,
    dataNascimento date not null,

    primary key (cpf)
);

create table Locadora(
    cnpj varchar(14) not null,
    nome varchar(256) not null,
    email varchar(256) not null,
    senha varchar(256) not null,
    cidade varchar(256) not null,

    primary key (cnpj)
);

create table Locacao(
    dataReserva datetime not null,
    cpfCliente varchar(11) not null,
    cnpjLocadora varchar(14) not null,

    foreign key (cpfCliente) references Cliente(cpf),
    foreign key (cnpjLocadora) references Locadora(cnpj),
    primary key (dataReserva, cpfCliente, cnpjLocadora)
);
