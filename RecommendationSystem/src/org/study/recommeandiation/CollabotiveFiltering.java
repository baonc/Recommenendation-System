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
	 * Getter of user profile
	 * 
	 * @return	: user profile
	 */
	public UserProfiles getUserProfile() {
		return this.userProfile;
	}
	
	/**
	 * Getter of utility matrix
	 * 
	 * @return	: utility matrix
	 */
	public UtilityMatrix getUtilityMarix() {
		return this.utilityMatrix;
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
			}
		}

		return artistOfUser;
	}
	
	/**
	 * Function get neighbour of user<br>
	 * Neighbour is user with distance to user minimum.<br>
	 * 
	 * @param user	: user will be get neighbour
	 * @return		: neighbour of user
	 */
	public User neighborOfUser(User user) {
		HashMap<String, Integer> artistOfUser = getArtistOfUser(user);
		User bestNeighbor = null;
		User userProfile[] = this.userProfile.getUserProfiles();
		double bestDistance = Double.MAX_VALUE;
		
		String userId = user.getUserId();
		for(int i = 0; i < userProfile.length; i++) {
			User candidateUser = userProfile[i];
			String candidateUserId = candidateUser.getUserId();
			if(!userId.equals(candidateUserId)) {
				HashMap<String, Integer> artistOfCandidateUser = getArtistOfUser(
					candidateUser);
				double distance = Distance.EuclideanDistance(artistOfUser, 
						artistOfCandidateUser);
				if(distance < bestDistance) {
					bestDistance = distance;
					bestNeighbor = candidateUser;
				}
			}
			System.out.println("Processing user: " + candidateUserId + ", Best neighbour"
					+ " is: " + bestNeighbor.getUserId() + ", distance: " + bestDistance);
		}
		
		return bestNeighbor;
	}
	
	/**
	 * Function recommendation of a user with its neighbour<br>
	 * 
	 * @param user			: user recommendation.
	 * @param neighbour		: best neighbour of user
	 * @return				: recommendation of user with Key: artistId, Value: number of
	 * 						  time user heard this artist
	 */
	public HashMap<String, Integer> recommendationOfUser(User user, User neighbour) {
		HashMap<String, Integer> recommendation = new HashMap<String, Integer>();
		HashMap<String, Integer> artistOfUser = getArtistOfUser(user);
		HashMap<String, Integer> artistOfNeighbour = getArtistOfUser(neighbour);
		
		for(String key : artistOfNeighbour.keySet()) {
			if(!artistOfUser.containsKey(key)) {
				recommendation.put(key, artistOfNeighbour.get(key));
			}
		}
		
		return recommendation;
	}
	
	public void run(String userId) {
		User users[] = this.userProfile.getUserProfiles();
		boolean flag = false;
		
		for(int i = 0; i < users.length; i++) {
			if(users[i].getUserId().equals(userId)) {
				flag = true;
				User user = users[i];
				User neighbourOfUser = neighborOfUser(user);
				System.out.println("Neighbour of: " + userId + " is: " + neighbourOfUser
						.getUserId());
				HashMap<String, Integer> recommendation = recommendationOfUser(user, 
						neighbourOfUser);
				System.out.println("SIZE: " + recommendation.size());
				for(String key : recommendation.keySet()) {
					System.out.println(key + ": " + recommendation.get(key));
				}
			}
		}
		
	}
}