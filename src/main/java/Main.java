import exception.DBException;
import model.User;
import service.UserService;
import util.DBHelper;

import java.sql.SQLException;

public class Main {


    public static void main(String[] args) throws DBException, SQLException {   //Метод только для теста
        System.out.println("Fuck YOU ALLL!!!!!");
        UserService userService = UserService.getInstance();
        DBHelper.getInstance();
        DBHelper.getProperties();
        //UserDAOJDBCImpl userDAOJDBCImpl = getInstance(DBHelper.getConnection());
        if (args.length != 0) {
            DBHelper.getProperties().setProperty("driver", args[0]);
        }
//        userDAOJDBCImpl.dropTable();
//        userDAOJDBCImpl.createTable();
        userService.addUser(new User("DartAxis", "mail", 32L));
        userService.addUser(new User("Kostya", "mail@ghb.ru", 29L));
        userService.addUser(new User("РусскоеИмя", "maiaxl1", 15L));
        userService.addUser(new User("Другое", "another@smail.ru", 16L));
        userService.addUser(new User("SovsemДругое", "tooanother@vmail.ru", 20L));
        for (User user : userService.getAllUsers()) {
            System.out.println(user.getId() + " " + user.getName() + " " + user.getEmail() + " " + user.getAge());
        }
        userService.deleteUser(3L);
        userService.updateUser(new User(2L, "hetoiiblpb", "hetoiiblpb@mail.ru", 20L));
        System.out.println(userService.checkUserByEmail("mail"));
        System.out.println(userService.checkUserByEmail("xxxxx"));

        for (User user : userService.getAllUsers()) {
            System.out.println(user.getId() + " " + user.getName() + " " + user.getEmail() + " " + user.getAge());
        }


    }

}
