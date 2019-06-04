/**
 * 
 */
package com.shtick.apps.sh.core;

import java.util.Collection;

/**
 * @author sean.cox
 *
 */
public interface SubjectQuestionGenerator {
	/**
	 * 
	 * @return The Subject identifier. This must be unique for each implementation of the SubjectQuestionGenerator and must not be null.
	 */
	Subject getSubject(); 
	
	/**
	 * 
	 * @param driver
	 * @param userID
	 * @param count
	 * @return A collection containing a number of questions identified by count.
	 */
	Collection<Question> generateQuestions(Driver driver, UserID userID, int count);

	/**
	 * 
	 * @param question A question with the same subject as returned by getSubject()
	 * @param answer An answer proposed.
	 * @return The number of points earned with the given answer. Must be greater than or equal to zero. Should be less than or equal to the number of points the question is worth.
	 * @throws IllegalArgumentException If the question has a a subject which does not match getSubject()
	 */
	default int getAnswerScore(Question question, String answer) throws IllegalArgumentException{
		if(!getSubject().equals(question.getSubject()))
			throw new IllegalArgumentException("This is not a question for this SubjectQuestionGenerator.");
		if(answer==null)
			return 0;
		if(answer.equals(question.getAnswerValue()))
			return question.getPoints();
		return 0;
	}
}
