package test;

public abstract class AbstractService<D extends AbstractDao> {

	protected D dao;
	
	public abstract void setDao(D dao);

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AbstractService [dao=");
		builder.append(dao);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
