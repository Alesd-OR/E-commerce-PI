create database JavaMarketBD;
use JavaMarketBD;

create table cliente (
id_cliente int primary key auto_increment,
nomeClie varchar(40) not null,
genero varchar(40),
cpf varchar(40) unique not null,
email varchar(40) not null,
endereco varchar(80) not null,
telefone varchar(40) not null);

create table produto(
id_produto int primary key auto_increment, 
nomeProd varchar(40) unique not null, 
descProd varchar (40), 
catProd varchar(40) not null, 
qtdProd int not null, 
valProd decimal(10,2));

create table vendaProdutoIndividual (
    id_vendaIndividual int primary key auto_increment,
    dataHoraVenda timestamp default current_timestamp unique,
    fk_idClie int not null,
    constraint fk_idClie foreign key (fk_idClie) references cliente(id_cliente),
    fk_idProd int not null,
    constraint fk_idProd foreign key (fk_idProd) references produto(id_produto),
    fk_nomeProd varchar(40) not null,
    constraint fk_nomeProd foreign key (fk_nomeProd) references produto(nomeProd),
    qdtProd int not null,
    valorProduto decimal (10,2) not null
);

create table vendaProdutoTotal (
	id_vendaTotal int primary key auto_increment,
    valorTotalVenda decimal (10,2) not null,
    qtdTotalItens int not null,
    fk_idCliente int not null,
    constraint fk_idCliente foreign key (fk_idCliente) references cliente(id_cliente),
    fk_dataHoraCompra timestamp default current_timestamp,
    constraint fk_dataHoraCompra foreign key (fk_dataHoraCompra) references vendaProdutoIndividual(dataHoraVenda)
);
