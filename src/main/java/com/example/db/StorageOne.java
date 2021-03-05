package com.example.db;

import com.example.Product;
import com.example.ProductCategory;
import com.example.User;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StorageOne {
    public static final Map<User, List<Product>> subscribedUsers = new HashMap<>();
}
