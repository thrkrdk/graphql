package com.graphql.springboot.graphql.instrumentation;

import graphql.ExecutionResult;
import graphql.execution.instrumentation.InstrumentationContext;
import graphql.execution.instrumentation.SimpleInstrumentation;
import graphql.execution.instrumentation.SimpleInstrumentationContext;
import graphql.execution.instrumentation.parameters.InstrumentationExecutionParameters;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;

@Slf4j
@Component
public class RequestLoggingInstrumentation extends SimpleInstrumentation {
//  Graphql execution adımlarını konfigure etmek için kullanılır

    public static final String ILISKI_ID = "iliski_id";
    @Override
    public InstrumentationContext<ExecutionResult> beginExecution(
            InstrumentationExecutionParameters parameters) {
        log.info("{} sorgusuna ait parametreler: {}", parameters.getQuery(), parameters.getVariables());
        return SimpleInstrumentationContext.whenCompleted((executionResult, throwable) -> {
                log.info("tamamlandı");
        });
    }
}
