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
import kotlin.UInt;

@Metadata(mv = { 1, 7, 1 }, k = 1, xi = 48, d1 = { "\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u0000 \u001c2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u00020\u00030\u0004:\u0001\u001cB\u0018\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u00f8\u0001\u0000¢\u0006\u0002\u0010\u0007J\u001b\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0003H\u0096\u0002\u00f8\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0096\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0010H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016R \u0010\b\u001a\u00020\u00038VX\u0097\u0004\u00f8\u0001\u0000\u00f8\u0001\u0001¢\u0006\f\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0006\u001a\u00020\u00038VX\u0096\u0004\u00f8\u0001\u0000\u00f8\u0001\u0001¢\u0006\u0006\u001a\u0004\b\r\u0010\fR\u001a\u0010\u0005\u001a\u00020\u00038VX\u0096\u0004\u00f8\u0001\u0000\u00f8\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u000e\u0010\f\u00f8\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\u001d" }, d2 = { "Lkotlin/ranges/UIntRange;", "Lkotlin/ranges/UIntProgression;", "Lkotlin/ranges/ClosedRange;", "Lkotlin/UInt;", "Lkotlin/ranges/OpenEndRange;", "start", "endInclusive", "(IILkotlin/jvm/internal/DefaultConstructorMarker;)V", "endExclusive", "getEndExclusive-pVg5ArA$annotations", "()V", "getEndExclusive-pVg5ArA", "()I", "getEndInclusive-pVg5ArA", "getStart-pVg5ArA", "contains", "", "value", "contains-WZ4Q5Ns", "(I)Z", "equals", "other", "", "hashCode", "", "isEmpty", "toString", "", "Companion", "kotlin-stdlib" })
@SinceKotlin(version = "1.5")
@WasExperimental(markerClass = { ExperimentalUnsignedTypes.class })
public final class UIntRange extends UIntProgression implements ClosedRange<UInt>, OpenEndRange<UInt>
{
    @NotNull
    public static final Companion Companion;
    @NotNull
    private static final UIntRange EMPTY;
    
    private UIntRange(final int start, final int endInclusive) {
        super(start, endInclusive, 1, null);
    }
    
    public int getStart-pVg5ArA() {
        return this.getFirst-pVg5ArA();
    }
    
    public int getEndInclusive-pVg5ArA() {
        return this.getLast-pVg5ArA();
    }
    
    @java.lang.Deprecated
    public int getEndExclusive-pVg5ArA() {
        if (this.getLast-pVg5ArA() == -1) {
            throw new IllegalStateException("Cannot return the exclusive upper bound of a range that includes MAX_VALUE.".toString());
        }
        return UInt.constructor-impl(this.getLast-pVg5ArA() + 1);
    }
    
    public boolean contains-WZ4Q5Ns(final int value) {
        return UnsignedKt.uintCompare(this.getFirst-pVg5ArA(), value) <= 0 && UnsignedKt.uintCompare(value, this.getLast-pVg5ArA()) <= 0;
    }
    
    @Override
    public boolean isEmpty() {
        return UnsignedKt.uintCompare(this.getFirst-pVg5ArA(), this.getLast-pVg5ArA()) > 0;
    }
    
    @Override
    public boolean equals(@Nullable final Object other) {
        return other instanceof UIntRange && ((this.isEmpty() && ((UIntRange)other).isEmpty()) || (this.getFirst-pVg5ArA() == ((UIntRange)other).getFirst-pVg5ArA() && this.getLast-pVg5ArA() == ((UIntRange)other).getLast-pVg5ArA()));
    }
    
    @Override
    public int hashCode() {
        return this.isEmpty() ? -1 : (31 * this.getFirst-pVg5ArA() + this.getLast-pVg5ArA());
    }
    
    @NotNull
    @Override
    public String toString() {
        return (Object)UInt.toString-impl(this.getFirst-pVg5ArA()) + ".." + (Object)UInt.toString-impl(this.getLast-pVg5ArA());
    }
    
    public static final /* synthetic */ UIntRange access$getEMPTY$cp() {
        return UIntRange.EMPTY;
    }
    
    static {
        Companion = new Companion(null);
        EMPTY = new UIntRange(-1, 0, null);
    }
    
    @Metadata(mv = { 1, 7, 1 }, k = 1, xi = 48, d1 = { "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007" }, d2 = { "Lkotlin/ranges/UIntRange$Companion;", "", "()V", "EMPTY", "Lkotlin/ranges/UIntRange;", "getEMPTY", "()Lkotlin/ranges/UIntRange;", "kotlin-stdlib" })
    public static final class Companion
    {
        private Companion() {
        }
        
        @NotNull
        public final UIntRange getEMPTY() {
            return UIntRange.access$getEMPTY$cp();
        }
    }
}
