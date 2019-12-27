package controller;

import com.google.gson.Gson;
import domain.User;
import domain.StandardResponse;
import domain.StatusResponse;
import repo.UserService;
import repo.UserServiceImpl;

import static spark.Spark.*;

public class SparkRestExample {
    public static void main(String[] args) {
        final UserService userService = new UserServiceImpl();

        post("/users", (request, response) -> {
            response.type("application.json");

            User user = new Gson().fromJson(request.body(), User.class);
            userService.addUser(user);

            return new Gson()
                    .toJson(new StandardResponse(StatusResponse.SUCCESS));
        });

        get("/users", (request, response) -> {
            response.type("application/json");

            return new Gson()
                    .toJson(new StandardResponse(StatusResponse.SUCCESS, new Gson().toJsonTree(userService.getUsers())));
        });

        get("/users/:id", (request, response) -> {
            response.type("application/json");

            return new Gson()
                    .toJson(new StandardResponse(StatusResponse.SUCCESS, new Gson().toJsonTree(userService.getUser(request.params(":id")))));
        });

        put("/users/:id", (request, response) -> {
            response.type("application/json");

            User toEdit = new Gson().fromJson(request.body(), User.class);
            User editedUser = userService.editUser(toEdit);

            return (editedUser != null) ?
                    new Gson()
                            .toJson(new StandardResponse(StatusResponse.SUCCESS, new Gson().toJsonTree(editedUser))) :
                    new Gson()
                            .toJson(new StandardResponse(StatusResponse.ERROR, new Gson().toJson("User not found or erroe in edit")));
        });

        delete("/users/:id", (request, response) -> {
            response.type("application/json");

            userService.deleteUser(request.params(":id"));
            return new Gson()
                    .toJson(new StandardResponse(StatusResponse.SUCCESS, "user deleted"));
        });

        options("/users/:id", (request, response) -> {
            response.type("application/json");

            return new Gson()
                    .toJson(new StandardResponse(StatusResponse.SUCCESS, (userService.userExist(request.params(":id"))) ?
                                                                                                                        "User exist" :
                                                                                                                        "User does not exists"));
        });
    }
}
