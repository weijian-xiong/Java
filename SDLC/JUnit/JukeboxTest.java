import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;


public class JukeboxTest {
  public static void main(String[] args) {
		System.out.println("Test Jukebox Class.");
  }
  private Song song1,song2,song3,song4;
  List<Song> tempSongList;
  Database tempDB;
  Jukebox jukeboxTester;

  @Before
  public void createTester() {
  song1=new Song("Kadhal Cricket", "Kharesma Ravichandran", 
				"Thani Oruvan", "Cricket.mp3", "Mp3", 214);
	song2=new Song("Kannala Kannala", "Kaushik Krish", 
				"Thani Oruvan", "Kannala.mp3", "Mp3", 215);
	song3=new Song("Kadhal Cricket", "Kharesma Ravichandran",
				"Thani Oruvan", "Cricket.mp3", "Mp3", 214);
	tempSongList= new ArrayList<Song>();
	tempSongList.add(song1);
	tempSongList.add(song2);
	tempSongList.add(song3);
		
	tempDB= new Database(tempSongList);
	jukeboxTester= new Jukebox(tempDB, 123456789);
  }
    
  @Test
  public void testIsValidCreditCard() {
    System.out.println("Running testIsValidCreditCard method(Jukebox class)...");
    assertEquals("Credit card is valid if it is not negative number",true,jukeboxTester.isValidCreditCard());
  }
  
  @Test
  public void testGetCreditCard() {
    System.out.println("Running testGetCreditCard method(Jukebox class)...");
    assertEquals("Get Credit card number",123456789,jukeboxTester.getCreditCard());
  }
}