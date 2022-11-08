CREATE DATABASE MobileСompany

USE MobileСompany




CREATE TABLE Tariff(
	TariffID int NOT NULL IDENTITY(1,1)  PRIMARY KEY,
	[Name] varchar(50) UNIQUE NOT NULL,
	Price int NOT NULL,						--Ціна за місяць 
	MinutesByOperator int NOT NULL,			--Кількість хвилин 
	MinutesOtherOperators int NOT NULL,     --Кількість хвилин на інші оператори
	SMS int NOT NULL,
	MB int NOT NULL, 
	PriceAdditionalMinute float(2) NOT NULL, --Ціна за додаткову хвилину
	PriceAdditionalSMS float(2) NOT NULL,    --Ціна за додаткову SMS
	PriceAdditional_100MB float(2) NOT NULL, --Ціна за додаткові 100 Мб
	SpecialCondition varchar(100) NULL		 --Спеціальні умови
)



CREATE TABLE Client(
	ClientID int NOT NULL IDENTITY(1,1)  PRIMARY KEY,
	[Password] varchar(100) NOT NULL, 
	PhoneNumber varchar(12) NOT NULL UNIQUE,
	Surname varchar(50) NOT NULL,
	[Name] varchar (50) NOT NULL,
	Patronymic varchar (50) NOT NULL,
	TariffID int FOREIGN KEY REFERENCES dbo.Tariff(TariffID) ON DELETE SET NULL NULL
)


INSERT INTO Client 
VALUES ('123','380000000000','Бичковський','Ігор','Ярославович',1),
	   ('12332','380000000001','Бичковський','Степан','Ігорович',2),
	   ('asdwqe1`13213asd*32','380000000002','Бичковський','Іван','Степанович',null),
	   ('12fljhasf3243','380000000003','Бичковський','Ігнат','Іванович',null)


INSERT INTO Tariff 
VALUES ('Tariff1',100,1000,100,5,6,1,10,2,'None'),
	   ('Tariff2',100,1000,100,5,6,1,10,2,'None'),
	   ('Tariff3',100,1000,100,5,6,1,10,2,'None'),
	   ('Tariff4',100,1000,100,5,6,1,10,2,'None')

	  




