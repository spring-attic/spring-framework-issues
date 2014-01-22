
package org.springframework.issues;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TEST_ENTITY")
public class TestEntity {
	
	@Id
	@Column(name="TE_NAME", nullable=false)
	private String			name;
	
	@Column(name="TE_COUNT", nullable=false)
	private int				count;

	
	public TestEntity() {
	}
	
	public TestEntity(String name, int count) {
		this.name = name;
		this.count = count;
	}
	
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCount() {
		return this.count;
	}

	public void setCount(int count) {	    
		this.count = count;
		
	}
}
