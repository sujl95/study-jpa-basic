package study_jpa_basic.ex1hellojpa.hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello"); // DB연결이 다 된다

		EntityManager em = emf.createEntityManager(); // createEntityManager 를 꺼내야한다
		EntityTransaction tx = em.getTransaction(); // transaction 을 얻는다
		tx.begin(); // 트랜잭션 시작


		try {
			Member member = new Member();
			member.setId(3L);
			member.setName("HelloC");
			System.out.println("persist 전");
			em.persist(member);
			System.out.println("persist 후");
			tx.commit(); // 커밋 해주어야 한다.
			System.out.println("commit 후");
		} catch (Exception e) {
			tx.rollback();
		} finally {
			em.close();
		}
		emf.close();
	}
}