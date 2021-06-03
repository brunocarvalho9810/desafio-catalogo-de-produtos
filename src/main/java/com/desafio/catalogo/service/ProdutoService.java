package com.desafio.catalogo.service;

import com.desafio.catalogo.model.dto.ProdutoRequestDTO;
import com.desafio.catalogo.model.dto.ProdutoResponseDTO;
import java.util.List;

public interface ProdutoService {
   List<ProdutoResponseDTO> getListProduto();

   ProdutoResponseDTO criarProduto(ProdutoRequestDTO produto);

   ProdutoResponseDTO atualizarProduto(ProdutoRequestDTO produto, Long id) throws Exception;

   ProdutoResponseDTO getProduto(Long id) throws Exception;

   void deleteProduto(Long id) throws Exception;

   List<ProdutoResponseDTO> getListFilterProduto(String min_price, String max_price, String q);
}