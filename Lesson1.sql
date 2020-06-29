create schema if not exists student_cms_plusplus character set `utf8mb4`;
create table if not exists student (
	`id` int primary key auto_increment,
    `name` varchar(50) null,
    `mssv` varchar(8) null,
    `password` varchar(100) null,
    `phone` varchar(10) null,
    `address` varchar(200) null,
    `age` int(2) null,
    `email` varchar(50) null,
    `created_timstamp` TIMESTAMP(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
    `last_updated_timestamp` TIMESTAMP(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6)
);

create table if not exists class(
	`id` int primary key auto_increment,
	`name` varchar(50) null,
    `major` varchar(50),
	`total_student` int(4),
	`teacher_name` varchar(50),
	`teacher_phone` varchar(10),
	`created_timestamp` TIMESTAMP(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
    `last_updated_timestamp` TIMESTAMP(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6)
);

create table if not exists student_class(
	`student_id` int(8),
	`class_id` int(8)
);
INSERT INTO `student_cms_plusplus`.`class` (`id`, `name`, `major`, `total_student`, `teacher_name`, `teacher_phone`) VALUES ('1', 'Nghĩa', 'HTTT', '60', 'ABC', '0901234567');
INSERT INTO `student_cms_plusplus`.`student` (`id`, `name`, `mssv`, `password`, `phone`, `address`, `age`, `email`) VALUES ('1', 'Nghĩa', '20195985', '123456', '0705088886', 'artemis', '19', 'vtng@gmail.com');

