-- BUILD WITH MODEL TIME 190110T1504
drop database  if exists pim;
create database pim;
alter  database pim  character set = utf8mb4  collate = utf8mb4_unicode_ci; -- 支持表情符号
use pim;

drop table  if exists platform_data;
create table platform_data (
	id                  	varchar(64)          not null            comment 'Id',
	name                	varchar(92)                              comment 'Name',
	introduction        	varchar(288)                             comment 'Introduction',
	current_version     	varchar(16)                              comment 'Current Version',
	version             	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists site_data;
create table site_data (
	id                  	varchar(64)          not null            comment 'Id',
	name                	varchar(92)                              comment 'Name',
	introduction        	varchar(148)                             comment 'Introduction',
	platform            	varchar(48)                              comment 'Platform',
	last_update_time    	datetime                                 comment 'Last Update Time',
	version             	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists catalog_data;
create table catalog_data (
	id                  	varchar(64)          not null            comment 'Id',
	name                	varchar(20)                              comment 'Name',
	seller_id           	varchar(32)                              comment 'Seller Id',
	site                	varchar(48)                              comment 'Site',
	platform            	varchar(48)                              comment 'Platform',
	version             	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists level_one_category_data;
create table level_one_category_data (
	id                  	varchar(64)          not null            comment 'Id',
	catalog             	varchar(48)                              comment 'Catalog',
	name                	varchar(52)                              comment 'Name',
	version             	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists level_two_category_data;
create table level_two_category_data (
	id                  	varchar(64)          not null            comment 'Id',
	parent_category     	varchar(48)                              comment 'Parent Category',
	name                	varchar(52)                              comment 'Name',
	version             	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists level_n_category_data;
create table level_n_category_data (
	id                  	varchar(64)          not null            comment 'Id',
	parent_category     	varchar(48)                              comment 'Parent Category',
	name                	varchar(44)                              comment 'Name',
	version             	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists brand_data;
create table brand_data (
	id                  	varchar(64)          not null            comment 'Id',
	brand_name          	varchar(40)                              comment 'Brand Name',
	logo                	varchar(512) CHARACTER SET ascii COLLATE ascii_general_ci                     comment 'Logo',
	remark              	varchar(336)                             comment 'Remark',
	platform            	varchar(48)                              comment 'Platform',
	version             	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists product_data;
create table product_data (
	id                  	varchar(64)          not null            comment 'Id',
	name                	varchar(20)                              comment 'Name',
	parent_category     	varchar(48)                              comment 'Parent Category',
	brand               	varchar(48)                              comment 'Brand',
	origin              	varchar(24)                              comment 'Origin',
	catalog             	varchar(48)                              comment 'Catalog',
	remark              	varchar(336)                             comment 'Remark',
	last_update_time    	datetime                                 comment 'Last Update Time',
	version             	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists sku_data;
create table sku_data (
	id                  	varchar(64)          not null            comment 'Id',
	name                	varchar(52)                              comment 'Name',
	size                	varchar(24)                              comment 'Size',
	product             	varchar(48)                              comment 'Product',
	active              	tinyint                                  comment 'Active',
	base_price          	numeric(7,2)                             comment 'Base Price',
	last_update_time    	datetime                                 comment 'Last Update Time',
	version             	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists user_domain_data;
create table user_domain_data (
	id                  	varchar(64)          not null            comment 'Id',
	name                	varchar(16)                              comment 'Name',
	version             	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists user_white_list_data;
create table user_white_list_data (
	id                  	varchar(64)          not null            comment 'Id',
	user_identity       	varchar(40)                              comment 'User Identity',
	user_special_functions	varchar(200)                             comment 'User Special Functions',
	domain              	varchar(48)                              comment 'Domain',
	version             	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists sec_user_data;
create table sec_user_data (
	id                  	varchar(64)          not null            comment 'Id',
	login               	varchar(20)                              comment 'Login',
	mobile              	varchar(11)                              comment 'Mobile',
	email               	varchar(76)                              comment 'Email',
	pwd                 	varchar(64)                              comment 'Pwd',
	verification_code   	int                                      comment 'Verification Code',
	verification_code_expire	datetime                                 comment 'Verification Code Expire',
	last_login_time     	datetime                                 comment 'Last Login Time',
	domain              	varchar(48)                              comment 'Domain',
	blocking            	varchar(48)                              comment 'Blocking',
	current_status      	varchar(28)                              comment 'Current Status',
	version             	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists sec_user_blocking_data;
create table sec_user_blocking_data (
	id                  	varchar(64)          not null            comment 'Id',
	who                 	varchar(52)                              comment 'Who',
	block_time          	datetime                                 comment 'Block Time',
	comments            	varchar(96)                              comment 'Comments',
	version             	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists user_app_data;
create table user_app_data (
	id                  	varchar(64)          not null            comment 'Id',
	title               	varchar(300)                             comment 'Title',
	sec_user            	varchar(48)                              comment 'Sec User',
	app_icon            	varchar(36)                              comment 'App Icon',
	full_access         	tinyint                                  comment 'Full Access',
	permission          	varchar(16)                              comment 'Permission',
	object_type         	varchar(108)                             comment 'Object Type',
	object_id           	varchar(40)                              comment 'Object Id',
	location            	varchar(48)                              comment 'Location',
	version             	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists list_access_data;
create table list_access_data (
	id                  	varchar(64)          not null            comment 'Id',
	name                	varchar(200)                             comment 'Name',
	internal_name       	varchar(200)                             comment 'Internal Name',
	read_permission     	tinyint                                  comment 'Read Permission',
	create_permission   	tinyint                                  comment 'Create Permission',
	delete_permission   	tinyint                                  comment 'Delete Permission',
	update_permission   	tinyint                                  comment 'Update Permission',
	execution_permission	tinyint                                  comment 'Execution Permission',
	app                 	varchar(48)                              comment 'App',
	version             	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists object_access_data;
create table object_access_data (
	id                  	varchar(64)          not null            comment 'Id',
	name                	varchar(28)                              comment 'Name',
	object_type         	varchar(112)                             comment 'Object Type',
	list1               	varchar(80)                              comment 'List1',
	list2               	varchar(80)                              comment 'List2',
	list3               	varchar(80)                              comment 'List3',
	list4               	varchar(80)                              comment 'List4',
	list5               	varchar(80)                              comment 'List5',
	list6               	varchar(80)                              comment 'List6',
	list7               	varchar(80)                              comment 'List7',
	list8               	varchar(80)                              comment 'List8',
	list9               	varchar(80)                              comment 'List9',
	app                 	varchar(48)                              comment 'App',
	version             	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists login_history_data;
create table login_history_data (
	id                  	varchar(64)          not null            comment 'Id',
	login_time          	datetime                                 comment 'Login Time',
	from_ip             	varchar(44)                              comment 'From Ip',
	description         	varchar(16)                              comment 'Description',
	sec_user            	varchar(48)                              comment 'Sec User',
	version             	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists generic_form_data;
create table generic_form_data (
	id                  	varchar(64)          not null            comment 'Id',
	title               	varchar(20)                              comment 'Title',
	description         	varchar(48)                              comment 'Description',
	version             	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists form_message_data;
create table form_message_data (
	id                  	varchar(64)          not null            comment 'Id',
	title               	varchar(24)                              comment 'Title',
	form                	varchar(48)                              comment 'Form',
	level               	varchar(28)                              comment 'Level',
	version             	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists form_field_message_data;
create table form_field_message_data (
	id                  	varchar(64)          not null            comment 'Id',
	title               	varchar(16)                              comment 'Title',
	parameter_name      	varchar(16)                              comment 'Parameter Name',
	form                	varchar(48)                              comment 'Form',
	level               	varchar(28)                              comment 'Level',
	version             	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists form_field_data;
create table form_field_data (
	id                  	varchar(64)          not null            comment 'Id',
	label               	varchar(12)                              comment 'Label',
	locale_key          	varchar(44)                              comment 'Locale Key',
	parameter_name      	varchar(16)                              comment 'Parameter Name',
	type                	varchar(36)                              comment 'Type',
	form                	varchar(48)                              comment 'Form',
	placeholder         	varchar(48)                              comment 'Placeholder',
	default_value       	varchar(12)                              comment 'Default Value',
	description         	varchar(48)                              comment 'Description',
	field_group         	varchar(16)                              comment 'Field Group',
	minimum_value       	varchar(60)                              comment 'Minimum Value',
	maximum_value       	varchar(72)                              comment 'Maximum Value',
	required            	tinyint                                  comment 'Required',
	disabled            	tinyint                                  comment 'Disabled',
	custom_rendering    	tinyint                                  comment 'Custom Rendering',
	candidate_values    	varchar(12)                              comment 'Candidate Values',
	suggest_values      	varchar(12)                              comment 'Suggest Values',
	version             	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists form_action_data;
create table form_action_data (
	id                  	varchar(64)          not null            comment 'Id',
	label               	varchar(8)                               comment 'Label',
	locale_key          	varchar(16)                              comment 'Locale Key',
	action_key          	varchar(24)                              comment 'Action Key',
	level               	varchar(28)                              comment 'Level',
	url                 	varchar(168)                             comment 'Url',
	form                	varchar(48)                              comment 'Form',
	version             	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;






	
insert into platform_data values ('P000001','Chain eComerce Platform','new generation of eCommerce platform based on opensource and modern tech','V1.0','1');

	
insert into site_data values ('S000001','The first customer site','The primary site for show the concept','P000001','2019-01-09 08:21:56','1');
insert into site_data values ('S000002','The first customer site0002','The primary site for show the concept0002','P000001','2019-01-03 14:38:45','1');

	
insert into catalog_data values ('C000001','Cloth','SC000001','S000001','P000001','1');
insert into catalog_data values ('C000002','Cloth0002','SC0000010002','S000001','P000001','1');
insert into catalog_data values ('C000003','Cloth0003','SC0000010003','S000002','P000001','1');
insert into catalog_data values ('C000004','Cloth0004','SC0000010004','S000002','P000001','1');

	
insert into level_one_category_data values ('LOC000001','C000001','Level One Cat','1');
insert into level_one_category_data values ('LOC000002','C000001','Level One Cat0002','1');
insert into level_one_category_data values ('LOC000003','C000002','Level One Cat0003','1');
insert into level_one_category_data values ('LOC000004','C000002','Level One Cat0004','1');
insert into level_one_category_data values ('LOC000005','C000003','Level One Cat0005','1');
insert into level_one_category_data values ('LOC000006','C000003','Level One Cat0006','1');
insert into level_one_category_data values ('LOC000007','C000004','Level One Cat0007','1');
insert into level_one_category_data values ('LOC000008','C000004','Level One Cat0008','1');

	
insert into level_two_category_data values ('LTC000001','LOC000001','Level Two Cat','1');
insert into level_two_category_data values ('LTC000002','LOC000001','Level Two Cat0002','1');
insert into level_two_category_data values ('LTC000003','LOC000002','Level Two Cat0003','1');
insert into level_two_category_data values ('LTC000004','LOC000002','Level Two Cat0004','1');
insert into level_two_category_data values ('LTC000005','LOC000003','Level Two Cat0005','1');
insert into level_two_category_data values ('LTC000006','LOC000003','Level Two Cat0006','1');
insert into level_two_category_data values ('LTC000007','LOC000004','Level Two Cat0007','1');
insert into level_two_category_data values ('LTC000008','LOC000004','Level Two Cat0008','1');
insert into level_two_category_data values ('LTC000009','LOC000005','Level Two Cat0009','1');
insert into level_two_category_data values ('LTC000010','LOC000005','Level Two Cat0010','1');
insert into level_two_category_data values ('LTC000011','LOC000006','Level Two Cat0011','1');
insert into level_two_category_data values ('LTC000012','LOC000006','Level Two Cat0012','1');
insert into level_two_category_data values ('LTC000013','LOC000007','Level Two Cat0013','1');
insert into level_two_category_data values ('LTC000014','LOC000007','Level Two Cat0014','1');
insert into level_two_category_data values ('LTC000015','LOC000008','Level Two Cat0015','1');
insert into level_two_category_data values ('LTC000016','LOC000008','Level Two Cat0016','1');

	
insert into level_n_category_data values ('LNC000001','LTC000001','Level N Cat','1');
insert into level_n_category_data values ('LNC000002','LTC000001','Level N Cat0002','1');
insert into level_n_category_data values ('LNC000003','LTC000002','Level N Cat0003','1');
insert into level_n_category_data values ('LNC000004','LTC000002','Level N Cat0004','1');
insert into level_n_category_data values ('LNC000005','LTC000003','Level N Cat0005','1');
insert into level_n_category_data values ('LNC000006','LTC000003','Level N Cat0006','1');
insert into level_n_category_data values ('LNC000007','LTC000004','Level N Cat0007','1');
insert into level_n_category_data values ('LNC000008','LTC000004','Level N Cat0008','1');
insert into level_n_category_data values ('LNC000009','LTC000005','Level N Cat0009','1');
insert into level_n_category_data values ('LNC000010','LTC000005','Level N Cat0010','1');
insert into level_n_category_data values ('LNC000011','LTC000006','Level N Cat0011','1');
insert into level_n_category_data values ('LNC000012','LTC000006','Level N Cat0012','1');
insert into level_n_category_data values ('LNC000013','LTC000007','Level N Cat0013','1');
insert into level_n_category_data values ('LNC000014','LTC000007','Level N Cat0014','1');
insert into level_n_category_data values ('LNC000015','LTC000008','Level N Cat0015','1');
insert into level_n_category_data values ('LNC000016','LTC000008','Level N Cat0016','1');
insert into level_n_category_data values ('LNC000017','LTC000009','Level N Cat0017','1');
insert into level_n_category_data values ('LNC000018','LTC000009','Level N Cat0018','1');
insert into level_n_category_data values ('LNC000019','LTC000010','Level N Cat0019','1');
insert into level_n_category_data values ('LNC000020','LTC000010','Level N Cat0020','1');
insert into level_n_category_data values ('LNC000021','LTC000011','Level N Cat0021','1');
insert into level_n_category_data values ('LNC000022','LTC000011','Level N Cat0022','1');
insert into level_n_category_data values ('LNC000023','LTC000012','Level N Cat0023','1');
insert into level_n_category_data values ('LNC000024','LTC000012','Level N Cat0024','1');
insert into level_n_category_data values ('LNC000025','LTC000013','Level N Cat0025','1');
insert into level_n_category_data values ('LNC000026','LTC000013','Level N Cat0026','1');
insert into level_n_category_data values ('LNC000027','LTC000014','Level N Cat0027','1');
insert into level_n_category_data values ('LNC000028','LTC000014','Level N Cat0028','1');
insert into level_n_category_data values ('LNC000029','LTC000015','Level N Cat0029','1');
insert into level_n_category_data values ('LNC000030','LTC000015','Level N Cat0030','1');
insert into level_n_category_data values ('LNC000031','LTC000016','Level N Cat0031','1');
insert into level_n_category_data values ('LNC000032','LTC000016','Level N Cat0032','1');

	
insert into brand_data values ('B000001','Telsa Auto','logo.jpg','The brand a great that has Roadester, Model S and Model X, Model 3 is in development','P000001','1');
insert into brand_data values ('B000002','Telsa Auto0002','logo.jpg','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0002','P000001','1');

	
insert into product_data values ('P000001','Jeans','LNC000001','B000001','China','C000001','The brand a great that has Roadester, Model S and Model X, Model 3 is in development','2019-01-03 01:40:02','1');
insert into product_data values ('P000002','Jeans0002','LNC000001','B000001','US','C000001','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0002','2019-01-04 15:54:45','1');
insert into product_data values ('P000003','Jeans0003','LNC000002','B000001','Japan','C000001','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0003','2018-12-23 13:43:28','1');
insert into product_data values ('P000004','Jeans0004','LNC000002','B000001','French','C000001','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0004','2018-12-25 22:49:33','1');
insert into product_data values ('P000005','Jeans0005','LNC000003','B000001','China','C000001','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0005','2018-12-21 12:14:25','1');
insert into product_data values ('P000006','Jeans0006','LNC000003','B000001','US','C000001','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0006','2019-01-03 23:16:49','1');
insert into product_data values ('P000007','Jeans0007','LNC000004','B000001','Japan','C000001','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0007','2018-12-24 17:57:50','1');
insert into product_data values ('P000008','Jeans0008','LNC000004','B000001','French','C000001','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0008','2018-12-29 13:21:44','1');
insert into product_data values ('P000009','Jeans0009','LNC000005','B000001','China','C000001','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0009','2018-12-29 22:15:41','1');
insert into product_data values ('P000010','Jeans0010','LNC000005','B000001','US','C000001','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0010','2019-01-07 04:15:48','1');
insert into product_data values ('P000011','Jeans0011','LNC000006','B000001','Japan','C000001','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0011','2019-01-09 08:54:48','1');
insert into product_data values ('P000012','Jeans0012','LNC000006','B000001','French','C000001','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0012','2018-12-19 22:21:37','1');
insert into product_data values ('P000013','Jeans0013','LNC000007','B000001','China','C000001','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0013','2018-12-31 13:07:29','1');
insert into product_data values ('P000014','Jeans0014','LNC000007','B000001','US','C000001','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0014','2018-12-26 21:11:38','1');
insert into product_data values ('P000015','Jeans0015','LNC000008','B000001','Japan','C000001','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0015','2018-12-30 01:14:43','1');
insert into product_data values ('P000016','Jeans0016','LNC000008','B000001','French','C000001','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0016','2018-12-19 21:47:34','1');
insert into product_data values ('P000017','Jeans0017','LNC000009','B000001','China','C000002','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0017','2019-01-06 11:16:13','1');
insert into product_data values ('P000018','Jeans0018','LNC000009','B000001','US','C000002','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0018','2019-01-07 16:57:53','1');
insert into product_data values ('P000019','Jeans0019','LNC000010','B000001','Japan','C000002','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0019','2018-12-26 12:14:06','1');
insert into product_data values ('P000020','Jeans0020','LNC000010','B000001','French','C000002','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0020','2018-12-30 18:38:03','1');
insert into product_data values ('P000021','Jeans0021','LNC000011','B000001','China','C000002','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0021','2019-01-07 18:19:27','1');
insert into product_data values ('P000022','Jeans0022','LNC000011','B000001','US','C000002','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0022','2018-12-21 21:12:17','1');
insert into product_data values ('P000023','Jeans0023','LNC000012','B000001','Japan','C000002','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0023','2018-12-23 15:29:57','1');
insert into product_data values ('P000024','Jeans0024','LNC000012','B000001','French','C000002','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0024','2018-12-27 16:04:42','1');
insert into product_data values ('P000025','Jeans0025','LNC000013','B000001','China','C000002','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0025','2018-12-28 00:34:37','1');
insert into product_data values ('P000026','Jeans0026','LNC000013','B000001','US','C000002','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0026','2019-01-01 11:40:30','1');
insert into product_data values ('P000027','Jeans0027','LNC000014','B000001','Japan','C000002','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0027','2019-01-08 17:32:46','1');
insert into product_data values ('P000028','Jeans0028','LNC000014','B000001','French','C000002','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0028','2019-01-09 07:12:59','1');
insert into product_data values ('P000029','Jeans0029','LNC000015','B000001','China','C000002','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0029','2018-12-31 17:01:53','1');
insert into product_data values ('P000030','Jeans0030','LNC000015','B000001','US','C000002','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0030','2019-01-07 14:09:33','1');
insert into product_data values ('P000031','Jeans0031','LNC000016','B000001','Japan','C000002','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0031','2019-01-04 17:10:30','1');
insert into product_data values ('P000032','Jeans0032','LNC000016','B000001','French','C000002','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0032','2018-12-25 09:11:41','1');
insert into product_data values ('P000033','Jeans0033','LNC000017','B000002','China','C000003','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0033','2018-12-21 02:59:08','1');
insert into product_data values ('P000034','Jeans0034','LNC000017','B000002','US','C000003','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0034','2018-12-23 07:10:46','1');
insert into product_data values ('P000035','Jeans0035','LNC000018','B000002','Japan','C000003','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0035','2019-01-01 00:13:14','1');
insert into product_data values ('P000036','Jeans0036','LNC000018','B000002','French','C000003','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0036','2018-12-24 11:21:02','1');
insert into product_data values ('P000037','Jeans0037','LNC000019','B000002','China','C000003','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0037','2018-12-22 19:52:09','1');
insert into product_data values ('P000038','Jeans0038','LNC000019','B000002','US','C000003','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0038','2018-12-26 17:09:23','1');
insert into product_data values ('P000039','Jeans0039','LNC000020','B000002','Japan','C000003','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0039','2018-12-29 12:35:55','1');
insert into product_data values ('P000040','Jeans0040','LNC000020','B000002','French','C000003','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0040','2019-01-02 00:07:49','1');
insert into product_data values ('P000041','Jeans0041','LNC000021','B000002','China','C000003','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0041','2018-12-31 04:38:37','1');
insert into product_data values ('P000042','Jeans0042','LNC000021','B000002','US','C000003','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0042','2018-12-24 05:57:11','1');
insert into product_data values ('P000043','Jeans0043','LNC000022','B000002','Japan','C000003','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0043','2018-12-27 09:30:31','1');
insert into product_data values ('P000044','Jeans0044','LNC000022','B000002','French','C000003','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0044','2018-12-25 00:42:24','1');
insert into product_data values ('P000045','Jeans0045','LNC000023','B000002','China','C000003','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0045','2018-12-21 00:16:06','1');
insert into product_data values ('P000046','Jeans0046','LNC000023','B000002','US','C000003','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0046','2019-01-01 03:40:04','1');
insert into product_data values ('P000047','Jeans0047','LNC000024','B000002','Japan','C000003','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0047','2018-12-22 01:57:49','1');
insert into product_data values ('P000048','Jeans0048','LNC000024','B000002','French','C000003','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0048','2018-12-26 04:58:50','1');
insert into product_data values ('P000049','Jeans0049','LNC000025','B000002','China','C000004','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0049','2019-01-04 12:58:53','1');
insert into product_data values ('P000050','Jeans0050','LNC000025','B000002','US','C000004','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0050','2018-12-27 17:07:06','1');
insert into product_data values ('P000051','Jeans0051','LNC000026','B000002','Japan','C000004','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0051','2019-01-03 23:10:14','1');
insert into product_data values ('P000052','Jeans0052','LNC000026','B000002','French','C000004','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0052','2018-12-19 21:12:46','1');
insert into product_data values ('P000053','Jeans0053','LNC000027','B000002','China','C000004','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0053','2019-01-05 11:11:34','1');
insert into product_data values ('P000054','Jeans0054','LNC000027','B000002','US','C000004','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0054','2019-01-09 02:14:19','1');
insert into product_data values ('P000055','Jeans0055','LNC000028','B000002','Japan','C000004','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0055','2018-12-28 05:26:39','1');
insert into product_data values ('P000056','Jeans0056','LNC000028','B000002','French','C000004','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0056','2018-12-26 09:56:19','1');
insert into product_data values ('P000057','Jeans0057','LNC000029','B000002','China','C000004','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0057','2018-12-19 21:04:14','1');
insert into product_data values ('P000058','Jeans0058','LNC000029','B000002','US','C000004','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0058','2018-12-20 13:01:23','1');
insert into product_data values ('P000059','Jeans0059','LNC000030','B000002','Japan','C000004','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0059','2019-01-08 02:56:12','1');
insert into product_data values ('P000060','Jeans0060','LNC000030','B000002','French','C000004','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0060','2018-12-31 02:26:58','1');
insert into product_data values ('P000061','Jeans0061','LNC000031','B000002','China','C000004','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0061','2018-12-23 12:36:36','1');
insert into product_data values ('P000062','Jeans0062','LNC000031','B000002','US','C000004','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0062','2019-01-03 20:18:00','1');
insert into product_data values ('P000063','Jeans0063','LNC000032','B000002','Japan','C000004','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0063','2018-12-19 20:29:23','1');
insert into product_data values ('P000064','Jeans0064','LNC000032','B000002','French','C000004','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0064','2018-12-25 16:45:38','1');

	
insert into sku_data values ('S000001','Jeans - Large','Large','P000001',1,'86.39','2019-01-07 09:40:05','1');
insert into sku_data values ('S000002','Jeans - Large0002','Small','P000001',1,'101.66','2019-01-07 16:28:51','1');
insert into sku_data values ('S000003','Jeans - Large0003','Medium','P000002',1,'98.70','2019-01-01 03:25:20','1');
insert into sku_data values ('S000004','Jeans - Large0004','Large','P000002',1,'86.22','2019-01-09 05:04:55','1');
insert into sku_data values ('S000005','Jeans - Large0005','Small','P000003',1,'97.89','2019-01-08 16:36:57','1');
insert into sku_data values ('S000006','Jeans - Large0006','Medium','P000003',1,'82.36','2019-01-09 09:24:08','1');
insert into sku_data values ('S000007','Jeans - Large0007','Large','P000004',1,'94.46','2018-12-20 08:31:51','1');
insert into sku_data values ('S000008','Jeans - Large0008','Small','P000004',1,'95.19','2018-12-21 21:46:01','1');
insert into sku_data values ('S000009','Jeans - Large0009','Medium','P000005',1,'103.11','2018-12-19 23:48:08','1');
insert into sku_data values ('S000010','Jeans - Large0010','Large','P000005',1,'102.57','2019-01-02 20:40:57','1');
insert into sku_data values ('S000011','Jeans - Large0011','Small','P000006',1,'88.87','2019-01-06 05:49:27','1');
insert into sku_data values ('S000012','Jeans - Large0012','Medium','P000006',1,'94.98','2018-12-20 18:51:51','1');
insert into sku_data values ('S000013','Jeans - Large0013','Large','P000007',1,'93.35','2018-12-27 00:05:05','1');
insert into sku_data values ('S000014','Jeans - Large0014','Small','P000007',1,'99.58','2018-12-31 08:46:48','1');
insert into sku_data values ('S000015','Jeans - Large0015','Medium','P000008',1,'78.01','2018-12-23 00:18:29','1');
insert into sku_data values ('S000016','Jeans - Large0016','Large','P000008',1,'102.36','2018-12-31 18:45:01','1');
insert into sku_data values ('S000017','Jeans - Large0017','Small','P000009',1,'84.83','2018-12-26 02:33:05','1');
insert into sku_data values ('S000018','Jeans - Large0018','Medium','P000009',1,'98.47','2018-12-25 18:30:28','1');
insert into sku_data values ('S000019','Jeans - Large0019','Large','P000010',1,'101.66','2019-01-06 16:05:16','1');
insert into sku_data values ('S000020','Jeans - Large0020','Small','P000010',1,'72.82','2019-01-07 22:50:17','1');
insert into sku_data values ('S000021','Jeans - Large0021','Medium','P000011',1,'81.31','2019-01-01 00:37:25','1');
insert into sku_data values ('S000022','Jeans - Large0022','Large','P000011',1,'89.43','2018-12-28 23:25:45','1');
insert into sku_data values ('S000023','Jeans - Large0023','Small','P000012',1,'91.30','2019-01-03 11:32:07','1');
insert into sku_data values ('S000024','Jeans - Large0024','Medium','P000012',1,'82.72','2018-12-30 13:13:41','1');
insert into sku_data values ('S000025','Jeans - Large0025','Large','P000013',1,'82.83','2018-12-29 16:46:23','1');
insert into sku_data values ('S000026','Jeans - Large0026','Small','P000013',1,'92.96','2018-12-24 19:09:34','1');
insert into sku_data values ('S000027','Jeans - Large0027','Medium','P000014',1,'89.53','2018-12-29 08:52:03','1');
insert into sku_data values ('S000028','Jeans - Large0028','Large','P000014',1,'78.99','2018-12-26 19:16:49','1');
insert into sku_data values ('S000029','Jeans - Large0029','Small','P000015',1,'92.38','2018-12-23 04:17:26','1');
insert into sku_data values ('S000030','Jeans - Large0030','Medium','P000015',1,'83.60','2019-01-03 04:27:11','1');
insert into sku_data values ('S000031','Jeans - Large0031','Large','P000016',1,'76.34','2018-12-22 08:15:30','1');
insert into sku_data values ('S000032','Jeans - Large0032','Small','P000016',1,'101.89','2019-01-05 06:53:11','1');
insert into sku_data values ('S000033','Jeans - Large0033','Medium','P000017',1,'95.07','2018-12-31 07:31:33','1');
insert into sku_data values ('S000034','Jeans - Large0034','Large','P000017',1,'85.90','2019-01-05 04:45:16','1');
insert into sku_data values ('S000035','Jeans - Large0035','Small','P000018',1,'85.13','2019-01-08 21:36:58','1');
insert into sku_data values ('S000036','Jeans - Large0036','Medium','P000018',1,'82.70','2019-01-06 12:25:08','1');
insert into sku_data values ('S000037','Jeans - Large0037','Large','P000019',1,'100.61','2018-12-29 14:13:59','1');
insert into sku_data values ('S000038','Jeans - Large0038','Small','P000019',1,'97.70','2019-01-10 04:17:26','1');
insert into sku_data values ('S000039','Jeans - Large0039','Medium','P000020',1,'76.40','2019-01-06 18:09:10','1');
insert into sku_data values ('S000040','Jeans - Large0040','Large','P000020',1,'75.60','2018-12-22 01:56:06','1');
insert into sku_data values ('S000041','Jeans - Large0041','Small','P000021',1,'84.62','2019-01-09 03:26:47','1');
insert into sku_data values ('S000042','Jeans - Large0042','Medium','P000021',1,'77.00','2018-12-26 16:58:53','1');
insert into sku_data values ('S000043','Jeans - Large0043','Large','P000022',1,'81.56','2018-12-21 22:04:28','1');
insert into sku_data values ('S000044','Jeans - Large0044','Small','P000022',1,'102.94','2018-12-31 15:36:56','1');
insert into sku_data values ('S000045','Jeans - Large0045','Medium','P000023',1,'89.75','2018-12-29 19:42:57','1');
insert into sku_data values ('S000046','Jeans - Large0046','Large','P000023',1,'96.60','2018-12-21 19:26:59','1');
insert into sku_data values ('S000047','Jeans - Large0047','Small','P000024',1,'100.26','2018-12-28 21:19:04','1');
insert into sku_data values ('S000048','Jeans - Large0048','Medium','P000024',1,'86.04','2019-01-08 02:24:54','1');
insert into sku_data values ('S000049','Jeans - Large0049','Large','P000025',1,'89.87','2018-12-26 10:19:48','1');
insert into sku_data values ('S000050','Jeans - Large0050','Small','P000025',1,'81.99','2019-01-08 01:36:25','1');
insert into sku_data values ('S000051','Jeans - Large0051','Medium','P000026',1,'93.48','2018-12-27 08:03:59','1');
insert into sku_data values ('S000052','Jeans - Large0052','Large','P000026',1,'78.21','2019-01-02 02:06:02','1');
insert into sku_data values ('S000053','Jeans - Large0053','Small','P000027',1,'79.70','2019-01-05 08:45:16','1');
insert into sku_data values ('S000054','Jeans - Large0054','Medium','P000027',1,'88.42','2019-01-10 12:53:29','1');
insert into sku_data values ('S000055','Jeans - Large0055','Large','P000028',1,'97.57','2018-12-28 03:10:09','1');
insert into sku_data values ('S000056','Jeans - Large0056','Small','P000028',1,'79.76','2019-01-04 20:51:38','1');
insert into sku_data values ('S000057','Jeans - Large0057','Medium','P000029',1,'101.40','2018-12-31 08:30:51','1');
insert into sku_data values ('S000058','Jeans - Large0058','Large','P000029',1,'83.66','2018-12-27 09:38:24','1');
insert into sku_data values ('S000059','Jeans - Large0059','Small','P000030',1,'73.87','2019-01-06 23:59:39','1');
insert into sku_data values ('S000060','Jeans - Large0060','Medium','P000030',1,'100.89','2018-12-30 11:39:31','1');
insert into sku_data values ('S000061','Jeans - Large0061','Large','P000031',1,'97.70','2019-01-05 13:32:55','1');
insert into sku_data values ('S000062','Jeans - Large0062','Small','P000031',1,'83.77','2019-01-04 23:40:10','1');
insert into sku_data values ('S000063','Jeans - Large0063','Medium','P000032',1,'91.86','2018-12-23 05:02:23','1');
insert into sku_data values ('S000064','Jeans - Large0064','Large','P000032',1,'77.29','2018-12-19 19:30:44','1');
insert into sku_data values ('S000065','Jeans - Large0065','Small','P000033',1,'92.66','2018-12-29 06:27:53','1');
insert into sku_data values ('S000066','Jeans - Large0066','Medium','P000033',1,'88.49','2019-01-06 14:44:44','1');
insert into sku_data values ('S000067','Jeans - Large0067','Large','P000034',1,'73.56','2019-01-02 06:26:21','1');
insert into sku_data values ('S000068','Jeans - Large0068','Small','P000034',1,'102.90','2018-12-29 08:52:21','1');
insert into sku_data values ('S000069','Jeans - Large0069','Medium','P000035',1,'78.77','2018-12-19 19:31:17','1');
insert into sku_data values ('S000070','Jeans - Large0070','Large','P000035',1,'90.81','2018-12-25 14:37:15','1');
insert into sku_data values ('S000071','Jeans - Large0071','Small','P000036',1,'84.04','2018-12-26 20:04:45','1');
insert into sku_data values ('S000072','Jeans - Large0072','Medium','P000036',1,'74.06','2018-12-24 12:53:09','1');
insert into sku_data values ('S000073','Jeans - Large0073','Large','P000037',1,'95.93','2019-01-04 00:33:58','1');
insert into sku_data values ('S000074','Jeans - Large0074','Small','P000037',1,'87.12','2018-12-21 00:54:49','1');
insert into sku_data values ('S000075','Jeans - Large0075','Medium','P000038',1,'101.66','2018-12-20 16:51:53','1');
insert into sku_data values ('S000076','Jeans - Large0076','Large','P000038',1,'91.75','2018-12-24 22:06:52','1');
insert into sku_data values ('S000077','Jeans - Large0077','Small','P000039',1,'82.39','2019-01-05 07:57:37','1');
insert into sku_data values ('S000078','Jeans - Large0078','Medium','P000039',1,'99.41','2019-01-03 18:30:43','1');
insert into sku_data values ('S000079','Jeans - Large0079','Large','P000040',1,'82.62','2018-12-27 09:15:31','1');
insert into sku_data values ('S000080','Jeans - Large0080','Small','P000040',1,'81.41','2018-12-25 04:05:29','1');
insert into sku_data values ('S000081','Jeans - Large0081','Medium','P000041',1,'91.43','2018-12-29 07:54:48','1');
insert into sku_data values ('S000082','Jeans - Large0082','Large','P000041',1,'89.39','2019-01-05 21:34:45','1');
insert into sku_data values ('S000083','Jeans - Large0083','Small','P000042',1,'73.93','2019-01-09 20:13:17','1');
insert into sku_data values ('S000084','Jeans - Large0084','Medium','P000042',1,'85.57','2019-01-06 19:41:40','1');
insert into sku_data values ('S000085','Jeans - Large0085','Large','P000043',1,'97.89','2019-01-04 15:51:39','1');
insert into sku_data values ('S000086','Jeans - Large0086','Small','P000043',1,'101.16','2019-01-01 19:50:07','1');
insert into sku_data values ('S000087','Jeans - Large0087','Medium','P000044',1,'90.22','2018-12-28 14:40:48','1');
insert into sku_data values ('S000088','Jeans - Large0088','Large','P000044',1,'75.61','2018-12-31 17:42:30','1');
insert into sku_data values ('S000089','Jeans - Large0089','Small','P000045',1,'96.63','2019-01-10 14:54:30','1');
insert into sku_data values ('S000090','Jeans - Large0090','Medium','P000045',1,'94.34','2018-12-22 08:11:54','1');
insert into sku_data values ('S000091','Jeans - Large0091','Large','P000046',1,'81.27','2018-12-25 14:39:25','1');
insert into sku_data values ('S000092','Jeans - Large0092','Small','P000046',1,'72.26','2018-12-26 23:33:40','1');
insert into sku_data values ('S000093','Jeans - Large0093','Medium','P000047',1,'73.18','2018-12-21 10:10:30','1');
insert into sku_data values ('S000094','Jeans - Large0094','Large','P000047',1,'98.40','2019-01-08 12:39:36','1');
insert into sku_data values ('S000095','Jeans - Large0095','Small','P000048',1,'92.81','2019-01-05 01:47:03','1');
insert into sku_data values ('S000096','Jeans - Large0096','Medium','P000048',1,'87.01','2018-12-21 02:24:37','1');
insert into sku_data values ('S000097','Jeans - Large0097','Large','P000049',1,'99.62','2018-12-29 01:15:35','1');
insert into sku_data values ('S000098','Jeans - Large0098','Small','P000049',1,'72.66','2019-01-07 20:40:29','1');
insert into sku_data values ('S000099','Jeans - Large0099','Medium','P000050',1,'95.90','2018-12-24 23:55:45','1');
insert into sku_data values ('S000100','Jeans - Large0100','Large','P000050',1,'100.97','2019-01-09 12:57:13','1');
insert into sku_data values ('S000101','Jeans - Large0101','Small','P000051',1,'89.51','2018-12-29 14:27:42','1');
insert into sku_data values ('S000102','Jeans - Large0102','Medium','P000051',1,'87.22','2019-01-02 10:08:18','1');
insert into sku_data values ('S000103','Jeans - Large0103','Large','P000052',1,'98.31','2018-12-23 02:52:02','1');
insert into sku_data values ('S000104','Jeans - Large0104','Small','P000052',1,'73.39','2018-12-25 00:32:50','1');
insert into sku_data values ('S000105','Jeans - Large0105','Medium','P000053',1,'99.78','2018-12-22 11:47:00','1');
insert into sku_data values ('S000106','Jeans - Large0106','Large','P000053',1,'101.01','2018-12-20 14:26:26','1');
insert into sku_data values ('S000107','Jeans - Large0107','Small','P000054',1,'90.70','2018-12-24 13:43:12','1');
insert into sku_data values ('S000108','Jeans - Large0108','Medium','P000054',1,'88.12','2018-12-24 17:36:31','1');
insert into sku_data values ('S000109','Jeans - Large0109','Large','P000055',1,'78.42','2018-12-28 21:08:23','1');
insert into sku_data values ('S000110','Jeans - Large0110','Small','P000055',1,'91.46','2018-12-24 14:03:37','1');
insert into sku_data values ('S000111','Jeans - Large0111','Medium','P000056',1,'84.95','2019-01-09 15:53:45','1');
insert into sku_data values ('S000112','Jeans - Large0112','Large','P000056',1,'88.20','2019-01-03 21:52:39','1');
insert into sku_data values ('S000113','Jeans - Large0113','Small','P000057',1,'85.45','2018-12-24 20:24:32','1');
insert into sku_data values ('S000114','Jeans - Large0114','Medium','P000057',1,'75.20','2018-12-20 22:59:26','1');
insert into sku_data values ('S000115','Jeans - Large0115','Large','P000058',1,'91.49','2018-12-21 18:39:17','1');
insert into sku_data values ('S000116','Jeans - Large0116','Small','P000058',1,'96.43','2018-12-24 08:07:14','1');
insert into sku_data values ('S000117','Jeans - Large0117','Medium','P000059',1,'87.16','2019-01-07 16:56:43','1');
insert into sku_data values ('S000118','Jeans - Large0118','Large','P000059',1,'77.64','2019-01-08 20:03:55','1');
insert into sku_data values ('S000119','Jeans - Large0119','Small','P000060',1,'91.81','2018-12-21 19:49:42','1');
insert into sku_data values ('S000120','Jeans - Large0120','Medium','P000060',1,'78.14','2019-01-09 18:39:10','1');
insert into sku_data values ('S000121','Jeans - Large0121','Large','P000061',1,'87.89','2018-12-23 02:47:18','1');
insert into sku_data values ('S000122','Jeans - Large0122','Small','P000061',1,'101.66','2018-12-26 17:52:08','1');
insert into sku_data values ('S000123','Jeans - Large0123','Medium','P000062',1,'85.16','2018-12-21 13:13:27','1');
insert into sku_data values ('S000124','Jeans - Large0124','Large','P000062',1,'80.61','2019-01-09 23:51:14','1');
insert into sku_data values ('S000125','Jeans - Large0125','Small','P000063',1,'86.40','2019-01-07 00:23:32','1');
insert into sku_data values ('S000126','Jeans - Large0126','Medium','P000063',1,'75.91','2018-12-31 09:18:21','1');
insert into sku_data values ('S000127','Jeans - Large0127','Large','P000064',1,'95.40','2019-01-05 23:38:16','1');
insert into sku_data values ('S000128','Jeans - Large0128','Small','P000064',1,'99.59','2019-01-09 04:03:36','1');

	
insert into user_domain_data values ('UD000001','用户区域','1');

	
insert into user_white_list_data values ('UWL000001','clariones','tester;ios-spokesperson','UD000001','1');
insert into user_white_list_data values ('UWL000002','13808188512','tester;ios-spokesperson0002','UD000001','1');

	
insert into sec_user_data values ('SU000001','login','13900000001','','C183EC89F92A462CF45B95504792EC4625E847C90536EEFE512D1C9DB8602E95','0','2019-01-05 14:57:23','2019-01-06 09:54:23','UD000001',NULL,'BLOCKED','1');
insert into sec_user_data values ('SU000002','login0002','13900000002','suddy_chang@163.com','AC2F95628244C6975EB2C36942EA879ED93D93F5895EF3157733E4629FA86B92','9999999','2018-12-24 16:23:51','2018-12-29 18:30:31','UD000001',NULL,'BLOCKED0002','1');

	
insert into sec_user_blocking_data values ('SUB000001','currentUser()','2019-01-06 20:12:48','这个用户多次发送违反社区的帖子，现在把他给屏蔽了','1');

	
insert into user_app_data values ('UA000001','审车平台','SU000001','users',1,'MXWR','CarInspectionPlatform','CIP000001','/link/to/app','1');
insert into user_app_data values ('UA000002','账户管理','SU000001','bank',1,'MXWR','UserDomain','UD000001','/link/to/app0002','1');
insert into user_app_data values ('UA000003','接车公司','SU000001','wechat',1,'MXWR','CarReceivingServiceCompany','CRSC000001','/link/to/app0003','1');
insert into user_app_data values ('UA000004','审车公司','SU000002','bar-chart',1,'MXWR','CarInspectionServiceCompany','CISC000001','/link/to/app0004','1');
insert into user_app_data values ('UA000005','维修公司','SU000002','user',1,'MXWR','CarRepairingServiceCompany','CRSC000001','/link/to/app0005','1');
insert into user_app_data values ('UA000006','顾客','SU000002','users',1,'MXWR','CustomerInfo','CI000001','/link/to/app0006','1');

	
insert into list_access_data values ('LA000001','列表','levelOneCategoryList',1,1,1,1,1,'UA000001','1');
insert into list_access_data values ('LA000002','列表0002','levelOneCategoryList0002',1,1,1,1,1,'UA000001','1');
insert into list_access_data values ('LA000003','列表0003','levelOneCategoryList0003',1,1,1,1,1,'UA000002','1');
insert into list_access_data values ('LA000004','列表0004','levelOneCategoryList0004',1,1,1,1,1,'UA000003','1');
insert into list_access_data values ('LA000005','列表0005','levelOneCategoryList0005',1,1,1,1,1,'UA000004','1');
insert into list_access_data values ('LA000006','列表0006','levelOneCategoryList0006',1,1,1,1,1,'UA000004','1');
insert into list_access_data values ('LA000007','列表0007','levelOneCategoryList0007',1,1,1,1,1,'UA000005','1');
insert into list_access_data values ('LA000008','列表0008','levelOneCategoryList0008',1,1,1,1,1,'UA000006','1');

	
insert into object_access_data values ('OA000001','控制访问列表1','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000001','1');
insert into object_access_data values ('OA000002','控制访问列表10002','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000001','1');
insert into object_access_data values ('OA000003','控制访问列表10003','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000002','1');
insert into object_access_data values ('OA000004','控制访问列表10004','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000003','1');
insert into object_access_data values ('OA000005','控制访问列表10005','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000004','1');
insert into object_access_data values ('OA000006','控制访问列表10006','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000004','1');
insert into object_access_data values ('OA000007','控制访问列表10007','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000005','1');
insert into object_access_data values ('OA000008','控制访问列表10008','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000006','1');

	
insert into login_history_data values ('LH000001','2018-12-27 22:12:31','192.168.1.1','登陆成功','SU000001','1');
insert into login_history_data values ('LH000002','2019-01-08 12:40:28','192.168.1.2','登陆成功0002','SU000001','1');
insert into login_history_data values ('LH000003','2018-12-20 06:48:30','192.168.1.1','登陆成功0003','SU000002','1');
insert into login_history_data values ('LH000004','2019-01-06 02:52:16','192.168.1.2','登陆成功0004','SU000002','1');

	
insert into generic_form_data values ('GF000001','登记输入单','姓名就是你身份证上的名字','1');

	
insert into form_message_data values ('FM000001','字段组合错误','GF000001','success','1');
insert into form_message_data values ('FM000002','字段组合错误0002','GF000001','info','1');

	
insert into form_field_message_data values ('FFM000001','输入错误','name','GF000001','success','1');
insert into form_field_message_data values ('FFM000002','输入错误0002','name0002','GF000001','info','1');

	
insert into form_field_data values ('FF000001','姓名','name','name','text','GF000001','姓名就是你身份证上的名字','李一一','姓名就是你身份证上的名字','基础信息','maybe any value','a value expression',true,true,0,'','','1');
insert into form_field_data values ('FF000002','年龄','age','name0002','longtext','GF000001','姓名就是你身份证上的名字0002','李一一0002','姓名就是你身份证上的名字0002','扩展信息','maybe any value0002','a value expression0002',false,false,0,'','','1');
insert into form_field_data values ('FF000003','出生地','birth_place','name0003','date','GF000001','姓名就是你身份证上的名字0003','李一一0003','姓名就是你身份证上的名字0003','基础信息','maybe any value0003','a value expression0003',true,true,0,'','','1');
insert into form_field_data values ('FF000004','国籍','country','name0004','date_time','GF000001','姓名就是你身份证上的名字0004','李一一0004','姓名就是你身份证上的名字0004','扩展信息','maybe any value0004','a value expression0004',false,false,0,'男,女','男,女','1');

	
insert into form_action_data values ('FA000001','功能','name','save','default','genericFormManager/name/name0002/name0003/','GF000001','1');
insert into form_action_data values ('FA000002','功能0002','name0002','update','warning','genericFormManager/name/name0002/name0003/0002','GF000001','1');

/*
Mysql innodb's foreign key has index automatically

*/

create unique index idx_platform_version on platform_data(id, version);

create unique index idx_site_version on site_data(id, version);

alter table site_data add constraint site4platform_fk
	foreign key(platform) references platform_data(id) on delete cascade on update cascade;
create unique index idx_catalog_version on catalog_data(id, version);

alter table catalog_data add constraint catalog4site_fk
	foreign key(site) references site_data(id) on delete cascade on update cascade;
alter table catalog_data add constraint catalog4platform_fk
	foreign key(platform) references platform_data(id) on delete cascade on update cascade;
create unique index idx_level_one_category_version on level_one_category_data(id, version);

alter table level_one_category_data add constraint level_one_category4catalog_fk
	foreign key(catalog) references catalog_data(id) on delete cascade on update cascade;
create unique index idx_level_two_category_version on level_two_category_data(id, version);

alter table level_two_category_data add constraint level_two_category4parent_category_fk
	foreign key(parent_category) references level_one_category_data(id) on delete cascade on update cascade;
create unique index idx_level_n_category_version on level_n_category_data(id, version);

alter table level_n_category_data add constraint level_n_category4parent_category_fk
	foreign key(parent_category) references level_two_category_data(id) on delete cascade on update cascade;
create unique index idx_brand_version on brand_data(id, version);

alter table brand_data add constraint brand4platform_fk
	foreign key(platform) references platform_data(id) on delete cascade on update cascade;
create unique index idx_product_version on product_data(id, version);

alter table product_data add constraint product4parent_category_fk
	foreign key(parent_category) references level_n_category_data(id) on delete cascade on update cascade;
alter table product_data add constraint product4brand_fk
	foreign key(brand) references brand_data(id) on delete cascade on update cascade;
alter table product_data add constraint product4catalog_fk
	foreign key(catalog) references catalog_data(id) on delete cascade on update cascade;
create unique index idx_sku_version on sku_data(id, version);

alter table sku_data add constraint sku4product_fk
	foreign key(product) references product_data(id) on delete cascade on update cascade;
create unique index idx_user_domain_version on user_domain_data(id, version);

create unique index idx_user_white_list_version on user_white_list_data(id, version);

alter table user_white_list_data add constraint user_white_list4domain_fk
	foreign key(domain) references user_domain_data(id) on delete cascade on update cascade;
create unique index idx_sec_user_version on sec_user_data(id, version);

alter table sec_user_data add constraint sec_user4domain_fk
	foreign key(domain) references user_domain_data(id) on delete cascade on update cascade;
alter table sec_user_data add constraint sec_user4blocking_fk
	foreign key(blocking) references sec_user_blocking_data(id) on delete cascade on update cascade;
create unique index idx_sec_user_blocking_version on sec_user_blocking_data(id, version);

create unique index idx_user_app_version on user_app_data(id, version);

alter table user_app_data add constraint user_app4sec_user_fk
	foreign key(sec_user) references sec_user_data(id) on delete cascade on update cascade;
create unique index idx_list_access_version on list_access_data(id, version);

alter table list_access_data add constraint list_access4app_fk
	foreign key(app) references user_app_data(id) on delete cascade on update cascade;
create unique index idx_object_access_version on object_access_data(id, version);

alter table object_access_data add constraint object_access4app_fk
	foreign key(app) references user_app_data(id) on delete cascade on update cascade;
create unique index idx_login_history_version on login_history_data(id, version);

alter table login_history_data add constraint login_history4sec_user_fk
	foreign key(sec_user) references sec_user_data(id) on delete cascade on update cascade;
create unique index idx_generic_form_version on generic_form_data(id, version);

create unique index idx_form_message_version on form_message_data(id, version);

alter table form_message_data add constraint form_message4form_fk
	foreign key(form) references generic_form_data(id) on delete cascade on update cascade;
create unique index idx_form_field_message_version on form_field_message_data(id, version);

alter table form_field_message_data add constraint form_field_message4form_fk
	foreign key(form) references generic_form_data(id) on delete cascade on update cascade;
create unique index idx_form_field_version on form_field_data(id, version);

alter table form_field_data add constraint form_field4form_fk
	foreign key(form) references generic_form_data(id) on delete cascade on update cascade;
create unique index idx_form_action_version on form_action_data(id, version);

alter table form_action_data add constraint form_action4form_fk
	foreign key(form) references generic_form_data(id) on delete cascade on update cascade;
-- create extra index for time, number and mobile phone

create index platform4version_idx on platform_data(version);
create index site4last_update_time_idx on site_data(last_update_time);
create index site4version_idx on site_data(version);
create index catalog4seller_id_idx on catalog_data(seller_id);
create index catalog4version_idx on catalog_data(version);
create index level_one_category4version_idx on level_one_category_data(version);
create index level_two_category4version_idx on level_two_category_data(version);
create index level_n_category4version_idx on level_n_category_data(version);
create index brand4version_idx on brand_data(version);
create index product4last_update_time_idx on product_data(last_update_time);
create index product4version_idx on product_data(version);
create index sku4base_price_idx on sku_data(base_price);
create index sku4last_update_time_idx on sku_data(last_update_time);
create index sku4version_idx on sku_data(version);
create index user_domain4version_idx on user_domain_data(version);
create index user_white_list4version_idx on user_white_list_data(version);
create index sec_user4mobile_idx on sec_user_data(mobile);
create index sec_user4verification_code_idx on sec_user_data(verification_code);
create index sec_user4verification_code_expire_idx on sec_user_data(verification_code_expire);
create index sec_user4last_login_time_idx on sec_user_data(last_login_time);
create index sec_user4version_idx on sec_user_data(version);
create index sec_user_blocking4block_time_idx on sec_user_blocking_data(block_time);
create index sec_user_blocking4version_idx on sec_user_blocking_data(version);
create index user_app4object_id_idx on user_app_data(object_id);
create index user_app4version_idx on user_app_data(version);
create index list_access4version_idx on list_access_data(version);
create index object_access4version_idx on object_access_data(version);
create index login_history4login_time_idx on login_history_data(login_time);
create index login_history4version_idx on login_history_data(version);
create index generic_form4version_idx on generic_form_data(version);
create index form_message4version_idx on form_message_data(version);
create index form_field_message4version_idx on form_field_message_data(version);
create index form_field4version_idx on form_field_data(version);
create index form_action4version_idx on form_action_data(version);










delete from sec_user_data;
delete from user_app_data;

/*
+--------------------------+-------------+------+-----+---------+-------+
| Field                    | Type        | Null | Key | Default | Extra |
+--------------------------+-------------+------+-----+---------+-------+
| id                       | varchar(64) | NO   | PRI | NULL    |       |
| login                    | varchar(20) | YES  |     | NULL    |       |
| mobile                   | varchar(11) | YES  | MUL | NULL    |       |
| email                    | varchar(76) | YES  |     | NULL    |       |
| pwd                      | varchar(64) | YES  |     | NULL    |       |
| verification_code        | int(11)     | YES  | MUL | NULL    |       |
| verification_code_expire | datetime    | YES  | MUL | NULL    |       |
| last_login_time          | datetime    | YES  | MUL | NULL    |       |
| domain                   | varchar(48) | YES  | MUL | NULL    |       |
| blocking                 | varchar(48) | YES  | MUL | NULL    |       |
| current_status           | varchar(28) | YES  |     | NULL    |       |
| version                  | int(11)     | YES  | MUL | NULL    |       |
+--------------------------+-------------+------+-----+---------+-------+


*/

insert into sec_user_data values('SU000001','u000001','13900000001','1000001@qq.com','258D9BB89BBC1F2A6CDDD3A4CB300E6CD9B83F3FC9984619DF1A59F6051F1F44','9292993','2019-09-09 09:09:09','2019-09-09 09:09:09','UD000001',NULL,'INIT',1);
insert into user_app_data values('UA000001','Platform','SU000001','at',1,'MXWR','Platform','P000001','/link/to/app','1'); -- REFER COUNT: 3
insert into user_app_data values('UA000002','My Account','SU000001','lock',1,'MXWR','SecUser','SU000001','/link/to/app','1'); -- REFER COUNT: 3
insert into sec_user_data values('SU000002','u000002','13900000002','1000002@qq.com','7FEABCC19D638787655F9FFC2C22755D5771184D85D000147D643D22F6617F7B','9292993','2019-09-09 09:09:09','2019-09-09 09:09:09','UD000001',NULL,'INIT',1);
insert into user_app_data values('UA000003','User Domain','SU000002','user',1,'MXWR','UserDomain','UD000001','/link/to/app','1'); -- REFER COUNT: 2
insert into user_app_data values('UA000004','My Account','SU000002','lock',1,'MXWR','SecUser','SU000002','/link/to/app','1'); -- REFER COUNT: 2
insert into sec_user_data values('SU000003','u000003','13900000003','1000003@qq.com','8169C17063461B0B0CC210CE5EF682E9517A19170F7DCA3C76170229D765DE7A','9292993','2019-09-09 09:09:09','2019-09-09 09:09:09','UD000001',NULL,'INIT',1);
insert into user_app_data values('UA000005','Sec User Blocking','SU000003','user',1,'MXWR','SecUserBlocking','SUB000001','/link/to/app','1'); -- REFER COUNT: 1
insert into user_app_data values('UA000006','My Account','SU000003','lock',1,'MXWR','SecUser','SU000003','/link/to/app','1'); -- REFER COUNT: 1




/*
| 角色        | 用户名           | 密码         |
| ------------- |:-------------:|:-------------------:|
|Platform|13900000001|DoubleChain!y1|
|User Domain|13900000002|DoubleChain!y1|
|Sec User Blocking|13900000003|DoubleChain!y1|


*/



/* start with data patch */
/* The sql file is not found from: /Users/Philip/githome/web-code-generator/sky/data-patch/pim.sql */


/*

+----------+---------------------------------+---------------------+--------+
| Charset  | Description                     | Default collation   | Maxlen |
+----------+---------------------------------+---------------------+--------+
| gb2312   | GB2312 Simplified Chinese       | gb2312_chinese_ci   |      2 |
| gbk      | GBK Simplified Chinese          | gbk_chinese_ci      |      2 |
| utf8mb4  | UTF-8 Unicode                   | utf8mb4_general_ci  |      4 |
| utf32    | UTF-32 Unicode                  | utf32_general_ci    |      4 |
| gb18030  | China National Standard GB18030 | gb18030_chinese_ci  |      4 |
+----------+---------------------------------+---------------------+--------+

*/

