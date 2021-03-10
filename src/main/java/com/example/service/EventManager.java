package com.example.service;

import com.example.BackToStockService;
import com.example.Product;
import com.example.User;
import com.example.comparator.UserComparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class EventManager {
    private static BackToStockService backToStockService;
    private static UserComparator userComparator;

    public List<User> notifyAllSubscribers(Product product) {
        List<User> allSubscribers=Optional.ofNullable(backToStockService.subscribedUsers(product)).get();
        Collections.sort(allSubscribers, userComparator);
        for (User eachSortedSubscriber : allSubscribers) {
            System.out.println("Dear " + eachSortedSubscriber.getName()
                    + " we happy to inform you, that product "
                    + product.getId()
                    + " you subscribed for, is in stock again! Have a nice shopping!");
        }
        return allSubscribers;
    }
}
