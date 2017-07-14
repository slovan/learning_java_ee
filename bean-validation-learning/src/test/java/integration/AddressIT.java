package integration;

import static org.junit.Assert.assertEquals;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.jboss.weld.environment.se.Weld;
import org.junit.Test;

import beans.Address;

public class AddressIT {
	@Test
	public void shouldRaiseConstraintViolationCauseInvalidZipCode() {
		Weld weld = new Weld();
		weld.initialize();

		ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
		Validator validator = vf.getValidator();
		Address address = new Address("233 Spring Street", "New York", "NY", "Dummy", "USA");
		Set<ConstraintViolation<Address>> violations = validator.validate(address);
		assertEquals(1, violations.size());
		vf.close();
		
		weld.shutdown();
	}
}
