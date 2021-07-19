package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class AlteraSaldoConta {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura_jpa");

		EntityManager em = emf.createEntityManager();
		
		Conta conta = em.find(Conta.class, 2L);
		
		conta.setTitular("conta 2");
		conta.setConta(102);
		
		em.getTransaction().begin();
		
		conta.setSaldo(300.00);
		
		em.getTransaction().commit();
	}
}
