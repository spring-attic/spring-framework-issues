package org.springframework.issues;

import static org.junit.Assert.assertTrue;

import java.util.Comparator;

import org.junit.Test;
import org.springframework.util.AntPathMatcher;

// Negative means we prefer the first argument when both patterns match
public class ReproTests {

	@Test
	public void patternComparatorWithHierarchicalMatchAccidentalPass() {
		Comparator<String> comparator = new AntPathMatcher().getPatternComparator("/hotels/new");
		// This passes accidentally: the order is correct but for the wrong reason
		assertTrue(comparator.compare("/hotels/{hotel}", "/hotels/**") < 0);
	}

	@Test
	public void patternComparatorWithHierarchicalMatchBracketsPreferred() {
		Comparator<String> comparator = new AntPathMatcher().getPatternComparator("/hotels/new/123");
		// This passes accidentally: the order is correct but for the wrong reason
		assertTrue(comparator.compare("/hotels/{hotel}/{booking}", "/hotels/**") < 0);
	}

	@Test
	public void patternComparatorWithHierarchicalMatch() {
		Comparator<String> comparator = new AntPathMatcher().getPatternComparator("/hotels/new/123");
		// This fails, even though the first path is clearly more specific
		assertTrue(comparator.compare("/hotels/{hotel}/**", "/**") < 0);
	}

	@Test
	public void patternComparatorWithHierarchicalMatchWithWorkaround() {
		Comparator<String> comparator = new AntPathMatcher().getPatternComparator("/hotels/new/123");
		// This is a workaround
		assertTrue(comparator.compare("/hotels/{hotel}/**", "/**/**") < 0);
	}

}
