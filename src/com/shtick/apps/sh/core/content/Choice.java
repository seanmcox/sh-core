/**
 * 
 */
package com.shtick.apps.sh.core.content;

/**
 * @author scox
 *
 */
public class Choice extends TypedContent{
	private String value;

	/**
	 * 
	 * @param type
	 * @param content
	 * @param value
	 */
	public Choice(String type, String content, String value) {
		super(type, content);
		this.value =  value;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}
	
}
