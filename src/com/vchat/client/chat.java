package com.vchat.client;

import java.util.ArrayList;

import org.apache.tools.ant.taskdefs.SendEmail;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.sun.java.swing.plaf.windows.resources.windows;
import com.vchat.client.putAsync;
import com.vchat.client.put;
import com.vchat.client.entity.entity;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.util.PreventSpuriousRebuilds;



/**
 * TODO Put here a description of what this class does.
 *
 * @author rangesh.
 *         Created Jul 8, 2012.
 */
public class chat implements EntryPoint{

	final putAsync send=(putAsync)GWT.create(put.class);
	final TextBox area1 =new TextBox();
	ArrayList<String>nicks=new ArrayList();
	ArrayList<String>msg=new ArrayList();
	String s=null;
	int count=0,temp=0,itr=1;
	@Override
	public void onModuleLoad() {
		// TODO Auto-generated method stub.
final FlowPanel panel=new FlowPanel();
panel.setSize("300px","450px");
DOM.setElementAttribute(panel.getElement(),"id","bg");
Label lab=new Label("Your Nick");
final TextBox area =new TextBox();
Button but=new Button("Join");
but.setSize("60px","30px");
area.setSize("200px","12px");
area1.setSize("120px","14px");
RootPanel.get().add(lab,490,90);
RootPanel.get().add(area1,552,88);
RootPanel.get().add(panel,120,90);
RootPanel.get().add(area,175,550);
Label mg=new Label("Message");
RootPanel.get().add(but,687,85);
RootPanel.get().add(mg,120,550);
but.addClickHandler(new ClickHandler() {
	
	@Override
	public void onClick(ClickEvent event) {
		// TODO Auto-generated method stub.
 s=area1.getText();
if(s.equalsIgnoreCase(" "))
{
s="Unknown";	
}
Label la=new Label(s+" has joined the Chat Server");
DOM.setElementAttribute(la.getElement(),"id","sc");
RootPanel.get().add(la,555,127);
	}
});
area.addKeyDownHandler(new KeyDownHandler() {
	
	@Override
	public void onKeyDown(KeyDownEvent event) {
		// TODO Auto-generated method stub.
		if(s.equalsIgnoreCase(" "))
		{
			s="Unknown";			
		}
		if(event.getNativeKeyCode()==KeyCodes.KEY_ENTER)
		{
Label lab1=new Label("You:"+" "+area.getText());
panel.add(lab1);
send.insertm(area.getText(),s,new AsyncCallback() {
	
	
	@Override
	public void onFailure(Throwable caught) {
		// TODO Auto-generated method stub.
		System.out.println("galli");
	}

	@Override
	public void onSuccess(Object result) {
		// TODO Auto-generated method stub.
		System.out.println("Succsee");
		area.setText("");
	}
});

		}
	}
});

Timer t = new Timer() {
    public void run() {
send.show(s,new AsyncCallback<ArrayList<entity>>() {
	
	@Override
	public void onSuccess(ArrayList<entity> result) {
		// TODO Auto-generated method stub.
	for(entity cmt:result)
	{
	count++;	
	}
	Label[] labs=new Label[count];
	//System.out.println("Total count"+count);
if(temp<count)
{
	for(entity cmt:result)
	{
	nicks.add(cmt.getNick());
	msg.add(cmt.getMeassge());
	}

	for(int i=(itr);i<count;i++)
	{
	labs[i]=new Label(nicks.get(i)+" Says:"+msg.get(i));	
	panel.add(labs[i]);
	panel.add(new HTML("<hr/>"));
	}
	
temp++;
}
temp=(count);
itr=count;
for(int i=0;i<nicks.size();i++)
{
nicks.remove(i);
msg.remove(i);
}
count=0;
//System.out.println("Temp"+temp);
	}
	
	@Override
	public void onFailure(Throwable caught) {
		// TODO Auto-generated method stub.
	System.out.println("galli");	
	}
});
    }
  };

  // Schedule the timer to run once in 5 seconds.
  t.scheduleRepeating(5000);
	}
	
	
}
