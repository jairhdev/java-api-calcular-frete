package com.jairhdev.calculateshipping.model.services;

import java.util.HashMap;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.jairhdev.calculateshipping.searchcep.SearchCep;
import com.jairhdev.calculateshipping.searchcep.SearchCepInterface;

@Service
public class SearchCepService implements SearchCepInterface {

    @Override
    public String requestDDD(String cep) {
	return requestConsultaCep(cep).getDdd();
    }

    @Override
    public String requestUF(String cep) {
	return requestConsultaCep(cep).getUf();
    }

    private SearchCep requestConsultaCep(String cep) {
	final String URI = "https://viacep.com.br/ws/{cep}/json/";

	HashMap<String, String> uriVariables = new HashMap<>();
	uriVariables.put("cep", cep);

	ResponseEntity<SearchCep> responseEntity = new RestTemplate().getForEntity(URI, SearchCep.class, uriVariables);

	return responseEntity.getBody();
    }

}
