// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.ranges;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import kotlin.SinceKotlin;
import kotlin.Metadata;

@Metadata(mv = { 1, 7, 1 }, k = 1, xi = 48, d1 = { "\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\bg\u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\u0005H\u0016J\u001d\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00028\u0000H&¢\u0006\u0002\u0010\f¨\u0006\r" }, d2 = { "Lkotlin/ranges/ClosedFloatingPointRange;", "T", "", "Lkotlin/ranges/ClosedRange;", "contains", "", "value", "(Ljava/lang/Comparable;)Z", "isEmpty", "lessThanOrEquals", "a", "b", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)Z", "kotlin-stdlib" })
@SinceKotlin(version = "1.1")
public interface ClosedFloatingPointRange<T extends Comparable<? super T>> extends ClosedRange<T>
{
    boolean contains(@NotNull final T p0);
    
    boolean isEmpty();
    
    boolean lessThanOrEquals(@NotNull final T p0, @NotNull final T p1);
    
    @Metadata(mv = { 1, 7, 1 }, k = 3, xi = 48)
    public static final class DefaultImpls
    {
        public static <T extends Comparable<? super T>> boolean contains(@NotNull final ClosedFloatingPointRange<T> $this, @NotNull final T value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return $this.lessThanOrEquals($this.getStart(), value) && $this.lessThanOrEquals(value, $this.getEndInclusive());
        }
        
        public static <T extends Comparable<? super T>> boolean isEmpty(@NotNull final ClosedFloatingPointRange<T> $this) {
            return !$this.lessThanOrEquals($this.getStart(), $this.getEndInclusive());
        }
    }
}
