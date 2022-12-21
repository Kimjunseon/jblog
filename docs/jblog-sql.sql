show tables;

desc user;
desc blog;
desc category;
desc post;

select * from user;
select * from blog;
select * from category;
select * from post;
delete from post where no = 1;


select no, title, descr, id from category
group by title;

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
                
select c.title, c.descr, d.category_no
  from user a, blog b, category c, post d
 where b.id = a.id
   and c.id = b.id
   and d.category_no = c.no
group by c.no = 1
	 and a.id = 'test';
     
     select c.no as no, c.title as title, c.descr as descr, count(d.no) as count
       from user a, blog b, category c left outer join post d
	     on d.category_no = c.id
      where b.id = a.id
		and c.id = b.id
        order by c.no desc;
        
        select * from post;
        
        
select count(title)
	from post;
    
    select a.id, c.title as title, c.descr as descr, count(d.category_no) as postno
                      from user a, blog b, category c
                      left outer join post d
	                    on d.category_no = c.id
                     where b.id = a.id
		               and c.id = b.id
					group by title
		          order by c.no desc;
                  
select a.name, c.no as no, c.title as title, c.descr as descr
                      from user a, blog b, category c
                     where b.id = a.id
		               and c.id = b.id
		          order by c.no desc;
                  
select * from category;