package com.vchat.client;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.vchat.client.entity.entity;

/**
 * TODO Put here a description of what this class does.
 *
 * @author rangesh.
 *         Created Jul 8, 2012.
 */
@RemoteServiceRelativePath("puts")
public interface put extends RemoteService {
void insertm(String message,String nick);
ArrayList<entity>show(String nick);
}
