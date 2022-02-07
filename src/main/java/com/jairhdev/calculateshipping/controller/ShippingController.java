package com.jairhdev.calculateshipping.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jairhdev.calculateshipping.model.entities.Response;
import com.jairhdev.calculateshipping.model.entities.Shipping;
import com.jairhdev.calculateshipping.model.services.ShippingPersistenceService;

@RestController
@RequestMapping(path = "/api/v1/calculate-shipping")
public class ShippingController {

    @Autowired
    private ShippingPersistenceService repository;

    @GetMapping("/peso/{peso}/cepOrigem/{cepOrigem}/cepDestino/{cepDestino}/nomeDestinatario/{nomeDestinatario}")
    public ResponseEntity<Response> calculateShipping(@PathVariable double peso, @PathVariable String cepOrigem,
	    @PathVariable String cepDestino, @PathVariable String nomeDestinatario) {

	Shipping shipping = new Shipping(peso, cepOrigem, cepDestino, nomeDestinatario);

	double valorFreteTotal = shipping.getValorFreteTotal();
	LocalDate dataPrevistaEntrega = shipping.getDataPrevistaEntrega();

	repository.insert(shipping);

	return ResponseEntity.ok(new Response(cepOrigem, cepDestino, valorFreteTotal, dataPrevistaEntrega));
    }

}
