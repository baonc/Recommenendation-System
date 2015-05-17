package org.study.recommeandiation;

/**
 * Recommendation System using collabotive filtering<br>
 * 
 * @created 17 / 5 / 2015
 * @author baonc
 *
 */
public class CollabotiveFiltering {
	private UtilityMatrix utilityMatrix;												  // utility matrix
	private UserProfiles userProfile;													  // user profile
	
	private static final int NUMBER_NEIGHBOURS = 20;									  // number of neighbour of user

	/**
	 * Constructor read data for utilityMatrix and userProfile
	 */
	public CollabotiveFiltering() {
		this.utilityMatrix = new UtilityMatrix();
		this.utilityMatrix.generatingUtilityMatrix();
		this.userProfile = new UserProfiles();
		this.userProfile.readFile();
	}
	
	
}
