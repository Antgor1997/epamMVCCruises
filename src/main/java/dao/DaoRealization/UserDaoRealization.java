package dao.DaoRealization;

import Models.User;
import dao.UserDao;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDaoRealization implements UserDao {

    /**
     * Logger for this class
     */
    private static final Logger LOGGER = LogManager.getLogger(UserDaoRealization.class);

    /**
     * QueryExecutor instance
     *
     * @see QueryExecutor
     */
    private QueryExecutor executor = QueryExecutor.getInstance();

    /**
     * SQL queries
     */
    private static final String FIND_USER =
            "SELECT passenger.id_client, passenger.name, passenger.login, passenger.password" +
                    "FROM passenger \n" +
                    "WHERE passenger.login = ? AND passenger.password = ?;";
    private static final String FIND_MAIN_ADMIN =
            "SELECT mainadmin.idMainAdmin, mainadmin.name, mainadmin.login, mainadmin.password, mainadmin.specialPassword" +
                    "FROM mainadmin \n" +
                    "WHERE mainadmin.login = ? AND mainadmin.password = ?;";
    private static final String FIND_SHIP_ADMIN =
            "SELECT shipadmin.idShipAdmin, shipadmin.name, shipadmin.login, shipadmin.password, shipadmin.idShip" +
                    "FROM shipadmin \n" +
                    "WHERE shipadmin.login = ? AND shipadmin.password = ?;";


    public User findByLoginAndPassword(String login, String password) {
        User user = null;
        if (login != null && password != null) {
            try {
                ResultSet rs = executor.getResultSet(FIND_USER, login, password);
                if (rs.next()) {
                    user = createEntity(rs, "passenger");
                }else {
                    rs = executor.getResultSet(FIND_SHIP_ADMIN, login, password);
                    if (rs.next()) {
                        user = createEntity(rs, "ship_admin");
                        System.out.println("Ship admin identified");
                    }else {
                        rs = executor.getResultSet(FIND_MAIN_ADMIN, login, password);
                        if (rs.next()) {
                            user = createEntity(rs, "main_admin");
                        }
                    }
                }
            } catch (SQLException e) {
                LOGGER.error("SQL exception " + e.getMessage());
            }
        }
        return user;
    }

    public void create(User entity) {

    }

    public void resetSpent(Integer price, Integer userId) {

    }


    public boolean checkUser(String login, String password){
        int isUserExist=0;

        try {
            Context envCtx = (Context) (new InitialContext().lookup("java:comp/env"));
            DataSource ds = (DataSource) envCtx.lookup("jdbc/cruises");
            Connection connection = ds.getConnection();
            Statement statement=connection.createStatement();
            String findUser="select * from passenger where (login='"+login+"'and password='"+password+"');";
            ResultSet resultSet=statement.executeQuery(findUser);
            System.out.println("result passenger: ");
            while (resultSet.next()){
                System.out.println("passengerName: "+resultSet.getString("name"));
                isUserExist=1;
            }
            connection.close();
        }catch (Exception ex){
            System.out.println("Connection failed...");
            System.out.println(ex);
        }
        if(isUserExist==0){
            return false;
        }else {
            return true;
        }
    }



    /**
     * Singleton instance
     */
    private static UserDaoRealization instance = null;

    public static synchronized UserDaoRealization getInstance() {
        if (instance == null) {
            instance = new UserDaoRealization();
        }
        return instance;
    }



    /**
     * Creates entity from result set
     *
     * @param rs
     * @return entity
     */
    private User createEntity(ResultSet rs, String role) {
        User user = new User();
        try {
            user.setUserId(rs.getInt("id"));
            user.setPassword(rs.getString("password"));
            user.setName(rs.getString("name"));
            user.setRole(role);
        } catch (SQLException e) {
            LOGGER.error("SQL exception1 " + e.getMessage());
        }
        return user;
    }
}
