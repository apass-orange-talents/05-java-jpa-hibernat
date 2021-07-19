package br.com.alura.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Categoria;
import br.com.alura.jpa.modelo.Movimentacao;

public class TesteComJoinJPQL {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura_jpa");
		EntityManager em = emf.createEntityManager();
		
		String jpql = "SELECT m FROM Movimentacao m join m.categorias ct where ct = :pCategoria";
		
		Categoria categoria = new Categoria();
		categoria.setId(2L);
		
		List<Movimentacao> resultList = em.createQuery(jpql, Movimentacao.class).setParameter("pCategoria", categoria).getResultList();
		
		for (Movimentacao movimentacao : resultList) {
			System.out.println("ID: " + movimentacao.getId());
			System.out.println("Descrição: " + movimentacao.getDescricao());
			System.out.println("Valor " + movimentacao.getValor());
			System.out.println();
			
		}
	}
}
