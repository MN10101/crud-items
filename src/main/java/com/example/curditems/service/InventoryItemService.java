package com.example.curditems.service;

import com.example.curditems.dao.InventoryItemRepository;
import com.example.curditems.entity.InventoryItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryItemService implements InventoryItemServiceInterface{

    private InventoryItemRepository inventoryItemRepository;

    @Autowired
    public InventoryItemService(InventoryItemRepository iRepository){
        inventoryItemRepository = iRepository;
    }


    @Override
    public List<InventoryItem> getAllItems() {
        return inventoryItemRepository.findAllByOrderByNameAsc();
    }

    @Override
    public InventoryItem getItemById(int id) {
        Optional<InventoryItem> result = inventoryItemRepository.findById(id);
        InventoryItem item = null;

        if(result.isPresent()){
            item = result.get();
        } else {
            throw new RuntimeException("Couldn't find item id: " + id);
        }
        return item;
    }

    @Override
    public InventoryItem save(InventoryItem item) {
        return inventoryItemRepository.save(item);
    }

    @Override
    public void deleteItem(int id) {
        inventoryItemRepository.deleteById(id);
    }
}
