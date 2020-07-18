/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2020/5/9 2:04:09                             */
/*==============================================================*/


drop table if exists administrator;

drop table if exists `add`;

drop table if exists administrate;

drop table if exists books;

drop table if exists buy;

drop table if exists favor;

drop table if exists favorite;

drop table if exists maintain;

drop table if exists merchant;

drop table if exists `order`;

drop table if exists shopping_cart;

drop table if exists user;

/*==============================================================*/
/* Table: administrator                                         */
/*==============================================================*/
create table administrator
(
   administrator_id     int not null auto_increment,
   birthday             date not null,
   address              varchar(30) not null,
   nickname             char(30) not null,
   real_name            varchar(10) not null,
   sex                  char(1) not null,
   ad_phone_number      char(11) not null,
   email                char(20) not null,
   password             char(20) not null,
   head_portrait        varchar(30),
   id_card              char(18),
   primary key (administrator_id)
);

/*==============================================================*/
/* Table: `add`                                                 */
/*==============================================================*/
create table `add`
(
   cart_user_phone      char(11) not null,
   books_id             int not null,
   add_date             datetime not null,
   add_sum              int not null,
   primary key (cart_user_phone, books_id)
);

/*==============================================================*/
/* Table: administrate                                          */
/*==============================================================*/
create table administrate
(
   administrator_id     int not null,
   books_id             int not null,
   administrate_date    datetime not null,
   primary key (administrator_id, books_id)
);

/*==============================================================*/
/* Table: books                                                 */
/*==============================================================*/
create table books
(
   name                 varchar(30) not null,
   price                decimal(30,2) not null,
   press                varchar(30) not null,
   press_date           date not null,
   brief                varchar(100) not null,
   url                  varchar(30) not null,
   picture              varchar(30) not null,
   books_id             int not null auto_increment,
   merchant_id          int,
   kind                 varchar(20) not null,
   primary key (books_id)
);

/*==============================================================*/
/* Table: buy                                                   */
/*==============================================================*/
create table buy
(
   order_id             int not null,
   books_id             int not null,
   buy_date             datetime not null,
   buy_sum              int not null,
   primary key (order_id, books_id)
);

/*==============================================================*/
/* Table: favor                                                 */
/*==============================================================*/
create table favor
(
   books_id             int not null,
   fav_user_phone       char(11) not null,
   favor_date           datetime not null,
   primary key (books_id, fav_user_phone)
);

/*==============================================================*/
/* Table: favorite                                              */
/*==============================================================*/
create table favorite
(
   fav_user_phone       char(11) not null,
   phone_number         char(11),
   primary key (fav_user_phone)
);

/*==============================================================*/
/* Table: maintain                                              */
/*==============================================================*/
create table maintain
(
   administrator_id     int not null,
   order_id             int not null,
   maintain_date        datetime not null,
   primary key (administrator_id, order_id)
);

/*==============================================================*/
/* Table: merchant                                              */
/*==============================================================*/
create table merchant
(
   merchant_id          int not null auto_increment,
   origin               varchar(30) not null,
   primary key (merchant_id)
);

/*==============================================================*/
/* Table: `order`                                               */
/*==============================================================*/
create table `order`
(
   order_id             int not null auto_increment,
   merchant_id          int not null,
   phone_number         char(11) not null,
   change_date          datetime not null,
   primary key (order_id)
);

/*==============================================================*/
/* Table: shopping_cart                                         */
/*==============================================================*/
create table shopping_cart
(
   cart_user_phone      char(11) not null,
   phone_number         char(11) not null,
   primary key (cart_user_phone)
);

/*==============================================================*/
/* Table: user                                                  */
/*==============================================================*/
create table user
(
   nickname             char(30) not null,
   real_name            varchar(10) not null,
   sex                  char(1) not null,
   phone_number         char(11) not null,
   email                char(20) not null,
   password             char(20) not null,
   head_portrait        varchar(30),
   id_card              char(18),
   birthday             date,
   address              varchar(30),
   balance              decimal(30,2) not null,
   primary key (phone_number)
);

alter table `add` add constraint fk_add foreign key (cart_user_phone)
      references shopping_cart (cart_user_phone) on delete restrict on update restrict;

alter table `add` add constraint fk_add2 foreign key (books_id)
      references books (books_id) on delete restrict on update restrict;

alter table administrate add constraint fk_administrate foreign key (administrator_id)
      references administrator (administrator_id) on delete restrict on update restrict;

alter table administrate add constraint fk_administrate2 foreign key (books_id)
      references books (books_id) on delete restrict on update restrict;

alter table books add constraint fk_provide foreign key (merchant_id)
      references merchant (merchant_id) on delete restrict on update restrict;

alter table buy add constraint fk_buy foreign key (order_id)
      references `order` (order_id) on delete restrict on update restrict;

alter table buy add constraint fk_buy2 foreign key (books_id)
      references books (books_id) on delete restrict on update restrict;

alter table favor add constraint fk_favor foreign key (books_id)
      references books (books_id) on delete restrict on update restrict;

alter table favor add constraint fk_favor2 foreign key (fav_user_phone)
      references favorite (fav_user_phone) on delete restrict on update restrict;

alter table favorite add constraint fk_poccess_fav foreign key (phone_number)
      references user (phone_number) on delete restrict on update restrict;

alter table maintain add constraint fk_maintain foreign key (administrator_id)
      references administrator (administrator_id) on delete restrict on update restrict;

alter table maintain add constraint fk_maintain2 foreign key (order_id)
      references `order` (order_id) on delete restrict on update restrict;

alter table `order` add constraint fk_change foreign key (merchant_id)
      references merchant (merchant_id) on delete restrict on update restrict;

alter table `order` add constraint fk_order foreign key (phone_number)
      references user (phone_number) on delete restrict on update restrict;

alter table shopping_cart add constraint fk_12 foreign key (phone_number)
      references user (phone_number) on delete restrict on update restrict;


//创建用户
delimiter $
create procedure create_user(in nickname char(30),in real_name varchar(10),in sex char(1),in phone_number char(11),in email char(20),in password char(20),in balance decimal(30,2))
begin
      declare t_error integer default 1;
      declare continue handler for sqlexception set t_error=-1;
      start transaction; 
            insert into user(nickname,real_name,sex,phone_number,email,`password`,balance) 
            values(nickname,real_name,sex,phone_number,email,password,balance); 
      if t_error = -1 then  
            rollback;  
      else  
            commit;  
      end if;
end$
delimiter ;

insert into user(nickname,real_name,sex,phone_number,email,`password`,balance) 
values("slim","李炜","男","19806633273","1315692350@qq.com","000312","0.0"); 


call  create_user("slim","李炜","男","19806633273","1315692350@qq.com","000312","0.0");
//创建购物车和收藏夹
delimiter $
create procedure create_cart_favorite(in nickname char(30),in real_name varchar(10),in sex char(1),in phone_number char(11),in email char(20),in password char(20),in balance decimal(30,2))
begin
      declare t_error integer default 1;
      declare continue handler for sqlexception set t_error=-1;
      start transaction; 
            insert into shopping_cart(cart_user_phone,phone_number) values(phone_number,phone_number);
            insert into favorite(fav_user_phone,phone_number) values(phone_number,phone_number);
      if t_error = -1 then  
            rollback;  
      else  
            commit;  
      end if;
end$
delimiter ;

//创建用户购物车和收藏夹
delimiter $
create procedure create_user_cart_favorite(in nickname char(30),in real_name varchar(10),in sex char(1),in phone_number char(11),in email char(20),in password char(20),in balance decimal(30,2))
begin
      declare t_error integer default 1;
      declare continue handler for sqlexception set t_error=-1;
      start transaction; 
            call create_user(nickname,real_name,sex,phone_number,email,password,balance);
            call create_cart_favorite(nickname,real_name,sex,phone_number,email,password,balance);
      if t_error = -1 then  
            rollback;  
      else  
            commit;  
      end if;
end$
delimiter ;
例子：call  create_user_cart_favorite("slim","李炜","男","19806633273","1315692340@qq.com","000312","0.0");

//创建商家
delimiter $
create procedure create_merchant(in origin varchar(30))
begin
      declare t_error integer default 1;
      declare continue handler for sqlexception set t_error=-1;
      start transaction; 
            insert into merchant(origin) values(origin);
            call create_cart_favorite(nickname,real_name,sex,phone_number,email,password,balance);
      if t_error = -1 then  
            rollback;  
      else  
            commit;  
      end if;
end$
delimiter ;
call create_merchant("揭阳");

//创建商品
delimiter $
create procedure create_books(in name varchar(30),in price decimal(30,2),in press varchar(30),in press_date date,in brief varchar(100),in url varchar(30),in picture varchar(30),in merchant_id varchar(20),in kind varchar(20))
begin
      declare t_error integer default 1;
      declare continue handler for sqlexception set t_error=-1;
      start transaction; 
            insert into books(`name`,price,press,press_date,brief,`url`,picture,merchant_id,kind)
            values(name,price,press,press_date,brief,url,picture,merchant_id,kind);
      if t_error = -1 then  
            rollback;  
      else  
            commit;  
      end if;
end$
delimiter ;
call create_books("你好旧时光",20.50,"北京大学出版社","2020-5-21","旧事","https://","https://",1,"网络文学");

//创建管理员
delimiter $
create procedure create_administrator(in birthday date,in address varchar(30),in nickname char(30),in real_name varchar(10),in sex char(1),in ad_phone_number char(11),in email char(20),in password char(20),in head_portrait varchar(30),in id_card char(18))
begin
      declare t_error integer default 1;
      declare continue handler for sqlexception set t_error=-1;
      start transaction; 
            insert into administrator(birthday,`address`,nickname,real_name,sex,ad_phone_number,email,`password`,head_portrait,id_card)
            values(birthday,address,nickname,real_name,sex,ad_phone_number,email,password,head_portrait,id_card);
      if t_error = -1 then  
            rollback;  
      else  
            commit;  
      end if;
end$
delimiter ;
call create_administrator("2020-05-21","灰寨","slimes","李炜柯","男","19806633283","664006035@qq.com","19806633263","https://","445222200003122217");

//下订单
delimiter $
create procedure create_order(in merchant_id int(11),in phone_number char(11),in change_date datetime)
begin 
      declare t_error integer default 1;
      declare continue handler for sqlexception set t_error=-1;
      start transaction; 
            insert into `order`(merchant_id,phone_number,change_date) values(merchant_id,phone_number,change_date);
      if t_error = -1 then  
            rollback;  
      else  
            commit;  
      end if;
end $
delimiter ;
call create_order("2","19806633263","2020-05-22 17:40:13");

//商品加入购物车
delimiter $
create procedure create_add(in cart_user_phone char(11),in books_id int(11),in add_date datetime,in add_sum int(11))
begin
      declare t_error integer default 1;
      declare continue handler for sqlexception set t_error=-1;
      start transaction; 
      insert into `add`(cart_user_phone,books_id,add_date,add_sum) values(cart_user_phone,books_id,add_date,add_sum);
      if t_error = -1 then  
            rollback;  
      else  
            commit;  
      end if;
end $
delimiter ;
call create_add("1980663263",1,"2020-05-22 17:40:13",2);

//订单订购商品
delimiter $
create procedure create_buy(in order_id int(11),in books_id int(11),in buy_date datetime,in buy_sum int(11))
begin 
      declare t_error integer default 1;
      declare continue handler for sqlexception set t_error=-1;
      start transaction; 
      insert into buy(order_id,books_id,buy_date,buy_sum) values(order_id,books_id,buy_date,buy_sum);
      if t_error = -1 then  
            rollback;  
      else  
            commit;  
      end if;
end $
delimiter ;
call create_buy(1,1,"2020-05-22 17:40:13",2);

//收藏夹收藏商品
delimiter $
create procedure create_favor(in books_id int(11),in fav_user_phone char(11),in favor_date datetime)
begin
      declare t_error integer default 1;
      declare continue handler for sqlexception set t_error=-1;
      start transaction; 
      insert into favor(books_id,fav_user_phone,favor_date) values(books_id,fav_user_phone,favor_date);
      if t_error = -1 then  
            rollback;  
      else  
            commit;  
      end if;
end $
delimiter ;
call create_favor(1,"19806633263","2020-05-22 17:40:13");

//获取用户的剩余金额
delimiter $
create procedure user_balance(in phone_numbers char(11),out ans decimal(30,2))
begin
      declare cnt int;
      select count(*) into cnt from user where phone_number=phone_numbers;
      if cnt=0 then 
      set ans=-1.00;
      else select balance into ans from user where user.phone_number=phone_numbers;
      end if;
end $
delimiter ;
--call user_balance("19806633263",@ans);
--select @ans;

//判断用户存不存在(储存过程实现)
delimiter $
create procedure user_exist(in phone_numbers char(11),out ans boolean)
begin
      declare cnt int;
      select count(*) into cnt from user where phone_number=phone_numbers;
      if cnt=0 then set ans=false;
      else set ans=true;
      end if;
end $
delimiter ;

//判断用户存不存在(储存函数实现)
delimiter $
create function user_exist(phone_numbers char(11))
returns int
deterministic
begin
      declare cnt int;
      select count(*) into cnt from user where phone_number=phone_numbers;
      
      return cnt;
end $
delimiter ;
select user_exist("19806633263");

//充钱
delimiter $
create procedure charge_money(in phone_numbers char(11),in add_money decimal(30,2))
begin
      update user set balance=balance+add_money where phone_number=phone_numbers;
end $
delimiter ;

//花钱
delimiter $
create procedure cost_money(in phone_numbers char(11),in add_money decimal(30,2))
begin
      update user set balance=balance-add_money where phone_number=phone_numbers;
end $
delimiter ;

//用户登陆判断密码是否正确(手机号或邮箱都可登陆)
delimiter $
create procedure judge_password(in phone_or_email varchar(20),in passwords char(20),out ok boolean)
begin   
    declare ok1,ok2 int;
    select count(*) into ok1 from user where phone_number=phone_or_email and `password`=passwords;  
    select count(*) into ok2 from user where email=phone_or_email and `password`=passwords;
    if ok1=1 or ok2=1 then set ok=true;
    else set ok=false;
    end if;
end $
delimiter ;

//用户上传头像
delimiter $
create procedure add_user_head_portrait(in phone_numbers char(11),in head_portraits varchar(30))
begin   
    update user set head_portrait=head_portraits where phone_number=phone_numbers;
end $
delimiter ;

//用户上传身份证信息
delimiter $
create procedure add_user_id_card(in phone_numbers char(11),in id_cards char(18))
begin
    update user set id_card=id_cards where phone_number=phone_numbers;
end $
delimiter ;

//用户上传生日信息
delimiter $
create procedure add_user_birthday(in phone_numbers char(11),in birthdays date)
begin
    update user set birthday=birthdays where phone_number=phone_numbers;
end $
delimiter ;

//用户填写地址信息
delimiter $
create procedure add_user_address(in phone_numbers char(11),in addresss varchar(30))
begin 
    update user set `address`=addresss where phone_number=phone_numbers;
end $
delimiter ;

//管理员登陆认证
delimiter $
create procedure judge_ad_password(in phone_or_email varchar(20),in passwords char(20),out ok boolean)
begin   
    declare ok1,ok2 int;
    select count(*) into ok1 from administrator where ad_phone_number=phone_or_email and `password`=passwords;  
    select count(*) into ok2 from administrator where email=phone_or_email and `password`=passwords;
    if ok1=1 or ok2=1 then set ok=true;
    else set ok=false;
    end if;
end $
delimiter ;

//创建用户日志表
create table user_logs(
    id int(11) not null auto_increment,
    operation varchar(20) not null comment "操作类型,insert/update/delete",
    operate_time datetime not null comment "操作时间",
    operate_phone char(11) not null comment "操作表的用户",
    operate_params varchar(500) comment "操作参数",
    primary key(`id`)
)engine=innodb default charset=utf8;

********************************************************************************
select CONCAT(null,"aaaa");
select CONCAT("aaaa",null);
上面这2种写法，返回的值都为Null
所以如果要把两个变量的值concat的话，需要替换掉Null值，不然的话只要某个变量为null，结果都为null
正确的写法应该是select CONCAT(ifnull(null,''),"aaaa");
*********************************************************************************
//创建 insert 型触发器，完成插入数据时的日志记录:
delimiter $
create trigger user_logs_insert_trigger
after insert on user
for each row
begin
    insert into user_logs(id,operation,operate_time,operate_phone,operate_params)
    values(null,"insert",now(),new.phone_number,concat("插入后(nickname:",ifnull(new.`nickname`,""),",realname:",ifnull(new.`real_name`,""),",sex:",ifnull(new.`sex`,""),",phone_number:",ifnull(new.`phone_number`,""),",email:",ifnull(new.`email`,""),",password:",ifnull(new.`password`,""),",head_portrait:",ifnull(new.`head_portrait`,""),",id_card:",ifnull(new.`id_card`,""),",birthday:",ifnull(new.`birthday`,""),",address:",ifnull(new.`birthday`,""),",balance:",ifnull(new.`balance`,""),",remember_password:",ifnull(new.`remember_password`,""),")"));
end $
delimiter ;

//创建 update 型触发器，完成更新数据时的日志记录:
delimiter $
create trigger user_logs_update_trigger
after update on user
for each row
begin
    insert into user_logs(id,operation,operate_time,operate_phone,operate_params)
    values(null," update",now(),new.phone_number,concat("更新前(nickname:",ifnull(old.`nickname`,""),",realname:",ifnull(old.`real_name`,""),",sex:",ifnull(old.`sex`,""),",phone_number:",ifnull(old.`phone_number`,""),",email:",ifnull(old.`email`,""),",password:",ifnull(old.`password`,""),",head_portrait:",ifnull(old.`head_portrait`,""),",id_card:",ifnull(old.`id_card`,""),",birthday:",ifnull(old.`birthday`,""),",address:",ifnull(old.`birthday`,""),",balance:",ifnull(old.`balance`,""),",remember_password:",ifnull(old.`remember_password`,""),")",
    "更新后(nickname:",ifnull(new.`nickname`,""),",realname:",ifnull(new.`real_name`,""),",sex:",ifnull(new.`sex`,""),",phone_number:",ifnull(new.`phone_number`,""),",email:",ifnull(new.`email`,""),",password:",ifnull(new.`password`,""),",head_portrait:",ifnull(new.`head_portrait`,""),",id_card:",ifnull(new.`id_card`,""),",birthday:",ifnull(new.`birthday`,""),",address:",ifnull(new.`birthday`,""),",balance:",ifnull(new.`balance`,""),",remember_password:",ifnull(new.`remember_password`,""),")"));
end $
delimiter ;

//创建 delete 型触发器，完成删除数据时的日志记录:
delimiter $
create trigger user_logs_delete_trigger
after delete on user
for each row
begin
    insert into user_logs(id,operation,operate_time,operate_phone,operate_params)
    values(null,"delete",now(),old.phone_number,concat("删除前(nickname:",ifnull(old.`nickname`,""),",realname:",ifnull(old.`real_name`,""),",sex:",ifnull(old.`sex`,""),",phone_number:",ifnull(old.`phone_number`,""),",email:",ifnull(old.`email`,""),",password:",ifnull(old.`password`,""),",head_portrait:",ifnull(old.`head_portrait`,""),",id_card:",ifnull(old.`id_card`,""),",birthday:",ifnull(old.`birthday`,""),",address:",ifnull(old.`birthday`,""),",balance:",ifnull(old.`balance`,""),",remember_password:",ifnull(old.`remember_password`,""),")"));
end $
delimiter ;

//创建购物车视图
create view shopping_cart_view(`name`,`sum`,single_price,user_phone,add_time)
as
select books.name,`add`.add_sum,books.price,`add`.cart_user_phone,`add`.add_date from 
books,`add`,shopping_cart where `add`.books_id=books.books_id and `add`.cart_user_phone=shopping_cart.cart_user_phone;

//创建订单视图
create view order_view(order_id,`name`,`sum`,single_price,user_phone,add_time)
as
select `buy`.order_id,books.name,`buy`.buy_sum,books.price,`order`.phone_number,`buy`.buy_date from
books,`order`,`buy` where `buy`.books_id=books.books_id and `order`.order_id=`buy`.order_id;

