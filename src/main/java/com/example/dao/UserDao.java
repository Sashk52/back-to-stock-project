package com.example.dao;

import com.example.Product;
import com.example.User;
import java.util.List;

public interface UserDao {
    void add(User user);

    User delete(User user);

    List<User> getAllSurscibers(Product product);

    void sendNotificationsToSudcribers(List<User> users, Product product);
}
