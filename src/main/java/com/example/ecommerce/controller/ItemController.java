package com.example.ecommerce.controller;

import com.example.ecommerce.model.Item;
import com.example.ecommerce.service.ItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@ResponseBody
public class ItemController {

    private ItemServiceImpl itemService;

    @Autowired
    public ItemController(ItemServiceImpl itemService) {
        this.itemService = itemService;
    }


    @GetMapping("/items")
    public List<Item> getItems() {
        return itemService.getItems();
    }

    @PostMapping("/items")
    public ResponseEntity<String> addItems(@RequestBody List<Item> items) {
        itemService.addItems(items);
        return new ResponseEntity<>("Items added successfully", HttpStatus.CREATED);
    }

    @DeleteMapping("/items")
    public ResponseEntity<String> deleteItems(@RequestBody List<Item> items) {
        itemService.deleteItems(items);
        return new ResponseEntity<>("Items deleted successfully", HttpStatus.ACCEPTED);
    }

}
