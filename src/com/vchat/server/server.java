package com.vchat.server;



import java.util.ArrayList;



import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.Query;
import com.vchat.client.put;
import com.vchat.client.entity.entity;

/**
 * TODO Put here a description of what this class does.
 *
 * @author rangesh.
 *         Created Jul 8, 2012.
 */
public class server extends RemoteServiceServlet implements put{

	static
	{
		ObjectifyService.register(entity.class);
		

	}
	private static final long serialVersionUID = 1L;
	@Override
	public void insertm(String message, String nick) {
		// TODO Auto-generated method stub.
		Objectify ran=ObjectifyService.begin();
		entity cmts=new entity();
cmts.setMeassge(message);
cmts.setNick(nick);
ran.put(cmts);
	}
	@Override
	public ArrayList<entity> show(String nick) {
		// TODO Auto-generated method stub.
		Objectify ran=ObjectifyService.begin();
		Query<entity> q=ran.query(entity.class);
		ArrayList<entity>cmn=new ArrayList<entity>();
		for (entity cmns:q)
		{
			boolean i=cmns.getNick().equalsIgnoreCase(nick);	
		if(i==false)
		{
			
			cmn.add(cmns);
		}	
		}
		return cmn;
	}
		

}
