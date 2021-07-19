package br.com.alura.jpa.testes;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.sun.tools.javac.util.List;

import br.com.alura.jpa.modelo.Categoria;
import br.com.alura.jpa.modelo.Movimentacao;
import br.com.alura.jpa.modelo.TipoMovimentacao;

public class TestaRelacionamentoCategoria {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura_jpa");
		EntityManager em = emf.createEntityManager();

		Categoria categoria1 = new Categoria("viagem");
		Categoria categoria2 = new Categoria("negócio");

		Movimentacao movimentacao1 = new Movimentacao();
		movimentacao1.setDescricao("Viagem à SP");
		movimentacao1.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		movimentacao1.setData(LocalDateTime.now());
		movimentacao1.setValor(new BigDecimal(300.0));
		movimentacao1.setCategorias(Arrays.asList(categoria1, categoria2));

		Movimentacao movimentacao2 = new Movimentacao();
		movimentacao2.setDescricao("Viagem à RG");
		movimentacao2.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		movimentacao2.setData(LocalDateTime.now());
		movimentacao2.setValor(new BigDecimal(400.0));
		movimentacao2.setCategorias(Arrays.asList(categoria1, categoria2));
		
		em.getTransaction().begin();
		
		em.persist(categoria1);
		em.persist(categoria2);
		em.persist(movimentacao1);
		em.persist(movimentacao2);
		
		em.getTransaction().commit();

	}

}
