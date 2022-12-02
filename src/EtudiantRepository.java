
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class EtudiantRepository implements IEtudiantRepo {
	IJournal affiche;
	private IDBConnection BD;
	
	public EtudiantRepository(IJournal affiche) {
		this.affiche = affiche;
	}
	
	@Override
	public void add(Etudiant E) throws SQLException
	{
		
		BD= (DBConnection) DBConnection.getDBConnection();
		Connection connect=BD.getConn();
		
		
		Statement stmt = connect.createStatement();
		String sql = "INSERT into etudiant values (" + E.getMatricule() + ",'" + E.getNom() + "','" + E.getPrenom() + "','" + E.getEmail() + "'," +E.getNbLivreMensuel_Autorise() + "," +E.getNbLivreEmprunte() + "," +E.getId_universite()+")";
		int rs = stmt.executeUpdate(sql);
		 
		if (rs == 1){
				affiche.outPut_Msg(("log : ajout dans la BD r�ussi de l'etudiant  du Matricule" + E.getMatricule()));;
			}else if (rs == 0){
				affiche.outPut_Msg("log : Echec de l'ajout dans la BD de l'etudiant  du Matricule" + E.getMatricule());
			}
		connect.close();
	}

	@Override
	public boolean Exists(String email) throws SQLException	
	{
		BD= (DBConnection) DBConnection.getDBConnection();
		
		Connection connect=BD.getConn();
		
		Statement stmt = connect.createStatement();
		String sql = "select * from etudiant where email='"+ email+"'";
		boolean rs = stmt.executeQuery(sql).next();
		
		if (rs){
			affiche.outPut_Msg("logBD--- :email existe dans la BD  " + email);
			connect.close();
			return true;
			}
		affiche.outPut_Msg("logBD--- : email n'existe pas " + email);	
		connect.close();
		return false;
	}
	@Override
	public boolean Exists(int mat) throws SQLException	
	{
		BD = (DBConnection) DBConnection.getDBConnection();
		Connection connect=BD.getConn();
		
		Statement stmt = connect.createStatement();
		String sql = "select * from etudiant where matricule="+ mat;
		boolean rs = stmt.executeQuery(sql).next();
		
		if (rs){
			affiche.outPut_Msg("logBD--- :etudiant avec ce matricule existe deja dans la BD  " + mat);
			connect.close();
			return true;
			}
		affiche.outPut_Msg("logBD----: etudiant avec ce matricule n'existe pas " + mat);	
		connect.close();
		return false;
	}
	
	@Override
	public boolean VerificationMatriculeMail(Etudiant etud) throws SQLException {
		String email = etud.getEmail();
		boolean existMat = Exists(etud.getMatricule());
		boolean existmail = Exists(email);
		boolean veriFormatMail = ((email == null) || (email.length() == 0));
		return (existMat || existmail || veriFormatMail);
		
	}
	
}
