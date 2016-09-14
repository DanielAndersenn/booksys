package booksys.presentation;
import java.awt.* ;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import booksys.application.domain.BookingImp;

class WaitingListDialog extends Dialog
{

protected Label dateLabel;
protected TextField dateField;
protected List list;
protected Button add;
protected Button close;
	

WaitingListDialog(Frame owner, String title)
	{
		
	super(owner, title);
	
	   addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
			  WaitingListDialog.this.hide() ;
			}
		      }) ;
	
	setSize(400, 400);   
	
	setLayout(new BorderLayout()); 
	   
	dateLabel = new Label("Date", Label.LEFT);
	dateField = new TextField("YYYY:MM:DD", 12);
	
	add = new Button("Add");
	close = new Button("Close");
	
	JPanel datePanel = new JPanel();
	JPanel listPanel = new JPanel();
	JPanel buttonPanel = new JPanel();
	JList<String> waitingList;
	
	DefaultListModel listModel = new DefaultListModel();
	listModel.addElement("    Name    |  Time  | Covers |  Phone  | Table ");
	populateList();
	waitingList = new JList<>(listModel);
	waitingList.setVisibleRowCount(20);
	JScrollPane listScroll = new JScrollPane(waitingList);
	
	datePanel.add(dateLabel);
	datePanel.add(dateField);
	
	listPanel.add(listScroll);
	
	buttonPanel.add(add);
	buttonPanel.add(close);
	
	add(datePanel, BorderLayout.PAGE_START);
	add(listPanel, BorderLayout.CENTER);
	add(buttonPanel, BorderLayout.PAGE_END);

	
	
	}
	
	void populateList() {
		
		
		return;
	}
	
}
