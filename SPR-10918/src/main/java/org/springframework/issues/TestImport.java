package org.springframework.issues;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class TestImport implements ImportBeanDefinitionRegistrar {
    public static int theInvocations = 0;

    @Override
    public void registerBeanDefinitions(AnnotationMetadata anImport, BeanDefinitionRegistry aRegistry) {
        theInvocations++;
    }
}