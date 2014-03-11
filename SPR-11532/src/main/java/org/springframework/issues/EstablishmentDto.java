package org.springframework.issues;

public class EstablishmentDto {

	private String establishmentId;

	private AreaOfResponsibility areaOfResponsibility;


	public String getEstablishmentId() {
		return establishmentId;
	}

	public void setEstablishmentId(String establishmentId) {
		this.establishmentId = establishmentId;
	}

	public AreaOfResponsibility getAreaOfResponsibility() {
		return areaOfResponsibility;
	}

	public void setAreaOfResponsibility(AreaOfResponsibility areaOfResponsibility) {
		this.areaOfResponsibility = areaOfResponsibility;
	}

}
