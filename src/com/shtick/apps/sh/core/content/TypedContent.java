/**
 * 
 */
package com.shtick.apps.sh.core.content;

/**
 * @author scox
 *
 */
public class TypedContent {
	private String type;
	private String content;
	
	/**
	 * 
	 * @param type
	 * @param content
	 */
	public TypedContent(String type, String content) {
		super();
		this.type = type;
		this.content = content;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}
}
