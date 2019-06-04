/**
 * 
 */
package com.shtick.apps.sh.core;

/**
 * @author sean.cox
 *
 */
public class QuestionDimension {
	private String id;
	private double value;
	private String description;
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return the value
	 */
	public double getValue() {
		return value;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param id
	 * @param value
	 * @param description
	 */
	public QuestionDimension(String id, double value, String description) {
		super();
		this.id = id;
		this.value = value;
		this.description = description;
	}
}
