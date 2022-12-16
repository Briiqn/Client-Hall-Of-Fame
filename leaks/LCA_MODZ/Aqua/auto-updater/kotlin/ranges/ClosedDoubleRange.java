// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.ranges;

import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.NotNull;
import kotlin.Metadata;

@Metadata(mv = { 1, 7, 1 }, k = 1, xi = 48, d1 = { "\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0002\u0010\u0005J\u0011\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0002H\u0096\u0002J\u0013\u0010\u000e\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\fH\u0016J\u0018\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0002H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u000e\u0010\u0006\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\t¨\u0006\u0019" }, d2 = { "Lkotlin/ranges/ClosedDoubleRange;", "Lkotlin/ranges/ClosedFloatingPointRange;", "", "start", "endInclusive", "(DD)V", "_endInclusive", "_start", "getEndInclusive", "()Ljava/lang/Double;", "getStart", "contains", "", "value", "equals", "other", "", "hashCode", "", "isEmpty", "lessThanOrEquals", "a", "b", "toString", "", "kotlin-stdlib" })
final class ClosedDoubleRange implements ClosedFloatingPointRange<Double>
{
    private final double _start;
    private final double _endInclusive;
    
    public ClosedDoubleRange(final double start, final double endInclusive) {
        this._start = start;
        this._endInclusive = endInclusive;
    }
    
    @NotNull
    @Override
    public Double getStart() {
        return this._start;
    }
    
    @NotNull
    @Override
    public Double getEndInclusive() {
        return this._endInclusive;
    }
    
    public boolean lessThanOrEquals(final double a, final double b) {
        return a <= b;
    }
    
    public boolean contains(final double value) {
        return value >= this._start && value <= this._endInclusive;
    }
    
    @Override
    public boolean isEmpty() {
        return this._start > this._endInclusive;
    }
    
    @Override
    public boolean equals(@Nullable final Object other) {
        return other instanceof ClosedDoubleRange && ((this.isEmpty() && ((ClosedDoubleRange)other).isEmpty()) || (this._start == ((ClosedDoubleRange)other)._start && this._endInclusive == ((ClosedDoubleRange)other)._endInclusive));
    }
    
    @Override
    public int hashCode() {
        return this.isEmpty() ? -1 : (31 * Double.valueOf(this._start).hashCode() + Double.valueOf(this._endInclusive).hashCode());
    }
    
    @NotNull
    @Override
    public String toString() {
        return this._start + ".." + this._endInclusive;
    }
}
