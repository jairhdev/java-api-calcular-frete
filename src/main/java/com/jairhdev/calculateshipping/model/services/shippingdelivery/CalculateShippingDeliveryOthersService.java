package com.jairhdev.calculateshipping.model.services.shippingdelivery;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.jairhdev.calculateshipping.model.entities.Shipping;

/*
 * Calcula prazo de entrega para outros casos.
 */

@Service
public class CalculateShippingDeliveryOthersService implements CalculateShippingDeliveryService {

    @Override
    public LocalDate calculateShippingDelivery(Shipping shipping) {
	final int deliveryTime = 10;
	return LocalDate.now().plusDays(deliveryTime);
    }

}
