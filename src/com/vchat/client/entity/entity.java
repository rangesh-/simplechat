package com.vchat.client.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * TODO Put here a description of what this class does.
 *
 * @author rangesh.
 *         Created Jul 8, 2012.
 */
@Entity
public class entity implements Serializable{

@Id
Long Id;
private static final long serialVersionUID = 1L;
private String nick;
private String meassge;
public String getNick() {
	return nick;
}
public void setNick(String nick) {
	this.nick = nick;
}
public String getMeassge() {
	return meassge;
}
public void setMeassge(String meassge) {
	this.meassge = meassge;
}
}
