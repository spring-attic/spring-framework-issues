package org.springframework.issues.test2;

public class Test2DTO implements Identifiable2<Long> {

	private static final long serialVersionUID = -1518868790807131221L;

	private Long id;
	private String value1;
	private String value2;

	public String getValue1() {
		return value1;
	}

	public void setValue1(String value1) {
		this.value1 = value1;
	}

	public String getValue2() {
		return value2;
	}

	public void setValue2(String value2) {
		this.value2 = value2;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("TestDTO[");
		sb.append("value1=").append(value1);
		sb.append(",value2=").append(value2);
		sb.append("]");
		return sb.toString();
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

}
