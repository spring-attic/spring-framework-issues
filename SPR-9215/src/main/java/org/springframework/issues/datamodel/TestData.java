package org.springframework.issues.datamodel;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "TBL_TEST")
public class TestData implements Serializable {
	private static final long serialVersionUID = 6731190069981115642L;

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "test-gen")
	@TableGenerator(name = "test-gen", pkColumnName = "TEST", allocationSize = 150, table = "TBL_IDS")
	@Column(name = "ID")
	private Long id;

	@Basic
	@Column(name = "NAME", length = 255)
	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
