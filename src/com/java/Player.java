package com.java;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Íæ¼Ò¶ÔÏó
 * @author myself
 *
 */
public class Player implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long playerId;
	
	private int age;
	
	private String name;
	
	private List<Integer> skills = new ArrayList<>();

	public Player(long playerId, int age, String name) {
		this.playerId = playerId;
		this.age = age;
		this.name = name;
	}

	public long getPlayerId() {
		return playerId;
	}

	public void setPlayerId(long playerId) {
		this.playerId = playerId;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Integer> getSkills() {
		return skills;
	}

	public void setSkills(List<Integer> skills) {
		this.skills = skills;
	}
	
}
