import dao.DatabaseHandler;
import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;

public class DaoUT {
    @Test
    public void testDbConnection() throws SQLException, ClassNotFoundException {
        DatabaseHandler handler = new DatabaseHandler();
        Assert.assertNotNull(handler.getDbConnection());
    }

}
