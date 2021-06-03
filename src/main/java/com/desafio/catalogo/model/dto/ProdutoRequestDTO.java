package com.desafio.catalogo.model.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class ProdutoRequestDTO {

	@NotEmpty(message = "{name.not.null}")
	private String name;

	@NotNull(message = "{description.not.null}")
	private String description;

	@NotNull(message = "{price.not.null}")
	@Positive(message = "{price.not.positive}")
	private double price;

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
