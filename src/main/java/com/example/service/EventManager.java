package com.example.service;

import com.example.Product;
import com.example.User;
import com.example.dao.UserDao;
import java.util.List;

public class EventManager {
    public static UserDao userDao;

    public void subscribe(User user) {
        userDao.add(user);
    }
    public void unsubscribe(User user) {
        userDao.delete(user);
    }
    public void notifyAll(Product product){
        List<User> allSubscribers = userDao.getAllSurscibers(product);
        userDao.sendNotificationsToSudcribers(allSubscribers, product);
    }
}
