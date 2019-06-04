/**
 * 
 */
package com.shtick.apps.sh.core;

/**
 * @author sean.cox
 *
 */
public class UserID {
	private String id;

	/**
	 * @param id
	 */
	public UserID(String id) {
		super();
		this.id = id;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof UserID))
			return false;
		UserID other = (UserID)obj;
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
