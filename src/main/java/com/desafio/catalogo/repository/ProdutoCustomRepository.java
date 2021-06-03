package com.desafio.catalogo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.desafio.catalogo.model.Produto;

@Repository
public class ProdutoCustomRepository {

	private EntityManager em;

	public ProdutoCustomRepository(EntityManager em) {
		this.em = em;
	}

	public List<Produto> find(String min_price, String max_price, String q) {
		
		String query = "select P from Produto as P";
		String condicao = " where ";

		if (min_price != null) {
			query = query + condicao + " P.price >= :min_price";
			condicao = " and ";
		}

		if (max_price != null) {
			query = query + condicao + " P.price <= :max_price";
			condicao = " and ";
		}

		if (q != null) {
			query = query + condicao + "name like '%" + q + "%' or description like '%" + q + "%'";
		}

		TypedQuery<Produto> cq = this.em.createQuery(query, Produto.class);

		if (min_price != null) {
			cq.setParameter("min_price", Double.valueOf(min_price));
		}

		if (max_price != null) {
			cq.setParameter("max_price", Double.valueOf(max_price));
		}

		return cq.getResultList();
	}
}
