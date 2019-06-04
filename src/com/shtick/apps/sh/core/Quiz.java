/**
 * 
 */
package com.shtick.apps.sh.core;

import java.time.ZonedDateTime;

/**
 * @author sean.cox
 *
 */
public class Quiz {
	private QuizID quizID;
	private UserID userID;
	private ZonedDateTime timeAdded;

	/**
	 * @param quizID
	 * @param userID 
	 * @param timeAdded 
	 */
	public Quiz(QuizID quizID, UserID userID, ZonedDateTime timeAdded) {
		super();
		this.quizID = quizID;
		this.userID = userID;
		this.timeAdded = timeAdded;
	}

	/**
	 * @return the quizID
	 */
	public QuizID getQuizID() {
		return quizID;
	}

	/**
	 * @return the userID
	 */
	public UserID getUserID() {
		return userID;
	}

	/**
	 * @return the creationTime
	 */
	public ZonedDateTime getTimeAdded() {
		return timeAdded;
	}
}
