package com.jairhdev.calculateshipping.searchcep;

public class SearchCep {

    /*
     * A API disponibiliza outros campos, porém, criei na classe somente os campos
     * utilizados pela aplicação.
     */
    private String uf;
    private String ddd;

    public SearchCep() {
    }

    public SearchCep(String uf, String ddd) {
	this.uf = uf;
	this.ddd = ddd;
    }

    public String getUf() {
	return uf;
    }

    public void setUf(String uf) {
	this.uf = uf;
    }

    public String getDdd() {
	return ddd;
    }

    public void setDdd(String ddd) {
	this.ddd = ddd;
    }

}
