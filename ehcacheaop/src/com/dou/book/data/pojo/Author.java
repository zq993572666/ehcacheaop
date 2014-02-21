package com.dou.book.data.pojo;

import java.util.Date;

public class Author {
	
private  String id;
private  String name;
private  Date borth;
private  String sex;
private  String country;
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Date getBorth() {
	return borth;
}
public void setBorth(Date borth) {
	this.borth = borth;
}
public String getSex() {
	return sex;
}
public void setSex(String sex) {
	this.sex = sex;
}
public String getCountry() {
	return country;
}
public void setCountry(String country) {
	this.country = country;
}
@Override
public String toString() {
	return "Author [id=" + id + ", name=" + name + ", borth=" + borth
			+ ", sex=" + sex + ", country=" + country + "]";
}

}
