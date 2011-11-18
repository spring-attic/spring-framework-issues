package org.openehealth.tutorial

import org.apache.camel.model.ProcessorDefinition
class SampleModelExtension {

     static extensions = {
         
         ProcessorDefinition.metaClass.reverse = {
             delegate.transmogrify { it.reverse() }
         }
         
     }
     
}
