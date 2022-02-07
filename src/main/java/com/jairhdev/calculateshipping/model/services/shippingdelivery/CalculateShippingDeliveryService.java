package com.jairhdev.calculateshipping.model.services.shippingdelivery;

import java.time.LocalDate;

import com.jairhdev.calculateshipping.model.entities.Shipping;

public interface CalculateShippingDeliveryService {

    LocalDate calculateShippingDelivery(Shipping shipping);

}
