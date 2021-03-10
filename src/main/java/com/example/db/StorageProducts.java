package com.example.db;

import com.example.BackToStockService;
import com.example.Product;
import java.util.HashMap;
import java.util.Map;

public class StorageProducts {
    public static Map<Product, Integer> storageProductsMap = new HashMap();
    private BackToStockService backToStockService;

    public StorageProducts(BackToStockService backToStockService) {
        this.backToStockService = backToStockService;
    }

    public void restock(Product product, Integer restockAmount) {
        if (storageProductsMap.containsKey(product)) {
            int currentAmount = storageProductsMap.get(product);
            currentAmount += restockAmount;
            storageProductsMap.put(product, currentAmount);
        } else {
            storageProductsMap.put(product, restockAmount);
        }
    }
}
