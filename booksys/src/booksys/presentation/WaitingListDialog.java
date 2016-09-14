package booksys.presentation;
import java.awt.* ;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import booksys.application.domain.Booking;
import booksys.application.domain.BookingImp;
import booksys.application.domain.WListEntry;

class WaitingListDialog extends Dialog
{

protected Label dateLabel, listLabel;
protected TextField dateField;
protected List list;
protected Button add;
protected Button close;
protected Button dateUpdateButton;
protected ReservationDialog rD;
protected StaffUI ui;
protected Vector<WListEntry> WList;
protected DefaultListModel listModel;
	

WaitingListDialog(Frame owner, String title, StaffUI ui)
	{	
	super(owner, title);
	
	this.ui = ui;
	
	   addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
			  WaitingListDialog.this.hide() ;
			}
		      }) ;
	
	setSize(400, 400);   
	
	setLayout(new BorderLayout()); 
	
	
	//Label panel
	JPanel labelPanel = new JPanel();
	listLabel = new Label("    Name    |  Time  | Covers |  Phone  |    Date  ");
	labelPanel.add(listLabel);
	
	
	
	
	/*
	//Date panel
	JPanel datePanel = new JPanel();
	
	
	*/
	
	//Button panel
	JPanel buttonPanel = new JPanel();
	add = new Button("Add");
	close = new Button("Close");
	buttonPanel.add(add);
	buttonPanel.add(close);
	buttonPanel.add(Box.createRigidArea(new Dimension(5,0)));
	dateLabel = new Label("Date", Label.LEFT);
	dateField = new TextField("YYYY:MM:DD", 12);
	dateUpdateButton = new Button("Update");
	buttonPanel.add(dateLabel);
	buttonPanel.add(dateField);
	buttonPanel.add(dateUpdateButton);
	
	//List panel
	JPanel listPanel = new JPanel();
	JList<String> waitingList;
	listModel = new DefaultListModel();
	
	populateList();
	waitingList = new JList<>(listModel);
	waitingList.setVisibleRowCount(20);
	JScrollPane listScroll = new JScrollPane(waitingList);
	
	listPanel.add(listScroll);
	
	
	//Build Layout
	add(labelPanel, BorderLayout.PAGE_START);
	//add(datePanel, BorderLayout.PAGE_START);
	add(listPanel, BorderLayout.CENTER);
	add(buttonPanel, BorderLayout.PAGE_END);

	add.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			rD = new ReservationDialog(owner, "Reservation to add to waiting list");	
			rD.show();
			if(rD.isConfirmed()) {
			ui.createWListEntry(rD);
			}
		}
	});
	
	}
	
	void populateList() {
		WList = ui.getWList();
		Iterator it = WList.iterator();
		while(it.hasNext()){
			WListEntry b = (WListEntry) it.next();
			// ("    Name    |  Time  | Covers |  Phone  |    Date  ")
			listModel.addElement("    "+b.getCust().getName()+"    |  "+b.getTime()+"  | "+b.getCovers()+" |  "+b.getCust().getPhoneNumber()+"  |    "+b.getDate()+"  ");
		}
		
		
			return;
	}

	public ReservationDialog getWaitingListEntry() {
		return rD;
		
	}
	
	
	
}
