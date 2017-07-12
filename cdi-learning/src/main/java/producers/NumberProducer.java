package producers;

import javax.enterprise.inject.Produces;

import annotations.qualifiers.Random;
import annotations.qualifiers.ThirteenDigits;


public class NumberProducer {
	
	@Produces @ThirteenDigits
	private String prefix13digits = "13-";
	
	@Produces @ThirteenDigits
	private int editorNumber = 84356;
	
	@Produces @Random
	public int random8digits() {
		return Math.abs(new java.util.Random().nextInt()) % 100000000;
	}
}
