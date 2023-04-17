create database user_info;
create database user_collection_novel;
create database user_collection_painting;
create database user_interest_novel;
create database user_interest_painting;
create database collection_ds;

-- 用户信息建表
use user_info;
CREATE TABLE IF NOT EXISTS `user_info` (
                                           `username` VARCHAR(255) NOT NULL,
                                           `password` VARCHAR(255) NOT NULL,
                                           `signature` VARCHAR(255) NOT NULL,
                                           `status` INTEGER NOT NULL DEFAULT 1,
                                           `characterCode` INTEGER NOT NULL,
                                           `create_time` VARCHAR(255) NOT NULL,
                                           `update_time` VARCHAR(255) NOT NULL,
                                           `id` INTEGER NOT NULL,
                                           PRIMARY KEY (`id`)
) ENGINE=InnoDB;

-- 用户兴趣小说建表
use user_collection_novel;
CREATE TABLE IF NOT EXISTS `user_collection_novel` (
                                                       `id` INTEGER NOT NULL,
                                                       `novel_name` VARCHAR(255) NOT NULL,
                                                       `novel_id` INTEGER NOT NULL,
                                                       `bought_time` VARCHAR(255) NOT NULL,
                                                       `update_time` VARCHAR(255) NOT NULL,
                                                       `username` VARCHAR(255) NOT NULL,
                                                       PRIMARY KEY (`id`)
) ENGINE=InnoDB;

-- 用户兴趣画作建表
use user_collection_painting;
CREATE TABLE IF NOT EXISTS `user_collection_painting` (
                                                          `id` INTEGER NOT NULL,
                                                          `painting_name` VARCHAR(255) NOT NULL,
                                                          `painting_id` INTEGER NOT NULL,
                                                          `bought_time` VARCHAR(255) NOT NULL,
                                                          `update_time` VARCHAR(255) NOT NULL,
                                                          PRIMARY KEY (`id`)
) ENGINE=InnoDB;

-- 所有商品信息建表
use collection_ds;
CREATE TABLE IF NOT EXISTS `novel` (
                                       `id` INTEGER NOT NULL,
                                       `novel_name` VARCHAR(255) NOT NULL,
                                       `writer` VARCHAR(255) NOT NULL,
                                       `introduction` VARCHAR(255) NOT NULL,
                                       `create_time` VARCHAR(255) NOT NULL,
                                       `update_time` VARCHAR(255) NOT NULL,
                                       `finish_time` VARCHAR(255),
                                       `file_path` VARCHAR(255) NOT NULL,
                                       `balance` INTEGER NOT NULL,
                                       PRIMARY KEY (`id`)
) ENGINE=InnoDB;
CREATE TABLE IF NOT EXISTS `painting` (
                                          `id` INTEGER NOT NULL,
                                          `painting_name` VARCHAR(255) NOT NULL,
                                          `painter` VARCHAR(255) NOT NULL,
                                          `introduction` VARCHAR(255) NOT NULL,
                                          `create_time` VARCHAR(255) NOT NULL,
                                          `update_time` VARCHAR(255) NOT NULL,
                                          `finish_time` VARCHAR(255),
                                          `file_path` VARCHAR(255) NOT NULL,
                                          `price` INTEGER NOT NULL,
                                          PRIMARY KEY (`id`)
) ENGINE=InnoDB;
