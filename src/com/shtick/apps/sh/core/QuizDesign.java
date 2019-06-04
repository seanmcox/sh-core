/**
 * 
 */
package com.shtick.apps.sh.core;

import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;

/**
 * @author sean.cox
 *
 */
public class QuizDesign {
	private QuizDesignID quizDesignID;
	private UserID UserID;
	private String title;
	private Set<QuizDesignSubject> subjects;
	private int minQuestions;
	private int maxQuestions;
	private ZonedDateTime timeAdded;
	
	/**
	 * For marshaling an existing quiz design.
	 * 
	 * @param quizDesignID
	 * @param userID
	 * @param title
	 * @param subjects
	 * @param minQuestions Should be greater than or equal to the the sum of the minQuestions for each subject, and less than or equal to maxQuestions.
	 * @param maxQuestions Should be less than or equal to the the sum of the maxQuestions for each subject, and greater than or equal to minQuestions.
	 * @param timeAdded
	 */
	public QuizDesign(QuizDesignID quizDesignID, com.shtick.apps.sh.core.UserID userID, String title,
			Set<QuizDesignSubject> subjects, int minQuestions, int maxQuestions, ZonedDateTime timeAdded) {
		super();
		this.quizDesignID = quizDesignID;
		UserID = userID;
		this.title = title;
		this.subjects = subjects;
		this.minQuestions = minQuestions;
		this.maxQuestions = maxQuestions;
		this.timeAdded = timeAdded;
	}

	/**
	 * For generating a new QuizDesign to be stored in the database.
	 * 
	 * @param userID
	 * @param title
	 * @param subjects
	 * @param minQuestions
	 * @param maxQuestions
	 */
	public QuizDesign(com.shtick.apps.sh.core.UserID userID, String title,
			Set<QuizDesignSubject> subjects, int minQuestions, int maxQuestions) {
		this(null,userID,title,subjects,minQuestions,maxQuestions,ZonedDateTime.now());
	}

	/**
	 * @return the quizDesignID
	 */
	public QuizDesignID getQuizDesignID() {
		return quizDesignID;
	}

	/**
	 * @return the userID
	 */
	public UserID getUserID() {
		return UserID;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @return the subjects
	 */
	public Set<QuizDesignSubject> getSubjects() {
		return new HashSet<>(subjects);
	}

	/**
	 * @return the minQuestions
	 */
	public int getMinQuestions() {
		return minQuestions;
	}

	/**
	 * @return the maxQuestions
	 */
	public int getMaxQuestions() {
		return maxQuestions;
	}

	/**
	 * @return the timeAdded
	 */
	public ZonedDateTime getTimeAdded() {
		return timeAdded;
	}

}
