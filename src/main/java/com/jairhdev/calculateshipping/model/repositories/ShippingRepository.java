package com.jairhdev.calculateshipping.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jairhdev.calculateshipping.model.entities.Shipping;

@Repository
public interface ShippingRepository extends JpaRepository<Shipping, Long> {
}
