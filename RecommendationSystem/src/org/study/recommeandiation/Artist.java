package org.study.recommeandiation;

import java.util.Set;

/**
 * Class containt information of a artist
 * 
 * @created 19 / 5 / 2015
 * @author baonc
 *
 */
public class Artist {
	private String artistId;															  // artist id
	private String artistName;															  // artist name
	private Set<String> trackList;													  	  // track list of artist 
	
	/**
	 * Constructor create an artist
	 * 
	 * @param artistId		: id of artist
	 * @param artistName	: name of artist
	 * @param trackList		: track list of artist
	 */
	public Artist(String artistId, String artistName, Set<String> trackList) {
		this.artistId = artistId;
		this.artistName = artistName;
		this.trackList = trackList;
	}
	
	/**
	 * Setter of artistId
	 * 
	 * @param artistId	: id of artist
	 */
	public void setArtistId(String artistId) {
		this.artistId = artistId;
	}
	
	/**
	 * Getter of artistId
	 * @return	: id of artist
	 */
	public String getArtistId() {
		return this.artistId;
	}
	
	/**
	 * Setter of artistName
	 * 
	 * @param artistName	: name of artist
	 */
	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}
	
	/**
	 * Getter of artistName
	 * 
	 * @return	: name of artist
	 */
	public String getArtistName() {
		return this.artistName;
	}
	
	/**
	 * Setter of trackList
	 * 
	 * @param trackList		: track list of an artist
	 */
	public void setTrackList(Set<String> trackList) {
		this.trackList = trackList;
	}
	
	/**
	 * Getter of track list
	 * 
	 * @return	: track list of an artist
	 */
	public Set<String> getTrackList() {
		return this.trackList;
	}
}
