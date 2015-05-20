package org.study.recommeandiation;

import static java.nio.file.StandardOpenOption.CREATE;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 * Class create utility matrix from file userid-timestamp-artid-artname-traid-
 * traname.tsv<br>
 * 
 * @created 16 / 5 / 2015
 * @author baonc
 *
 */
public class UtilityMatrix {
	private HashMap<String, Integer> utilityHashMap;									  // hash map contain Key: userId:artistId and value: 
																					      // number of trackid on artist id.
	private ArrayList<Artist> artistList;												  // array list containt track of a artist

	private static final String INPUT_FILE = "data/userid-timestamp-artid-"				  // input file
			+ "artname-traid-traname.tsv";
	
	/**
	 * Getter of utilitiHashMap
	 * 
	 * @return	: utilityHashMap
	 */
	public	HashMap<String, Integer> getUtilityHashMap() {
		return this.utilityHashMap;
	}

	/**
	 * Getter of artist list
	 * 
	 * @return	: artist list
	 */
	public ArrayList<Artist> getArtistList() {
		return this.artistList;
	}

	/**
	 * Function read input file and put data to utilityHashMap.
	 */
	public void generatingUtilityMatrix() {
		this.utilityHashMap = new HashMap<String, Integer>();
		this.artistList = new ArrayList<Artist>();
		
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
			reader.close();
			in.close();
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
	
	/**
	 * Function write artist - track to file<br>
	 * File name: artist_track
	 */
	public void writeArtistTrackLis() {
		Path file = Paths.get("data/artist_track");
		
		try(OutputStream out = new BufferedOutputStream(Files.newOutputStream(file, 
				CREATE))) {
			for(int i = 0; i < this.artistList.size(); i++) {
				out.write(this.artistList.get(i).getArtistId().getBytes());
				out.write("\t".getBytes());
				out.write(this.artistList.get(i).getArtistName().getBytes());
				out.write("\t".getBytes());
				Set<String> trackSet = this.artistList.get(i).getTrackList();
				for(String track : trackSet) {
					out.write(track.getBytes());
					out.write(" ".getBytes());
				}
				out.write("\n".getBytes());
				System.out.println("Writing line: " + i);
			}
		} catch(IOException ioe) {
			ioe.printStackTrace();
		}
		
		this.artistList = null;
	}
}