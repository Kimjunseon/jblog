show tables;

desc user;
desc blog;
desc category;
desc post;

select * from user;
select * from blog;
select * from category;
select * from post;

  select *
    from user a, blog b, category c
   where b.id = a.id
     and c.id = b.id;

select a.name, b.title, b.profile, c.title, c.no, d.title, d.contents, d.reg_date, d.no
  from user a, blog b, category c, post d
 where b.id = a.id
   and c.id = b.id
   and d.catagory_no = c.no;

