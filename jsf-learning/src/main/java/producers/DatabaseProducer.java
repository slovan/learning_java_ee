package producers;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class DatabaseProducer {
	@Produces
	@PersistenceContext(unitName = "learningJSF")
	private EntityManager em;
}
