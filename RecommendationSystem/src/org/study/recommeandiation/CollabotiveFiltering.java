package org.study.recommeandiation;

import java.util.HashMap;

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
	
	/**
	 * Class get top NUMBER_NEIGHBOURS of a user
	 * 
	 * @param user	: user
	 * @return		: index of top neighbours in userProfile
	 */
	public int[] topNeighbourOfUser(User user) {
		int neighbour[] = new int[CollabotiveFiltering.NUMBER_NEIGHBOURS];
		// do not done.
		return neighbour;
	}
	
	/**
	 * Function get artistid of user
	 * 
	 * @param user	: user will be get artist
	 * @return		: list artist of user<br>
	 * <li> Format: HashMap<ArtistID, NumberOfSongUser heard>
	 */
	public HashMap<String, Integer> getArtistOfUser(User user) {
		HashMap<String, Integer> artistOfUser = new HashMap<String, Integer>();
		String userId = user.getUserId();
		HashMap<String, Integer> utilityHashMap = this.utilityMatrix.getUtilityHashMap();
		String processException;
		
		for(String key : utilityHashMap.keySet()) {
			processException = key + ":$";
			String userIdAndArtistId[] = processException.split(":");
			if(userId.equals(userIdAndArtistId[0])) {
				artistOfUser.put(userIdAndArtistId[1], utilityHashMap.get(key));
				//System.out.println(key + ": " + utilityHashMap.get(key));
			}
		}

		return artistOfUser;
	}
}