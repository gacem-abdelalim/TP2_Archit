import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
	
public class EtudiantService {
	private IEtudiantRepo etudRepo;
	private IUnivRepo univRepo;
	IJournal affiche;
	
	
	public EtudiantService(IEtudiantRepo etudRepo, IUnivRepo univRepo, IJournal affiche) {
		this.etudRepo = etudRepo;
		this.univRepo = univRepo;
		this.affiche = affiche;
	}
	
	boolean inscription ( int matricule, String nom, String prenom, String email,String pwd, int id_universite ) throws SQLException, IOException {

	    Etudiant stud = new Etudiant(matricule, nom, prenom, email,pwd,id_universite);
	    Universite univ=this.univRepo.GetById(id_universite);
	    
	    affiche.outPut_Msg("Log: debut de l'operation d'ajout de l'etudiant avec matricule "+matricule);
	    
	    if (etudRepo.VerificationMatriculeMail(stud)) {
	    	
	    	return false;
	    }
	    
		 stud.setNbLivreMensuel_Autorise(univRepo.getNbLivreAutoriser(stud.getId_universite()));
		 etudRepo.add(stud);
		 affiche.outPut_Msg("Log: Fin de l'operation d'ajout de l'etudiant avec matricule "+matricule);
		 return true;
	    
		
	}
	
	
	
	
public ArrayList<Etudiant> GetEtudiantParUniversitye()
{	
    //...
	return new ArrayList<>(4);
}	
	
public ArrayList<Etudiant> GetEtudiatparLivreEmprunte()
{   
    //...
	return new ArrayList<>(4);
	
}

    
	
}   
	