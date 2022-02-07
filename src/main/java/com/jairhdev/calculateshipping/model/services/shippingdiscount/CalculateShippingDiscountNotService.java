package com.jairhdev.calculateshipping.model.services.shippingdiscount;

import org.springframework.stereotype.Service;

import com.jairhdev.calculateshipping.model.entities.Shipping;

/*
 * Não há desconto no preço do frete.
 */

@Service
public class CalculateShippingDiscountNotService implements CalculateShippingDiscountService {

    @Override
    public double calculateShippingDiscount(Shipping shipping) {
	return 0;
    }

}
