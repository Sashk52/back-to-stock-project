package com.example;

import com.example.db.Storage;
import com.example.db.StorageOne;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BackToStockServiceImpl implements BackToStockService {
    @Override
    public void subscribe(User user, Product product) {
        if (StorageOne.subscribedUsers.containsKey(user)) {
            List<Product> productList = StorageOne.subscribedUsers.get(user);
            productList.add(product);
            StorageOne.subscribedUsers.put(user, productList);
        } else {
            List<Product> singleProductList = new ArrayList<>();
            singleProductList.add(product);
            StorageOne.subscribedUsers.put(user, singleProductList);
        }
    }

    @Override
    public List<User> subscribedUsers(Product product) {
        Set<User> keySet = StorageOne.subscribedUsers.keySet();
        List<User> subscribersOfProduct = new ArrayList<>();
        for (User eachKeyUser : keySet) {
            if (StorageOne.subscribedUsers.get(eachKeyUser).contains(product)) {
                subscribersOfProduct.add(eachKeyUser);
            }
        }
        return subscribersOfProduct;
    }
}
