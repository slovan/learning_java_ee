package beans;

import java.util.Random;
import java.util.logging.Logger;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import annotations.interceptor_binding.Loggable;
import annotations.qualifiers.ThirteenDigits;
import beans.interfaces.NumberGenerator;

@Alternative
@ThirteenDigits
public class MockGenerator implements NumberGenerator {

	@Inject
	private Logger logger;
	
	@Loggable
	@Override
	public String generateNumber() {
		String mock = "MOCK-" + Math.abs(new Random().nextInt()) % 100000000;
		logger.info("Generated MOCK : " + mock);
		return mock;
	}

}
