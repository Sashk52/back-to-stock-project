package com.example;

import com.example.db.StorageOne;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BackToStockServiceImpl implements BackToStockService {
    @Override
    public void subscribe(User user, Product product) {
        if (StorageOne.getSubscribedUsers().containsKey(user)) {
            List<Product> productList = StorageOne.getSubscribedUsers().get(user);
            productList.add(product);
            StorageOne.getSubscribedUsers().put(user, productList);
        } else {
            List<Product> singleProductList = new ArrayList<>();
            singleProductList.add(product);
            StorageOne.getSubscribedUsers().put(user, singleProductList);
        }
    }

    @Override
    public List<User> subscribedUsers(Product product) {
        Set<User> keySet = StorageOne.getSubscribedUsers().keySet();
        List<User> subscribersOfProduct = new ArrayList<>();
        for (User eachKeyUser : keySet) {
            if (StorageOne.getSubscribedUsers().get(eachKeyUser).contains(product)) {
                subscribersOfProduct.add(eachKeyUser);
            }
        }
        return subscribersOfProduct;
    }
}
