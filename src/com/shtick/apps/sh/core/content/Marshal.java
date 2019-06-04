/**
 * 
 */
package com.shtick.apps.sh.core.content;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.shtick.apps.sh.core.QuizDesignSubject;
import com.shtick.apps.sh.core.Subject;
import com.shtick.utils.data.json.JSONDecoder;

/**
 * @author scox
 *
 */
public class Marshal {
	/**
	 * 
	 * @param multipleChoice
	 * @return A Map representing the provided MultipleChoice.
	 */
	public static Map<String,Object> marshal(MultipleChoice multipleChoice) {
		Map<String,Object> retval = marshal((TypedContent)multipleChoice);
		List<Choice> unmarshalledChoices = multipleChoice.getChoices();
		ArrayList<Map<String,Object>> marshalledChoices = new ArrayList<>(unmarshalledChoices.size());
		for(Choice choice:unmarshalledChoices)
			marshalledChoices.add(marshal(choice));
		retval.put("choices", marshalledChoices);
		return retval;
	}
	
	/**
	 * 
	 * @param json
	 * @return A MultipleChoice instance based on the encoded JSON form provided.
	 * @throws IllegalArgumentException
	 */
	public static MultipleChoice unmarshalMultipleChoice(String json) throws IllegalArgumentException{
		Object jsonDecoded = JSONDecoder.decode(json, null);
		if(!(jsonDecoded instanceof Map<?,?>))
			throw new IllegalArgumentException("JSON did not encode an object.");
		return unmarshalMultipleChoice((Map<String,Object>)jsonDecoded);
	}

	/**
	 * 
	 * @param map
	 * @return A MultipleChoice instance based on the Map provided.
	 * @throws IllegalArgumentException
	 */
	public static MultipleChoice unmarshalMultipleChoice(Map<String,Object> map) throws IllegalArgumentException{
		Object promptTypeValue = map.get("type");
		Object promptContentValue = map.get("content");
		Object choicesValue = map.get("choices");
		if(!(promptTypeValue instanceof String))
			throw new IllegalArgumentException("type not found or recognized as valid");
		if(!(promptContentValue instanceof String))
			throw new IllegalArgumentException("content not found or recognized as valid");
		if(!(choicesValue instanceof List<?>))
			throw new IllegalArgumentException("choices not found or recognized as valid");
		if(((List<?>)choicesValue).size()<=0)
			throw new IllegalArgumentException("no choices provided");
		List<Choice> choices;
		choices = new ArrayList<>(((List<?>)choicesValue).size());
		for(Object object:(List<?>)choicesValue) {
			if(!(object instanceof Map<?,?>))
				throw new IllegalArgumentException("choice found but is not a map");
			choices.add(unmarshalChoice((Map<String,Object>)object));
		}
		return new MultipleChoice((String)promptTypeValue, (String)promptContentValue, choices);
	}

	/**
	 * 
	 * @param choice
	 * @return A Map representing the provided Choice.
	 */
	public static Map<String,Object> marshal(Choice choice) {
		Map<String,Object> retval = marshal((TypedContent)choice);
		retval.put("value", choice.getValue());
		return retval;
	}

	/**
	 * 
	 * @param map
	 * @return A Choice instance based on the Map provided.
	 * @throws IllegalArgumentException
	 */
	public static Choice unmarshalChoice(Map<String,Object> map) throws IllegalArgumentException{
		Object promptTypeValue = map.get("type");
		Object promptContentValue = map.get("content");
		Object value = map.get("value");
		if(!(promptTypeValue instanceof String))
			throw new IllegalArgumentException("type not found or recognized as valid");
		if(!(promptContentValue instanceof String))
			throw new IllegalArgumentException("content not found or recognized as valid");
		if(!(value instanceof String))
			throw new IllegalArgumentException("value not found or recognized as valid");
		return new Choice((String)promptTypeValue, (String)promptContentValue, (String)value);
	}

	/**
	 * 
	 * @param typedContent
	 * @return A Map representing the provided TypedContent.
	 */
	public static Map<String,Object> marshal(TypedContent typedContent) {
		HashMap<String,Object> retval = new HashMap<>();
		retval.put("type", typedContent.getType());
		retval.put("content", typedContent.getContent());
		return retval;
	}

	/**
	 * 
	 * @param map
	 * @return A TypedContent instance based on the Map provided.
	 * @throws IllegalArgumentException
	 */
	public static TypedContent unmarshalTypedContent(Map<String,Object> map) throws IllegalArgumentException{
		Object promptTypeValue = map.get("type");
		Object promptContentValue = map.get("content");
		if(!(promptTypeValue instanceof String))
			throw new IllegalArgumentException("type not found or recognized as valid");
		if(!(promptContentValue instanceof String))
			throw new IllegalArgumentException("content not found or recognized as valid");
		return new TypedContent((String)promptTypeValue, (String)promptContentValue);
	}
	
	/**
	 * 
	 * @param quizDesignSubject
	 * @return A Map representing the provided QuizDesignSubject.
	 */
	public static Map<String,Object> marshal(QuizDesignSubject quizDesignSubject){
		HashMap<String,Object> retval = new HashMap<>();
		retval.put("subject", quizDesignSubject.getSubject().toString());
		retval.put("min", quizDesignSubject.getMinQuestions());
		retval.put("max", quizDesignSubject.getMaxQuestions());
		return retval;
	}
	
	/**
	 * 
	 * @param map
	 * @return A QuizDesignSubject instance based on the Map provided.
	 */
	public static QuizDesignSubject unmarshalQuizDesignSubject(Map<String,Object> map) {
		return new QuizDesignSubject(new Subject(map.get("subject").toString()), ((Number)map.get("min")).intValue(), ((Number)map.get("max")).intValue());
	}
}
