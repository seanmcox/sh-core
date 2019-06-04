/**
 * 
 */
package com.shtick.apps.sh.core;

import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * @author sean.cox
 *
 */
public class Question {
	private QuestionID questionID;
	private QuizID quizID;
	private int order;
	private Subject subject;
	private String prompt;
	private String promptType;
	private String answerPrompt;
	private String answerPromptType;
	private String answerValue;
	private int points;
	private HashMap<String, Float> questionDimensions;
	private ZonedDateTime timeAdded;
	
	/**
	 * @param questionID
	 * @param quizID
	 * @param order 
	 * @param subject
	 * @param prompt
	 * @param promptType
	 * @param answerPrompt
	 * @param answerPromptType
	 * @param answerValue 
	 * @param questionDimensions
	 * @param points The number of points the question is worth.
	 * @param timeAdded
	 */
	public Question(QuestionID questionID, QuizID quizID, int order, Subject subject, String prompt, String promptType,
			String answerPrompt, String answerPromptType, String answerValue, Map<String, Float> questionDimensions, int points,
			ZonedDateTime timeAdded) {
		super();
		this.questionID = questionID;
		this.quizID = quizID;
		this.order = order;
		this.subject = subject;
		this.prompt = prompt;
		this.promptType = promptType;
		this.answerPrompt = answerPrompt;
		this.answerPromptType = answerPromptType;
		this.answerValue = answerValue;
		this.points = points;
		this.questionDimensions = new HashMap<>(questionDimensions);
		this.timeAdded = timeAdded;
	}

	/**
	 * @param prompt
	 * @param promptType 
	 * @param answerPrompt
	 * @param answerPromptType
	 * @param answerValue 
	 * @param questionDimensions
	 * @param points 
	 */
	public Question(String prompt, String promptType, String answerPrompt, String answerPromptType, String answerValue,
			Map<String, Float> questionDimensions, int points) {
		super();
		this.prompt = prompt;
		this.promptType = promptType;
		this.answerPrompt = answerPrompt;
		this.answerPromptType = answerPromptType;
		this.answerValue = answerValue;
		this.questionDimensions = new HashMap<>(questionDimensions);
		this.points = points;
	}
	
	/**
	 * @param questionID 
	 * @param quizID
	 * @param subject
	 * @param question 
	 * @param timeAdded 
	 */
	public Question(QuestionID questionID, QuizID quizID, Subject subject, Question question, ZonedDateTime timeAdded) {
		this(questionID,quizID,-1,subject,question.prompt, question.promptType,question.answerPrompt,question.answerPromptType, question.getAnswerValue(), question.getQuestionDimensions(), question.getPoints(),timeAdded);
	}

	/**
	 * @return the questionID
	 */
	public QuestionID getQuestionID() {
		return questionID;
	}

	/**
	 * @return the quizID
	 */
	public QuizID getQuizID() {
		return quizID;
	}

	/**
	 * @return the order
	 */
	public int getOrder() {
		return order;
	}

	/**
	 * @return the subject
	 */
	public Subject getSubject() {
		return subject;
	}

	/**
	 * @return the prompt
	 */
	public String getPrompt() {
		return prompt;
	}

	/**
	 * @return the promptType
	 */
	public String getPromptType() {
		return promptType;
	}

	/**
	 * @return the questionDimensions
	 */
	public Map<String, Float> getQuestionDimensions() {
		return new HashMap<>(questionDimensions);
	}

	/**
	 * @return the answerPrompt
	 */
	public String getAnswerPrompt() {
		return answerPrompt;
	}

	/**
	 * @return the answerPromptType
	 */
	public String getAnswerPromptType() {
		return answerPromptType;
	}

	/**
	 * @return the answerValue
	 */
	public String getAnswerValue() {
		return answerValue;
	}

	/**
	 * @return the points
	 */
	public int getPoints() {
		return points;
	}

	/**
	 * @return the timeAdded
	 */
	public ZonedDateTime getTimeAdded() {
		return timeAdded;
	}
}
