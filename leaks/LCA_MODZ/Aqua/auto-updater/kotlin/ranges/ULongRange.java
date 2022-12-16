// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.ranges;

import org.jetbrains.annotations.Nullable;
import kotlin.UnsignedKt;
import kotlin.ExperimentalStdlibApi;
import kotlin.Deprecated;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.WasExperimental;
import kotlin.SinceKotlin;
import kotlin.Metadata;
import kotlin.ULong;

@Metadata(mv = { 1, 7, 1 }, k = 1, xi = 48, d1 = { "\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u0000 \u001c2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u00020\u00030\u0004:\u0001\u001cB\u0018\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u00f8\u0001\u0000¢\u0006\u0002\u0010\u0007J\u001b\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0003H\u0096\u0002\u00f8\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0096\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0010H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016R \u0010\b\u001a\u00020\u00038VX\u0097\u0004\u00f8\u0001\u0000\u00f8\u0001\u0001¢\u0006\f\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0006\u001a\u00020\u00038VX\u0096\u0004\u00f8\u0001\u0000\u00f8\u0001\u0001¢\u0006\u0006\u001a\u0004\b\r\u0010\fR\u001a\u0010\u0005\u001a\u00020\u00038VX\u0096\u0004\u00f8\u0001\u0000\u00f8\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u000e\u0010\f\u00f8\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\u001d" }, d2 = { "Lkotlin/ranges/ULongRange;", "Lkotlin/ranges/ULongProgression;", "Lkotlin/ranges/ClosedRange;", "Lkotlin/ULong;", "Lkotlin/ranges/OpenEndRange;", "start", "endInclusive", "(JJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "endExclusive", "getEndExclusive-s-VKNKU$annotations", "()V", "getEndExclusive-s-VKNKU", "()J", "getEndInclusive-s-VKNKU", "getStart-s-VKNKU", "contains", "", "value", "contains-VKZWuLQ", "(J)Z", "equals", "other", "", "hashCode", "", "isEmpty", "toString", "", "Companion", "kotlin-stdlib" })
@SinceKotlin(version = "1.5")
@WasExperimental(markerClass = { ExperimentalUnsignedTypes.class })
public final class ULongRange extends ULongProgression implements ClosedRange<ULong>, OpenEndRange<ULong>
{
    @NotNull
    public static final Companion Companion;
    @NotNull
    private static final ULongRange EMPTY;
    
    private ULongRange(final long start, final long endInclusive) {
        super(start, endInclusive, 1L, null);
    }
    
    public long getStart-s-VKNKU() {
        return this.getFirst-s-VKNKU();
    }
    
    public long getEndInclusive-s-VKNKU() {
        return this.getLast-s-VKNKU();
    }
    
    @java.lang.Deprecated
    public long getEndExclusive-s-VKNKU() {
        if (this.getLast-s-VKNKU() == -1L) {
            throw new IllegalStateException("Cannot return the exclusive upper bound of a range that includes MAX_VALUE.".toString());
        }
        return ULong.constructor-impl(this.getLast-s-VKNKU() + ULong.constructor-impl((long)1 & 0xFFFFFFFFL));
    }
    
    public boolean contains-VKZWuLQ(final long value) {
        return UnsignedKt.ulongCompare(this.getFirst-s-VKNKU(), value) <= 0 && UnsignedKt.ulongCompare(value, this.getLast-s-VKNKU()) <= 0;
    }
    
    @Override
    public boolean isEmpty() {
        return UnsignedKt.ulongCompare(this.getFirst-s-VKNKU(), this.getLast-s-VKNKU()) > 0;
    }
    
    @Override
    public boolean equals(@Nullable final Object other) {
        return other instanceof ULongRange && ((this.isEmpty() && ((ULongRange)other).isEmpty()) || (this.getFirst-s-VKNKU() == ((ULongRange)other).getFirst-s-VKNKU() && this.getLast-s-VKNKU() == ((ULongRange)other).getLast-s-VKNKU()));
    }
    
    @Override
    public int hashCode() {
        return this.isEmpty() ? -1 : (31 * (int)ULong.constructor-impl(this.getFirst-s-VKNKU() ^ ULong.constructor-impl(this.getFirst-s-VKNKU() >>> 32)) + (int)ULong.constructor-impl(this.getLast-s-VKNKU() ^ ULong.constructor-impl(this.getLast-s-VKNKU() >>> 32)));
    }
    
    @NotNull
    @Override
    public String toString() {
        return (Object)ULong.toString-impl(this.getFirst-s-VKNKU()) + ".." + (Object)ULong.toString-impl(this.getLast-s-VKNKU());
    }
    
    public static final /* synthetic */ ULongRange access$getEMPTY$cp() {
        return ULongRange.EMPTY;
    }
    
    static {
        Companion = new Companion(null);
        EMPTY = new ULongRange(-1L, 0L, null);
    }
    
    @Metadata(mv = { 1, 7, 1 }, k = 1, xi = 48, d1 = { "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007" }, d2 = { "Lkotlin/ranges/ULongRange$Companion;", "", "()V", "EMPTY", "Lkotlin/ranges/ULongRange;", "getEMPTY", "()Lkotlin/ranges/ULongRange;", "kotlin-stdlib" })
    public static final class Companion
    {
        private Companion() {
        }
        
        @NotNull
        public final ULongRange getEMPTY() {
            return ULongRange.access$getEMPTY$cp();
        }
    }
}
