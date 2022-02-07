package com.jairhdev.calculateshipping.model.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.jairhdev.calculateshipping.model.services.SearchCepService;

@Entity
@Table(name = "tb_shipping")
public class Shipping implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "peso")
    private double peso;

    @Column(name = "cep_origem")
    private String cepOrigem;

    @Column(name = "cep_destino")
    private String cepDestino;

    @Column(name = "nome_destinatario")
    private String nomeDestinatario;

    @Transient
    private double valorFreteSemDesconto;

    @Column(name = "valor_frete_total")
    private double valorFreteTotal;

    @Column(name = "data_prevista_entrega")
    private LocalDate dataPrevistaEntrega;

    @Column(name = "data_consulta")
    private LocalDate dataConsulta;

    @Transient
    private ShippingDiscountEnum whatDiscount;

    @Transient
    private ShippingDeliveryEnum whatDelivery;

    @Transient
    private SearchCepService serviceSearchCep;

    /*
     * CONSTRUTORES
     */

    public Shipping() {
    }

    public Shipping(double peso, String cepOrigem, String cepDestino, String nomeDestinatario) {

	this.serviceSearchCep = new SearchCepService();

	this.id = null;
	this.peso = peso;
	this.cepOrigem = cepOrigem;
	this.cepDestino = cepDestino;
	this.nomeDestinatario = nomeDestinatario;

	this.valorFreteSemDesconto = calculateShippingNotDiscount();
	this.whatDiscount = whatDiscount();
	this.valorFreteTotal = this.valorFreteSemDesconto - calculateShippingDiscount();

	this.whatDelivery = whatDelivery();
	this.dataPrevistaEntrega = calculateShippingDelivery();

	this.dataConsulta = LocalDate.now();
    }

    /*
     * GETTERS, SETTERS
     */

    public Long getId() {
	return id;
    }

    public double getPeso() {
	return peso;
    }

    public void setPeso(double peso) {
	this.peso = peso;
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

    public String getNomeDestinatario() {
	return nomeDestinatario;
    }

    public void setNomeDestinatario(String nomeDestinatario) {
	this.nomeDestinatario = nomeDestinatario;
    }

    public double getValorFreteSemDesconto() {
	return valorFreteSemDesconto;
    }

    public double getValorFreteTotal() {
	return valorFreteTotal;
    }

    public LocalDate getDataPrevistaEntrega() {
	return dataPrevistaEntrega;
    }

    public void setDataPrevistaEntrega(LocalDate dataPrevistaEntrega) {
	this.dataPrevistaEntrega = dataPrevistaEntrega;
    }

    public LocalDate getDataConsulta() {
	return dataConsulta;
    }

    public ShippingDiscountEnum getWhatDiscount() {
	return whatDiscount;
    }

    public ShippingDeliveryEnum getWhatDelivery() {
	return whatDelivery;
    }

    /*
     * MÉTODOS
     */

    /*
     * Calcula valor bruto do frete (sem descontos) baseado no peso informado.
     */
    private double calculateShippingNotDiscount() {
	final double priceWeight = 1.0;
	return peso * priceWeight;
    }

    /*
     * Identifica qual desconto aplicar.
     */
    private ShippingDiscountEnum whatDiscount() {
	ShippingDiscountEnum result = null;

	if (isEqualDDD()) {
	    result = ShippingDiscountEnum.EQUAL_DDD;
	} else if (isEqualUF()) {
	    result = ShippingDiscountEnum.EQUAL_UF;
	} else {
	    result = ShippingDiscountEnum.NOT_DISCOUNT;
	}
	return result;
    }

    /*
     * Calcula desconto do frete.
     */
    private double calculateShippingDiscount() {
	return getWhatDiscount().getCalculateShippingDiscount().calculateShippingDiscount(this);
    }

    /*
     * Identifica qual condição de prazo de entrega aplicar.
     */
    private ShippingDeliveryEnum whatDelivery() {
	ShippingDeliveryEnum result = null;

	if (isEqualDDD()) {
	    result = ShippingDeliveryEnum.EQUAL_DDD;
	} else if (isEqualUF()) {
	    result = ShippingDeliveryEnum.EQUAL_UF;
	} else {
	    result = ShippingDeliveryEnum.OTHERS;
	}
	return result;
    }

    /*
     * Calcula prazo de entrega.
     */
    private LocalDate calculateShippingDelivery() {
	return getWhatDelivery().getCalculateShippingDelivery().calculateShippingDelivery(this);
    }

    /*
     * Verifica se DDD de CEP origem e destino são iguais.
     */
    private boolean isEqualDDD() {
	return (serviceSearchCep.requestDDD(cepOrigem).equals(serviceSearchCep.requestDDD(cepDestino))) ? true : false;
    }

    /*
     * Verifica se UF de CEP origem e destino são iguais.
     */
    private boolean isEqualUF() {
	return (serviceSearchCep.requestUF(cepOrigem).equals(serviceSearchCep.requestUF(cepDestino))) ? true : false;
    }

}
