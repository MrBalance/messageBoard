CREATE SCHEMA `message_board` DEFAULT CHARACTER SET utf8 COLLATE utf8_bin ;

CREATE TABLE `message_board`.`usr_table` (
  `usr_id` INT NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `usr_account` VARCHAR(45) NOT NULL COMMENT '用户账号',
  `usr_name` VARCHAR(45) NULL COMMENT '用户名称',
  `usr_password` VARCHAR(45) NOT NULL COMMENT '用户密码',
  `is_active` INT NOT NULL COMMENT '是否有效（0：无效；1：有效）',
  PRIMARY KEY (`usr_id`),
  UNIQUE INDEX `usr_account_UNIQUE` (`usr_account` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_bin
COMMENT = '用户表';

CREATE TABLE `message_board`.`message_board_info` (
  `message_info_id` INT NOT NULL AUTO_INCREMENT COMMENT '留言id\n',
  `Message_tittle` VARCHAR(45) NOT NULL COMMENT '留言标题',
  `message_date` VARCHAR(45) NOT NULL COMMENT '留言时间',
  `Message_accout` VARCHAR(45) NOT NULL COMMENT '留言账户',
  `Message_context` VARCHAR(500) NULL COMMENT '留言内容',
  `Message_key` VARCHAR(45) NULL COMMENT '留言关键字',
  `is_active` INT NOT NULL COMMENT '是否有效（0：无效；1：有效）',
  PRIMARY KEY (`message_info_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_bin
COMMENT = '留言板信息表';

CREATE TABLE `message_board`.`message_key` (
  `key_id` INT NOT NULL AUTO_INCREMENT COMMENT '关键字id',
  `key_context` VARCHAR(45) NOT NULL COMMENT '关键字内容',
  `message_info_id` VARCHAR(45) NOT NULL COMMENT '留言信息id',
  PRIMARY KEY (`key_id`))
COMMENT = '留言关键字';

INSERT INTO `message_board`.`usr_table` (`usr_account`, `usr_name`, `usr_password`, `is_active`) VALUES ('admin', '管理员', '123456', '1');

INSERT INTO `message_board`.`message_board_info` (`Message_tittle`, `message_date`, `Message_accout`, `Message_context`, `is_active`) VALUES ('testTitle', '2019-06-10', '1', '123456', '1');