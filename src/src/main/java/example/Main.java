package example;

import example.config.AppConfig;
import example.model.User;
import example.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);


        UserService userService = context.getBean(UserService.class);

        User user1 = new User();
        user1.setName("иван иванов");
        userService.createUser(user1);

        User user2 = new User();
        user2.setName("петр петров");
        userService.createUser(user2);


        System.out.println("список всех пользователей:");
        userService.getAllUsers().forEach(user -> System.out.println(user));

        context.close();
    }
}