package pl.bug;


public class A implements IA {

	private IC c;
	private ICWithAutoWired cWithAutoWired;
	
	public void setC( IC c ) {
		this.c = c;
	}
	
	public void setcWithAutoWired( ICWithAutoWired cWithAutoWired ) {
		this.cWithAutoWired = cWithAutoWired;
	}
}
