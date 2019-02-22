-- BUILD WITH MODEL TIME 190221T1800
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
	product_cover_image 	varchar(512) CHARACTER SET ascii COLLATE ascii_general_ci                     comment 'Product Cover Image',
	origin              	varchar(24)                              comment 'Origin',
	catalog             	varchar(48)                              comment 'Catalog',
	remark              	varchar(336)                             comment 'Remark',
	last_update_time    	datetime                                 comment 'Last Update Time',
	platform            	varchar(48)                              comment 'Platform',
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

drop table  if exists profile_data;
create table profile_data (
	id                  	varchar(64)          not null            comment 'Id',
	name                	varchar(72)                              comment 'Name',
	platform            	varchar(48)                              comment 'Platform',
	version             	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists brand_filter_data;
create table brand_filter_data (
	id                  	varchar(64)          not null            comment 'Id',
	name                	varchar(72)                              comment 'Name',
	internal_id         	varchar(28)                              comment 'Internal Id',
	profile             	varchar(48)                              comment 'Profile',
	version             	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists price_filter_data;
create table price_filter_data (
	id                  	varchar(64)          not null            comment 'Id',
	name                	varchar(72)                              comment 'Name',
	price_start         	numeric(4,2)                             comment 'Price Start',
	price_end           	numeric(10,2)                            comment 'Price End',
	profile             	varchar(48)                              comment 'Profile',
	version             	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists category_filter_data;
create table category_filter_data (
	id                  	varchar(64)          not null            comment 'Id',
	name                	varchar(72)                              comment 'Name',
	internal_id         	varchar(32)                              comment 'Internal Id',
	profile             	varchar(48)                              comment 'Profile',
	version             	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists new_product_data;
create table new_product_data (
	id                  	varchar(64)          not null            comment 'Id',
	name                	varchar(20)                              comment 'Name',
	parent_category     	varchar(48)                              comment 'Parent Category',
	brand               	varchar(48)                              comment 'Brand',
	product_cover_image 	varchar(512) CHARACTER SET ascii COLLATE ascii_general_ci                     comment 'Product Cover Image',
	origin              	varchar(24)                              comment 'Origin',
	catalog             	varchar(48)                              comment 'Catalog',
	profile             	varchar(48)                              comment 'Profile',
	remark              	varchar(336)                             comment 'Remark',
	last_update_time    	datetime                                 comment 'Last Update Time',
	platform            	varchar(48)                              comment 'Platform',
	version             	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists editor_pick_product_data;
create table editor_pick_product_data (
	id                  	varchar(64)          not null            comment 'Id',
	name                	varchar(20)                              comment 'Name',
	parent_category     	varchar(48)                              comment 'Parent Category',
	brand               	varchar(48)                              comment 'Brand',
	product_cover_image 	varchar(512) CHARACTER SET ascii COLLATE ascii_general_ci                     comment 'Product Cover Image',
	origin              	varchar(24)                              comment 'Origin',
	catalog             	varchar(48)                              comment 'Catalog',
	profile             	varchar(48)                              comment 'Profile',
	remark              	varchar(336)                             comment 'Remark',
	last_update_time    	datetime                                 comment 'Last Update Time',
	platform            	varchar(48)                              comment 'Platform',
	version             	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists top_rated_product_data;
create table top_rated_product_data (
	id                  	varchar(64)          not null            comment 'Id',
	name                	varchar(20)                              comment 'Name',
	parent_category     	varchar(48)                              comment 'Parent Category',
	brand               	varchar(48)                              comment 'Brand',
	product_cover_image 	varchar(512) CHARACTER SET ascii COLLATE ascii_general_ci                     comment 'Product Cover Image',
	origin              	varchar(24)                              comment 'Origin',
	catalog             	varchar(48)                              comment 'Catalog',
	remark              	varchar(336)                             comment 'Remark',
	last_update_time    	datetime                                 comment 'Last Update Time',
	profile             	varchar(48)                              comment 'Profile',
	platform            	varchar(48)                              comment 'Platform',
	version             	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists recommand_product_data;
create table recommand_product_data (
	id                  	varchar(64)          not null            comment 'Id',
	name                	varchar(20)                              comment 'Name',
	parent_category     	varchar(48)                              comment 'Parent Category',
	brand               	varchar(48)                              comment 'Brand',
	product_cover_image 	varchar(512) CHARACTER SET ascii COLLATE ascii_general_ci                     comment 'Product Cover Image',
	origin              	varchar(24)                              comment 'Origin',
	catalog             	varchar(48)                              comment 'Catalog',
	remark              	varchar(336)                             comment 'Remark',
	last_update_time    	datetime                                 comment 'Last Update Time',
	profile             	varchar(48)                              comment 'Profile',
	platform            	varchar(48)                              comment 'Platform',
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

	
insert into site_data values ('S000001','The first customer site','The primary site for show the concept','P000001','2019-02-05 09:41:44','1');
insert into site_data values ('S000002','The first customer site0002','The primary site for show the concept0002','P000001','2019-02-03 03:02:00','1');

	
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

	
insert into brand_data values ('B000001','Telsa Auto','https://demo.doublechaintech.com/demodata/imageManager/genImage/logo00/400/200/grey/','The brand a great that has Roadester, Model S and Model X, Model 3 is in development','P000001','1');
insert into brand_data values ('B000002','Telsa Auto0002','https://demo.doublechaintech.com/demodata/imageManager/genImage/logo00/400/200/grey/','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0002','P000001','1');

	
insert into product_data values ('P000001','Jeans','LNC000001','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','China','C000001','The brand a great that has Roadester, Model S and Model X, Model 3 is in development','2019-02-11 14:12:10','P000001','1');
insert into product_data values ('P000002','Jeans0002','LNC000001','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','US','C000001','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0002','2019-02-08 02:57:50','P000001','1');
insert into product_data values ('P000003','Jeans0003','LNC000002','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','Japan','C000001','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0003','2019-02-05 02:20:42','P000001','1');
insert into product_data values ('P000004','Jeans0004','LNC000002','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','French','C000001','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0004','2019-02-14 03:18:23','P000001','1');
insert into product_data values ('P000005','Jeans0005','LNC000003','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','China','C000001','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0005','2019-02-10 03:35:05','P000001','1');
insert into product_data values ('P000006','Jeans0006','LNC000003','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','US','C000001','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0006','2019-02-18 23:11:53','P000001','1');
insert into product_data values ('P000007','Jeans0007','LNC000004','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','Japan','C000001','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0007','2019-02-14 10:08:02','P000001','1');
insert into product_data values ('P000008','Jeans0008','LNC000004','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','French','C000001','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0008','2019-02-01 00:29:28','P000001','1');
insert into product_data values ('P000009','Jeans0009','LNC000005','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','China','C000001','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0009','2019-02-01 10:12:38','P000001','1');
insert into product_data values ('P000010','Jeans0010','LNC000005','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','US','C000001','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0010','2019-02-01 01:00:51','P000001','1');
insert into product_data values ('P000011','Jeans0011','LNC000006','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','Japan','C000001','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0011','2019-02-22 07:10:39','P000001','1');
insert into product_data values ('P000012','Jeans0012','LNC000006','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','French','C000001','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0012','2019-02-11 09:33:23','P000001','1');
insert into product_data values ('P000013','Jeans0013','LNC000007','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','China','C000001','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0013','2019-02-15 06:10:12','P000001','1');
insert into product_data values ('P000014','Jeans0014','LNC000007','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','US','C000001','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0014','2019-02-14 15:28:22','P000001','1');
insert into product_data values ('P000015','Jeans0015','LNC000008','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','Japan','C000001','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0015','2019-02-14 01:08:42','P000001','1');
insert into product_data values ('P000016','Jeans0016','LNC000008','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','French','C000001','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0016','2019-02-12 10:53:28','P000001','1');
insert into product_data values ('P000017','Jeans0017','LNC000009','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','China','C000002','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0017','2019-02-21 10:06:43','P000001','1');
insert into product_data values ('P000018','Jeans0018','LNC000009','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','US','C000002','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0018','2019-02-03 13:40:14','P000001','1');
insert into product_data values ('P000019','Jeans0019','LNC000010','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','Japan','C000002','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0019','2019-02-16 07:08:19','P000001','1');
insert into product_data values ('P000020','Jeans0020','LNC000010','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','French','C000002','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0020','2019-02-04 20:06:39','P000001','1');
insert into product_data values ('P000021','Jeans0021','LNC000011','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','China','C000002','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0021','2019-02-15 11:33:47','P000001','1');
insert into product_data values ('P000022','Jeans0022','LNC000011','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','US','C000002','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0022','2019-02-04 16:15:12','P000001','1');
insert into product_data values ('P000023','Jeans0023','LNC000012','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','Japan','C000002','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0023','2019-02-10 15:06:41','P000001','1');
insert into product_data values ('P000024','Jeans0024','LNC000012','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','French','C000002','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0024','2019-02-03 17:00:44','P000001','1');
insert into product_data values ('P000025','Jeans0025','LNC000013','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','China','C000002','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0025','2019-02-22 12:40:10','P000001','1');
insert into product_data values ('P000026','Jeans0026','LNC000013','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','US','C000002','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0026','2019-02-15 18:18:26','P000001','1');
insert into product_data values ('P000027','Jeans0027','LNC000014','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','Japan','C000002','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0027','2019-02-13 22:12:02','P000001','1');
insert into product_data values ('P000028','Jeans0028','LNC000014','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','French','C000002','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0028','2019-02-02 13:57:42','P000001','1');
insert into product_data values ('P000029','Jeans0029','LNC000015','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','China','C000002','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0029','2019-02-16 09:26:36','P000001','1');
insert into product_data values ('P000030','Jeans0030','LNC000015','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','US','C000002','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0030','2019-02-10 12:53:09','P000001','1');
insert into product_data values ('P000031','Jeans0031','LNC000016','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','Japan','C000002','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0031','2019-02-20 17:35:39','P000001','1');
insert into product_data values ('P000032','Jeans0032','LNC000016','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','French','C000002','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0032','2019-02-14 21:37:03','P000001','1');
insert into product_data values ('P000033','Jeans0033','LNC000017','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','China','C000003','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0033','2019-02-13 07:23:58','P000001','1');
insert into product_data values ('P000034','Jeans0034','LNC000017','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','US','C000003','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0034','2019-02-12 00:16:53','P000001','1');
insert into product_data values ('P000035','Jeans0035','LNC000018','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','Japan','C000003','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0035','2019-02-20 15:31:08','P000001','1');
insert into product_data values ('P000036','Jeans0036','LNC000018','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','French','C000003','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0036','2019-02-13 13:48:11','P000001','1');
insert into product_data values ('P000037','Jeans0037','LNC000019','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','China','C000003','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0037','2019-02-20 13:48:41','P000001','1');
insert into product_data values ('P000038','Jeans0038','LNC000019','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','US','C000003','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0038','2019-02-15 22:21:35','P000001','1');
insert into product_data values ('P000039','Jeans0039','LNC000020','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','Japan','C000003','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0039','2019-02-14 10:50:38','P000001','1');
insert into product_data values ('P000040','Jeans0040','LNC000020','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','French','C000003','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0040','2019-02-01 20:24:45','P000001','1');
insert into product_data values ('P000041','Jeans0041','LNC000021','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','China','C000003','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0041','2019-02-08 01:52:05','P000001','1');
insert into product_data values ('P000042','Jeans0042','LNC000021','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','US','C000003','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0042','2019-02-03 13:46:33','P000001','1');
insert into product_data values ('P000043','Jeans0043','LNC000022','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','Japan','C000003','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0043','2019-02-17 10:24:28','P000001','1');
insert into product_data values ('P000044','Jeans0044','LNC000022','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','French','C000003','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0044','2019-02-16 19:24:05','P000001','1');
insert into product_data values ('P000045','Jeans0045','LNC000023','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','China','C000003','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0045','2019-02-02 14:24:12','P000001','1');
insert into product_data values ('P000046','Jeans0046','LNC000023','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','US','C000003','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0046','2019-02-06 04:20:38','P000001','1');
insert into product_data values ('P000047','Jeans0047','LNC000024','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','Japan','C000003','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0047','2019-02-18 15:31:53','P000001','1');
insert into product_data values ('P000048','Jeans0048','LNC000024','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','French','C000003','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0048','2019-02-13 00:13:31','P000001','1');
insert into product_data values ('P000049','Jeans0049','LNC000025','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','China','C000004','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0049','2019-02-01 02:34:44','P000001','1');
insert into product_data values ('P000050','Jeans0050','LNC000025','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','US','C000004','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0050','2019-02-13 15:59:31','P000001','1');
insert into product_data values ('P000051','Jeans0051','LNC000026','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','Japan','C000004','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0051','2019-02-02 02:50:43','P000001','1');
insert into product_data values ('P000052','Jeans0052','LNC000026','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','French','C000004','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0052','2019-02-13 14:42:38','P000001','1');
insert into product_data values ('P000053','Jeans0053','LNC000027','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','China','C000004','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0053','2019-02-17 01:07:59','P000001','1');
insert into product_data values ('P000054','Jeans0054','LNC000027','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','US','C000004','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0054','2019-02-05 13:37:27','P000001','1');
insert into product_data values ('P000055','Jeans0055','LNC000028','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','Japan','C000004','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0055','2019-02-13 17:09:57','P000001','1');
insert into product_data values ('P000056','Jeans0056','LNC000028','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','French','C000004','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0056','2019-02-07 05:18:17','P000001','1');
insert into product_data values ('P000057','Jeans0057','LNC000029','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','China','C000004','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0057','2019-02-01 12:58:25','P000001','1');
insert into product_data values ('P000058','Jeans0058','LNC000029','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','US','C000004','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0058','2019-02-11 09:26:21','P000001','1');
insert into product_data values ('P000059','Jeans0059','LNC000030','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','Japan','C000004','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0059','2019-02-07 05:16:11','P000001','1');
insert into product_data values ('P000060','Jeans0060','LNC000030','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','French','C000004','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0060','2019-02-08 02:31:24','P000001','1');
insert into product_data values ('P000061','Jeans0061','LNC000031','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','China','C000004','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0061','2019-02-06 02:22:32','P000001','1');
insert into product_data values ('P000062','Jeans0062','LNC000031','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','US','C000004','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0062','2019-02-19 07:58:40','P000001','1');
insert into product_data values ('P000063','Jeans0063','LNC000032','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','Japan','C000004','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0063','2019-02-07 13:27:56','P000001','1');
insert into product_data values ('P000064','Jeans0064','LNC000032','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','French','C000004','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0064','2019-02-03 06:49:22','P000001','1');

	
insert into sku_data values ('S000001','Jeans - Large','Large','P000001',1,'81.75','2019-02-09 13:39:26','1');
insert into sku_data values ('S000002','Jeans - Large0002','Small','P000001',1,'90.30','2019-02-07 05:26:55','1');
insert into sku_data values ('S000003','Jeans - Large0003','Medium','P000002',1,'79.38','2019-02-11 10:55:44','1');
insert into sku_data values ('S000004','Jeans - Large0004','Large','P000002',1,'77.39','2019-02-09 10:52:24','1');
insert into sku_data values ('S000005','Jeans - Large0005','Small','P000003',1,'102.05','2019-02-11 08:42:52','1');
insert into sku_data values ('S000006','Jeans - Large0006','Medium','P000003',1,'97.35','2019-02-05 21:48:15','1');
insert into sku_data values ('S000007','Jeans - Large0007','Large','P000004',1,'81.09','2019-02-11 01:01:30','1');
insert into sku_data values ('S000008','Jeans - Large0008','Small','P000004',1,'83.89','2019-02-18 16:27:28','1');
insert into sku_data values ('S000009','Jeans - Large0009','Medium','P000005',1,'78.51','2019-02-21 18:37:16','1');
insert into sku_data values ('S000010','Jeans - Large0010','Large','P000005',1,'82.78','2019-02-15 22:49:04','1');
insert into sku_data values ('S000011','Jeans - Large0011','Small','P000006',1,'87.48','2019-02-07 14:40:27','1');
insert into sku_data values ('S000012','Jeans - Large0012','Medium','P000006',1,'101.97','2019-02-10 12:44:59','1');
insert into sku_data values ('S000013','Jeans - Large0013','Large','P000007',1,'76.34','2019-02-16 22:12:03','1');
insert into sku_data values ('S000014','Jeans - Large0014','Small','P000007',1,'84.38','2019-02-05 14:31:36','1');
insert into sku_data values ('S000015','Jeans - Large0015','Medium','P000008',1,'102.86','2019-02-01 20:11:01','1');
insert into sku_data values ('S000016','Jeans - Large0016','Large','P000008',1,'95.12','2019-02-15 12:19:28','1');
insert into sku_data values ('S000017','Jeans - Large0017','Small','P000009',1,'95.52','2019-02-10 11:57:29','1');
insert into sku_data values ('S000018','Jeans - Large0018','Medium','P000009',1,'98.23','2019-02-16 11:57:50','1');
insert into sku_data values ('S000019','Jeans - Large0019','Large','P000010',1,'103.11','2019-02-14 10:26:27','1');
insert into sku_data values ('S000020','Jeans - Large0020','Small','P000010',1,'82.47','2019-02-18 15:39:06','1');
insert into sku_data values ('S000021','Jeans - Large0021','Medium','P000011',1,'87.85','2019-02-11 19:16:57','1');
insert into sku_data values ('S000022','Jeans - Large0022','Large','P000011',1,'74.04','2019-02-07 07:49:31','1');
insert into sku_data values ('S000023','Jeans - Large0023','Small','P000012',1,'89.85','2019-02-14 12:16:44','1');
insert into sku_data values ('S000024','Jeans - Large0024','Medium','P000012',1,'81.89','2019-02-09 19:56:04','1');
insert into sku_data values ('S000025','Jeans - Large0025','Large','P000013',1,'102.49','2019-02-03 19:44:02','1');
insert into sku_data values ('S000026','Jeans - Large0026','Small','P000013',1,'90.34','2019-02-08 12:24:19','1');
insert into sku_data values ('S000027','Jeans - Large0027','Medium','P000014',1,'90.77','2019-02-19 02:45:50','1');
insert into sku_data values ('S000028','Jeans - Large0028','Large','P000014',1,'92.49','2019-02-12 09:35:24','1');
insert into sku_data values ('S000029','Jeans - Large0029','Small','P000015',1,'77.82','2019-02-09 10:44:40','1');
insert into sku_data values ('S000030','Jeans - Large0030','Medium','P000015',1,'93.76','2019-02-16 20:11:38','1');
insert into sku_data values ('S000031','Jeans - Large0031','Large','P000016',1,'100.15','2019-02-07 17:14:52','1');
insert into sku_data values ('S000032','Jeans - Large0032','Small','P000016',1,'100.35','2019-02-14 11:27:32','1');
insert into sku_data values ('S000033','Jeans - Large0033','Medium','P000017',1,'89.45','2019-02-12 23:04:51','1');
insert into sku_data values ('S000034','Jeans - Large0034','Large','P000017',1,'95.68','2019-02-06 02:43:29','1');
insert into sku_data values ('S000035','Jeans - Large0035','Small','P000018',1,'99.89','2019-02-01 20:37:32','1');
insert into sku_data values ('S000036','Jeans - Large0036','Medium','P000018',1,'83.76','2019-02-17 14:02:20','1');
insert into sku_data values ('S000037','Jeans - Large0037','Large','P000019',1,'92.44','2019-02-12 23:36:23','1');
insert into sku_data values ('S000038','Jeans - Large0038','Small','P000019',1,'101.97','2019-02-19 12:15:47','1');
insert into sku_data values ('S000039','Jeans - Large0039','Medium','P000020',1,'77.45','2019-02-08 12:38:16','1');
insert into sku_data values ('S000040','Jeans - Large0040','Large','P000020',1,'79.24','2019-02-06 15:01:44','1');
insert into sku_data values ('S000041','Jeans - Large0041','Small','P000021',1,'75.92','2019-02-06 19:05:10','1');
insert into sku_data values ('S000042','Jeans - Large0042','Medium','P000021',1,'96.44','2019-02-07 21:55:43','1');
insert into sku_data values ('S000043','Jeans - Large0043','Large','P000022',1,'72.85','2019-02-13 04:39:38','1');
insert into sku_data values ('S000044','Jeans - Large0044','Small','P000022',1,'83.22','2019-02-01 02:28:27','1');
insert into sku_data values ('S000045','Jeans - Large0045','Medium','P000023',1,'86.07','2019-02-18 00:34:12','1');
insert into sku_data values ('S000046','Jeans - Large0046','Large','P000023',1,'81.26','2019-02-03 22:26:23','1');
insert into sku_data values ('S000047','Jeans - Large0047','Small','P000024',1,'93.65','2019-02-16 18:25:15','1');
insert into sku_data values ('S000048','Jeans - Large0048','Medium','P000024',1,'83.02','2019-02-02 12:36:30','1');
insert into sku_data values ('S000049','Jeans - Large0049','Large','P000025',1,'91.41','2019-02-22 08:06:03','1');
insert into sku_data values ('S000050','Jeans - Large0050','Small','P000025',1,'77.00','2019-02-22 07:04:14','1');
insert into sku_data values ('S000051','Jeans - Large0051','Medium','P000026',1,'100.32','2019-02-06 16:28:48','1');
insert into sku_data values ('S000052','Jeans - Large0052','Large','P000026',1,'100.27','2019-02-08 20:28:31','1');
insert into sku_data values ('S000053','Jeans - Large0053','Small','P000027',1,'90.61','2019-02-03 14:05:02','1');
insert into sku_data values ('S000054','Jeans - Large0054','Medium','P000027',1,'101.01','2019-02-02 11:00:52','1');
insert into sku_data values ('S000055','Jeans - Large0055','Large','P000028',1,'102.25','2019-02-20 16:55:31','1');
insert into sku_data values ('S000056','Jeans - Large0056','Small','P000028',1,'91.53','2019-02-09 11:37:41','1');
insert into sku_data values ('S000057','Jeans - Large0057','Medium','P000029',1,'80.80','2019-02-05 23:51:35','1');
insert into sku_data values ('S000058','Jeans - Large0058','Large','P000029',1,'73.23','2019-02-05 10:44:23','1');
insert into sku_data values ('S000059','Jeans - Large0059','Small','P000030',1,'86.80','2019-02-07 10:30:33','1');
insert into sku_data values ('S000060','Jeans - Large0060','Medium','P000030',1,'100.11','2019-02-11 04:11:34','1');
insert into sku_data values ('S000061','Jeans - Large0061','Large','P000031',1,'85.26','2019-02-09 16:13:20','1');
insert into sku_data values ('S000062','Jeans - Large0062','Small','P000031',1,'86.22','2019-02-06 04:19:58','1');
insert into sku_data values ('S000063','Jeans - Large0063','Medium','P000032',1,'84.93','2019-02-03 13:04:49','1');
insert into sku_data values ('S000064','Jeans - Large0064','Large','P000032',1,'85.79','2019-02-19 08:23:12','1');
insert into sku_data values ('S000065','Jeans - Large0065','Small','P000033',1,'90.69','2019-02-09 18:01:11','1');
insert into sku_data values ('S000066','Jeans - Large0066','Medium','P000033',1,'74.97','2019-02-07 22:00:59','1');
insert into sku_data values ('S000067','Jeans - Large0067','Large','P000034',1,'80.25','2019-02-14 02:20:28','1');
insert into sku_data values ('S000068','Jeans - Large0068','Small','P000034',1,'89.73','2019-02-14 05:59:02','1');
insert into sku_data values ('S000069','Jeans - Large0069','Medium','P000035',1,'77.55','2019-02-05 20:46:54','1');
insert into sku_data values ('S000070','Jeans - Large0070','Large','P000035',1,'82.04','2019-02-06 07:26:04','1');
insert into sku_data values ('S000071','Jeans - Large0071','Small','P000036',1,'80.47','2019-02-17 10:34:44','1');
insert into sku_data values ('S000072','Jeans - Large0072','Medium','P000036',1,'83.82','2019-02-10 14:49:05','1');
insert into sku_data values ('S000073','Jeans - Large0073','Large','P000037',1,'101.95','2019-02-08 15:30:44','1');
insert into sku_data values ('S000074','Jeans - Large0074','Small','P000037',1,'75.99','2019-02-14 23:17:37','1');
insert into sku_data values ('S000075','Jeans - Large0075','Medium','P000038',1,'73.77','2019-02-17 15:36:22','1');
insert into sku_data values ('S000076','Jeans - Large0076','Large','P000038',1,'84.29','2019-02-10 10:00:41','1');
insert into sku_data values ('S000077','Jeans - Large0077','Small','P000039',1,'101.61','2019-02-21 17:59:23','1');
insert into sku_data values ('S000078','Jeans - Large0078','Medium','P000039',1,'100.78','2019-02-19 12:45:18','1');
insert into sku_data values ('S000079','Jeans - Large0079','Large','P000040',1,'80.45','2019-02-07 10:45:15','1');
insert into sku_data values ('S000080','Jeans - Large0080','Small','P000040',1,'80.14','2019-02-13 22:37:24','1');
insert into sku_data values ('S000081','Jeans - Large0081','Medium','P000041',1,'81.35','2019-02-07 11:30:44','1');
insert into sku_data values ('S000082','Jeans - Large0082','Large','P000041',1,'101.12','2019-02-17 08:09:42','1');
insert into sku_data values ('S000083','Jeans - Large0083','Small','P000042',1,'99.93','2019-02-16 12:33:27','1');
insert into sku_data values ('S000084','Jeans - Large0084','Medium','P000042',1,'93.13','2019-02-19 06:12:28','1');
insert into sku_data values ('S000085','Jeans - Large0085','Large','P000043',1,'87.05','2019-02-02 16:38:00','1');
insert into sku_data values ('S000086','Jeans - Large0086','Small','P000043',1,'93.04','2019-02-20 17:17:48','1');
insert into sku_data values ('S000087','Jeans - Large0087','Medium','P000044',1,'86.02','2019-02-09 13:46:22','1');
insert into sku_data values ('S000088','Jeans - Large0088','Large','P000044',1,'89.99','2019-02-11 01:58:08','1');
insert into sku_data values ('S000089','Jeans - Large0089','Small','P000045',1,'81.93','2019-02-09 16:49:23','1');
insert into sku_data values ('S000090','Jeans - Large0090','Medium','P000045',1,'102.12','2019-02-16 16:45:40','1');
insert into sku_data values ('S000091','Jeans - Large0091','Large','P000046',1,'75.69','2019-02-17 01:34:16','1');
insert into sku_data values ('S000092','Jeans - Large0092','Small','P000046',1,'79.18','2019-02-11 09:24:28','1');
insert into sku_data values ('S000093','Jeans - Large0093','Medium','P000047',1,'78.49','2019-02-15 01:12:02','1');
insert into sku_data values ('S000094','Jeans - Large0094','Large','P000047',1,'89.56','2019-02-12 23:03:43','1');
insert into sku_data values ('S000095','Jeans - Large0095','Small','P000048',1,'93.31','2019-02-11 04:08:38','1');
insert into sku_data values ('S000096','Jeans - Large0096','Medium','P000048',1,'97.34','2019-02-06 17:33:00','1');
insert into sku_data values ('S000097','Jeans - Large0097','Large','P000049',1,'97.90','2019-02-12 17:40:30','1');
insert into sku_data values ('S000098','Jeans - Large0098','Small','P000049',1,'78.36','2019-02-20 14:36:02','1');
insert into sku_data values ('S000099','Jeans - Large0099','Medium','P000050',1,'94.88','2019-02-08 10:45:48','1');
insert into sku_data values ('S000100','Jeans - Large0100','Large','P000050',1,'92.78','2019-02-10 15:14:36','1');
insert into sku_data values ('S000101','Jeans - Large0101','Small','P000051',1,'78.16','2019-02-01 11:38:14','1');
insert into sku_data values ('S000102','Jeans - Large0102','Medium','P000051',1,'95.66','2019-02-04 21:57:14','1');
insert into sku_data values ('S000103','Jeans - Large0103','Large','P000052',1,'85.18','2019-02-10 05:44:29','1');
insert into sku_data values ('S000104','Jeans - Large0104','Small','P000052',1,'76.63','2019-02-21 09:37:11','1');
insert into sku_data values ('S000105','Jeans - Large0105','Medium','P000053',1,'92.24','2019-02-18 19:08:31','1');
insert into sku_data values ('S000106','Jeans - Large0106','Large','P000053',1,'97.32','2019-02-16 00:02:17','1');
insert into sku_data values ('S000107','Jeans - Large0107','Small','P000054',1,'99.67','2019-02-10 12:55:16','1');
insert into sku_data values ('S000108','Jeans - Large0108','Medium','P000054',1,'100.18','2019-02-13 04:24:23','1');
insert into sku_data values ('S000109','Jeans - Large0109','Large','P000055',1,'84.22','2019-02-17 03:43:18','1');
insert into sku_data values ('S000110','Jeans - Large0110','Small','P000055',1,'94.50','2019-02-15 23:56:35','1');
insert into sku_data values ('S000111','Jeans - Large0111','Medium','P000056',1,'75.39','2019-02-21 17:56:47','1');
insert into sku_data values ('S000112','Jeans - Large0112','Large','P000056',1,'73.01','2019-02-16 06:47:04','1');
insert into sku_data values ('S000113','Jeans - Large0113','Small','P000057',1,'88.39','2019-02-06 10:10:22','1');
insert into sku_data values ('S000114','Jeans - Large0114','Medium','P000057',1,'75.43','2019-02-19 17:37:56','1');
insert into sku_data values ('S000115','Jeans - Large0115','Large','P000058',1,'92.47','2019-02-08 14:09:02','1');
insert into sku_data values ('S000116','Jeans - Large0116','Small','P000058',1,'79.43','2019-02-19 10:52:35','1');
insert into sku_data values ('S000117','Jeans - Large0117','Medium','P000059',1,'92.76','2019-02-16 00:03:12','1');
insert into sku_data values ('S000118','Jeans - Large0118','Large','P000059',1,'81.59','2019-02-10 19:17:51','1');
insert into sku_data values ('S000119','Jeans - Large0119','Small','P000060',1,'97.14','2019-02-20 02:06:01','1');
insert into sku_data values ('S000120','Jeans - Large0120','Medium','P000060',1,'77.85','2019-02-01 22:57:48','1');
insert into sku_data values ('S000121','Jeans - Large0121','Large','P000061',1,'94.10','2019-02-05 02:38:12','1');
insert into sku_data values ('S000122','Jeans - Large0122','Small','P000061',1,'77.87','2019-02-20 01:45:18','1');
insert into sku_data values ('S000123','Jeans - Large0123','Medium','P000062',1,'98.48','2019-02-04 17:02:26','1');
insert into sku_data values ('S000124','Jeans - Large0124','Large','P000062',1,'89.53','2019-02-14 08:06:48','1');
insert into sku_data values ('S000125','Jeans - Large0125','Small','P000063',1,'78.79','2019-02-08 09:39:23','1');
insert into sku_data values ('S000126','Jeans - Large0126','Medium','P000063',1,'84.23','2019-02-14 15:16:53','1');
insert into sku_data values ('S000127','Jeans - Large0127','Large','P000064',1,'89.40','2019-02-03 17:52:39','1');
insert into sku_data values ('S000128','Jeans - Large0128','Small','P000064',1,'86.41','2019-02-13 09:18:58','1');

	
insert into profile_data values ('P000001','Philip Zhang','P000001','1');
insert into profile_data values ('P000002','Naveen Kumar R ','P000001','1');
insert into profile_data values ('P000003','VENKATESH GADUPUTI','P000001','1');

	
insert into brand_filter_data values ('BF000001','Philip Zhang','brandid','P000001','1');
insert into brand_filter_data values ('BF000002','Naveen Kumar R ','brandid0002','P000001','1');
insert into brand_filter_data values ('BF000003','VENKATESH GADUPUTI','brandid0003','P000002','1');
insert into brand_filter_data values ('BF000004','Philip Zhang','brandid0004','P000003','1');

	
insert into price_filter_data values ('PF000001','Philip Zhang','1.72','719192.45','P000001','1');
insert into price_filter_data values ('PF000002','Naveen Kumar R ','1.93','774166.97','P000001','1');
insert into price_filter_data values ('PF000003','VENKATESH GADUPUTI','1.55','709858.01','P000002','1');
insert into price_filter_data values ('PF000004','Philip Zhang','1.56','785385.65','P000003','1');

	
insert into category_filter_data values ('CF000001','Philip Zhang','category','P000001','1');
insert into category_filter_data values ('CF000002','Naveen Kumar R ','category0002','P000001','1');
insert into category_filter_data values ('CF000003','VENKATESH GADUPUTI','category0003','P000002','1');
insert into category_filter_data values ('CF000004','Philip Zhang','category0004','P000003','1');

	
insert into new_product_data values ('NP000001','Jeans','LNC000001','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','China','C000001','P000001','The brand a great that has Roadester, Model S and Model X, Model 3 is in development','2019-02-05 22:52:23','P000001','1');
insert into new_product_data values ('NP000002','Jeans0002','LNC000001','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','US','C000001','P000001','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0002','2019-02-09 19:48:05','P000001','1');
insert into new_product_data values ('NP000003','Jeans0003','LNC000002','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','Japan','C000001','P000001','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0003','2019-02-11 03:22:19','P000001','1');
insert into new_product_data values ('NP000004','Jeans0004','LNC000002','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','French','C000001','P000001','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0004','2019-02-04 23:43:03','P000001','1');
insert into new_product_data values ('NP000005','Jeans0005','LNC000003','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','China','C000001','P000001','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0005','2019-02-03 16:12:59','P000001','1');
insert into new_product_data values ('NP000006','Jeans0006','LNC000003','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','US','C000001','P000001','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0006','2019-02-17 23:34:13','P000001','1');
insert into new_product_data values ('NP000007','Jeans0007','LNC000004','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','Japan','C000001','P000001','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0007','2019-02-20 19:53:43','P000001','1');
insert into new_product_data values ('NP000008','Jeans0008','LNC000004','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','French','C000001','P000001','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0008','2019-02-05 23:07:58','P000001','1');
insert into new_product_data values ('NP000009','Jeans0009','LNC000005','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','China','C000001','P000001','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0009','2019-02-07 02:00:07','P000001','1');
insert into new_product_data values ('NP000010','Jeans0010','LNC000005','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','US','C000001','P000001','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0010','2019-01-31 23:08:23','P000001','1');
insert into new_product_data values ('NP000011','Jeans0011','LNC000006','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','Japan','C000001','P000001','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0011','2019-02-09 20:07:16','P000001','1');
insert into new_product_data values ('NP000012','Jeans0012','LNC000006','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','French','C000001','P000001','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0012','2019-02-20 01:41:17','P000001','1');
insert into new_product_data values ('NP000013','Jeans0013','LNC000007','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','China','C000001','P000001','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0013','2019-02-04 05:57:34','P000001','1');
insert into new_product_data values ('NP000014','Jeans0014','LNC000007','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','US','C000001','P000001','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0014','2019-02-05 13:09:26','P000001','1');
insert into new_product_data values ('NP000015','Jeans0015','LNC000008','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','Japan','C000001','P000001','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0015','2019-02-16 23:15:52','P000001','1');
insert into new_product_data values ('NP000016','Jeans0016','LNC000008','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','French','C000001','P000001','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0016','2019-02-09 09:03:04','P000001','1');
insert into new_product_data values ('NP000017','Jeans0017','LNC000009','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','China','C000002','P000001','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0017','2019-02-20 10:23:02','P000001','1');
insert into new_product_data values ('NP000018','Jeans0018','LNC000009','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','US','C000002','P000001','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0018','2019-02-10 10:50:25','P000001','1');
insert into new_product_data values ('NP000019','Jeans0019','LNC000010','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','Japan','C000002','P000001','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0019','2019-02-21 01:09:20','P000001','1');
insert into new_product_data values ('NP000020','Jeans0020','LNC000010','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','French','C000002','P000001','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0020','2019-02-06 00:36:53','P000001','1');
insert into new_product_data values ('NP000021','Jeans0021','LNC000011','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','China','C000002','P000001','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0021','2019-02-01 17:40:27','P000001','1');
insert into new_product_data values ('NP000022','Jeans0022','LNC000011','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','US','C000002','P000001','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0022','2019-02-15 01:29:36','P000001','1');
insert into new_product_data values ('NP000023','Jeans0023','LNC000012','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','Japan','C000002','P000002','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0023','2019-02-05 07:22:58','P000001','1');
insert into new_product_data values ('NP000024','Jeans0024','LNC000012','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','French','C000002','P000002','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0024','2019-02-12 00:29:32','P000001','1');
insert into new_product_data values ('NP000025','Jeans0025','LNC000013','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','China','C000002','P000002','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0025','2019-02-14 14:20:09','P000001','1');
insert into new_product_data values ('NP000026','Jeans0026','LNC000013','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','US','C000002','P000002','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0026','2019-02-17 17:09:52','P000001','1');
insert into new_product_data values ('NP000027','Jeans0027','LNC000014','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','Japan','C000002','P000002','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0027','2019-02-01 13:41:16','P000001','1');
insert into new_product_data values ('NP000028','Jeans0028','LNC000014','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','French','C000002','P000002','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0028','2019-02-11 13:09:33','P000001','1');
insert into new_product_data values ('NP000029','Jeans0029','LNC000015','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','China','C000002','P000002','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0029','2019-02-15 00:41:12','P000001','1');
insert into new_product_data values ('NP000030','Jeans0030','LNC000015','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','US','C000002','P000002','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0030','2019-02-06 17:39:36','P000001','1');
insert into new_product_data values ('NP000031','Jeans0031','LNC000016','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','Japan','C000002','P000002','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0031','2019-02-10 23:18:57','P000001','1');
insert into new_product_data values ('NP000032','Jeans0032','LNC000016','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','French','C000002','P000002','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0032','2019-02-09 05:56:03','P000001','1');
insert into new_product_data values ('NP000033','Jeans0033','LNC000017','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','China','C000003','P000002','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0033','2019-02-12 17:45:38','P000001','1');
insert into new_product_data values ('NP000034','Jeans0034','LNC000017','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','US','C000003','P000002','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0034','2019-02-20 12:03:31','P000001','1');
insert into new_product_data values ('NP000035','Jeans0035','LNC000018','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','Japan','C000003','P000002','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0035','2019-02-14 10:02:35','P000001','1');
insert into new_product_data values ('NP000036','Jeans0036','LNC000018','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','French','C000003','P000002','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0036','2019-02-02 19:51:49','P000001','1');
insert into new_product_data values ('NP000037','Jeans0037','LNC000019','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','China','C000003','P000002','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0037','2019-02-18 17:17:44','P000001','1');
insert into new_product_data values ('NP000038','Jeans0038','LNC000019','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','US','C000003','P000002','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0038','2019-01-31 23:17:59','P000001','1');
insert into new_product_data values ('NP000039','Jeans0039','LNC000020','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','Japan','C000003','P000002','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0039','2019-02-14 13:33:25','P000001','1');
insert into new_product_data values ('NP000040','Jeans0040','LNC000020','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','French','C000003','P000002','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0040','2019-02-21 07:29:06','P000001','1');
insert into new_product_data values ('NP000041','Jeans0041','LNC000021','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','China','C000003','P000002','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0041','2019-02-20 06:23:34','P000001','1');
insert into new_product_data values ('NP000042','Jeans0042','LNC000021','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','US','C000003','P000002','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0042','2019-02-13 19:59:49','P000001','1');
insert into new_product_data values ('NP000043','Jeans0043','LNC000022','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','Japan','C000003','P000002','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0043','2019-02-02 01:55:39','P000001','1');
insert into new_product_data values ('NP000044','Jeans0044','LNC000022','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','French','C000003','P000003','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0044','2019-02-22 12:46:08','P000001','1');
insert into new_product_data values ('NP000045','Jeans0045','LNC000023','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','China','C000003','P000003','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0045','2019-02-02 05:04:58','P000001','1');
insert into new_product_data values ('NP000046','Jeans0046','LNC000023','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','US','C000003','P000003','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0046','2019-02-21 08:42:43','P000001','1');
insert into new_product_data values ('NP000047','Jeans0047','LNC000024','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','Japan','C000003','P000003','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0047','2019-02-21 22:07:17','P000001','1');
insert into new_product_data values ('NP000048','Jeans0048','LNC000024','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','French','C000003','P000003','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0048','2019-02-12 16:29:41','P000001','1');
insert into new_product_data values ('NP000049','Jeans0049','LNC000025','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','China','C000004','P000003','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0049','2019-02-19 08:58:40','P000001','1');
insert into new_product_data values ('NP000050','Jeans0050','LNC000025','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','US','C000004','P000003','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0050','2019-02-05 02:56:30','P000001','1');
insert into new_product_data values ('NP000051','Jeans0051','LNC000026','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','Japan','C000004','P000003','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0051','2019-02-13 06:12:49','P000001','1');
insert into new_product_data values ('NP000052','Jeans0052','LNC000026','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','French','C000004','P000003','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0052','2019-02-14 19:47:41','P000001','1');
insert into new_product_data values ('NP000053','Jeans0053','LNC000027','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','China','C000004','P000003','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0053','2019-02-19 05:41:30','P000001','1');
insert into new_product_data values ('NP000054','Jeans0054','LNC000027','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','US','C000004','P000003','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0054','2019-02-19 16:24:53','P000001','1');
insert into new_product_data values ('NP000055','Jeans0055','LNC000028','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','Japan','C000004','P000003','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0055','2019-02-21 13:49:02','P000001','1');
insert into new_product_data values ('NP000056','Jeans0056','LNC000028','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','French','C000004','P000003','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0056','2019-02-12 11:12:05','P000001','1');
insert into new_product_data values ('NP000057','Jeans0057','LNC000029','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','China','C000004','P000003','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0057','2019-02-04 21:30:10','P000001','1');
insert into new_product_data values ('NP000058','Jeans0058','LNC000029','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','US','C000004','P000003','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0058','2019-02-07 17:33:44','P000001','1');
insert into new_product_data values ('NP000059','Jeans0059','LNC000030','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','Japan','C000004','P000003','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0059','2019-02-10 06:12:42','P000001','1');
insert into new_product_data values ('NP000060','Jeans0060','LNC000030','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','French','C000004','P000003','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0060','2019-02-21 01:28:12','P000001','1');
insert into new_product_data values ('NP000061','Jeans0061','LNC000031','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','China','C000004','P000003','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0061','2019-02-18 20:17:13','P000001','1');
insert into new_product_data values ('NP000062','Jeans0062','LNC000031','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','US','C000004','P000003','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0062','2019-02-01 14:00:30','P000001','1');
insert into new_product_data values ('NP000063','Jeans0063','LNC000032','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','Japan','C000004','P000003','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0063','2019-02-21 23:57:24','P000001','1');
insert into new_product_data values ('NP000064','Jeans0064','LNC000032','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','French','C000004','P000003','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0064','2019-02-15 09:17:34','P000001','1');

	
insert into editor_pick_product_data values ('EPP000001','Jeans','LNC000001','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','China','C000001','P000001','The brand a great that has Roadester, Model S and Model X, Model 3 is in development','2019-02-19 10:23:27','P000001','1');
insert into editor_pick_product_data values ('EPP000002','Jeans0002','LNC000001','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','US','C000001','P000001','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0002','2019-02-04 11:27:27','P000001','1');
insert into editor_pick_product_data values ('EPP000003','Jeans0003','LNC000002','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','Japan','C000001','P000001','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0003','2019-02-10 06:11:31','P000001','1');
insert into editor_pick_product_data values ('EPP000004','Jeans0004','LNC000002','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','French','C000001','P000001','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0004','2019-02-10 21:24:17','P000001','1');
insert into editor_pick_product_data values ('EPP000005','Jeans0005','LNC000003','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','China','C000001','P000001','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0005','2019-02-20 19:18:53','P000001','1');
insert into editor_pick_product_data values ('EPP000006','Jeans0006','LNC000003','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','US','C000001','P000001','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0006','2019-02-07 19:59:11','P000001','1');
insert into editor_pick_product_data values ('EPP000007','Jeans0007','LNC000004','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','Japan','C000001','P000001','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0007','2019-02-15 17:34:50','P000001','1');
insert into editor_pick_product_data values ('EPP000008','Jeans0008','LNC000004','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','French','C000001','P000001','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0008','2019-02-14 23:41:11','P000001','1');
insert into editor_pick_product_data values ('EPP000009','Jeans0009','LNC000005','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','China','C000001','P000001','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0009','2019-02-19 20:22:41','P000001','1');
insert into editor_pick_product_data values ('EPP000010','Jeans0010','LNC000005','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','US','C000001','P000001','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0010','2019-02-09 12:06:55','P000001','1');
insert into editor_pick_product_data values ('EPP000011','Jeans0011','LNC000006','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','Japan','C000001','P000001','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0011','2019-02-05 04:19:19','P000001','1');
insert into editor_pick_product_data values ('EPP000012','Jeans0012','LNC000006','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','French','C000001','P000001','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0012','2019-02-20 13:41:40','P000001','1');
insert into editor_pick_product_data values ('EPP000013','Jeans0013','LNC000007','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','China','C000001','P000001','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0013','2019-02-21 07:10:28','P000001','1');
insert into editor_pick_product_data values ('EPP000014','Jeans0014','LNC000007','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','US','C000001','P000001','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0014','2019-02-05 14:20:00','P000001','1');
insert into editor_pick_product_data values ('EPP000015','Jeans0015','LNC000008','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','Japan','C000001','P000001','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0015','2019-02-07 17:27:09','P000001','1');
insert into editor_pick_product_data values ('EPP000016','Jeans0016','LNC000008','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','French','C000001','P000001','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0016','2019-02-22 04:24:25','P000001','1');
insert into editor_pick_product_data values ('EPP000017','Jeans0017','LNC000009','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','China','C000002','P000001','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0017','2019-02-03 23:23:13','P000001','1');
insert into editor_pick_product_data values ('EPP000018','Jeans0018','LNC000009','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','US','C000002','P000001','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0018','2019-02-12 00:09:23','P000001','1');
insert into editor_pick_product_data values ('EPP000019','Jeans0019','LNC000010','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','Japan','C000002','P000001','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0019','2019-02-08 06:11:17','P000001','1');
insert into editor_pick_product_data values ('EPP000020','Jeans0020','LNC000010','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','French','C000002','P000001','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0020','2019-02-05 13:02:51','P000001','1');
insert into editor_pick_product_data values ('EPP000021','Jeans0021','LNC000011','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','China','C000002','P000001','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0021','2019-02-05 17:49:14','P000001','1');
insert into editor_pick_product_data values ('EPP000022','Jeans0022','LNC000011','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','US','C000002','P000001','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0022','2019-02-12 12:20:53','P000001','1');
insert into editor_pick_product_data values ('EPP000023','Jeans0023','LNC000012','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','Japan','C000002','P000002','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0023','2019-02-09 17:53:42','P000001','1');
insert into editor_pick_product_data values ('EPP000024','Jeans0024','LNC000012','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','French','C000002','P000002','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0024','2019-02-15 15:15:34','P000001','1');
insert into editor_pick_product_data values ('EPP000025','Jeans0025','LNC000013','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','China','C000002','P000002','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0025','2019-02-21 12:54:38','P000001','1');
insert into editor_pick_product_data values ('EPP000026','Jeans0026','LNC000013','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','US','C000002','P000002','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0026','2019-02-06 20:11:53','P000001','1');
insert into editor_pick_product_data values ('EPP000027','Jeans0027','LNC000014','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','Japan','C000002','P000002','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0027','2019-02-11 10:51:42','P000001','1');
insert into editor_pick_product_data values ('EPP000028','Jeans0028','LNC000014','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','French','C000002','P000002','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0028','2019-02-02 11:13:32','P000001','1');
insert into editor_pick_product_data values ('EPP000029','Jeans0029','LNC000015','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','China','C000002','P000002','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0029','2019-02-13 00:42:44','P000001','1');
insert into editor_pick_product_data values ('EPP000030','Jeans0030','LNC000015','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','US','C000002','P000002','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0030','2019-02-15 07:32:04','P000001','1');
insert into editor_pick_product_data values ('EPP000031','Jeans0031','LNC000016','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','Japan','C000002','P000002','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0031','2019-02-17 16:55:49','P000001','1');
insert into editor_pick_product_data values ('EPP000032','Jeans0032','LNC000016','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','French','C000002','P000002','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0032','2019-02-16 14:59:12','P000001','1');
insert into editor_pick_product_data values ('EPP000033','Jeans0033','LNC000017','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','China','C000003','P000002','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0033','2019-02-05 10:13:40','P000001','1');
insert into editor_pick_product_data values ('EPP000034','Jeans0034','LNC000017','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','US','C000003','P000002','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0034','2019-02-15 23:40:58','P000001','1');
insert into editor_pick_product_data values ('EPP000035','Jeans0035','LNC000018','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','Japan','C000003','P000002','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0035','2019-02-15 16:04:49','P000001','1');
insert into editor_pick_product_data values ('EPP000036','Jeans0036','LNC000018','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','French','C000003','P000002','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0036','2019-02-18 16:23:22','P000001','1');
insert into editor_pick_product_data values ('EPP000037','Jeans0037','LNC000019','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','China','C000003','P000002','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0037','2019-02-03 21:31:09','P000001','1');
insert into editor_pick_product_data values ('EPP000038','Jeans0038','LNC000019','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','US','C000003','P000002','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0038','2019-02-16 16:48:04','P000001','1');
insert into editor_pick_product_data values ('EPP000039','Jeans0039','LNC000020','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','Japan','C000003','P000002','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0039','2019-02-16 04:11:33','P000001','1');
insert into editor_pick_product_data values ('EPP000040','Jeans0040','LNC000020','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','French','C000003','P000002','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0040','2019-02-04 20:47:57','P000001','1');
insert into editor_pick_product_data values ('EPP000041','Jeans0041','LNC000021','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','China','C000003','P000002','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0041','2019-02-21 20:09:30','P000001','1');
insert into editor_pick_product_data values ('EPP000042','Jeans0042','LNC000021','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','US','C000003','P000002','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0042','2019-02-10 05:24:35','P000001','1');
insert into editor_pick_product_data values ('EPP000043','Jeans0043','LNC000022','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','Japan','C000003','P000002','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0043','2019-02-16 11:42:26','P000001','1');
insert into editor_pick_product_data values ('EPP000044','Jeans0044','LNC000022','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','French','C000003','P000003','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0044','2019-02-14 08:08:17','P000001','1');
insert into editor_pick_product_data values ('EPP000045','Jeans0045','LNC000023','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','China','C000003','P000003','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0045','2019-02-14 06:12:28','P000001','1');
insert into editor_pick_product_data values ('EPP000046','Jeans0046','LNC000023','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','US','C000003','P000003','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0046','2019-02-02 04:36:33','P000001','1');
insert into editor_pick_product_data values ('EPP000047','Jeans0047','LNC000024','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','Japan','C000003','P000003','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0047','2019-02-15 22:16:32','P000001','1');
insert into editor_pick_product_data values ('EPP000048','Jeans0048','LNC000024','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','French','C000003','P000003','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0048','2019-02-10 08:22:18','P000001','1');
insert into editor_pick_product_data values ('EPP000049','Jeans0049','LNC000025','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','China','C000004','P000003','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0049','2019-02-10 09:28:52','P000001','1');
insert into editor_pick_product_data values ('EPP000050','Jeans0050','LNC000025','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','US','C000004','P000003','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0050','2019-02-18 06:06:27','P000001','1');
insert into editor_pick_product_data values ('EPP000051','Jeans0051','LNC000026','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','Japan','C000004','P000003','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0051','2019-02-08 18:50:07','P000001','1');
insert into editor_pick_product_data values ('EPP000052','Jeans0052','LNC000026','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','French','C000004','P000003','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0052','2019-02-19 08:26:01','P000001','1');
insert into editor_pick_product_data values ('EPP000053','Jeans0053','LNC000027','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','China','C000004','P000003','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0053','2019-02-06 18:07:05','P000001','1');
insert into editor_pick_product_data values ('EPP000054','Jeans0054','LNC000027','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','US','C000004','P000003','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0054','2019-02-18 06:54:34','P000001','1');
insert into editor_pick_product_data values ('EPP000055','Jeans0055','LNC000028','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','Japan','C000004','P000003','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0055','2019-02-04 12:59:04','P000001','1');
insert into editor_pick_product_data values ('EPP000056','Jeans0056','LNC000028','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','French','C000004','P000003','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0056','2019-02-20 22:35:42','P000001','1');
insert into editor_pick_product_data values ('EPP000057','Jeans0057','LNC000029','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','China','C000004','P000003','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0057','2019-02-17 21:19:25','P000001','1');
insert into editor_pick_product_data values ('EPP000058','Jeans0058','LNC000029','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','US','C000004','P000003','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0058','2019-02-15 01:35:46','P000001','1');
insert into editor_pick_product_data values ('EPP000059','Jeans0059','LNC000030','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','Japan','C000004','P000003','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0059','2019-02-13 10:30:03','P000001','1');
insert into editor_pick_product_data values ('EPP000060','Jeans0060','LNC000030','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','French','C000004','P000003','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0060','2019-02-16 17:36:11','P000001','1');
insert into editor_pick_product_data values ('EPP000061','Jeans0061','LNC000031','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','China','C000004','P000003','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0061','2019-02-21 19:26:49','P000001','1');
insert into editor_pick_product_data values ('EPP000062','Jeans0062','LNC000031','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','US','C000004','P000003','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0062','2019-02-11 07:06:33','P000001','1');
insert into editor_pick_product_data values ('EPP000063','Jeans0063','LNC000032','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','Japan','C000004','P000003','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0063','2019-02-02 01:45:11','P000001','1');
insert into editor_pick_product_data values ('EPP000064','Jeans0064','LNC000032','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','French','C000004','P000003','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0064','2019-02-08 00:46:28','P000001','1');

	
insert into top_rated_product_data values ('TRP000001','Jeans','LNC000001','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','China','C000001','The brand a great that has Roadester, Model S and Model X, Model 3 is in development','2019-02-07 17:26:41','P000001','P000001','1');
insert into top_rated_product_data values ('TRP000002','Jeans0002','LNC000001','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','US','C000001','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0002','2019-02-19 03:16:13','P000001','P000001','1');
insert into top_rated_product_data values ('TRP000003','Jeans0003','LNC000002','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','Japan','C000001','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0003','2019-02-03 07:46:21','P000001','P000001','1');
insert into top_rated_product_data values ('TRP000004','Jeans0004','LNC000002','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','French','C000001','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0004','2019-02-17 17:36:21','P000001','P000001','1');
insert into top_rated_product_data values ('TRP000005','Jeans0005','LNC000003','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','China','C000001','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0005','2019-02-08 14:21:23','P000001','P000001','1');
insert into top_rated_product_data values ('TRP000006','Jeans0006','LNC000003','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','US','C000001','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0006','2019-02-01 10:54:39','P000001','P000001','1');
insert into top_rated_product_data values ('TRP000007','Jeans0007','LNC000004','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','Japan','C000001','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0007','2019-02-03 06:29:49','P000001','P000001','1');
insert into top_rated_product_data values ('TRP000008','Jeans0008','LNC000004','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','French','C000001','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0008','2019-02-05 14:09:52','P000001','P000001','1');
insert into top_rated_product_data values ('TRP000009','Jeans0009','LNC000005','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','China','C000001','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0009','2019-02-18 18:55:19','P000001','P000001','1');
insert into top_rated_product_data values ('TRP000010','Jeans0010','LNC000005','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','US','C000001','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0010','2019-02-01 05:15:03','P000001','P000001','1');
insert into top_rated_product_data values ('TRP000011','Jeans0011','LNC000006','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','Japan','C000001','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0011','2019-02-05 13:10:58','P000001','P000001','1');
insert into top_rated_product_data values ('TRP000012','Jeans0012','LNC000006','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','French','C000001','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0012','2019-02-15 01:45:31','P000001','P000001','1');
insert into top_rated_product_data values ('TRP000013','Jeans0013','LNC000007','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','China','C000001','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0013','2019-02-13 20:43:16','P000001','P000001','1');
insert into top_rated_product_data values ('TRP000014','Jeans0014','LNC000007','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','US','C000001','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0014','2019-02-11 17:27:35','P000001','P000001','1');
insert into top_rated_product_data values ('TRP000015','Jeans0015','LNC000008','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','Japan','C000001','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0015','2019-02-09 06:57:46','P000001','P000001','1');
insert into top_rated_product_data values ('TRP000016','Jeans0016','LNC000008','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','French','C000001','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0016','2019-02-08 08:19:53','P000001','P000001','1');
insert into top_rated_product_data values ('TRP000017','Jeans0017','LNC000009','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','China','C000002','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0017','2019-02-07 13:33:37','P000001','P000001','1');
insert into top_rated_product_data values ('TRP000018','Jeans0018','LNC000009','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','US','C000002','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0018','2019-02-01 10:32:33','P000001','P000001','1');
insert into top_rated_product_data values ('TRP000019','Jeans0019','LNC000010','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','Japan','C000002','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0019','2019-02-05 06:51:55','P000001','P000001','1');
insert into top_rated_product_data values ('TRP000020','Jeans0020','LNC000010','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','French','C000002','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0020','2019-02-09 18:18:32','P000001','P000001','1');
insert into top_rated_product_data values ('TRP000021','Jeans0021','LNC000011','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','China','C000002','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0021','2019-02-10 10:31:40','P000001','P000001','1');
insert into top_rated_product_data values ('TRP000022','Jeans0022','LNC000011','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','US','C000002','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0022','2019-02-08 08:26:45','P000001','P000001','1');
insert into top_rated_product_data values ('TRP000023','Jeans0023','LNC000012','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','Japan','C000002','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0023','2019-02-07 00:26:46','P000002','P000001','1');
insert into top_rated_product_data values ('TRP000024','Jeans0024','LNC000012','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','French','C000002','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0024','2019-02-07 18:14:04','P000002','P000001','1');
insert into top_rated_product_data values ('TRP000025','Jeans0025','LNC000013','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','China','C000002','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0025','2019-02-05 00:08:26','P000002','P000001','1');
insert into top_rated_product_data values ('TRP000026','Jeans0026','LNC000013','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','US','C000002','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0026','2019-02-02 17:32:09','P000002','P000001','1');
insert into top_rated_product_data values ('TRP000027','Jeans0027','LNC000014','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','Japan','C000002','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0027','2019-02-04 18:57:56','P000002','P000001','1');
insert into top_rated_product_data values ('TRP000028','Jeans0028','LNC000014','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','French','C000002','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0028','2019-02-05 20:14:45','P000002','P000001','1');
insert into top_rated_product_data values ('TRP000029','Jeans0029','LNC000015','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','China','C000002','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0029','2019-02-10 13:32:54','P000002','P000001','1');
insert into top_rated_product_data values ('TRP000030','Jeans0030','LNC000015','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','US','C000002','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0030','2019-02-06 04:11:44','P000002','P000001','1');
insert into top_rated_product_data values ('TRP000031','Jeans0031','LNC000016','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','Japan','C000002','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0031','2019-02-22 08:20:08','P000002','P000001','1');
insert into top_rated_product_data values ('TRP000032','Jeans0032','LNC000016','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','French','C000002','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0032','2019-02-08 02:06:57','P000002','P000001','1');
insert into top_rated_product_data values ('TRP000033','Jeans0033','LNC000017','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','China','C000003','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0033','2019-02-20 11:01:01','P000002','P000001','1');
insert into top_rated_product_data values ('TRP000034','Jeans0034','LNC000017','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','US','C000003','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0034','2019-02-12 01:12:10','P000002','P000001','1');
insert into top_rated_product_data values ('TRP000035','Jeans0035','LNC000018','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','Japan','C000003','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0035','2019-02-05 08:05:15','P000002','P000001','1');
insert into top_rated_product_data values ('TRP000036','Jeans0036','LNC000018','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','French','C000003','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0036','2019-02-04 06:44:30','P000002','P000001','1');
insert into top_rated_product_data values ('TRP000037','Jeans0037','LNC000019','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','China','C000003','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0037','2019-02-19 14:17:44','P000002','P000001','1');
insert into top_rated_product_data values ('TRP000038','Jeans0038','LNC000019','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','US','C000003','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0038','2019-02-15 11:59:57','P000002','P000001','1');
insert into top_rated_product_data values ('TRP000039','Jeans0039','LNC000020','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','Japan','C000003','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0039','2019-02-06 22:09:21','P000002','P000001','1');
insert into top_rated_product_data values ('TRP000040','Jeans0040','LNC000020','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','French','C000003','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0040','2019-02-01 19:17:22','P000002','P000001','1');
insert into top_rated_product_data values ('TRP000041','Jeans0041','LNC000021','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','China','C000003','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0041','2019-02-06 13:59:17','P000002','P000001','1');
insert into top_rated_product_data values ('TRP000042','Jeans0042','LNC000021','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','US','C000003','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0042','2019-02-17 21:06:50','P000002','P000001','1');
insert into top_rated_product_data values ('TRP000043','Jeans0043','LNC000022','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','Japan','C000003','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0043','2019-02-13 18:56:52','P000002','P000001','1');
insert into top_rated_product_data values ('TRP000044','Jeans0044','LNC000022','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','French','C000003','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0044','2019-02-10 19:24:40','P000003','P000001','1');
insert into top_rated_product_data values ('TRP000045','Jeans0045','LNC000023','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','China','C000003','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0045','2019-02-04 08:28:56','P000003','P000001','1');
insert into top_rated_product_data values ('TRP000046','Jeans0046','LNC000023','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','US','C000003','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0046','2019-02-16 08:06:36','P000003','P000001','1');
insert into top_rated_product_data values ('TRP000047','Jeans0047','LNC000024','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','Japan','C000003','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0047','2019-02-02 06:46:13','P000003','P000001','1');
insert into top_rated_product_data values ('TRP000048','Jeans0048','LNC000024','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','French','C000003','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0048','2019-02-20 09:55:14','P000003','P000001','1');
insert into top_rated_product_data values ('TRP000049','Jeans0049','LNC000025','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','China','C000004','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0049','2019-02-07 11:20:49','P000003','P000001','1');
insert into top_rated_product_data values ('TRP000050','Jeans0050','LNC000025','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','US','C000004','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0050','2019-02-01 16:37:47','P000003','P000001','1');
insert into top_rated_product_data values ('TRP000051','Jeans0051','LNC000026','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','Japan','C000004','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0051','2019-02-05 18:59:44','P000003','P000001','1');
insert into top_rated_product_data values ('TRP000052','Jeans0052','LNC000026','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','French','C000004','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0052','2019-02-12 07:11:01','P000003','P000001','1');
insert into top_rated_product_data values ('TRP000053','Jeans0053','LNC000027','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','China','C000004','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0053','2019-02-12 01:23:50','P000003','P000001','1');
insert into top_rated_product_data values ('TRP000054','Jeans0054','LNC000027','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','US','C000004','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0054','2019-02-20 00:39:33','P000003','P000001','1');
insert into top_rated_product_data values ('TRP000055','Jeans0055','LNC000028','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','Japan','C000004','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0055','2019-02-01 10:36:47','P000003','P000001','1');
insert into top_rated_product_data values ('TRP000056','Jeans0056','LNC000028','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','French','C000004','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0056','2019-02-09 23:05:09','P000003','P000001','1');
insert into top_rated_product_data values ('TRP000057','Jeans0057','LNC000029','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','China','C000004','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0057','2019-02-04 12:38:08','P000003','P000001','1');
insert into top_rated_product_data values ('TRP000058','Jeans0058','LNC000029','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','US','C000004','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0058','2019-02-11 08:11:58','P000003','P000001','1');
insert into top_rated_product_data values ('TRP000059','Jeans0059','LNC000030','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','Japan','C000004','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0059','2019-02-02 01:10:10','P000003','P000001','1');
insert into top_rated_product_data values ('TRP000060','Jeans0060','LNC000030','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','French','C000004','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0060','2019-02-13 02:34:24','P000003','P000001','1');
insert into top_rated_product_data values ('TRP000061','Jeans0061','LNC000031','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','China','C000004','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0061','2019-02-11 20:24:45','P000003','P000001','1');
insert into top_rated_product_data values ('TRP000062','Jeans0062','LNC000031','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','US','C000004','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0062','2019-02-20 20:55:25','P000003','P000001','1');
insert into top_rated_product_data values ('TRP000063','Jeans0063','LNC000032','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','Japan','C000004','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0063','2019-02-06 14:36:40','P000003','P000001','1');
insert into top_rated_product_data values ('TRP000064','Jeans0064','LNC000032','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','French','C000004','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0064','2019-02-08 15:36:16','P000003','P000001','1');

	
insert into recommand_product_data values ('RP000001','Jeans','LNC000001','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','China','C000001','The brand a great that has Roadester, Model S and Model X, Model 3 is in development','2019-02-09 08:12:40','P000001','P000001','1');
insert into recommand_product_data values ('RP000002','Jeans0002','LNC000001','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','US','C000001','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0002','2019-02-03 04:42:34','P000001','P000001','1');
insert into recommand_product_data values ('RP000003','Jeans0003','LNC000002','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','Japan','C000001','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0003','2019-02-03 12:57:17','P000001','P000001','1');
insert into recommand_product_data values ('RP000004','Jeans0004','LNC000002','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','French','C000001','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0004','2019-02-09 07:32:41','P000001','P000001','1');
insert into recommand_product_data values ('RP000005','Jeans0005','LNC000003','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','China','C000001','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0005','2019-02-21 21:14:29','P000001','P000001','1');
insert into recommand_product_data values ('RP000006','Jeans0006','LNC000003','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','US','C000001','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0006','2019-02-18 04:59:29','P000001','P000001','1');
insert into recommand_product_data values ('RP000007','Jeans0007','LNC000004','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','Japan','C000001','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0007','2019-02-20 14:52:03','P000001','P000001','1');
insert into recommand_product_data values ('RP000008','Jeans0008','LNC000004','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','French','C000001','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0008','2019-02-14 11:31:51','P000001','P000001','1');
insert into recommand_product_data values ('RP000009','Jeans0009','LNC000005','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','China','C000001','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0009','2019-02-16 17:20:48','P000001','P000001','1');
insert into recommand_product_data values ('RP000010','Jeans0010','LNC000005','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','US','C000001','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0010','2019-02-19 10:37:28','P000001','P000001','1');
insert into recommand_product_data values ('RP000011','Jeans0011','LNC000006','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','Japan','C000001','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0011','2019-02-18 18:30:23','P000001','P000001','1');
insert into recommand_product_data values ('RP000012','Jeans0012','LNC000006','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','French','C000001','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0012','2019-02-03 06:33:25','P000001','P000001','1');
insert into recommand_product_data values ('RP000013','Jeans0013','LNC000007','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','China','C000001','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0013','2019-02-17 08:33:24','P000001','P000001','1');
insert into recommand_product_data values ('RP000014','Jeans0014','LNC000007','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','US','C000001','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0014','2019-02-10 02:27:47','P000001','P000001','1');
insert into recommand_product_data values ('RP000015','Jeans0015','LNC000008','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','Japan','C000001','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0015','2019-02-21 19:57:58','P000001','P000001','1');
insert into recommand_product_data values ('RP000016','Jeans0016','LNC000008','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','French','C000001','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0016','2019-02-09 10:00:08','P000001','P000001','1');
insert into recommand_product_data values ('RP000017','Jeans0017','LNC000009','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','China','C000002','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0017','2019-02-05 17:34:32','P000001','P000001','1');
insert into recommand_product_data values ('RP000018','Jeans0018','LNC000009','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','US','C000002','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0018','2019-02-02 05:15:30','P000001','P000001','1');
insert into recommand_product_data values ('RP000019','Jeans0019','LNC000010','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','Japan','C000002','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0019','2019-02-05 13:36:16','P000001','P000001','1');
insert into recommand_product_data values ('RP000020','Jeans0020','LNC000010','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','French','C000002','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0020','2019-02-13 00:34:59','P000001','P000001','1');
insert into recommand_product_data values ('RP000021','Jeans0021','LNC000011','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','China','C000002','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0021','2019-02-18 04:35:35','P000001','P000001','1');
insert into recommand_product_data values ('RP000022','Jeans0022','LNC000011','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','US','C000002','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0022','2019-02-18 15:25:43','P000001','P000001','1');
insert into recommand_product_data values ('RP000023','Jeans0023','LNC000012','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','Japan','C000002','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0023','2019-02-21 10:22:07','P000002','P000001','1');
insert into recommand_product_data values ('RP000024','Jeans0024','LNC000012','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','French','C000002','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0024','2019-02-20 17:19:36','P000002','P000001','1');
insert into recommand_product_data values ('RP000025','Jeans0025','LNC000013','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','China','C000002','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0025','2019-02-07 00:36:01','P000002','P000001','1');
insert into recommand_product_data values ('RP000026','Jeans0026','LNC000013','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','US','C000002','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0026','2019-02-19 01:07:08','P000002','P000001','1');
insert into recommand_product_data values ('RP000027','Jeans0027','LNC000014','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','Japan','C000002','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0027','2019-02-15 06:12:26','P000002','P000001','1');
insert into recommand_product_data values ('RP000028','Jeans0028','LNC000014','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','French','C000002','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0028','2019-02-14 17:41:29','P000002','P000001','1');
insert into recommand_product_data values ('RP000029','Jeans0029','LNC000015','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','China','C000002','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0029','2019-02-16 00:20:27','P000002','P000001','1');
insert into recommand_product_data values ('RP000030','Jeans0030','LNC000015','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','US','C000002','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0030','2019-02-15 03:57:43','P000002','P000001','1');
insert into recommand_product_data values ('RP000031','Jeans0031','LNC000016','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','Japan','C000002','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0031','2019-02-01 00:21:54','P000002','P000001','1');
insert into recommand_product_data values ('RP000032','Jeans0032','LNC000016','B000001','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','French','C000002','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0032','2019-02-18 00:12:19','P000002','P000001','1');
insert into recommand_product_data values ('RP000033','Jeans0033','LNC000017','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','China','C000003','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0033','2019-02-19 05:52:41','P000002','P000001','1');
insert into recommand_product_data values ('RP000034','Jeans0034','LNC000017','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','US','C000003','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0034','2019-02-15 02:03:47','P000002','P000001','1');
insert into recommand_product_data values ('RP000035','Jeans0035','LNC000018','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','Japan','C000003','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0035','2019-02-22 07:33:56','P000002','P000001','1');
insert into recommand_product_data values ('RP000036','Jeans0036','LNC000018','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','French','C000003','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0036','2019-02-02 16:47:00','P000002','P000001','1');
insert into recommand_product_data values ('RP000037','Jeans0037','LNC000019','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','China','C000003','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0037','2019-02-18 16:09:06','P000002','P000001','1');
insert into recommand_product_data values ('RP000038','Jeans0038','LNC000019','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','US','C000003','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0038','2019-02-13 10:34:33','P000002','P000001','1');
insert into recommand_product_data values ('RP000039','Jeans0039','LNC000020','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','Japan','C000003','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0039','2019-02-15 13:38:44','P000002','P000001','1');
insert into recommand_product_data values ('RP000040','Jeans0040','LNC000020','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','French','C000003','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0040','2019-02-19 09:58:53','P000002','P000001','1');
insert into recommand_product_data values ('RP000041','Jeans0041','LNC000021','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','China','C000003','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0041','2019-01-31 18:24:04','P000002','P000001','1');
insert into recommand_product_data values ('RP000042','Jeans0042','LNC000021','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','US','C000003','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0042','2019-02-09 00:36:28','P000002','P000001','1');
insert into recommand_product_data values ('RP000043','Jeans0043','LNC000022','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','Japan','C000003','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0043','2019-02-01 00:40:11','P000002','P000001','1');
insert into recommand_product_data values ('RP000044','Jeans0044','LNC000022','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','French','C000003','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0044','2019-02-06 10:52:27','P000003','P000001','1');
insert into recommand_product_data values ('RP000045','Jeans0045','LNC000023','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','China','C000003','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0045','2019-02-14 06:46:22','P000003','P000001','1');
insert into recommand_product_data values ('RP000046','Jeans0046','LNC000023','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','US','C000003','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0046','2019-02-13 00:16:19','P000003','P000001','1');
insert into recommand_product_data values ('RP000047','Jeans0047','LNC000024','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','Japan','C000003','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0047','2019-02-07 20:33:35','P000003','P000001','1');
insert into recommand_product_data values ('RP000048','Jeans0048','LNC000024','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','French','C000003','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0048','2019-02-19 07:12:07','P000003','P000001','1');
insert into recommand_product_data values ('RP000049','Jeans0049','LNC000025','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','China','C000004','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0049','2019-02-15 05:23:08','P000003','P000001','1');
insert into recommand_product_data values ('RP000050','Jeans0050','LNC000025','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','US','C000004','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0050','2019-02-12 09:08:02','P000003','P000001','1');
insert into recommand_product_data values ('RP000051','Jeans0051','LNC000026','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','Japan','C000004','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0051','2019-02-06 00:59:10','P000003','P000001','1');
insert into recommand_product_data values ('RP000052','Jeans0052','LNC000026','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','French','C000004','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0052','2019-02-19 15:42:28','P000003','P000001','1');
insert into recommand_product_data values ('RP000053','Jeans0053','LNC000027','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','China','C000004','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0053','2019-02-12 14:49:07','P000003','P000001','1');
insert into recommand_product_data values ('RP000054','Jeans0054','LNC000027','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','US','C000004','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0054','2019-02-05 22:37:56','P000003','P000001','1');
insert into recommand_product_data values ('RP000055','Jeans0055','LNC000028','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','Japan','C000004','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0055','2019-02-02 14:07:35','P000003','P000001','1');
insert into recommand_product_data values ('RP000056','Jeans0056','LNC000028','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','French','C000004','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0056','2019-02-12 07:11:09','P000003','P000001','1');
insert into recommand_product_data values ('RP000057','Jeans0057','LNC000029','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','China','C000004','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0057','2019-02-01 13:11:05','P000003','P000001','1');
insert into recommand_product_data values ('RP000058','Jeans0058','LNC000029','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','US','C000004','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0058','2019-02-08 15:55:26','P000003','P000001','1');
insert into recommand_product_data values ('RP000059','Jeans0059','LNC000030','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','Japan','C000004','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0059','2019-02-18 23:51:30','P000003','P000001','1');
insert into recommand_product_data values ('RP000060','Jeans0060','LNC000030','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','French','C000004','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0060','2019-02-19 16:54:07','P000003','P000001','1');
insert into recommand_product_data values ('RP000061','Jeans0061','LNC000031','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','China','C000004','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0061','2019-02-20 13:42:18','P000003','P000001','1');
insert into recommand_product_data values ('RP000062','Jeans0062','LNC000031','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','US','C000004','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0062','2019-02-02 22:35:30','P000003','P000001','1');
insert into recommand_product_data values ('RP000063','Jeans0063','LNC000032','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','Japan','C000004','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0063','2019-02-18 07:39:48','P000003','P000001','1');
insert into recommand_product_data values ('RP000064','Jeans0064','LNC000032','B000002','https://demo.doublechaintech.com/demodata/imageManager/genImage/prod00/800/600/blue/','French','C000004','The brand a great that has Roadester, Model S and Model X, Model 3 is in development0064','2019-02-21 19:29:20','P000003','P000001','1');

	
insert into user_domain_data values ('UD000001','用户区域','1');

	
insert into user_white_list_data values ('UWL000001','clariones','tester;ios-spokesperson','UD000001','1');
insert into user_white_list_data values ('UWL000002','13808188512','tester;ios-spokesperson0002','UD000001','1');

	
insert into sec_user_data values ('SU000001','login','13900000001','','C183EC89F92A462CF45B95504792EC4625E847C90536EEFE512D1C9DB8602E95','0','2019-02-02 12:20:36','2019-02-05 20:22:35','UD000001',NULL,'BLOCKED','1');
insert into sec_user_data values ('SU000002','login0002','13900000002','suddy_chang@163.com','AC2F95628244C6975EB2C36942EA879ED93D93F5895EF3157733E4629FA86B92','9999999','2019-02-07 21:55:47','2019-02-21 18:36:21','UD000001',NULL,'BLOCKED0002','1');

	
insert into sec_user_blocking_data values ('SUB000001','currentUser()','2019-02-10 22:51:16','这个用户多次发送违反社区的帖子，现在把他给屏蔽了','1');

	
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

	
insert into login_history_data values ('LH000001','2019-02-18 08:19:37','192.168.1.1','登陆成功','SU000001','1');
insert into login_history_data values ('LH000002','2019-02-04 02:41:54','192.168.1.2','登陆成功0002','SU000001','1');
insert into login_history_data values ('LH000003','2019-02-02 14:21:16','192.168.1.1','登陆成功0003','SU000002','1');
insert into login_history_data values ('LH000004','2019-02-04 22:54:32','192.168.1.2','登陆成功0004','SU000002','1');

	
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
alter table product_data add constraint product4platform_fk
	foreign key(platform) references platform_data(id) on delete cascade on update cascade;
create unique index idx_sku_version on sku_data(id, version);

alter table sku_data add constraint sku4product_fk
	foreign key(product) references product_data(id) on delete cascade on update cascade;
create unique index idx_profile_version on profile_data(id, version);

alter table profile_data add constraint profile4platform_fk
	foreign key(platform) references platform_data(id) on delete cascade on update cascade;
create unique index idx_brand_filter_version on brand_filter_data(id, version);

alter table brand_filter_data add constraint brand_filter4profile_fk
	foreign key(profile) references profile_data(id) on delete cascade on update cascade;
create unique index idx_price_filter_version on price_filter_data(id, version);

alter table price_filter_data add constraint price_filter4profile_fk
	foreign key(profile) references profile_data(id) on delete cascade on update cascade;
create unique index idx_category_filter_version on category_filter_data(id, version);

alter table category_filter_data add constraint category_filter4profile_fk
	foreign key(profile) references profile_data(id) on delete cascade on update cascade;
create unique index idx_new_product_version on new_product_data(id, version);

alter table new_product_data add constraint new_product4parent_category_fk
	foreign key(parent_category) references level_n_category_data(id) on delete cascade on update cascade;
alter table new_product_data add constraint new_product4brand_fk
	foreign key(brand) references brand_data(id) on delete cascade on update cascade;
alter table new_product_data add constraint new_product4catalog_fk
	foreign key(catalog) references catalog_data(id) on delete cascade on update cascade;
alter table new_product_data add constraint new_product4profile_fk
	foreign key(profile) references profile_data(id) on delete cascade on update cascade;
alter table new_product_data add constraint new_product4platform_fk
	foreign key(platform) references platform_data(id) on delete cascade on update cascade;
create unique index idx_editor_pick_product_version on editor_pick_product_data(id, version);

alter table editor_pick_product_data add constraint editor_pick_product4parent_category_fk
	foreign key(parent_category) references level_n_category_data(id) on delete cascade on update cascade;
alter table editor_pick_product_data add constraint editor_pick_product4brand_fk
	foreign key(brand) references brand_data(id) on delete cascade on update cascade;
alter table editor_pick_product_data add constraint editor_pick_product4catalog_fk
	foreign key(catalog) references catalog_data(id) on delete cascade on update cascade;
alter table editor_pick_product_data add constraint editor_pick_product4profile_fk
	foreign key(profile) references profile_data(id) on delete cascade on update cascade;
alter table editor_pick_product_data add constraint editor_pick_product4platform_fk
	foreign key(platform) references platform_data(id) on delete cascade on update cascade;
create unique index idx_top_rated_product_version on top_rated_product_data(id, version);

alter table top_rated_product_data add constraint top_rated_product4parent_category_fk
	foreign key(parent_category) references level_n_category_data(id) on delete cascade on update cascade;
alter table top_rated_product_data add constraint top_rated_product4brand_fk
	foreign key(brand) references brand_data(id) on delete cascade on update cascade;
alter table top_rated_product_data add constraint top_rated_product4catalog_fk
	foreign key(catalog) references catalog_data(id) on delete cascade on update cascade;
alter table top_rated_product_data add constraint top_rated_product4profile_fk
	foreign key(profile) references profile_data(id) on delete cascade on update cascade;
alter table top_rated_product_data add constraint top_rated_product4platform_fk
	foreign key(platform) references platform_data(id) on delete cascade on update cascade;
create unique index idx_recommand_product_version on recommand_product_data(id, version);

alter table recommand_product_data add constraint recommand_product4parent_category_fk
	foreign key(parent_category) references level_n_category_data(id) on delete cascade on update cascade;
alter table recommand_product_data add constraint recommand_product4brand_fk
	foreign key(brand) references brand_data(id) on delete cascade on update cascade;
alter table recommand_product_data add constraint recommand_product4catalog_fk
	foreign key(catalog) references catalog_data(id) on delete cascade on update cascade;
alter table recommand_product_data add constraint recommand_product4profile_fk
	foreign key(profile) references profile_data(id) on delete cascade on update cascade;
alter table recommand_product_data add constraint recommand_product4platform_fk
	foreign key(platform) references platform_data(id) on delete cascade on update cascade;
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
create index profile4version_idx on profile_data(version);
create index brand_filter4internal_id_idx on brand_filter_data(internal_id);
create index brand_filter4version_idx on brand_filter_data(version);
create index price_filter4price_start_idx on price_filter_data(price_start);
create index price_filter4price_end_idx on price_filter_data(price_end);
create index price_filter4version_idx on price_filter_data(version);
create index category_filter4internal_id_idx on category_filter_data(internal_id);
create index category_filter4version_idx on category_filter_data(version);
create index new_product4last_update_time_idx on new_product_data(last_update_time);
create index new_product4version_idx on new_product_data(version);
create index editor_pick_product4last_update_time_idx on editor_pick_product_data(last_update_time);
create index editor_pick_product4version_idx on editor_pick_product_data(version);
create index top_rated_product4last_update_time_idx on top_rated_product_data(last_update_time);
create index top_rated_product4version_idx on top_rated_product_data(version);
create index recommand_product4last_update_time_idx on recommand_product_data(last_update_time);
create index recommand_product4version_idx on recommand_product_data(version);
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

insert into sec_user_data values('SU000001','User000001','13900000001','1000001@qq.com','258D9BB89BBC1F2A6CDDD3A4CB300E6CD9B83F3FC9984619DF1A59F6051F1F44','9292993','2019-09-09 09:09:09','2019-09-09 09:09:09','UD000001',NULL,'INIT',1);
insert into user_app_data values('UA000001','Platform','SU000001','at',1,'MXWR','Platform','P000001','/link/to/app','1'); -- REFER COUNT: 9
insert into user_app_data values('UA000002','My Account','SU000001','lock',1,'MXWR','SecUser','SU000001','/link/to/app','1'); -- REFER COUNT: 9
insert into sec_user_data values('SU000002','User000002','13900000002','1000002@qq.com','7FEABCC19D638787655F9FFC2C22755D5771184D85D000147D643D22F6617F7B','9292993','2019-09-09 09:09:09','2019-09-09 09:09:09','UD000001',NULL,'INIT',1);
insert into user_app_data values('UA000003','Catalog','SU000002','at',1,'MXWR','Catalog','C000001','/link/to/app','1'); -- REFER COUNT: 6
insert into user_app_data values('UA000004','My Account','SU000002','lock',1,'MXWR','SecUser','SU000002','/link/to/app','1'); -- REFER COUNT: 6
insert into sec_user_data values('SU000003','User000003','13900000003','1000003@qq.com','8169C17063461B0B0CC210CE5EF682E9517A19170F7DCA3C76170229D765DE7A','9292993','2019-09-09 09:09:09','2019-09-09 09:09:09','UD000001',NULL,'INIT',1);
insert into user_app_data values('UA000005','Level N Category','SU000003','accessible-icon',1,'MXWR','LevelNCategory','LNC000001','/link/to/app','1'); -- REFER COUNT: 5
insert into user_app_data values('UA000006','My Account','SU000003','lock',1,'MXWR','SecUser','SU000003','/link/to/app','1'); -- REFER COUNT: 5
insert into sec_user_data values('SU000004','User000004','13900000004','1000004@qq.com','025745F4A4EA0C11059911E40714470F323C42836B1137D66AD3F85210A725CF','9292993','2019-09-09 09:09:09','2019-09-09 09:09:09','UD000001',NULL,'INIT',1);
insert into user_app_data values('UA000007','Brand','SU000004','address-card',1,'MXWR','Brand','B000001','/link/to/app','1'); -- REFER COUNT: 5
insert into user_app_data values('UA000008','My Account','SU000004','lock',1,'MXWR','SecUser','SU000004','/link/to/app','1'); -- REFER COUNT: 5
insert into sec_user_data values('SU000005','User000005','13900000005','1000005@qq.com','F8D472FBE8716BFB66C0A9BC73208FE4C5971051D240D9AC3B5EBCEF05CD5FFA','9292993','2019-09-09 09:09:09','2019-09-09 09:09:09','UD000001',NULL,'INIT',1);
insert into user_app_data values('UA000009','Profile','SU000005','file',1,'MXWR','Profile','P000001','/link/to/app','1'); -- REFER COUNT: 7
insert into user_app_data values('UA000010','My Account','SU000005','lock',1,'MXWR','SecUser','SU000005','/link/to/app','1'); -- REFER COUNT: 7
insert into sec_user_data values('SU000006','User000006','13900000006','1000006@qq.com','FEE10F101DD4B9D2C98FAA1A672821DF22B9FA662528ED5B885B60C0979E6530','9292993','2019-09-09 09:09:09','2019-09-09 09:09:09','UD000001',NULL,'INIT',1);
insert into user_app_data values('UA000011','User Domain','SU000006','user',1,'MXWR','UserDomain','UD000001','/link/to/app','1'); -- REFER COUNT: 2
insert into user_app_data values('UA000012','My Account','SU000006','lock',1,'MXWR','SecUser','SU000006','/link/to/app','1'); -- REFER COUNT: 2
insert into sec_user_data values('SU000007','User000007','13900000007','1000007@qq.com','016B4A47737559D64FC1369AA4D8CFD0B47E11F4C6219E80946C0E47A4C1C74B','9292993','2019-09-09 09:09:09','2019-09-09 09:09:09','UD000001',NULL,'INIT',1);
insert into user_app_data values('UA000013','Sec User Blocking','SU000007','user',1,'MXWR','SecUserBlocking','SUB000001','/link/to/app','1'); -- REFER COUNT: 1
insert into user_app_data values('UA000014','My Account','SU000007','lock',1,'MXWR','SecUser','SU000007','/link/to/app','1'); -- REFER COUNT: 1




/*
| 角色        | 用户名           | 密码         |
| ------------- |:-------------:|:-------------------:|
|Platform|13900000001|DoubleChain!y1|
|Catalog|13900000002|DoubleChain!y1|
|Level N Category|13900000003|DoubleChain!y1|
|Brand|13900000004|DoubleChain!y1|
|Profile|13900000005|DoubleChain!y1|
|User Domain|13900000006|DoubleChain!y1|
|Sec User Blocking|13900000007|DoubleChain!y1|


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

