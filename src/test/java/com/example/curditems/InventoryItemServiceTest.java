package com.example.curditems;

import com.example.curditems.dao.InventoryItemRepository;
import com.example.curditems.entity.InventoryItem;
import com.example.curditems.service.InventoryItemService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class InventoryItemServiceTest {

    @Mock
    private InventoryItemRepository inventoryItemRepository;

    @InjectMocks
    private InventoryItemService inventoryItemService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindAll() {

        List<InventoryItem> items = Arrays.asList(
                new InventoryItem("iPhone 15 Pro", 253),
                new InventoryItem("GAMING PC | Intel Core i9-11900KF 8x3.50GHz | 16GB DDR4 | RTX 3060 12GB | 1TB M.2 SSD", 240));

        when(inventoryItemRepository.findAllByOrderByNameAsc()).thenReturn(items);

        // Call the method under test environment
        List<InventoryItem> result = inventoryItemService.getAllItems();

        // Verify with assertEquals methods
        assertEquals(2, result.size());

    }

    @Test
    public void testFindByIdExistingId() {
        // Mock the data
        InventoryItem item = new InventoryItem("iPhone 15 Pro", 253);
        item.setId(1);

        // Mock the behavior of the repository
        when(inventoryItemRepository.findById(1)).thenReturn(java.util.Optional.of(item));

        // Call the service method and verify
        InventoryItem result = inventoryItemService.getItemById(1);

        // Verify with assertEquals methods
        assertEquals("iPhone 15 Pro", result.getName());
        assertEquals(253, result.getQuantity());

    }

    @Test
    public void testFindByIdNonExistingId() {

        // Mock the behavior of the repository
        when(inventoryItemRepository.findById(1)).thenReturn(java.util.Optional.empty());

        // Verify with assertEquals methods and call the method under test environment
        assertThrows(RuntimeException.class, () -> inventoryItemService.getItemById(1));
    }

    @Test
    public void testSave() {
        // Mock the data
        InventoryItem item = new InventoryItem("iPhone 15 Pro", 253);

        // Mock the behavior of the repository
        when(inventoryItemRepository.save(item)).thenReturn(item);

        // Call the method under test environment
        InventoryItem result = inventoryItemService.save(item);

        // Verify with assertEquals methods
        assertEquals("iPhone 15 Pro", result.getName());
        assertEquals(253, result.getQuantity());

    }

    @Test
    public void testDelete() {

        // No need to mock the data or the behavior of the repository

        // Call the method under test environment
        inventoryItemService.deleteItem(1);

        verify(inventoryItemRepository, times(1)).deleteById(1);

    }

}
