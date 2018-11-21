# Spring WebFlux Validation

This repo was created to reproduce problem with translating validation errors in Spring WebFlux.

There are custom messages for `@NotNull` error in both English and Polish. 

The `TranslateValidationWebMvcTest` test checks whether the custom message is served when invalid object is sent and the locale is Polish.
This test passes, but webflux equivalent `TranslateValidationWebFluxTest` does not.

I assume it is because `LocalValidatorFactoryBean` uses `LocaleContextMessageInterpolator`. Hibernate Validator calls
the `public String interpolate(String message, Context context)` method, which relays on the `LocaleContextHolder`.
It uses a `ThreadLocal` which can't be used in WebFlux.