/**
 * 
 */
package com.shtick.apps.sh.core;

/**
 * 
 * @author sean.cox
 *
 */
public class AnswerID {
	private String id;

	/**
	 * @param id
	 */
	public AnswerID(String id) {
		super();
		this.id = id;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof AnswerID))
			return false;
		AnswerID other = (AnswerID)obj;
		return this.id.equals(other.id);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return this.id.hashCode();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.id;
	}
}
