package services;

import model.User;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class UserService {

    private Map<Integer, User> users = new HashMap<>();
    private AtomicInteger count = new AtomicInteger(0);

    public User createUser(String name, String email) {
        int currentId = count.incrementAndGet();
        User user = new User(currentId, name, email);
        users.put(currentId, user);
        return user;
    }

    public User getUser(String id) {
        return null;
    }

    public List<User> getAllUsers() {
        return new ArrayList(users.values());
    }
}
