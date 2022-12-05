import java.io.IOException;
import java.sql.SQLException;

public interface IUnivRepo {
	public Universite GetById(int universityId) throws SQLException;

}
