package org.study.recommeandiation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Class containt users profile in lasf.fm
 * 
 * @author baonc
 *
 */
public class UserProfiles {
	private User userProfiles[];																  // array contain user profile of lasf.fm
	
	private static final String INPUT_FILE = "data/userid-profile.tsv";

	/**
	 * Setter of user array
	 * 
	 * @return	: user array.
	 */
	public User[] getUser() {
		return this.userProfiles;
	}
	
	/**
	 * function read file from input file and set data for user array
	 */
	public void readFile() {
		String line = "";
		String dataArray[];
		this.userProfiles = new User[992];
		StringBuilder userId = new StringBuilder();
		char gender;
		int age;
		StringBuilder country = new StringBuilder();
		StringBuilder signup = new StringBuilder();
		
		try(InputStream in = Files.newInputStream(Paths.get(UserProfiles.INPUT_FILE));
				BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
			int index = 0;
			while((line = reader.readLine()) != null) {
				dataArray = line.split("\t");
				
				userId.append(dataArray[0]);
				gender = dataArray[1].charAt(0);
				if(dataArray[2].equals("")) {
					age = -1;
				} else {
					age = Integer.parseInt(dataArray[2]);
				}
				country.append(dataArray[3]);
				signup.append(dataArray[4]);
				
				User user = new User(userId.toString(), gender, age, country.toString(),
						signup.toString());
				this.userProfiles[index] = user;
			}
		} catch(IOException ioe) {
			ioe.printStackTrace();
		}
	}
}