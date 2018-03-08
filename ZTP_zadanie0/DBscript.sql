CREATE DATABASE ztpZad0;
USE ztpZad0;

CREATE TABLE Item (
	IdItem int NOT NULL AUTO_INCREMENT,
	productName varchar(40),
	price int,
	quantity int,
	PRIMARY KEY (IdItem)
);

CREATE TABLE Dealer (
	IdDealer int NOT NULL AUTO_INCREMENT,
	companyName varchar(40),
	city varchar(40),
	NIP varchar(40),
	PRIMARY KEY (IdDealer)
);

CREATE TABLE Client (
	IdClient int NOT NULL AUTO_INCREMENT,
	id varchar(40),
	city varchar(40),
	NIP varchar(40),
	PRIMARY KEY (IdClient)
);

CREATE TABLE Invoice (
	IdInvoice int NOT NULL AUTO_INCREMENT,
	IdItem int,
	IdDealer int,
	IdClient int,
	PRIMARY KEY (IdInvoice),
	FOREIGN KEY (IdItem) REFERENCES Item(IdItem),
	FOREIGN KEY (IdDealer) REFERENCES Dealer(IdDealer),
	FOREIGN KEY (IdClient) REFERENCES Client(IdClient) 
);