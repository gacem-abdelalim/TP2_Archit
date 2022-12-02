
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UniversiteRepository implements IUnivRepo{
	private IDBConnection BD;
	IJournal affiche;
	public UniversiteRepository(IJournal affiche) {
		this.affiche = affiche;
	}
	
	@Override
	public Universite GetById(int universityId) throws SQLException {
		
		BD= (DBConnection) DBConnection.getDBConnection();
		Connection connect=BD.getConn();
		Statement stmt = connect.createStatement();
		affiche.outPut_Msg("LogBD : d�but recherche de id universit� dans la base de donn�e");
		
		String sql = "select * from universite where id_universite="+ universityId;
		ResultSet rs = stmt.executeQuery(sql);
		rs.next();
		TypePackage p=TypePackage.valueOf(rs.getString(3));
		Universite u = new Universite (rs.getInt(1),rs.getString(2),p);
			
		affiche.outPut_Msg("LogBD : universite recupere");
		
		connect.close();
		return u;	
		
		
	}
	
	@Override
	public int getNbLivreAutoriser(int universityId) throws SQLException, IOException{
		Universite univ=this.GetById(universityId);
		if (univ.getPack() == TypePackage.Standard)
	     {
			  
	          return 10;
	     }
	     else if (univ.getPack() == TypePackage.Premium)
	     {
	    	 return 20;
	     }
		return 0;
	}
		
	@Override
	public int getNbLivreBonus(int universityId) throws SQLException, IOException{
		Universite univ=this.GetById(universityId);
		if (univ.getPack() == TypePackage.Standard)
	     {
			  
	          return 5;
	     }
	     else if (univ.getPack() == TypePackage.Premium)
	     {
	    	 return 10;
	     }
	return 0;
	}
	
	
	
	
}
