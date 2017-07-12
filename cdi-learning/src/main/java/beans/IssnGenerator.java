package beans;

import java.util.Random;
import java.util.logging.Logger;

import javax.inject.Inject;

import annotations.interceptor_binding.Loggable;
import annotations.qualifiers.EightDigits;
import beans.interfaces.NumberGenerator;

@EightDigits
public class IssnGenerator implements NumberGenerator {

	@Inject
	private Logger logger;
	
	@Loggable
	@Override
	public String generateNumber() {
		String issn = "8-" + Math.abs(new Random().nextInt()) % 100000000;
		logger.info("Generated ISBN : " + issn);
		return issn;
	}

}
