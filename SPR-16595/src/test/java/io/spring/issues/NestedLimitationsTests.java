package io.spring.issues;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

@SpringBootTest
@Import(Imported.class)
class NestedLimitationsTests {

	@Test
	void outerTest() {
	}

	@Nested
	@Import(Imported.class)
	class NestedTests {

		@Test
		void innerTest() {
		}

		@Nested
		@Import(Imported.class)
		class NestedNestedTests {

			@Test
			void innerInnerTest() {
			}
		}
	}
}

@Component
class Imported {
}