package com.jairhdev.calculateshipping.model.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jairhdev.calculateshipping.model.entities.Shipping;
import com.jairhdev.calculateshipping.model.repositories.ShippingRepository;

@Service
public class ShippingPersistenceService {

    @Autowired
    private ShippingRepository repository;

    public Shipping insert(Shipping shipping) {
	return repository.save(shipping);
    }
}
