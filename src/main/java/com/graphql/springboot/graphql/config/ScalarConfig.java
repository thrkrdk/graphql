package com.graphql.springboot.graphql.config;

import graphql.scalars.ExtendedScalars;
import graphql.schema.GraphQLScalarType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ScalarConfig {

    @Bean
    public GraphQLScalarType nonNegativeInt() {
        return ExtendedScalars.NonNegativeInt;
    }

    @Bean
    public GraphQLScalarType date() {
        return ExtendedScalars.Date;
    }

    @Bean
    public GraphQLScalarType dateTime() {
        return ExtendedScalars.DateTime;
    }

    @Bean
    public GraphQLScalarType nonNegativeFloat() {
        return ExtendedScalars.NonNegativeFloat;
    }

    @Bean
    public GraphQLScalarType time() {
        return ExtendedScalars.Time;
    }
    
     @Bean
    public GraphQLScalarType longScalar() {
        return GraphQLScalarType.newScalar().name("Long").description("Java 8 Long as scalar.").coercing(new Coercing<Long, String>() {
            @Override
            public String serialize(final Object dataFetcherResult) {
                if (dataFetcherResult instanceof Long) {
                    return dataFetcherResult.toString();
                } else {
                    throw new CoercingSerializeException("Expected a Long object.");
                }
            }

            @Override
            public Long parseValue(final Object input) {
                try {
                    if (input instanceof String) {
                        return Long.parseLong((String) input);
                    } else {
                        throw new CoercingParseValueException("Expected a String");
                    }
                } catch (Exception e) {
                    throw new CoercingParseValueException(String.format("Not a valid Long: '%s'.", input), e);
                }
            }

            @Override
            public Long parseLiteral(final Object input) {
                if (input instanceof StringValue) {
                    try {
                        return Long.parseLong((((StringValue) input).getValue()));
                    } catch (Exception e) {
                        throw new CoercingParseLiteralException(e);
                    }
                } else {
                    throw new CoercingParseLiteralException("Expected a StringValue.");
                }
            }
        }).build();
    }
}
