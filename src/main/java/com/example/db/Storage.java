package com.example.db;

import com.example.ProductCategory;
import com.example.User;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Storage {
    public static final Map<List<ProductCategory>, List<User>> users = new HashMap<>();
}
