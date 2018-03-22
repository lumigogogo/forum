-- 数据库初始化脚本

CREATE DATABASE forum DEFAULT CHARACTER SET gbk COLLATE gbk_chinese_ci;;

DROP DATABASE forum;

USE forum;

-- 用户表
CREATE TABLE user(
  user_id BIGINT NOT NULL AUTO_INCREMENT COMMENT '用户id',
  name VARCHAR(20) NOT NULL COMMENT '用户真实姓名',
  nick_name VARCHAR(50) COMMENT '用户昵称',
  password VARCHAR(100) NOT NULL COMMENT '用户密码',
  phone BIGINT NOT NULL COMMENT '用户手机号',
  state SMALLINT DEFAULT 0 COMMENT '用户状态',
  title VARCHAR(20) NOT NULL COMMENT '用户职务',
  PRIMARY KEY (user_id),
  KEY idx_user_phone(phone),
  KEY idx_user_name(name)
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=gbk COMMENT='用户表';

INSERT INTO user(
name, nick_name, password, phone, state, title
) VALUES (
'陆米', '风里风筝', 'MCC0420', 18817314957, 0, 'superAdmin'
);

-- 文章表
CREATE TABLE article(
  article_id BIGINT NOT NULL AUTO_INCREMENT COMMENT '文章id',
  title VARCHAR(120) NOT NULL COMMENT '文章标题',
  state SMALLINT DEFAULT 0 COMMENT '文章状态',
  owner_id BIGINT NOT NULL COMMENT '文章作者',
  create_time TIMESTAMP NOT NULL DEFAULT current_timestamp COMMENT '文章创建时间',
  body TEXT NOT NULL COMMENT '文章内容',
  comment_num INT NOT NULL DEFAULT 0 COMMENT '评论数',
  update_time TIMESTAMP COMMENT '文章修改时间',
  PRIMARY KEY (article_id),
  KEY idx_article_title(title),
  KEY idx_article_state(state),
  KEY idx_article_owner_id(owner_id),
  CONSTRAINT `article_ibfk_1` FOREIGN KEY (`owner_id`) REFERENCES `user`(`user_id`)
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=gbk COMMENT='文章表';

-- 评论表
CREATE TABLE comment(
  comment_id BIGINT NOT NULL AUTO_INCREMENT COMMENT '评论id',
  article_id BIGINT NOT NULL COMMENT '文章id',
  owner_id BIGINT NOT NULL COMMENT '创建者id',
  state SMALLINT NOT NULL DEFAULT 0 COMMENT '评论状态',
  body TEXT NOT NULL COMMENT '评论内容',
  create_time TIMESTAMP NOT NULL DEFAULT current_timestamp COMMENT '评论创建时间',
  comment_level BIGINT NOT NULL COMMENT '评论楼层',
  update_time TIMESTAMP COMMENT '评论修改时间',
  PRIMARY KEY (comment_id),
  KEY idx_comment_owner_id (owner_id),
  CONSTRAINT `comment_ibfk_1` FOREIGN KEY (`owner_id`) REFERENCES `user`(`user_id`),
  CONSTRAINT `comment_ibfk_2` FOREIGN KEY (`article_id`) REFERENCES `article`(`article_id`)
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=gbk COMMENT='评论表';