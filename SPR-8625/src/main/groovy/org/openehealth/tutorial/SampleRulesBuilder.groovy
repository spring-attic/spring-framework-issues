package org.openehealth.tutorial

import ca.uhn.hl7v2.validation.ValidationContext

import org.openehealth.ipf.modules.hl7.validation.builder.RuleBuilder
import org.openehealth.ipf.modules.hl7.validation.builder.ValidationContextBuilder

class SampleRulesBuilder extends ValidationContextBuilder {

    // We define only a subset of the segments defined in the HL7 2.2 spec
    
    public RuleBuilder forContext(ValidationContext context) {
        new RuleBuilder(context)
          .forVersion('2.2')
            .message('ADT', 'A01').abstractSyntax(
                    'MSH',
                    'EVN',
                    'PID',
                    [  {  'NK1'  }  ],  
                    'PV1',
                    [  {  INSURANCE(
                              'IN1',  
                              [  'IN2'  ] , 
                              [  'IN3'  ]  
                    )}]                                                  
            )
    }
    
}
