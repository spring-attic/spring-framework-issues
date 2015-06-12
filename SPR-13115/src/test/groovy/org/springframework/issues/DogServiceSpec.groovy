package org.springframework.issues

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.SpringApplicationContextLoader
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

@ContextConfiguration(loader = SpringApplicationContextLoader, locations = ['org.springframework.issues'])
class DogServiceSpec extends Specification {

    @Autowired
    private DogService subject

    def 'should introduce by his name'() {
        given:
            String introduction = subject.introduce('Curly')
        expect:
            introduction =~ /.*Curly.*/
    }

}
