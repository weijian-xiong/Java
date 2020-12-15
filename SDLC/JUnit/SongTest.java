import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;


public class SongTest {
  public static void main(String[] args) {
		System.out.println("Test Song Class.");
  }
  private Song testSong1, testSong2;

  @Before
  public void createTester() {
    testSong1 = new Song("Kadhal Cricket", "Kharesma Ravichandran", 
    "Thani Oruvan", "Cricket.mp3", "Mp3", 214);
    testSong2 = new Song("Kadhal Cricket", "Kharesma Ravichandran", 
    "Thani Oruvan", "Cricket.mp3", "Mp3", 14);
  }
  @Test
  public void testGetName() {
    System.out.println("Running testGetName method(Song class) ...");
    testSong1.setName("Kannala Kannala");
    assertEquals("Song names are equal","Kannala Kannala",testSong1.getName());
  }

  @Test
  public void testGetArtist() {
    System.out.println("Running testGetArtist method(Song class)...");
    testSong1.setArtist("Kaushik Krish");
    assertEquals("Song artists are equal","Kaushik Krish",testSong1.getArtist());
  }

  @Test
  public void testGetAlbum() {
    System.out.println("Running testGetAlbum method(Song class)...");
    testSong1.setAlbum("Thani Oruvan");
    assertEquals("Song albums are equal","Thani Oruvan",testSong1.getAlbum());
  }

  @Test
  public void testGetUrl() {
    System.out.println("Running testGetUrl method(Song class)...");
    testSong1.setUrl("Kannala.mp3");
    assertEquals("Song urls are equal","Kannala.mp3",testSong1.getUrl());
  }

  @Test
  public void testGetFormat() {
    System.out.println("Running testGetFormat method(Song class)...");
    testSong1.setFormat("Mp3");
    assertEquals("Song formats are equal","Mp3",testSong1.getFormat());
  }
  
  @Test
  public void testGetDuration() {
    System.out.println("Running testGetDuration method(Song class)...");
    testSong1.setDuration(300);
    assertEquals("Song durations are equal",300,testSong1.getDuration());
  }

  
  @Test
  public void testIsLong() {
    System.out.println("Running testIsLong method(Song class)...");
    assertEquals("Song is long if length is more than 50",true,testSong1.isLong());
  }

  @Test
  public void testIsLong2() {
    System.out.println("Running testIsLong2 method(Song class)...");
    assertEquals("Song is long if length is not more than 50",false,testSong2.isLong());
  }
}