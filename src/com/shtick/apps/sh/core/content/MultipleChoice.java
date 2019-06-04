/**
 * 
 */
package com.shtick.apps.sh.core.content;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author scox
 *
 */
public class MultipleChoice extends TypedContent{
	private List<Choice> choices;

	/**
	 * 
	 * @param type
	 * @param content
	 * @param choices
	 */
	public MultipleChoice(String type, String content, List<Choice> choices) {
		super(type, content);
		this.choices =  new ArrayList<>(choices);
	}

	/**
	 * @return the choices
	 */
	public List<Choice> getChoices() {
		return Collections.unmodifiableList(choices);
	}
	
}
