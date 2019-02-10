package com.hlj.util.annotation.field;

import java.lang.annotation.*;


@Documented
@Target(ElementType.FIELD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface FieldInfo {
	
	
	    String value() default ""; //?????????????????    @MethodInfo("Healerjean");
	    
}
