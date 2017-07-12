package beans;

import java.util.logging.Logger;

import javax.inject.Inject;

import annotations.interceptor_binding.Loggable;
import annotations.qualifiers.ThirteenDigits;
import annotations.qualifiers.Random;
import beans.interfaces.NumberGenerator;


@ThirteenDigits
public class IsbnGenerator implements NumberGenerator {

	@Inject
	private Logger logger;
	
	@Inject @ThirteenDigits
	private String prefix;
	
	@Inject @ThirteenDigits
	private int editorNumber;
	
	@Inject @Random
	private int postfix;
	
	@Loggable
	@Override
	public String generateNumber() {
		String isbn = prefix + editorNumber + "-" + postfix;
		logger.info("Generated ISBN : " + isbn);
		return isbn;
	}
}
