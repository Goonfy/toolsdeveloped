create table books_inventory(
    id INTEGER AUTO_INCREMENT,
    title CHAR(255) NOT NULL,
    author CHAR(255) NOT NULL,
    year INTEGER NOT NULL,
    genre CHAR(255) NOT NULL,
    publisher CHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

create table users(
    id INTEGER AUTO_INCREMENT,
    name CHAR(255) NOT NULL,
    birthdate DATE NOT NULL,
    phone_number CHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

create table reservations(
    pickup_date DATE NOT NULL, 
    return_date DATE NOT NULL,
    return_status BIT DEFAULT(0),
    user_id INTEGER NOT NULL,
    book_id INTEGER NOT NULL,
    PRIMARY KEY (pickup_date, book_id)
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (book_id) REFERENCES books_inventory(id)
);

insert into books_inventory(title, author, year, genre, publisher) values ('Harry Potter and The Sorcerer Stone', 'J.K. Rowling', 1997, 'Fantasy', 'Bloomsbury');
insert into books_inventory(title, author, year, genre, publisher) values ('300', 'Frank Miller', 1998, 'Comics', 'Dark Horse Comics');
insert into books_inventory(title, author, year, genre, publisher) values ('War and Peace', 'Leo Tolstoi', 1869, 'Novel', 'The Russian Messenger');
insert into books_inventory(title, author, year, genre, publisher) values ('Silmarillion', 'J.R.R. Tolkien', 1977, 'Fantasy', 'Allen & Unwin');
insert into books_inventory(title, author, year, genre, publisher) values ('1984', 'George Orwell', 1949, 'Novel', 'Penguin');
insert into books_inventory(title, author, year, genre, publisher) values ('O Bando dos Quatro: O Jogo Misterioso', 'João Aguiar', 1998, 'Adventure', 'Asa');
insert into books_inventory(title, author, year, genre, publisher) values ('The Little Prince', 'Antoine de Saint-Exupéry', 1943, 'Children', 'Edit. Aster');
insert into books_inventory(title, author, year, genre, publisher) values ('Java For Dummies', 'Filipe Santos', 2020, 'Technical', 'Academia de Código');
insert into books_inventory(title, author, year, genre, publisher) values ('O Primo Basílio', 'Eça de Queiroz', 1878, 'Novel', 'Livraria Chardron');

insert into users(name, birthdate, phone_number) values ('Raqueluxa Martini', '1990-05-16', '+351925242688');
insert into users(name, birthdate, phone_number) values ('Sofia Texas', '1992-07-03', '+351456789033');
insert into users(name, birthdate, phone_number) values ('Eng. Eduardo', '1996-05-10', '+42045678924');
insert into users(name, birthdate, phone_number) values ('Pablo Escobar', '1995-09-01', '+34989098756');

insert into reservations(pickup_date, return_date, return_status, user_id, book_id) values ('2020-05-03', '2020-05-13', 1, 1, 7);
insert into reservations(pickup_date, return_date, return_status, user_id, book_id) values ('1965-05-03', '1965-05-13', 0, 2, 3);
insert into reservations(pickup_date, return_date, return_status, user_id, book_id) values ('2020-08-11', '2020-08-21', 1, 4, 1);
insert into reservations(pickup_date, return_date, return_status, user_id, book_id) values ('2015-09-11', '2020-09-13', 0, 3, 2);