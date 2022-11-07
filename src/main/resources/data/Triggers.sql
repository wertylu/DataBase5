USE `steam_db`;

DELIMITER //
DROP TRIGGER IF EXISTS AddUserCheckCreditScore //
CREATE TRIGGER AddUserCheckCreditScore
    BEFORE INSERT
    ON `steam_db`.`user` FOR EACH ROW
BEGIN
    IF(NOT EXISTS(
            SELECT id FROM `steam_db`.`credit_score`
            WHERE id = NEW.credit_score_id
        ))
    THEN SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Foreign key error: No credit_score with such id';
    END IF;
END //

DROP TRIGGER IF EXISTS UpdateUserCheckCreditScore //
CREATE TRIGGER UpdateUserCheckCreditScore
    BEFORE UPDATE
    ON `steam_db`.`user` FOR EACH ROW
BEGIN
    IF(NOT EXISTS(
            SELECT id FROM `steam_db`.`credit_score`
            WHERE id = NEW.credit_score_id
        ))
    THEN SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Foreign key error: No  credit_score with such id';
    END IF;
END //

DROP TRIGGER IF EXISTS UpdateCreditScoreCheckId //
CREATE TRIGGER UpdateCreditScoreCheckId
    BEFORE UPDATE
    ON `steam_db`.`credit_score` FOR EACH ROW
BEGIN
    IF(EXISTS(
            SELECT credit_score_id FROM `steam_db`.`user`
            WHERE credit_score_id = OLD.id
        ))
    THEN SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Foreign key error: Can`t update row with record present in related table';
    END IF;
END //


DROP TRIGGER IF EXISTS DeleteCreditScoreCheckId //
CREATE TRIGGER DeleteCreditScoreCheckId
    BEFORE DELETE
    ON `steam_db`.`credit_score` FOR EACH ROW
BEGIN
    IF(EXISTS(
            SELECT  credit_score_id FROM `steam_db`.`user`
            WHERE credit_score_id = OLD.id
        ))
    THEN SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Foreign key error: Can`t delete row with record present in related table';
    END IF;
END //



/* 3 пункт 6 lab-db */
DROP TRIGGER IF EXISTS CheckAgeCardinality//
CREATE TRIGGER CheckAgeCardinality
    BEFORE INSERT
    ON `steam_db`.`user` FOR EACH ROW
BEGIN
    IF (NEW.age < 10)
    THEN SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Value error: age can`t be less than 10';
    END IF;
END //

DROP TRIGGER IF EXISTS CheckUserName //
CREATE TRIGGER CheckUserName
    BEFORE INSERT
    ON `steam_db`.`user` FOR EACH ROW
BEGIN
    IF (NEW.name NOT RLIKE '^[a-zA-Z0-9]')
    THEN SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Value error: invalid name format';
    END IF;
END //

DROP TRIGGER IF EXISTS ForbidDeletePlatform //
CREATE TRIGGER ForbidDeletePlatform
    BEFORE DELETE
    ON `steam_db`.`platform` FOR EACH ROW
BEGIN
    SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Forbidden method: you can`t delete data from table `platform`';
END //

DELIMITER ;


