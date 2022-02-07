package com.jairhdev.calculateshipping.model.services.shippingdiscount;

import org.springframework.stereotype.Service;

import com.jairhdev.calculateshipping.model.entities.Shipping;

/*
 * Calcula desconto do frete caso o DDD de origem e destino sejam iguais.
 */

@Service
public class CalculateShippingDiscountEqualDDDService implements CalculateShippingDiscountService {

    @Override
    public double calculateShippingDiscount(Shipping shipping) {
	final double discountPercentual = 50.0 / 100;
	return shipping.getValorFreteSemDesconto() * discountPercentual;
    }

}
