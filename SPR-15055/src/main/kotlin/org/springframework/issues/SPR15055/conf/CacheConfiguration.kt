package org.springframework.issues.SPR15055.conf


import org.springframework.cache.annotation.EnableCaching
import org.springframework.context.annotation.Configuration

@EnableCaching
@Configuration
open class CacheConfiguration {
    //this can be empty. when removing the @EnableCaching Annotation everything works
}
