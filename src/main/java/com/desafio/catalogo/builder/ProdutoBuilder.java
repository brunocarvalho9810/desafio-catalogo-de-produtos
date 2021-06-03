package com.desafio.catalogo.builder;

import com.desafio.catalogo.model.Produto;

public class ProdutoBuilder {

	private Produto produto;

	public ProdutoBuilder() {
		this.produto = new Produto();
	}

	public ProdutoBuilder comName(String name) {
		this.produto.setName(name);
		return this;
	}

	public ProdutoBuilder comDescription(String description) {
		this.produto.setDescription(description);
		return this;
	}

	public ProdutoBuilder comPrice(double price) {
		this.produto.setPrice(price);
		return this;
	}

	public Produto builder() {
		return this.produto;
	}
}
