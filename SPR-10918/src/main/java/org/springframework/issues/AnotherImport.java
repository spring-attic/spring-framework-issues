package org.springframework.issues;

import org.springframework.context.annotation.Import;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Import(TestImport.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface AnotherImport {
}