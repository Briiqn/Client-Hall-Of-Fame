// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.reflect;

import kotlin.SinceKotlin;
import kotlin.Metadata;

@Metadata(mv = { 1, 7, 1 }, k = 1, xi = 48, d1 = { "\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007" }, d2 = { "Lkotlin/reflect/KVisibility;", "", "(Ljava/lang/String;I)V", "PUBLIC", "PROTECTED", "INTERNAL", "PRIVATE", "kotlin-stdlib" })
@SinceKotlin(version = "1.1")
public enum KVisibility
{
    PUBLIC, 
    PROTECTED, 
    INTERNAL, 
    PRIVATE;
    
    private static final /* synthetic */ KVisibility[] $values() {
        return new KVisibility[] { KVisibility.PUBLIC, KVisibility.PROTECTED, KVisibility.INTERNAL, KVisibility.PRIVATE };
    }
    
    static {
        $VALUES = $values();
    }
}
