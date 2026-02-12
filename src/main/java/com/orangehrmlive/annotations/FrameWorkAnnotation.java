package com.orangehrmlive.annotations;

import com.orangehrmlive.enums.AuthorType;
import com.orangehrmlive.enums.CategoryType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface FrameWorkAnnotation {
    public AuthorType[] author();
    public CategoryType[] category();

}
