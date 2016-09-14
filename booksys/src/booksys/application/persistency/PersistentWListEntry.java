package booksys.application.persistency;

import java.sql.Time;

import booksys.application.domain.Customer;
import booksys.application.domain.Reservation;
import booksys.application.domain.Table;
import booksys.application.domain.WListEntry;

public class PersistentWListEntry extends WListEntry implements PersistentBooking
{
	  private int oid ;

	  public PersistentWListEntry(int id, int c, java.sql.Date d, java.sql.Time t, Customer cust)
	  {
	    super(c, d, t, cust) ;
	    oid = id ;
	  }

	  /* public because getId defined in an interface and hence public */
	  
	  public int getId() {
	    return oid ;
	  }

	@Override
	public Time getArrivalTime() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Time getEndTime() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Table getTable() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getTableNumber() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getDetails() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setArrivalTime(Time t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setTable(Table t) {
		// TODO Auto-generated method stub
		
	}
	}
