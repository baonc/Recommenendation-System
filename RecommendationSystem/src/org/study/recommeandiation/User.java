package org.study.recommeandiation;

/**
 * Class containt user information
 * 
 * @created 17 / 5 / 2015
 * @author baonc
 *
 */
public class User {
	private String userId;																  // user id
	private char gender;																  // gender of user
	private String age;																	  // age of user
	private String country;																  // country of user
	private String signup;																  // time signup
	
	/**
	 * Constructor constructing a user
	 * 
	 * @param userId	: user id
	 * @param gender	: gender of user
	 * @param age		: age of user
	 * @param coutry	: contry of user
	 * @param signup	: date signup of user
	 */
	public User(String userId, char gender, String age, String coutry, String signup) {
		this.userId = userId;
		this.gender = gender;
		this.age = age;
		this.country = coutry;
		this.signup = signup;
	}
	
	/**
	 * Setter of userid
	 * @param userID	: user id
	 */
	public void setUserId(String userID) {
		this.userId = userID;
	}
	
	/**
	 * Setter of user id
	 * 
	 * @return	: user id of this instance
	 */
	public String getUserId() {
		return this.userId;
	}
	
	/**
	 * Getter of gender
	 * 
	 * @param gender	: gender for this instance
	 */
	public void setGender(char gender) {
		this.gender = gender;
	}
	
	/**
	 * Getter of gender of this instance
	 * 
	 * @return	: gender of this instance
	 */
	public char getGender() {
		return this.gender;
	}
	
	/**
	 * Setter of age of this instance
	 * 
	 * @param age	: age of this instance
	 */
	public void setAge(String age) {
		this.age = age;
	}
	
	/**
	 * Getter of age of this instance
	 * 
	 * @return	: age of this instance
	 */
	public String getAge() {
		return this.age;
	}
	
	/**
	 * Setter of country
	 * 
	 * @param country	: country will be setted
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	
	/**
	 * Getter of country
	 * 
	 * @return	: country of this instance
	 */
	public String getCountry() {
		return this.country;
	}
	
	/**
	 * Setter of date signup
	 * @param signup	: signup will be setted
	 */
	public void setSignup(String signup) {
		this.signup = signup;
	}
	
	/**
	 * Getter of date sign up
	 * 
	 * @return	: signup of this instance
	 */
	public String getSignup() {
		return this.signup;
	}
}