package com.example.db;

import com.example.Product;
import com.example.User;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StorageOne {
    private static Map<User, List<Product>> subscribedUsers = new HashMap<>();

    public static Map<User, List<Product>> getSubscribedUsers() {
        return subscribedUsers;
    }

    public static void setSubscribedUsers(Map<User, List<Product>> subscribedUsers) {
        StorageOne.subscribedUsers = subscribedUsers;
    }

}
