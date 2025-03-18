package com.example.ecommerce.repository;

import com.example.ecommerce.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {

    List<Item> items = new ArrayList<>();

    default void addItems(List<Item> itemsList) {
        items.addAll(itemsList);
    }

    default List<Item> getItems() {
        return new ArrayList<>(items);
    }

    default void deleteItems(List<Item> itemsList) {
        for (Item item : itemsList) {
            items.remove(item);
        }
    }

}
