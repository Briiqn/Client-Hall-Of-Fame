// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.jvm.internal;

import kotlin.jvm.JvmName;
import kotlin.SinceKotlin;
import kotlin.Metadata;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
import kotlin.annotation.AnnotationTarget;
import kotlin.annotation.Target;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.Retention;
import java.lang.annotation.Annotation;

@Retention(AnnotationRetention.BINARY)
@Target(allowedTargets = { AnnotationTarget.CLASS })
@java.lang.annotation.Retention(RetentionPolicy.CLASS)
@java.lang.annotation.Target({ ElementType.TYPE })
@Metadata(mv = { 1, 7, 1 }, k = 1, xi = 48, d1 = { "\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0010\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0007¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007" }, d2 = { "Lkotlin/jvm/internal/SerializedIr;", "", "bytes", "", "", "b", "()[Ljava/lang/String;", "kotlin-stdlib" })
@SinceKotlin(version = "1.6")
public @interface SerializedIr {
    @JvmName(name = "b")
    String[] b() default {};
}
