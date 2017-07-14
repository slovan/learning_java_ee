package constraints;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.inject.Inject;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import beans.ZipCodeChecker;
import constraints.annotations.ZipCode;
import qualifiers.annotations.USA;

public class ZipCodeValidator implements ConstraintValidator<ZipCode, String> {

	@Inject	@USA
	private ZipCodeChecker checker;
	
	private Pattern zipPattern = Pattern.compile("\\d{5}(-\\d{5})?");

	public void initialize(ZipCode zipCode) {
	}

	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (value == null)
			return true;
		Matcher m = zipPattern.matcher(value);
		if (!m.matches())
			return false;
		System.out.println(checker == null);
		return checker.isZipCodeValid(value);
	}
}
