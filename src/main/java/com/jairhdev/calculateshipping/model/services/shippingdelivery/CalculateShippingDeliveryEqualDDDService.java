package com.jairhdev.calculateshipping.model.services.shippingdelivery;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.jairhdev.calculateshipping.model.entities.Shipping;

/*
 * Calcula prazo de entrega caso o DDD de origem e destino sejam iguais.
 */

@Service
public class CalculateShippingDeliveryEqualDDDService implements CalculateShippingDeliveryService {

    @Override
    public LocalDate calculateShippingDelivery(Shipping shipping) {
	final int deliveryTime = 1;
	return LocalDate.now().plusDays(deliveryTime);
    }

}
