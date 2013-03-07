
package org.springframework.issues;

import javax.validation.constraints.NotNull;

public interface Foo {

	void bar(@NotNull String s) throws ValidationException;

	void bar() throws ValidationException;
}
