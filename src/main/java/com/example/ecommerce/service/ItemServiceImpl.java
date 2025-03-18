package com.example.ecommerce.service;

import com.example.ecommerce.model.Item;
import com.example.ecommerce.repository.ItemRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    private ItemRepository itemRepository;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }


    @Override
    public List<Item> getItems() {
        return itemRepository.getItems();
    }

    @Transactional
    @Override
    public void addItems(List<Item> items) {
        itemRepository.addItems(items);
    }

    @Override
    public void deleteItems(List<Item> items) {
        itemRepository.deleteItems(items);
    }

    @Override
    public void updateItems(List<Item> items) {

    }
}
