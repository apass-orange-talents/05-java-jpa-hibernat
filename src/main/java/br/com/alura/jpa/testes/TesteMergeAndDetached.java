package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class TesteMergeAndDetached {
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		Conta conta = new Conta();
		
		conta.setTitular("conta 1");
		conta.setConta(102);
		conta.setSaldo(1000.00);
		
		em.getTransaction().begin();
		
		em.merge(conta);
		
		em.getTransaction().commit();
		
	}
}
