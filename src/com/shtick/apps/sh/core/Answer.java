/**
 * 
 */
package com.shtick.apps.sh.core;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author sean.cox
 *
 */
public class Answer {
	private AnswerID answerID;
	private QuestionID questionID;
	private String value;
	private int points;
	private ZonedDateTime timeAsked;
	private ZonedDateTime timeAnswered;
	
	/**
	 * @param answerID
	 * @param questionID
	 * @param value
	 * @param points
	 * @param timeAsked
	 * @param timeAnswered
	 */
	public Answer(AnswerID answerID, QuestionID questionID, String value, int points, ZonedDateTime timeAsked,
			ZonedDateTime timeAnswered) {
		super();
		this.answerID = answerID;
		this.questionID = questionID;
		this.value = value;
		this.points = points;
		this.timeAsked = timeAsked;
		this.timeAnswered = timeAnswered;
	}

	/**
	 * @return the answerID
	 */
	public AnswerID getAnswerID() {
		return answerID;
	}

	/**
	 * @return the questionID
	 */
	public QuestionID getQuestionID() {
		return questionID;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @return the points
	 */
	public int getPoints() {
		return points;
	}

	/**
	 * @return the timeAsked
	 */
	public ZonedDateTime getTimeAsked() {
		return timeAsked;
	}

	/**
	 * @return the timeAnswered
	 */
	public ZonedDateTime getTimeAnswered() {
		return timeAnswered;
	}
}
