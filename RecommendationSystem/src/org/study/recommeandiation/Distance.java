package org.study.recommeandiation;

import java.util.HashMap;

/**
 * Class calculating distance of two user
 * 
 * @created 18 / 5 / 2015
 * @author baonc
 *
 */
public class Distance {
	
	/**
	 * Function using euclidean distance to calculating distance of two user<br>
	 * 
	 * @param user1	: artist of user 1
	 * @param user2	: artist of user 2
	 * @return		: euclidean distance of two user
	 */
	public static double EuclideanDistance(HashMap<String, Integer> user1, 
			HashMap<String, Integer> user2) {
		double distance = 0;
		
		for(String artistOfUser1 : user1.keySet()) {
			if(user2.containsKey(artistOfUser1)) {
				distance += (user2.get(artistOfUser1) - user1.get(artistOfUser1)) * 
						(user2.get(artistOfUser1) - user1.get(artistOfUser1));
			}
		}
		distance = Math.sqrt(distance);
		
		return distance;
	}
}