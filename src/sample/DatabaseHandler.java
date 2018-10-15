package sample;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class DatabaseHandler extends Configs {
Connection dbConnection;
    public Connection getDbConnection()
            throws SQLException, ClassNotFoundException {
        String connectionString = "jdbc:postgresql://"+ dbHost + ":" + dbPort + "/" + dbName;

        Class.forName("org.postgresql.Driver") ;

        dbConnection = DriverManager.getConnection(connectionString, dbUsername, dbPassword);
        if (dbConnection != null) {
            System.out.println("You successfully connected to database now");
        } else {
            System.out.println("Failed to make connection to database");
        }
   return dbConnection;

    }
public void signUpUser(Users user){
        String insert = "INSERT INTO " + Const.USER_TABLE + "(" + Const.USERS_FIRSTNAME + "," + Const.USERS_LASTTNAME + "," + Const.USERS_USERNAME + "," + Const.USERS_PASSWORD +"," + Const.USERS_GENDER + "," + Const.USERS_COUNTRY + ")" +
         "VALUES(?,?,?,?,?,?)";


    try {
        PreparedStatement prSt = getDbConnection().prepareStatement(insert);
        prSt.setString(1, user.getFirstname());
        prSt.setString(2, user.getLasttname());
        prSt.setString(3, user.getUsername());
        prSt.setString(4, user.getPassword());
        prSt.setString(5, user.getGender());
        prSt.setString(6, user.getCountry());
        prSt.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    catch (ClassNotFoundException e){
        e.printStackTrace();
    }
}

public ResultSet getUser(Users user){
        ResultSet res = null;

        String select = "SELECT * FROM " + Const.USER_TABLE + " WHERE " + Const.USERS_USERNAME + "=? AND " +  Const.USERS_PASSWORD + "=?";
    try {
        PreparedStatement prSt = getDbConnection().prepareStatement(select);

        prSt.setString(1, user.getUsername());
        prSt.setString(2, user.getPassword());

        res = prSt.executeQuery();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    catch (ClassNotFoundException e){
        e.printStackTrace();
    }
    return  res;
}
}
