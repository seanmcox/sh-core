/**
 * 
 */
package com.shtick.apps.sh.core;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.util.Collection;

/**
 * @author sean.cox
 *
 */
public interface Driver {

	/**
	 * 
	 * @param username
	 * @return The created user.
	 * @throws IOException
	 */
	UserID createUser(String username) throws IOException;
	
	/**
	 * 
	 * @param userID
	 * @throws IOException
	 */
	void deleteUser(UserID userID) throws IOException;

	/**
	 * 
	 * @param userID
	 * @param username 
	 * @throws IOException
	 */
	void updateUser(UserID userID, String username) throws IOException;

	/**
	 * 
	 * @param userID
	 * @return The identified User or null.
	 * @throws IOException
	 */
	User getUser(UserID userID) throws IOException;
	
	/**
	 * 
	 * @return A Collection of all users.
	 * @throws IOException
	 */
	Collection<User> getUsers() throws IOException;

	/**
	 * 
	 * @param quizDesign
	 * @return An updated version of quizDesign with the ID and creation time set for the new persisted instance.
	 * @throws IOException 
	 */
	QuizDesignID createQuizDesign(QuizDesign quizDesign) throws IOException;

	/**
	 * 
	 * @param quizDesign
	 * @throws IOException 
	 */
	void updateQuizDesign(QuizDesign quizDesign) throws IOException;

	/**
	 * 
	 * @param userID
	 * @return A collection of all quizes designed for the user identified by userID
	 * @throws IOException 
	 */
	Collection<QuizDesign> getQuizDesigns(UserID userID) throws IOException;

	/**
	 * 
	 * @param designID
	 * @return The quiz identified by designID
	 * @throws IOException 
	 */
	QuizDesign getQuizDesign(QuizDesignID designID) throws IOException;

	/**
	 * @param designID
	 * @throws IOException
	 */
	void deleteQuizDesign(QuizDesignID designID) throws IOException;

	/**
	 * 
	 * @param quizDesignID 
	 * @return A Project loaded from the given file.
	 * @throws IOException 
	 */
	Quiz generateQuiz(QuizDesignID quizDesignID) throws IOException;

	/**
	 * 
	 * @param quizID
	 * @return The Quiz with the given ID or null.
	 * @throws IOException
	 */
	Quiz getQuiz(QuizID quizID) throws IOException;
	
	/**
	 * 
	 * @param userID
	 * @return A collection of all quizes for the given user.
	 * @throws IOException
	 */
	Collection<Quiz> getUserQuizes(UserID userID) throws IOException;

	/**
	 * @param quizID
	 * @throws IOException
	 */
	void deleteQuiz(QuizID quizID) throws IOException;
	
	/**
	 * 
	 * @param questionID
	 * @return The question identified, or null, if there is no such question.
	 * @throws IOException
	 */
	Question getQuizQuestion(QuestionID questionID) throws IOException;
	
	/**
	 * 
	 * @param quizID
	 * @return A collection of all questions for the given quiz.
	 * @throws IOException
	 */
	Collection<Question> getQuizQuestions(QuizID quizID) throws IOException;
	
	/**
	 * 
	 * @param userID
	 * @param subject
	 * @return A collection of all questions for the given user and subject.
	 * @throws IOException
	 */
	Collection<Question> getUserSubjectQuestions(UserID userID, Subject subject) throws IOException;

	/**
	 * 
	 * @param question
	 * @param answer
	 * @param points The number of points earned by the answer. Must be greater than or equal to zero. Should be less than or equal to the number of points the question is worth.
	 * @param timeAsked 
	 * @return The ID of the generated answer record.
	 * @throws IOException
	 */
	AnswerID saveAnswer(Question question, String answer, ZonedDateTime timeAsked) throws IOException;

	/**
	 * 
	 * @param answerID 
	 * @return The identified answer, or null if there is no answer with the given ID.
	 * @throws IOException
	 */
	Answer getAnswer(AnswerID answerID) throws IOException;

	/**
	 * 
	 * @param questionID 
	 * @return A collection of all answers for the given question.
	 * @throws IOException
	 */
	Collection<Answer> getQuestionAnswers(QuestionID questionID) throws IOException;

	/**
	 * 
	 * @param questionID 
	 * @return The most recent answers for the given question, or null if there is none.
	 * @throws IOException
	 */
	Answer getLatestAnswer(QuestionID questionID) throws IOException;
	
	/**
	 * 
	 * @return A collection of all subjects.
	 * @throws IOException
	 */
	Collection<Subject> getAllSubjects() throws IOException;
}
