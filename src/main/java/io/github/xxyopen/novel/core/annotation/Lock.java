package io.github.xxyopen.novel.core.annotation;

import io.github.xxyopen.novel.core.common.constant.ErrorCodeEnum;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Distributed Lock Annotation
 */
@Documented
@Retention(RUNTIME)
@Target(METHOD)
public @interface Lock {

    String prefix();

    boolean isWait() default false;

    long waitTime() default 3L;

    ErrorCodeEnum failCode() default ErrorCodeEnum.OK;

}
