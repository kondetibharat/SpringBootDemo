package com.demo.boot.context;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * Created by kondetib on 10/28/14.
 */
public class TestConditional implements Condition {

    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        return "test".equalsIgnoreCase(conditionContext.getEnvironment().getProperty("target"));
    }
}
