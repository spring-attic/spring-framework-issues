
package org.springframework.issues;

@MatchingFields(field = "name", confirmField = "confirmName")
public class ActivateAccountForm {

	private String name = "x";

	private String confirmName = "y";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getConfirmName() {
		return confirmName;
	}

	public void setConfirmName(String confirmName) {
		this.confirmName = confirmName;
	}

}
