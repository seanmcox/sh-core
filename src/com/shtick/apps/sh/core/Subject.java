/**
 * 
 */
package com.shtick.apps.sh.core;

/**
 * 
 * @author sean.cox
 *
 */
public class Subject {
	private String id;

	/**
	 * @param id A string of the format [alphanum](.[alphanum])*
	 */
	public Subject(String id) {
		super();
		if(!id.matches("[a-zA-Z0-9]+(\\.[a-zA-Z0-9]+)*"))
			throw new IllegalArgumentException("Invalid subject identifier format.");
		this.id = id;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Subject))
			return false;
		Subject other = (Subject)obj;
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
