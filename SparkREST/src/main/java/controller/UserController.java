package controller;

import static spark.Spark.*;

import model.User;
import services.UserService;
import static util.JsonUtil.*;

public class UserController {

    public UserController(final UserService service) {
        get("/users", (request, response) -> service.getAllUsers(), json());

        post("/users", (request, response) -> service.createUser(
                request.queryParams("name"),
                request.queryParams("email")
        ), json());

        get("/users/:id", (request, response) -> {
            int id = Integer.valueOf(request.params(":id"));
            User user = service.getUser(id);
            if (user != null) {
                return user;
            }
            response.status(404);
            return new ResponseError("No such user with id '%d' found", String.valueOf(id));
        }, json());

        after((request, response) -> {
            response.type("application/json");
        });
    }
}
