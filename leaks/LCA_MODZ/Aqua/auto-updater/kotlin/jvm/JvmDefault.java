// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.jvm;

import kotlin.SinceKotlin;
import kotlin.Metadata;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import kotlin.Deprecated;
import kotlin.annotation.AnnotationTarget;
import kotlin.annotation.Target;
import java.lang.annotation.Annotation;

@Target(allowedTargets = { AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY })
@Deprecated(message = "Switch to new -Xjvm-default modes: `all` or `all-compatibility`")
@Retention(RetentionPolicy.RUNTIME)
@java.lang.annotation.Target({ ElementType.METHOD })
@Metadata(mv = { 1, 7, 1 }, k = 1, xi = 48, d1 = { "\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002" }, d2 = { "Lkotlin/jvm/JvmDefault;", "", "kotlin-stdlib" })
@SinceKotlin(version = "1.2")
public @interface JvmDefault {
}
