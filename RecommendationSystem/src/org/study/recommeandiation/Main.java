package org.study.recommeandiation;

import java.util.HashMap;

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
		
		UserProfiles user = new UserProfiles();
		user.readFile();
		User userProfile[] = user.getUserProfiles();
		CollabotiveFiltering collabotiveFiltering = new CollabotiveFiltering();
		HashMap<String, Integer> artistOfUser = collabotiveFiltering.getArtistOfUser(userProfile[2]);
		for(String key : artistOfUser.keySet()) {
			System.out.println(key + ": " + artistOfUser.get(key));
		}
		System.out.println("SIZE:" + artistOfUser.size());

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