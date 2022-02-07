package com.jairhdev.calculateshipping.model.entities;

import java.time.LocalDate;

public class Response {

    private String cepOrigem;
    private String cepDestino;
    private double valorFreteTotal;
    private LocalDate dataPrevistaEntrega;

    public Response() {
    }

    public Response(String cepOrigem, String cepDestino, double valorFreteTotal, LocalDate dataPrevistaEntrega) {
	this.cepOrigem = cepOrigem;
	this.cepDestino = cepDestino;
	this.valorFreteTotal = valorFreteTotal;
	this.dataPrevistaEntrega = dataPrevistaEntrega;
    }

    public String getCepOrigem() {
	return cepOrigem;
    }

    public void setCepOrigem(String cepOrigem) {
	this.cepOrigem = cepOrigem;
    }

    public String getCepDestino() {
	return cepDestino;
    }

    public void setCepDestino(String cepDestino) {
	this.cepDestino = cepDestino;
    }

    public double getValorFreteTotal() {
	return valorFreteTotal;
    }

    public void setValorFreteTotal(double valorFreteTotal) {
	this.valorFreteTotal = valorFreteTotal;
    }

    public LocalDate getDataPrevistaEntrega() {
	return dataPrevistaEntrega;
    }

    public void setDataPrevistaEntrega(LocalDate dataPrevistaEntrega) {
	this.dataPrevistaEntrega = dataPrevistaEntrega;
    }

}
