package ru.rogzy.api.core.annotations.api;


import name.falgout.jeffrey.testing.junit.guice.IncludeModule;
import org.junit.jupiter.api.Tag;
import ru.rogzy.api.core.modules.ApiModule;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Retention(RUNTIME)
@Target({TYPE, METHOD})
@Inherited
@Tag("api")
@IncludeModule(ApiModule.class)
public @interface Api {
}
