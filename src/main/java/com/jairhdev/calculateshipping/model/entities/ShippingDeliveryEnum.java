package com.jairhdev.calculateshipping.model.entities;

import com.jairhdev.calculateshipping.model.services.shippingdelivery.CalculateShippingDeliveryEqualDDDService;
import com.jairhdev.calculateshipping.model.services.shippingdelivery.CalculateShippingDeliveryEqualUFService;
import com.jairhdev.calculateshipping.model.services.shippingdelivery.CalculateShippingDeliveryOthersService;
import com.jairhdev.calculateshipping.model.services.shippingdelivery.CalculateShippingDeliveryService;

enum ShippingDeliveryEnum {

    EQUAL_DDD(new CalculateShippingDeliveryEqualDDDService()), EQUAL_UF(new CalculateShippingDeliveryEqualUFService()),
    OTHERS(new CalculateShippingDeliveryOthersService());

    private final CalculateShippingDeliveryService calculateShippingDelivery;

    private ShippingDeliveryEnum(CalculateShippingDeliveryService calculateShippingDelivery) {
	this.calculateShippingDelivery = calculateShippingDelivery;
    }

    CalculateShippingDeliveryService getCalculateShippingDelivery() {
	return calculateShippingDelivery;
    }
}
