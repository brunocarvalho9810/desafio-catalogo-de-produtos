package com.desafio.catalogo.service.impl;

import com.desafio.catalogo.builder.ProdutoBuilder;
import com.desafio.catalogo.builder.ProdutoResponseBuilder;
import com.desafio.catalogo.model.Produto;
import com.desafio.catalogo.model.dto.ProdutoRequestDTO;
import com.desafio.catalogo.model.dto.ProdutoResponseDTO;
import com.desafio.catalogo.repository.ProdutoCustomRepository;
import com.desafio.catalogo.repository.ProdutoRepository;
import com.desafio.catalogo.service.ProdutoService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.NoHandlerFoundException;

@Service
public class ProdutoServiceImpl implements ProdutoService {
	
	@Autowired
	private ProdutoRepository repository;
	
	@Autowired
	private ProdutoCustomRepository repositoryCustom;

	public List<ProdutoResponseDTO> getListProduto() {
		List<Produto> retorno = this.repository.findAll();
		List<ProdutoResponseDTO> list = new ArrayList<ProdutoResponseDTO>();
		if (!retorno.isEmpty()) {
			Iterator<Produto> var4 = retorno.iterator();
			while (var4.hasNext()) {
				Produto produto = (Produto) var4.next();
				list.add(this.builderProdutoResponse(produto));
			}
		}
		return list;
	}

	public ProdutoResponseDTO criarProduto(ProdutoRequestDTO produtoRequest) {
		Produto produto = this.builderProduto(produtoRequest);
		this.repository.save(produto);
		return this.builderProdutoResponse(produto);
	}

	public ProdutoResponseDTO atualizarProduto(ProdutoRequestDTO produtoRequest, Long id) throws Exception {
		Optional<Produto> produtoResult = this.repository.findById(id);

		if (produtoResult.isPresent()) {
			Produto produto = this.builderProduto(produtoRequest);
			produto.setId(produtoResult.get().getId());
			this.repository.save(produto);
			return this.builderProdutoResponse(produto);
		} else {
			throw new NoHandlerFoundException("PUT", "/products/" + id, (HttpHeaders) null);
		}
	}

	public ProdutoResponseDTO getProduto(Long id) throws Exception {
		Optional<Produto> produto = this.repository.findById(id);
		if (produto.isPresent()) {
			return this.builderProdutoResponse((Produto) produto.get());
		} else {
			throw new NoHandlerFoundException("GET", "/products/" + id, (HttpHeaders) null);
		}
	}

	public void deleteProduto(Long id) throws Exception {
		Optional<Produto> produto = this.repository.findById(id);
		if (produto.isPresent()) {
			this.repository.delete((Produto) produto.get());
		} else {
			throw new NoHandlerFoundException("DELETE", "/products/" + id, (HttpHeaders) null);
		}
	}

	public List<ProdutoResponseDTO> getListFilterProduto(String min_price, String max_price, String q) {
		List<Produto> retorno = this.repositoryCustom.find(min_price, max_price, q);
		List<ProdutoResponseDTO> list = new ArrayList<ProdutoResponseDTO>();
		if (!retorno.isEmpty()) {
			Iterator<Produto> var7 = retorno.iterator();
			while (var7.hasNext()) {
				Produto produto = (Produto) var7.next();
				list.add(this.builderProdutoResponse(produto));
			}
		}
		return list;
	}

	private Produto builderProduto(ProdutoRequestDTO dto) {
		return (new ProdutoBuilder())
				.comDescription(dto.getDescription())
				.comName(dto.getName())
				.comPrice(dto.getPrice())
				.builder();
	}

	private ProdutoResponseDTO builderProdutoResponse(Produto produto) {
		return (new ProdutoResponseBuilder())
				.comId(produto.getId())
				.comDescription(produto.getDescription())
				.comName(produto.getName())
				.comPrice(produto.getPrice())
				.builder();
	}
}
