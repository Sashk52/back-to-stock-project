package com.example;

import com.example.db.StorageProducts;
import org.junit.Assert;
import org.junit.Test;

public class StorageProductsTest {

    private static final BackToStockService backToStockService=new BackToStockServiceImpl();
    @Test
    public void restock_ok(){
        StorageProducts storageProducts = new StorageProducts(backToStockService);
        Product onTheRoadBook = new Product("1", ProductCategory.BOOKS);
        StorageProducts.storageProductsMap.put(onTheRoadBook, 1);
        storageProducts.restock(onTheRoadBook,5);
        Integer actualStock=StorageProducts.storageProductsMap.get(onTheRoadBook);
        Integer expectedStock=6;
        Assert.assertEquals(expectedStock,actualStock);
    }
}
