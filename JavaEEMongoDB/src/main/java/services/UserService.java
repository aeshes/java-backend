package services;

import com.mongodb.DBObject;
import com.mongodb.WriteResult;

import spark.servlet.SparkApplication;
import com.google.gson.Gson;

import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.after;

import mongo.MongoConnection;
import mongo.UserDAO;
import models.User;

public class UserService implements SparkApplication {

    Gson gson = new Gson();
    UserDAO dao = null;

    @Override
    public void init() {
        MongoConnection conn = MongoConnection.getInstance();
        dao = new UserDAO(conn.getDatastore());

        get("/api/getAll", (req,  res) -> {
            return dao.find().asList();
        }, gson::toJson);

        post("/api/insert", (req, res) -> {
            User user = gson.fromJson(req.body(), User.class);
            DBObject tmp = conn.getMorphia().toDBObject(user);

            WriteResult wResult = dao.getCollection().insert(tmp);

            return wResult.getUpsertedId();
        }, gson::toJson);

        after((req, res) -> {
            res.header("Content-Type", "application/json");
        });
    }
}
