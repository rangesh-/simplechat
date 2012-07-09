package com.vchat.client;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.vchat.client.entity.entity;

/**
 * TODO Put here a description of what this class does.
 *
 * @author rangesh.
 *         Created Jul 8, 2012.
 */
public interface putAsync {

	void insertm(String message, String nick, AsyncCallback<Void> callback);

	void show(String nick, AsyncCallback<ArrayList<entity>> callback);



}
