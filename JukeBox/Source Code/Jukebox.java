import java.util.ArrayList;
import java.util.List;

public class Jukebox {
	Database db;
	int creditCard;
	public Jukebox(){
		
	}
	public Jukebox(Database db, int creditCard) {
		super();
		this.db = db;
		this.creditCard = creditCard;
	}	
	public Database getDb() {
		return db;
	}
	public void setDb(Database db) {
		this.db = db;
	}
	public int getCreditCard() {
		return creditCard;
	}
	public void setCreditCard(int creditCard) {
		this.creditCard = creditCard;
	}
	public boolean isValidCreditCard(){
		if(creditCard>0)
			return true;
		else
			return false;
	}
	void play(int i) {
		   Song song=db.getSongList(i);
		   song.play();
	}
	void play() {
	   for (int index=0;index<db.getSongList().size();index++)
	   {
	      Song song=db.getSongList(index);
	      trace("Currently Playing :"+song.getName());
	      song.play();
	      
	   }
	}
	private void trace(String s){
		System.out.println(s);
	}
	
	
	public static void main(String[] args){
		Song song1=new Song("Kadhal Cricket", "Kharesma Ravichandran", 
				"Thani Oruvan", "Cricket.mp3", "Mp3", 214);
		Song song2=new Song("Kannala Kannala", "Kaushik Krish", 
				"Thani Oruvan", "Kannala.mp3", "Mp3", 215);
		Song song3=new Song("Kadhal Cricket", "Kharesma Ravichandran",
				"Thani Oruvan", "D://Cricket.mp3", "Mp3", 214);
		List<Song> tempSongList= new ArrayList<Song>();
		tempSongList.add(song1);
		tempSongList.add(song2);
		tempSongList.add(song3);
		
		Database tempDB= new Database(tempSongList);
		Jukebox juke= new Jukebox(tempDB, 123456777);
		
		System.out.println("Validity of CC : "+juke.isValidCreditCard());
		juke.getDb().toString();

		System.out.println("\nDeleting Song @ index 2");
		juke.getDb().removeSong(2);
		juke.getDb().toString();
		
		System.out.println("Playing the SongList");
		juke.play();
		
		System.out.println("Playing Song @ index 2");
		juke.play(2);
		
	}	
}
