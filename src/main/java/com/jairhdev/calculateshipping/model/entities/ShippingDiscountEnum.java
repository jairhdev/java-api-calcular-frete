package com.jairhdev.calculateshipping.model.entities;

import com.jairhdev.calculateshipping.model.services.shippingdiscount.CalculateShippingDiscountEqualDDDService;
import com.jairhdev.calculateshipping.model.services.shippingdiscount.CalculateShippingDiscountEqualUFService;
import com.jairhdev.calculateshipping.model.services.shippingdiscount.CalculateShippingDiscountNotService;
import com.jairhdev.calculateshipping.model.services.shippingdiscount.CalculateShippingDiscountService;

enum ShippingDiscountEnum {

    EQUAL_DDD(new CalculateShippingDiscountEqualDDDService()), EQUAL_UF(new CalculateShippingDiscountEqualUFService()),
    NOT_DISCOUNT(new CalculateShippingDiscountNotService());

    private final CalculateShippingDiscountService calculateShippingDiscount;

    private ShippingDiscountEnum(CalculateShippingDiscountService calculateShippingDiscount) {
	this.calculateShippingDiscount = calculateShippingDiscount;
    }

    CalculateShippingDiscountService getCalculateShippingDiscount() {
	return calculateShippingDiscount;
    }
}
