package example;

import example.annotation.AfterAnnotation;
import example.annotation.BeforeAnnotation;

public class CheckedInterfaceImpl implements CheckedInterface {

	@Override
	@BeforeAnnotation
	@AfterAnnotation
	public void checkedMethod() {
		System.out.println("checkedMethod");
	}

}
