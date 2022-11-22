import java.sql.SQLException;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IEtudiantRepo etudRepo = new EtudiantRepository();
		IUnivRepo univRepo = new UniversiteRepository();

		EtudiantService serv= new EtudiantService(etudRepo, univRepo);
		try {
			serv.inscription(2, "alim", "gacem", "guene@gmail.com","xxxx", 123);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
