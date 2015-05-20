package org.study.recommeandiation;



/**
 * Class run/test program
 * 
 * @created 16 / 5 / 2015
 * @author baonc
 *
 */
public class Main {
	public static void main(String args[]) {
		/*UtilityMatrix uti = new UtilityMatrix();
		uti.generatingUtilityMatrix();
		uti.test();*/
		/*String testString = "a		b";
		String testSplit[] = testString.split("\t");
		
		for(int i = 0; i < testSplit.length; i++) {
			System.out.println("\"" + testSplit[i] + "\"");
		}*/
		
		CollabotiveFiltering collabotiveFiltering = new CollabotiveFiltering();
		collabotiveFiltering.run("user_000993");
		/*UserProfiles user = collabotiveFiltering.getUserProfile();
		User userProfile[] = user.getUserProfiles();
		HashMap<String, Integer> artistOfUser = collabotiveFiltering.
				getArtistOfUser(userProfile[2]);
		HashMap<String, Integer> artistOfUser1 = collabotiveFiltering.
				getArtistOfUser(userProfile[1]);
		double distance = Distance.EuclideanDistance(artistOfUser, artistOfUser1);
		System.out.println("Euclidian distance of user 1 and user2: " + distance);

		User neighbor = collabotiveFiltering.neighborOfUser(userProfile[2]);
		System.out.println("Neighbour: " + neighbor.getUserId());
		HashMap<String, Integer> recommendation = collabotiveFiltering.
				recommendationOfUser(userProfile[2], neighbor);
		System.out.println("Recommendation for user 1");
		System.out.println("SIZE: " + recommendation.size());
		for(String key : recommendation.keySet()) {
			System.out.println(key + ": " +  recommendation.get(key));
		}*/

		/*for(int i = 0; i < userProfile.length; i++) {
			System.out.println("ID: " + userProfile[i].getUserId() + ", gender: " 
		+ userProfile[i].getGender() + ", age: " + userProfile[i].getAge() + 
		", country: " + userProfile[i].getCountry() + ", signup: " + userProfile[i].
		getSignup());
		}*/
		
		/*String test = "user_000030					c";
		String arr[] = test.split("\t");
		System.out.println(arr.length);
		for(int i = 0; i < arr.length; i++) {
			System.out.println("\"" + arr[i] + "\"");
		}*/
	}
}