package zad2;

import java.util.ArrayList;

public class Mp3PlayerMock implements Mp3Player {
	
	private ArrayList songs;
	private int currentSongId;
	private int songTime;
	private boolean isPlayed = false;

	@Override
	public void play() {
		if(songs != null){
			songTime = 1;
			isPlayed = true;
		}
	}

	@Override
	public void pause() {
		isPlayed = false;
	}

	@Override
	public void stop() {
		songTime = 0;
		isPlayed = false;
	}

	@Override
	public double currentPosition() {
		return songTime;
	}

	@Override
	public String currentSong() {
		if(songs == null)
			return null;
		
		return (String) songs.get(currentSongId);
	}

	@Override
	public void next() {
		if(currentSongId == songs.size() -1)
			currentSongId = 0;
		else
			currentSongId++;
		
		songTime = 0;
		play();
	}

	@Override
	public void prev() {
		if(currentSongId == 0)
			currentSongId = songs.size() -1;
		else
			currentSongId--;
		
		songTime = 0;
		play();
	}

	@Override
	public boolean isPlaying() {
		return isPlayed;
	}

	@Override
	public void loadSongs(ArrayList names) {
		songs = names;
	}

}
