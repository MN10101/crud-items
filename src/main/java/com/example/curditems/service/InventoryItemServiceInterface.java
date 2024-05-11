package com.example.curditems.service;

import com.example.curditems.entity.InventoryItem;

import java.util.List;

public interface InventoryItemServiceInterface {
    List<InventoryItem> getAllItems();
    InventoryItem getItemById(int id);
    InventoryItem save(InventoryItem item);
    void deleteItem(int id);
}
