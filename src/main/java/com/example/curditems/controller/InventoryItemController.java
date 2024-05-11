package com.example.curditems.controller;

import com.example.curditems.entity.InventoryItem;
import com.example.curditems.service.InventoryItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/items")
public class InventoryItemController {

    private InventoryItemService inventoryItemService;

    @Autowired
    public InventoryItemController(InventoryItemService iService) {
        inventoryItemService = iService;
    }

    @GetMapping("/get")
    public String getItems(Model model) {
        List<InventoryItem> items = inventoryItemService.getAllItems();
        model.addAttribute("items", items);
        return "get-items";
    }


    @GetMapping("/addItem")
    public String addItem(Model model){
        InventoryItem item = new InventoryItem();
        model.addAttribute("item", item);
        return "item-form";
    }


    @GetMapping("/updateItem")
    public String updateItem(@RequestParam("itemId") int id, Model model) {
        InventoryItem item = inventoryItemService.getItemById(id);
        model.addAttribute("item", item);
        return "item-form";
    }


    @PostMapping("/saveItem")
    public String saveItem(@ModelAttribute("item") InventoryItem item) {
        InventoryItem savedItem = inventoryItemService.save(item);
        inventoryItemService.save(savedItem);
        return "redirect:/items/get";
    }

    @GetMapping("/deleteItem")
    public String deleteItem(@RequestParam("itemId") int id) {
        inventoryItemService.deleteItem(id);
        return "redirect:/items/get";
    }
}
