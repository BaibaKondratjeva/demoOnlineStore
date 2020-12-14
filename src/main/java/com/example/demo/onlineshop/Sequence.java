package com.example.demo.onlineshop;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicLong;

import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_PROTOTYPE;

@Scope(SCOPE_PROTOTYPE)
@Component
public class Sequence {
    private AtomicLong SEQUENCE = new AtomicLong(1);

    long next() {
        return SEQUENCE.getAndIncrement();
    }
}
