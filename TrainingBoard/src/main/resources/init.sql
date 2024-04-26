-- 初期生成テーブルを定義(要修正)
CREATE TABLE IF NOT EXISTS batch.hoge{
	id bigserial NOT NULL,
	name character varying(100),
	PRIMARY KEY(id),
	UNIQUE(name) -- スレッド名
);