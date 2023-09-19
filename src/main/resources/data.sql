CREATE TABLE user (
	id number  not null auto_increment, 
	first_Name varchar(255) not null, 
	last_Name varchar(255) not null, 
	email varchar(255) not null, 
	birthday date not null, 
	login varchar(255) not null, 
	password varchar(255) not null, 
	phone varchar(255) not null,
	primary key (id)
);


 INSERT INTO user (first_Name, last_Name, email, birthday, login, password, phone) VALUES
   ('firstName', 'lastName', 'teste@gmail.com', '2021-02-02', 'teste', '$2a$12$8LkA73Obg9ScLJN5P/M/muOmd22lCK.6329RHhPfrnJk4OSMOVVre', '8199968744');

CREATE TABLE car (
	id number not null auto_increment, 
	year int not null, 
	license_Plate varchar(255) not null, 
	model varchar(255) not null, 
	color varchar(255) not null, 
	primary key (id),
  	user_id number REFERENCES user(id)
);



