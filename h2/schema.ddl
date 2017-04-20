CREATE TABLE Article (
    id long not null primary key auto_increment,
    subject varchar(256) not null,
    content text not null,
    visitCount integer not null default 0,
    createDate timestamp not null default current_timestamp
)
;