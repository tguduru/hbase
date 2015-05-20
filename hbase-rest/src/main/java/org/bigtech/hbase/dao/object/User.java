package org.bigtech.hbase.dao.object;

/**
 * User pojo
 * 
 * @author Thirupathi Reddy Guduru
 * @date May 20, 2015
 */
public class User {
	private final String userName;
	private final int userId;

	/**
	 * @param userName
	 * @param userId
	 */
	public User(String userName, int userId) {
		super();
		this.userName = userName;
		this.userId = userId;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [userName=" + userName + ", userId=" + userId + "]";
	}

}
