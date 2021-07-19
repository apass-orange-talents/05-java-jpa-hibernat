package br.com.alura.jpa.testes;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.modelo.Movimentacao;
import br.com.alura.jpa.modelo.TipoMovimentacao;

public class TestaRelacionamento {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura_jpa");
		
		EntityManager em = emf.createEntityManager();
	
		Movimentacao movimentacao = new Movimentacao();
		
		movimentacao.setData(LocalDateTime.now());
		movimentacao.setDescricao("Churrascaria");
		movimentacao.setValor(new BigDecimal(200.0));
		movimentacao.setTipoMovimentacao(TipoMovimentacao.ENTRADA);
		
		Conta conta = new Conta();
		conta.setAgencia(2);
		conta.setConta(210);
		conta.setTitular("Fulando da conta 210");
		conta.setSaldo(500.00);
		
		movimentacao.setConta(conta);
		
		em.getTransaction().begin();
		em.persist(conta);
		em.persist(movimentacao);
		
		em.getTransaction().commit();
		
		em.close();
	}
}
