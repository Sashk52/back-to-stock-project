package com.example.dao.impl;

import com.example.Product;
import com.example.ProductCategory;
import com.example.User;
import com.example.dao.UserDao;
import com.example.db.Storage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class UserDaoImpl implements UserDao {

    @Override
    public void add(User user) {
        if (user.isPremium()) {
            List<User> premiumUsers = Storage.users.get(ProductCategory.values());
            premiumUsers.add(user);
            Storage.users.put(Arrays.asList(ProductCategory.values()), premiumUsers);
            return;
        } else if (user.getAge() > 70) {
            List<User> medicalPremiumUsers = Storage.users.get(ProductCategory.valueOf("MEDICAL"));
            medicalPremiumUsers.add(user);
            Storage.users.put(Arrays.asList(ProductCategory.valueOf("Medical")), medicalPremiumUsers);
            return;
        }
        List<User> typicalUsers = Storage.users.get(Collections.emptyList());
        typicalUsers.add(user);
        Storage.users.put(Collections.emptyList(), typicalUsers);
    }

    @Override
    public User delete(User user) {
        Set<List<ProductCategory>> lists = Storage.users.keySet();
        for (List<ProductCategory> eachList : lists) {
            List<User> eachUsers = Storage.users.get(eachList);
            if (eachUsers.contains(user)) {
                eachUsers.remove(user);
                return user;
            }
        }
        return new User();
    }

    @Override
    public List<User> getAllSurscibers(Product product) {
        ProductCategory productCategory = product.getCategory();
        Set<List<ProductCategory>> lists = Storage.users.keySet();
        List<User> allPremiumUsersForCurrentProduct = new ArrayList<>();
        for (List<ProductCategory> eachList : lists) {
            if (eachList.contains(productCategory)) {
                List<User> currentList = Storage.users.get(eachList);
                allPremiumUsersForCurrentProduct.addAll(currentList);
            }
        }
        return allPremiumUsersForCurrentProduct;
    }

    @Override
    public void sendNotificationsToSudcribers(List<User> users, Product product) {
        for (User eachUser : users) {
            System.out.println(eachUser.getName() + " Dear buyer, the product " + product.getId() + " available again!");
        }
    }
}
