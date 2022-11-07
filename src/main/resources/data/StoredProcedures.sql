USE `steam_db`;

/*2a, 2c, 2d 6 lab db*/

DROP PROCEDURE IF EXISTS GameTestInserts;
DELIMITER //
CREATE PROCEDURE GameTestInserts(
    IN new_game_genre VARCHAR(50),
    IN new_game_rating INT,
    IN new_game_engine VARCHAR(50))
BEGIN
    DECLARE max_id INT;
    DECLARE idx INT;
    SELECT MAX(id) + 1 INTO max_id FROM `game`;
    IF max_id IS NULL THEN
        SET max_id = 1;
    END IF;
    SET idx = 1;
    label1:
    WHILE idx < 11
        DO
            INSERT INTO `game` (genre, rating, engine)
            VALUES (CONCAT(new_game_genre, max_id), CONCAT(new_game_rating, max_id), CONCAT(new_game_engine, max_id));
            SET max_id = max_id + 1;
            SET idx = idx + 1;
            ITERATE label1;
        END WHILE;
END //
DELIMITER ;

DROP PROCEDURE IF EXISTS UserParamInsert;
DELIMITER //
CREATE PROCEDURE UserParamInsert(
    IN new_name VARCHAR(50),

    IN new_age INT)
BEGIN
    INSERT INTO `user` (name,  age) VALUES (new_name, new_age);
    SELECT id, name, age FROM `user`  WHERE name = new_name AND age = new_age;
END //
DELIMITER ;

DROP PROCEDURE IF EXISTS CalcAverageAge;
DELIMITER //
CREATE PROCEDURE CalcAverageAge()
BEGIN
    DECLARE label VARCHAR(20);
    SELECT GetAverageAge() AS average_age;
END //



/*2b*/
DROP PROCEDURE IF EXISTS AddSteamHasGameRelationship //
CREATE PROCEDURE AddSteamHasGameRelationship(
    IN stm_mos INT,
    IN gm_gnr VARCHAR(50))
BEGIN
    DECLARE stm_id, gm_id INT;
    SELECT id INTO stm_id FROM `steam` WHERE money_on_steam = stm_mos;
    SELECT id INTO gm_id FROM `game` WHERE genre = gm_gnr;
    IF (stm_id IS NULL)
    THEN SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Null value: no such steam found';
    END IF;
    IF (gm_id IS NULL)
    THEN SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Null value: no such game found';
    END IF;
    INSERT INTO `steam_has_game` (steam_id, game_id) VALUES (stm_id, gm_id);
END //


DROP PROCEDURE IF EXISTS CreateTablesWithCursor //
CREATE PROCEDURE CreateTablesWithCursor()
BEGIN
    DECLARE done BOOL DEFAULT false;
    DECLARE game_genre VARCHAR(50);
    DECLARE my_cursor CURSOR
        FOR SELECT genre FROM `game`;

    DECLARE CONTINUE HANDLER
        FOR NOT FOUND SET done = true;

    OPEN my_cursor;
    my_loop: LOOP
        FETCH my_cursor INTO  game_genre;
        IF (done = true) THEN LEAVE my_loop;
        END IF;
        SET @temp_query = CONCAT('CREATE TABLE IF NOT EXISTS ', game_genre, DATE_FORMAT(NOW(), '_%Y_%m_%d_%H_%i_%s'), ' (', game_genre, '1 INT, ', game_genre, '2 BOOL);');
        PREPARE my_query FROM @temp_query;
        EXECUTE my_query;
        DEALLOCATE PREPARE my_query;
    END LOOP;
    CLOSE my_cursor;
END //

DELIMITER ;

