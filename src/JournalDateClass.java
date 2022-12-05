import java.text.SimpleDateFormat;  
import java.util.Date;
public class JournalDateClass extends IJournal{
	
	@Override
	public void outPut_Msg(String message) {
		String className = Thread.currentThread().getStackTrace()[3].getClassName();
	    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
	    Date date = new Date();
	    System.out.println(formatter.format(date) + " - " + className + " - " + message);  
		
		
	}

}
