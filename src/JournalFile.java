import java.io.*;

public class JournalFile extends IJournal{

	@Override
	public void outPut_Msg(String message) {
		File myObj = new File("filename.txt");

	    try {
	        FileWriter myWriter = new FileWriter(myObj, true);
	        myWriter.write(message+"\n");
	        myWriter.close();
	        System.out.println("Successfully wrote to the file.");
	      } catch (IOException e) {
	        System.out.println("An error occurred.");
	        e.printStackTrace();
	      }
		      
		      
		
	}

}
