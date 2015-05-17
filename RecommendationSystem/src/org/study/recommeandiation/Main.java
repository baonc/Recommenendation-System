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
		
		UserProfiles user = new UserProfiles();
		user.readFile();
		User userProfile[] = user.getUserProfiles();
		
		for(int i = 0; i < userProfile.length; i++) {
			System.out.println("ID: " + userProfile[0] + ", gender: " + userProfile[1] + 
					", age: " + userProfile[2] + ", country: " + userProfile[3] + 
					", signup: " + userProfile[4]);
		}
	}
}