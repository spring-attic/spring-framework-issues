package org.springframework.issues;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class Foo {

	private List<Bar> bars = new ArrayList<Bar>();

	public List<Bar> getBars() {
		return bars;
	}

	@Autowired
	public void setBars(List<Bar> bars) {
		this.bars.addAll(bars);
	}
}