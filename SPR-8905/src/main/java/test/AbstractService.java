package test;

public abstract class AbstractService<D extends AbstractDao> {

	protected D dao;

	public abstract void setDao(D dao);

}
