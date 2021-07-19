package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class CriaConta {
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		Conta conta = new Conta();
		
		conta.setAgencia(1);
		conta.setConta(101);
		conta.setTitular("numero 1");
		conta.setSaldo(500D);
		
		em.getTransaction().begin();
		em.persist(conta);
		em.getTransaction().commit();
	}
}
