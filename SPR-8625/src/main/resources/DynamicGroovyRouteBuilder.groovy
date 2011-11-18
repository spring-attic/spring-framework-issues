

import ca.uhn.hl7v2.validation.ValidationContext

import org.apache.camel.Exchange
import org.apache.camel.spring.SpringRouteBuilder
import org.openehealth.ipf.platform.camel.core.extend.RouteModelExtender

class DynamicGroovyRouteBuilder extends SpringRouteBuilder {
    RouteModelExtender routeModelExtender;

    void configure() {
        from('jetty:http://localhost:8080/tutorial')                  // start HTTP server
            .to('direct:input')                                       // forward request

        from('direct:input')                                          // receive HL7 message
            .unmarshal().ghl7()                                       // create message adapter (HL7 DSL support)
            .validate().ghl7()
                .profile(lookup(ValidationContext.class))             // validate against custom validation context
            .transmogrify { msg ->
                msg.PV1[3][2] = ''                                    // clear room nr.
                msg.PV1[3][3] = ''                                    // clear bed nr.
                msg.PID[7][1] = msg.PID[7][1].value.substring(0, 8)   // format birth date
                msg.PID[8]    = msg.PID[8].mapGender()                // map 'gender' code
                msg                                                   // return result
            }
            .setHeader(Exchange.FILE_NAME) {exchange ->               // set filename header to
                exchange.in.body.MSH[4].value + '.hl7'                // sending facility (MSH[4])
            }
            .marshal().ghl7()                                         // convert to external representation
            .to('file:target/output')                                 // write external representation to file
    }    
    
}
