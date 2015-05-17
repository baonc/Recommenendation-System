package org.study.recommeandiation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

/**
 * Class create utility matrix from file userid-timestamp-artid-artname-traid-
 * traname.tsv<br>
 * 
 * @created 16 / 5 / 2015
 * @author baonc
 *
 */
public class UtilityMatrix {
	private Map<String, Integer> utilityHashMap;										  // hash map contain Key: userId:artistId and value: 
																					      // number of trackid on artist id.
	private static final String INPUT_FILE = "data/userid-timestamp-artid-"				  // input file
			+ "artname-traid-traname.tsv";
	
	/**
	 * Getter of utilitiHashMap
	 * 
	 * @return	: utilityHashMap
	 */
	public	Map<String, Integer> getUtilityHashMap() {
		return this.utilityHashMap;
	}

	/**
	 * Function read input file and put data to utilityHashMap.
	 */
	public void generatingUtilityMatrix() {
		this.utilityHashMap = new HashMap<String, Integer>();
		
		try(InputStream in = Files.newInputStream(Paths.get(UtilityMatrix.INPUT_FILE));
				BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
			String line = "";
			String contentArray[];
			StringBuilder userAndArtistId = new StringBuilder();
			StringBuilder trackId = new StringBuilder();
			
			int lineNumber = 0;
			while((line = reader.readLine()) != null) {
				contentArray = line.trim().split("\t");
				userAndArtistId.append(contentArray[0] + ":" + contentArray[2]);
				trackId.append(contentArray[4]);
				
				if(this.utilityHashMap.containsKey(userAndArtistId.toString())) {
					int numberOfTrack = this.utilityHashMap.get(userAndArtistId.
							toString());
					numberOfTrack++;
					this.utilityHashMap.remove(userAndArtistId.toString());
					this.utilityHashMap.put(userAndArtistId.toString(), numberOfTrack);
				} else {
					this.utilityHashMap.put(userAndArtistId.toString(), 1);
				}
				
				lineNumber++;
				System.out.println("Processing line: " + lineNumber);
				
				userAndArtistId.setLength(0);
				trackId.setLength(0);
			}
			
			System.out.println("DONE.");
		} catch(IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	/**
	 * Function test data on utilityHashMap
	 */
	public void test() {
		for(String key : this.utilityHashMap.keySet()) {
			System.out.println(key + ": " + this.utilityHashMap.get(key));
		}
		System.out.println("Size: " + this.utilityHashMap.size());
	}
}