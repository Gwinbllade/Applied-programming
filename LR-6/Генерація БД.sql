CREATE DATABASE Mobile�ompany

USE Mobile�ompany




CREATE TABLE Tariff(
	TariffID int NOT NULL IDENTITY(1,1)  PRIMARY KEY,
	[Name] varchar(50) UNIQUE NOT NULL,
	Price int NOT NULL,						--ֳ�� �� ����� 
	MinutesByOperator int NOT NULL,			--ʳ������ ������ 
	MinutesOtherOperators int NOT NULL,     --ʳ������ ������ �� ���� ���������
	SMS int NOT NULL,
	MB int NOT NULL, 
	PriceAdditionalMinute float(2) NOT NULL, --ֳ�� �� ��������� �������
	PriceAdditionalSMS float(2) NOT NULL,    --ֳ�� �� ��������� SMS
	PriceAdditional_100MB float(2) NOT NULL, --ֳ�� �� �������� 100 ��
	SpecialCondition varchar(100) NULL		 --��������� �����
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
VALUES ('123','380000000000','�����������','����','�����������',1),
	   ('12332','380000000001','�����������','������','��������',2),
	   ('asdwqe1`13213asd*32','380000000002','�����������','����','����������',null),
	   ('12fljhasf3243','380000000003','�����������','�����','��������',null)


INSERT INTO Tariff 
VALUES ('Tariff1',100,1000,100,5,6,1,10,2,'None'),
	   ('Tariff2',100,1000,100,5,6,1,10,2,'None'),
	   ('Tariff3',100,1000,100,5,6,1,10,2,'None'),
	   ('Tariff4',100,1000,100,5,6,1,10,2,'None')

	  




