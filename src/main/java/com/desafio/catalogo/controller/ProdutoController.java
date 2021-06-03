package com.desafio.catalogo.controller;

import java.util.List;

import javax.validation.Valid;
import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.catalogo.model.dto.ProdutoRequestDTO;
import com.desafio.catalogo.model.dto.ProdutoResponseDTO;
import com.desafio.catalogo.service.ProdutoService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping({ "/products" })
public class ProdutoController {

	@Autowired
	private ProdutoService service;

	@GetMapping
	@ApiOperation("Lista de produtos")
	public List<ProdutoResponseDTO> getListProduto() {
		return this.service.getListProduto();
	}

	@PostMapping
	@ApiOperation("Criação de um produto")
	@ResponseStatus(HttpStatus.CREATED)
	public ProdutoResponseDTO criarProduto(@Valid @RequestBody ProdutoRequestDTO produto) {
		return this.service.criarProduto(produto);
	}

	@PutMapping({ "/{id}" })
	@ApiOperation("Atualização de um produto")
	public ProdutoResponseDTO atualizarProduto(@Valid @RequestBody ProdutoRequestDTO produtoRequest,
			@PathVariable Long id) throws Exception {
		return this.service.atualizarProduto(produtoRequest, id);
	}

	@GetMapping({ "/{id}" })
	@ApiOperation("Busca de um produto por ID")
	public ProdutoResponseDTO getProduto(@PathVariable Long id) throws Exception {
		return this.service.getProduto(id);
	}

	@DeleteMapping({ "/{id}" })
	@ApiOperation("Deleção de um produto")
	public void deleteProduto(@PathVariable Long id) throws Exception {
		this.service.deleteProduto(id);
	}

	@GetMapping({ "/search" })
	@ApiOperation("Lista de produtos filtrados")
	public List<ProdutoResponseDTO> getListFilterProduto(@QueryParam("min_price") String min_price,
			@QueryParam("max_price") String max_price, @QueryParam("q") String q) {
		return this.service.getListFilterProduto(min_price, max_price, q);
	}
}
