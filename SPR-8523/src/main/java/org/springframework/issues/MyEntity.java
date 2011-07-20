package org.springframework.issues;

import javax.persistence.*;

@Entity
@Table(name = "T_ENTITY")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class MyEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private String id;

	public String getId() {
		return id;
	}
}
