package org.springframework.issues;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class TestController {


	@RequestMapping(value = "/establishments/employees/{areaOfResponsibility.owner.id}", method = RequestMethod.GET)
	public void getEstablishmentsByEmployeeId(
			@Valid @ModelAttribute("request-payload") EstablishmentDto establishment) {

		System.out.println("areaOfResponsibility.owner.id field: " +
				establishment.getAreaOfResponsibility().getOwner().getId());

	}


	@RequestMapping(value = "/assets/establishments/{establishmentId}", method = RequestMethod.GET)
	public void getAssetByEstablishmentId(
			@Valid @ModelAttribute("request-payload") EstablishmentDto establishment) {

		System.out.println("establishmentId field: " + establishment.getEstablishmentId());

	}

}
