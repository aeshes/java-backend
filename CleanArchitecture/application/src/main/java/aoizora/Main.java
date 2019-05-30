package aoizora;

import aoizora.config.ManualConfig;
import aoizora.entity.User;

public class Main {

    public static void main(String[] args) {
        var config = new ManualConfig();
        var createUser = config.createUser();
        var findUser = config.findUser();
        var user = User.newBuilder()
                .email("test@test.in")
                .password("123")
                .firstName("Ami")
                .lastName("Yami")
                .build();

        var actualCreateUser = createUser.create(user);
        System.out.println("User created: " + actualCreateUser.getId());

        var actualFindUser = findUser.findById(actualCreateUser.getId());
        System.out.println("Found user with id = " + actualFindUser.get().getId());

        var users = findUser.findAllUsers();
        System.out.println("List all users: " + users);
    }
}
