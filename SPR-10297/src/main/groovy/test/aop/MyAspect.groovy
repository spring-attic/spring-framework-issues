package test.aop


import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.DeclareParents


@Aspect
class MyAspect {

    @DeclareParents(value = 'test.service.*', defaultImpl = RunnableMixin)
    private Runnable mixin;
}
