package zad2;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Mp3PlayerTest {
	
	private Mp3Player mp3;
	private ArrayList songs = new ArrayList();
	
	private static final double DELTA = 1e-15;

	@Before
	public void setUp() {
		mp3 = new Mp3PlayerMock();
		songs = new ArrayList();
		songs.add("Bill Chase -- Open Up Wide");
		songs.add("Jethro Tull -- Locomotive Breath");
		songs.add("The Boomtown Rats -- Monday");
		songs.add("Carl Orff -- O Fortuna");
	}

	@After
	public void tearDown() {
		mp3 = null;
		songs = null;
	}

	@Test
	public void testPlay() {
		mp3.loadSongs(songs);
		assertNotNull(mp3.currentSong());
		
		mp3.play();
		assertEquals(1, mp3.currentPosition(), DELTA);
		assertEquals(songs.get(0), mp3.currentSong());
		assertTrue(mp3.isPlaying());
		
		mp3.pause();
		assertEquals(1, mp3.currentPosition(), DELTA);
		assertFalse(mp3.isPlaying());
		
		mp3.stop();
		assertEquals(0, mp3.currentPosition(), DELTA);
		assertFalse(mp3.isPlaying());
	}
	
	@Test
	public void testPlayNoList() {
		mp3.play();
		assertEquals(0, mp3.currentPosition(), DELTA);
		assertNull(mp3.currentSong());
		
		mp3.pause();
		assertEquals(0, mp3.currentPosition(), DELTA);
		assertFalse(mp3.isPlaying());
		
		mp3.stop();
		assertEquals(0, mp3.currentPosition(), DELTA);
		assertFalse(mp3.isPlaying());
	}
	
	@Test
	public void testAdvance() {
		mp3.loadSongs(songs);
		int n = songs.size();
		
		mp3.play();
		assertEquals(1, mp3.currentPosition(), DELTA);
		assertEquals(songs.get(0), mp3.currentSong());
		assertTrue(mp3.isPlaying());
		
		mp3.prev();
		assertEquals(1, mp3.currentPosition(), DELTA);
		assertEquals(songs.get(n-1), mp3.currentSong());
		assertTrue(mp3.isPlaying());
		
		mp3.next();
		assertEquals(songs.get(0), mp3.currentSong());
		
		mp3.next();
		assertEquals(songs.get(1), mp3.currentSong());
		
		mp3.prev();
		assertEquals(songs.get(0), mp3.currentSong());
		
		mp3.next();
		assertEquals(songs.get(1), mp3.currentSong());
		
		mp3.next();
		assertEquals(songs.get(2), mp3.currentSong());
		
		mp3.next();
		assertEquals(songs.get(3), mp3.currentSong());
		
		mp3.next();
		assertEquals(1, mp3.currentPosition(), DELTA);
		assertEquals(songs.get(0), mp3.currentSong());
		assertTrue(mp3.isPlaying());
	}

}
