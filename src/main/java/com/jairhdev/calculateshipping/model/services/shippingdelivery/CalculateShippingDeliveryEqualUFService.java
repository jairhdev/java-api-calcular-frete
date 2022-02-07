package com.jairhdev.calculateshipping.model.services.shippingdelivery;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.jairhdev.calculateshipping.model.entities.Shipping;

/*
 * Calcula prazo de entrega caso a UF de origem e destino sejam iguais.
 */

@Service
public class CalculateShippingDeliveryEqualUFService implements CalculateShippingDeliveryService {

    @Override
    public LocalDate calculateShippingDelivery(Shipping shipping) {
	final int deliveryTime = 3;
	return LocalDate.now().plusDays(deliveryTime);
    }

}
