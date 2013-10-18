package org.springframework.issues;

/**
 * @author piofin <piotr.findeisen@syncron.com>
 * @since Oct 17, 2013
 */
public class Fooizm extends Foo {

	@Override
	public MoreBar getBar() {
		return (MoreBar) super.getBar();
	}
}
