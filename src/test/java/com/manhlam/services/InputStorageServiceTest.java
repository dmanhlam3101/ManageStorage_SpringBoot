package com.manhlam.services;

import com.manhlam.dtos.InputStorageDTO;
import com.manhlam.mappers.InputStorageMapper;
import com.manhlam.models.InputStorage;
import com.manhlam.models.Product;
import com.manhlam.repositories.InputStorageRepository;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
class InputStorageServiceTest {
    @InjectMocks
    private InputStorageService inputStorageService;
    @Mock
    private InputStorageRepository inputStorageRepository;
    //Set<Integer> productIds = Set.of(1, 2, 3);
    private static InputStorageDTO inputStorageDTO = new InputStorageDTO(1,Set.of(1,2),
            10,new Date(2021-01-01),1.5,10.0,true);

    @Test
    @Order(1)
    void testGetAllInputStorageByProductId() {

        Integer productId = 1;
        // Return a list containing the single InputStorage object
        Mockito.when(inputStorageService.getAllInputStorageByProductId(productId))
                .thenReturn(Collections.singletonList(inputStorageDTO));
        List<InputStorageDTO> result = inputStorageService.getAllInputStorageByProductId(productId);

        assertEquals(1,result.size());
        assertThat(result.get(0).getInputId()).isEqualTo(inputStorageDTO.getInputId());


    }

    @Test
    @Order(2)
    void testGetAllInputStorage() {
        Mockito.when(inputStorageService.getAllInputStorage()).thenReturn(Collections.singletonList(inputStorageDTO));
        List<InputStorageDTO> result = inputStorageService.getAllInputStorage();
        assertEquals(1,result.size());
        assertThat(result.get(0).getInputId()).isEqualTo(inputStorageDTO.getInputId());

    }

    @Test
    @Order(3)
    void testCreateInputStorage() {

        Mockito.when(inputStorageService.createInputStorage(inputStorageDTO)).thenReturn(inputStorageDTO);
        InputStorageDTO result = inputStorageService.createInputStorage(inputStorageDTO);
        Mockito.verify(inputStorageService,Mockito.times(1)).createInputStorage(inputStorageDTO);
        assertThat(result.getInputId()).isEqualTo(1);
    }
//
    @Test
    @Order(4)
    void testEditInputStorage() {
        Integer inputStorageId = 1;
        Mockito.when(inputStorageService.editInputStorage(inputStorageId,inputStorageDTO)).thenReturn(inputStorageDTO);
        InputStorageDTO result = inputStorageService.editInputStorage(inputStorageId,inputStorageDTO);
        Mockito.verify(inputStorageService,Mockito.times(1)).editInputStorage(inputStorageId,inputStorageDTO);
        assertThat(result.getInputId()).isEqualTo(inputStorageId);
    }

    @Test
    @Order(5)
    void testDeleteInputStorage() {
            Integer inputStorageId = 1;
            Mockito.when(inputStorageService.deleteInputStorage(inputStorageId)).thenReturn(inputStorageDTO);
            InputStorageDTO result = inputStorageService.deleteInputStorage(inputStorageId);
            Mockito.verify(inputStorageService,Mockito.times(1)).deleteInputStorage(inputStorageId);
            assertThat(result.getInputId()).isEqualTo(inputStorageId);
    }

    @Test
    void getAll() {
    }

    @Test
    void getInputStorageById() {
    }
}