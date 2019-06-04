/**
 * 
 */
package com.shtick.apps.sh.core;

/**
 * @author scox
 *
 */
public class QuizDesignSubject {
	private Subject subject;
	private int minQuestions;
	private int maxQuestions;
	
	/**
	 * 
	 * @param subject
	 * @param minQuestions
	 * @param maxQuestions
	 */
	public QuizDesignSubject(Subject subject, int minQuestions, int maxQuestions) {
		super();
		this.subject = subject;
		this.minQuestions = minQuestions;
		this.maxQuestions = maxQuestions;
	}

	/**
	 * @return the subject
	 */
	public Subject getSubject() {
		return subject;
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
}
