import java.io.IOException;
import java.sql.SQLException;

public interface IUnivRepo {
	public Universite GetById(int universityId) throws SQLException;
	public int getNbLivreAutoriser(int universityId) throws SQLException, IOException;
	public int getNbLivreBonus(int universityId) throws SQLException, IOException;
}
