CREATE
    DATABASE IF NOT EXISTS steam_db;
USE
    `steam_db`;

DROP TABLE IF EXISTS steam_has_game;
DROP TABLE IF EXISTS steam;
DROP TABLE IF EXISTS game;
DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS platform;


CREATE TABLE platform
(
    id            INT AUTO_INCREMENT PRIMARY KEY,
    platform_name VARCHAR(50) NOT NULL
);

CREATE TABLE user
(
    id          INT AUTO_INCREMENT PRIMARY KEY,
    name        VARCHAR(50) NOT NULL,
    surname     VARCHAR(50) NOT NULL,
    age         INT         NOT NULL,
    platform_id INT         NULL,
    CONSTRAINT FK_user_platform_platform
        FOREIGN KEY (platform_id)
            REFERENCES platform (id)
            ON DELETE CASCADE ON UPDATE SET NULL

);



CREATE TABLE game
(
    id          INT AUTO_INCREMENT PRIMARY KEY,
    genre       VARCHAR(50) NOT NULL,
    rating      INT         NOT NULL,
    engine      VARCHAR(50) NOT NULL,
    platform_id INT         NULL,
    CONSTRAINT FOREIGN KEY (platform_id) REFERENCES platform (id)
);

CREATE TABLE steam
(
    id                INT AUTO_INCREMENT PRIMARY KEY,
    money_on_steam    INT NOT NULL,
    number_of_friends INT NOT NULL,
    user_id           INT NULL,
    CONSTRAINT FK_steam_user_user
        FOREIGN KEY (user_id)
            REFERENCES user (id)
);

CREATE TABLE steam_has_game
(
    steam_id INT NOT NULL,
    game_id  INT NOT NULL,
    PRIMARY KEY (steam_id, game_id),
    CONSTRAINT FOREIGN KEY (steam_id) REFERENCES steam (id),
    CONSTRAINT FOREIGN KEY (game_id) REFERENCES game (id)
);



 insert into platform
 values (1, 'Windows'),
        (2, 'MacOS'),
        (3, 'Linux');


 insert into user
 values (1, 'Roman', 'Onyshkiv',18,1),
        (2, 'Rostyk','Postolaki', 19, 3),
        (3, 'John', 'Doe', 45, 2),
        (4, 'Gustavo', 'Sus', 55, 2),
       (5, 'Steve', 'Jobless', 70, 1 );


 insert into game
 values (1, 'MMORPG', 2, 'V8', 1),
        (2, 'Shooter', 100, 'Source 2', 1),
        (3, 'Runner', 0,'Unreal Engine 5', 2),
        (4, 'Indy', 4, 'Unity', 3),
        (5, 'Adventure', 50 ,'Frost Engine', 2);


insert into steam
 values (1, 500, 12, 1 ),
        (2, 100, 500, 2),
        (3, 2, 3, 3 ),
        (4, 100500, 0 , 4 ),
        (5, 1, 1, 5);

 insert into steam_has_game
 values (1,1),
        (1,2),
        (2,1),
        (3,3),
        (4,1),
        (4,2),
        (4,3),
        (4,4),
        (4,5),
        (5,2);


