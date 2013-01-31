
package org.springframework.issues;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@v
public class ActivateAccountForm {

	@NotEmpty(groups = Login1Checks.class)
	@Size.List({
		@Size(groups = Login2Checks.class, min = 2, message = "{value.too-short}"),
		@Size(groups = Login2Checks.class, max = 4, message = "{value.too-long}") })
	private String login = "x";

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
}
