package com.jairhdev.calculateshipping.model.services.shippingdiscount;

import com.jairhdev.calculateshipping.model.entities.Shipping;

public interface CalculateShippingDiscountService {

    double calculateShippingDiscount(Shipping shipping);

}
