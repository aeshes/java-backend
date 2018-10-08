package controller;

import static spark.Spark.*;

import services.UserService;
import static util.JsonUtil.*;

public class UserController {

    public UserController(final UserService service) {
        get("/users", (request, response) -> service.getAllUsers(), json());

        post("/users", (request, response) -> service.createUser(
                request.queryParams("name"),
                request.queryParams("email")
        ));

        after((request, response) -> {
            response.type("application/json");
        });
    }
}
