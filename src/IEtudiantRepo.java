import java.sql.SQLException;

public interface IEtudiantRepo {
	
	void add(Etudiant E) throws SQLException;
	
	boolean Exists(String email) throws SQLException;
	
	boolean Exists(int mat) throws SQLException;
	public boolean VerificationMatriculeMail(Etudiant etud) throws SQLException;
	

}

