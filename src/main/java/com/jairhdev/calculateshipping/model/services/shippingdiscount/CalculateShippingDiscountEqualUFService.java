package com.jairhdev.calculateshipping.model.services.shippingdiscount;

import org.springframework.stereotype.Service;

import com.jairhdev.calculateshipping.model.entities.Shipping;

/*
 * Calcula desconto do frete caso a UF de origem e destino sejam iguais.
 */

@Service
public class CalculateShippingDiscountEqualUFService implements CalculateShippingDiscountService {

    @Override
    public double calculateShippingDiscount(Shipping shipping) {
	final double discountPercentual = 75.0 / 100;
	return shipping.getValorFreteSemDesconto() * discountPercentual;
    }

}
