package com.desafio.catalogo.builder;

import com.desafio.catalogo.model.dto.ProdutoResponseDTO;

public class ProdutoResponseBuilder {

	private ProdutoResponseDTO produtoResponse;

	public ProdutoResponseBuilder() {
		this.produtoResponse = new ProdutoResponseDTO();
	}

	public ProdutoResponseBuilder comId(Long id) {
		this.produtoResponse.setId(String.valueOf(id));
		return this;
	}

	public ProdutoResponseBuilder comName(String name) {
		this.produtoResponse.setName(name);
		return this;
	}

	public ProdutoResponseBuilder comDescription(String description) {
		this.produtoResponse.setDescription(description);
		return this;
	}

	public ProdutoResponseBuilder comPrice(double price) {
		this.produtoResponse.setPrice(price);
		return this;
	}

	public ProdutoResponseDTO builder() {
		return this.produtoResponse;
	}
}
