package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;



public class Main {
    private static final UserService userService = new UserServiceImpl();
    private static final User user1 = new User("Ilya", "Lukanchev", (byte) 29);
    private static final User user2 = new User("Anna", "Anisimova", (byte) 22);
    private static final User user3 = new User("Stanislav", "Ytukov", (byte) 36);
    private static final User user4 = new User("Oleg", "Mongol", (byte) 52);



    public static void main(String[] args) {
        //userService.createUsersTable();

        userService.saveUser(user1.getName(), user1.getLastName(), user1.getAge());

        userService.saveUser(user2.getName(), user2.getLastName(), user2.getAge());

        userService.saveUser(user3.getName(), user3.getLastName(), user3.getAge());

        userService.saveUser(user4.getName(), user4.getLastName(), user4.getAge());

       userService.getAllUsers();

        userService.removeUserById(1L);

        userService.cleanUsersTable();

        //userService.dropUsersTable();
    }

}
