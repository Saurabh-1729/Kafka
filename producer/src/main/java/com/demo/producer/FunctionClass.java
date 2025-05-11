package com.demo.producer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class FunctionClass {
    @Bean
    public Function<String, String> uppercase() {
        return value -> value.toUpperCase();
    }
}

/*
3. Advantages of Using Function Interface:
Unified Programming Model:

Write business logic once, and run it on different environments (AWS Lambda, Azure Functions, on-premises, etc.).

Flexibility:

Supports various types like Function<T, R>, Consumer<T>, Supplier<T>, etc.

Reactive Programming:

You can define reactive functions using Function<Flux<T>, Flux<R>> for processing streams.

Reduced Boilerplate:

Focuses on business logic rather than infrastructure setup.
 */