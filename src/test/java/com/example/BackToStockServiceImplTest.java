package com.example;

import com.example.BackToStockService;
import com.example.BackToStockServiceImpl;
import com.example.Product;
import com.example.ProductCategory;
import com.example.User;
import com.example.db.StorageOne;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BackToStockServiceImplTest {
    private static BackToStockService backToStockService = new BackToStockServiceImpl();

    @Before
    public void init(){
        StorageOne.setSubscribedUsers(new HashMap<User, List<Product>>());
    }
    @Test
    public void subscriber_ok() {
        Product shining = new Product("1", ProductCategory.BOOKS);
        User jimUser = new User("Jim", false, 26);
        User sueUser = new User("Sue", true, 21);
        backToStockService.subscribe(jimUser, shining);
        backToStockService.subscribe(sueUser, shining);
        Set<User> actualUserSet = StorageOne.getSubscribedUsers().keySet();
        Set<User> expectedUserSet = new HashSet<User>();
        expectedUserSet.add(jimUser);
        expectedUserSet.add(sueUser);
        assertEquals(expectedUserSet, actualUserSet);
    }

    @Test
    public void subscribedUsers_ok() {
        Product laptopAcerN1 = new Product("2", ProductCategory.DIGITAL);
        User joUser = new User("Jo", false, 20);
        User jessUser = new User("Jess", true, 25);
        User robUser = new User("Rob", true, 30);
        backToStockService.subscribe(joUser, laptopAcerN1);
        backToStockService.subscribe(jessUser, laptopAcerN1);
        backToStockService.subscribe(robUser, laptopAcerN1);
        List<User> expectedPremiumTest = new ArrayList<>();
        expectedPremiumTest.add(joUser);
        expectedPremiumTest.add(jessUser);
        expectedPremiumTest.add(robUser);
        List<User> actualPremiumTest = backToStockService.subscribedUsers(laptopAcerN1);
        assertEquals(expectedPremiumTest, actualPremiumTest);
    }
    @Test
    public void subscribedUsers_NotOk() {
        Product laptopAcerN1 = new Product("2", ProductCategory.DIGITAL);
        User boUser = new User("Bo", false, 18);
        User samUser = new User("Sam", true, 45);
        backToStockService.subscribe(boUser, laptopAcerN1);
        backToStockService.subscribe(samUser, laptopAcerN1);
        List<User> expectedPremiumTest = new ArrayList<>();
        expectedPremiumTest.add(samUser);
        expectedPremiumTest.add(boUser);
        List<User> actualPremiumTest = backToStockService.subscribedUsers(laptopAcerN1);
        assertNotEquals(expectedPremiumTest, actualPremiumTest);
    }

    @Test
    public void subscriber_notOk() {
        Product shining = new Product("1", ProductCategory.BOOKS);
        User bobUser = new User("Bob", false, 26);
        User sueUser = new User("Sue", false, 21);
        backToStockService.subscribe(sueUser, shining);
        backToStockService.subscribe(bobUser, shining);
        Set<User> actualUserSet = StorageOne.getSubscribedUsers().keySet();
        Set<User> expectedUserSet = new HashSet<>();
        expectedUserSet.add(bobUser);
        assertNotEquals(expectedUserSet, actualUserSet);
    }

}