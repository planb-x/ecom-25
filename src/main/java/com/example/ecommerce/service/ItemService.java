package com.example.ecommerce.service;

import com.example.ecommerce.model.Item;

import java.util.List;

public interface ItemService {

    List<Item> getItems();

    void addItems(List<Item> items);

    void deleteItems(List<Item> items);

    void updateItems(List<Item> items);



}
