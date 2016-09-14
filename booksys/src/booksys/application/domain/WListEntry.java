package booksys.application.domain;

import java.sql.Date ;
import java.sql.Time ;

//7.10 Class(DTO) to handle WlistEntry objects

public class WListEntry {
	protected int covers;
	protected Date date;
	protected Time time;
	protected Customer cust;

public WListEntry(int covers, Date date, Time time, Customer cust){
	this.covers = covers;
	this.date = date;
	this.time = time;
	this.cust = cust;
}

public Customer getCust() {
	return cust;
}

public void setCust(Customer cust) {
	this.cust = cust;
}

public int getCovers() {
	return covers;
}

public void setCovers(int covers) {
	this.covers = covers;
}

public Date getDate() {
	return date;
}

public void setDate(Date date) {
	this.date = date;
}

public Time getTime() {
	return time;
}

public void setTime(Time time) {
	this.time = time;
}


}
