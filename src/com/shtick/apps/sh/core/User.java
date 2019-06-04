/**
 * 
 */
package com.shtick.apps.sh.core;

import java.time.ZonedDateTime;

/**
 * @author sean.cox
 *
 */
public class User {
	private UserID userID;
	private String name;
	private ZonedDateTime timeAdded;

	/**
	 * @param userID
	 * @param name
	 * @param timeAdded 
	 */
	public User(UserID userID, String name, ZonedDateTime timeAdded) {
		super();
		this.userID = userID;
		this.name = name;
		this.timeAdded = timeAdded;
	}

	/**
	 * @return the userID
	 */
	public UserID getUserID() {
		return userID;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the timeAdded
	 */
	public ZonedDateTime getTimeAdded() {
		return timeAdded;
	}
}
