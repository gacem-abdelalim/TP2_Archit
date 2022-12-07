import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MainApp {

	public static void main(String[] args) {
		
		IJournal journal1 = new JournalDateClass();
		IJournal journal2 = new JournalEcran();
		IJournal journal3 = new JournalFile();
		
		List<IJournal> listJournal =new ArrayList<IJournal>();
		listJournal.add(journal2);
		listJournal.add(journal1);
		listJournal.add(journal3);
		IJournal affiche = new AfficheMessage(listJournal);
		IEtudiantRepo etudRepo = new EtudiantRepository(affiche);
		IUnivRepo univRepo = new UniversiteRepository(affiche);
		

		EtudiantService serv= new EtudiantService(etudRepo, univRepo, affiche);
		try {
			serv.inscription(4244, "alfimwjhzz", "gabnzcefzxm", "guenvenzzf@xgmail.com","xxxx", 123);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}