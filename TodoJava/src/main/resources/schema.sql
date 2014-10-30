create table Todo (
	id identity primary key,
	label varchar(1024) not null,
	completed boolean default false,
	date_created datetime default current_timestamp,
	date_completed datetime
);