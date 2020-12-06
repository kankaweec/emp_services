package com.th.employee.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(description = "Token for authen")
//mark class as an Entity 
@Entity
//defining class name as Table name
@Table
public class Books
{
	
@ApiModelProperty(notes="Book id")
//Defining book id as primary key
@Id
@Column
private String bookid;
@ApiModelProperty(notes="Book name")
@Column
private String bookname;
@ApiModelProperty(notes="Author")
@Column
private String author;
@ApiModelProperty(notes="Price")
@Column
private int price;
public String getBookid() 
{
return bookid;
}
public void setBookid(String bookid) 
{
this.bookid = bookid;
}
public String getBookname()
{
return bookname;
}
public void setBookname(String bookname) 
{
this.bookname = bookname;
}
public String getAuthor() 
{
return author;
}
public void setAuthor(String author) 
{
this.author = author;
}
public int getPrice() 
{
return price;
}
public void setPrice(int price) 
{
this.price = price;
}
}