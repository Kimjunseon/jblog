show tables;

desc user;
desc blog;
desc category;
desc post;

select * from user;
select * from blog;
select * from category;
select * from post;

insert into user
values('new', 'hi', '123');

insert into blog
values('new' , concat('name' , '회원님 사이트입니다.'), '기본사진');

  select *
    from user a, blog b, category c
   where b.id = a.id
     and c.id = b.id;

select a.name, b.title, b.profile, c.title, c.no, d.title, d.contents, d.reg_date, d.no, count(c.no)
  from user a, blog b, category c, post d
 where b.id = a.id
   and c.id = b.id
   and d.catagory_no = c.no
group by c.no = 2;


select no, title, descr, id
					from category
				   where id = 'pingu'
			    order by no desc;
                
select c.title, count(d.no), c.descr
  from user a, blog b, category c, post d
 where b.id = a.id
   and c.id = b.id
   and d.catagory_no = c.no
group by c.no = 1
	 and a.id = 'test';
     
     select count(d.no)
       from user a, blog b, category c, post d
      where b.id = a.id
		and c.id = b.id
        and d.category_no = c.no
   group by a.id
     having a.id = 'test';
   
 
select *
	from user;