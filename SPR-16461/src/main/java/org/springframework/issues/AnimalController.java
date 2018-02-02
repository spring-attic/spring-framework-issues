package org.springframework.issues;

import org.springframework.issues.model.Animal;
import org.springframework.issues.model.Cat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class AnimalController
{
	private final Cat bizzy = new Cat("Bizzy", 10);

	@RequestMapping(method = GET, value = "/animal")
	public Animal getAnimal()
	{
		return bizzy;
	}

	@RequestMapping(method = GET, value = "/cat")
	public Cat getCat()
	{
		return bizzy;
	}
}
