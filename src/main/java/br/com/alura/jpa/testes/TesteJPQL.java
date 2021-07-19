package br.com.alura.jpa.testes;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.modelo.Movimentacao;

public class TesteJPQL {

	public static void main(String[] args) throws SQLException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura_jpa");
		EntityManager em = emf.createEntityManager();


		String jpql = "from Movimentacao m where m.conta = :pConta";

		Conta conta = new Conta();
		conta.setId(2L);
		
		List<Movimentacao> resultList = em.createQuery(jpql, Movimentacao.class)
				.setParameter("pConta", conta).getResultList();

		for (Movimentacao movimentacao : resultList) {
			System.out.println(movimentacao.getDescricao());
		}

	}

}
