package com.store.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.store.entity.Owner;
import com.store.repository.OwnerRepository;
import com.store.service.impl.OwnerServiceImpl;

public class OwnerServiceTest {

    @InjectMocks
    private OwnerServiceImpl ownerService;

    @Mock
    private OwnerRepository ownerRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateOwner() {
        // Given
        Owner owner = new Owner();
        owner.setOwnerid(1l);
        owner.setOwnername("Manda Manisha");
        owner.setOwneremail("manisha@example.com");
        owner.setOwnerpassword("password");

        // When
        when(ownerRepository.save(any(Owner.class))).thenReturn(owner);

        // Act
        Owner createdOwner = ownerService.createOwner(owner);

        // Then
        assertEquals("Manda Manisha", createdOwner.getOwnername());
        assertEquals("manisha@example.com", createdOwner.getOwneremail());
        assertEquals("password", createdOwner.getOwnerpassword());
    }
}
