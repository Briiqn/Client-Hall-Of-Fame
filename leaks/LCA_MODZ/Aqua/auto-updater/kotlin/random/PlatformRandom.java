// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.random;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import java.util.Random;
import org.jetbrains.annotations.NotNull;
import kotlin.Metadata;
import java.io.Serializable;

@Metadata(mv = { 1, 7, 1 }, k = 1, xi = 48, d1 = { "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u0000 \t2\u00020\u00012\u00060\u0002j\u0002`\u0003:\u0001\tB\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\n" }, d2 = { "Lkotlin/random/PlatformRandom;", "Lkotlin/random/AbstractPlatformRandom;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "impl", "Ljava/util/Random;", "(Ljava/util/Random;)V", "getImpl", "()Ljava/util/Random;", "Companion", "kotlin-stdlib" })
final class PlatformRandom extends AbstractPlatformRandom implements Serializable
{
    @NotNull
    private static final Companion Companion;
    @NotNull
    private final java.util.Random impl;
    @Deprecated
    private static final long serialVersionUID = 0L;
    
    public PlatformRandom(@NotNull final java.util.Random impl) {
        Intrinsics.checkNotNullParameter(impl, "impl");
        this.impl = impl;
    }
    
    @NotNull
    @Override
    public java.util.Random getImpl() {
        return this.impl;
    }
    
    static {
        Companion = new Companion(null);
    }
    
    @Metadata(mv = { 1, 7, 1 }, k = 1, xi = 48, d1 = { "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005" }, d2 = { "Lkotlin/random/PlatformRandom$Companion;", "", "()V", "serialVersionUID", "", "kotlin-stdlib" })
    private static final class Companion
    {
    }
}
