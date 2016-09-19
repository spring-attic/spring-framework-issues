import org.springframework.cache.annotation.Cacheable

class Sample {

	@Cacheable("foo")
	String test() {
		"Hello World"
	}

	String toString() {
		test()
	}

}