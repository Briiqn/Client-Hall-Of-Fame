// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.coroutines;

import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.NotNull;
import kotlin.SinceKotlin;
import kotlin.Metadata;

@Metadata(mv = { 1, 7, 1 }, k = 1, xi = 48, d1 = { "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001:\u0002\u0011\u0012J5\u0010\u0002\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u00032\u0018\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u0002H\u00030\u0006H&¢\u0006\u0002\u0010\bJ(\u0010\t\u001a\u0004\u0018\u0001H\n\"\b\b\u0000\u0010\n*\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\n0\fH¦\u0002¢\u0006\u0002\u0010\rJ\u0014\u0010\u000e\u001a\u00020\u00002\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\fH&J\u0011\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0000H\u0096\u0002¨\u0006\u0013" }, d2 = { "Lkotlin/coroutines/CoroutineContext;", "", "fold", "R", "initial", "operation", "Lkotlin/Function2;", "Lkotlin/coroutines/CoroutineContext$Element;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "get", "E", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "minusKey", "plus", "context", "Element", "Key", "kotlin-stdlib" })
@SinceKotlin(version = "1.3")
public interface CoroutineContext
{
    @Nullable
     <E extends Element> E get(@NotNull final Key<E> p0);
    
     <R> R fold(final R p0, @NotNull final Function2<? super R, ? super Element, ? extends R> p1);
    
    @NotNull
    CoroutineContext plus(@NotNull final CoroutineContext p0);
    
    @NotNull
    CoroutineContext minusKey(@NotNull final Key<?> p0);
    
    @Metadata(mv = { 1, 7, 1 }, k = 3, xi = 48)
    public static final class DefaultImpls
    {
        @NotNull
        public static CoroutineContext plus(@NotNull final CoroutineContext $this, @NotNull final CoroutineContext context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return (context == EmptyCoroutineContext.INSTANCE) ? $this : context.fold($this, (Function2<? super CoroutineContext, ? super Element, ? extends CoroutineContext>)CoroutineContext$plus.CoroutineContext$plus$1.INSTANCE);
        }
    }
    
    @Metadata(mv = { 1, 7, 1 }, k = 1, xi = 48, d1 = { "\u0000\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003¨\u0006\u0004" }, d2 = { "Lkotlin/coroutines/CoroutineContext$Key;", "E", "Lkotlin/coroutines/CoroutineContext$Element;", "", "kotlin-stdlib" })
    public interface Key<E extends Element>
    {
    }
    
    @Metadata(mv = { 1, 7, 1 }, k = 1, xi = 48, d1 = { "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J5\u0010\u0006\u001a\u0002H\u0007\"\u0004\b\u0000\u0010\u00072\u0006\u0010\b\u001a\u0002H\u00072\u0018\u0010\t\u001a\u0014\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u0002H\u00070\nH\u0016¢\u0006\u0002\u0010\u000bJ(\u0010\f\u001a\u0004\u0018\u0001H\r\"\b\b\u0000\u0010\r*\u00020\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\r0\u0003H\u0096\u0002¢\u0006\u0002\u0010\u000eJ\u0014\u0010\u000f\u001a\u00020\u00012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0016R\u0016\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0010" }, d2 = { "Lkotlin/coroutines/CoroutineContext$Element;", "Lkotlin/coroutines/CoroutineContext;", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "getKey", "()Lkotlin/coroutines/CoroutineContext$Key;", "fold", "R", "initial", "operation", "Lkotlin/Function2;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "get", "E", "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "minusKey", "kotlin-stdlib" })
    public interface Element extends CoroutineContext
    {
        @NotNull
        Key<?> getKey();
        
        @Nullable
         <E extends Element> E get(@NotNull final Key<E> p0);
        
         <R> R fold(final R p0, @NotNull final Function2<? super R, ? super Element, ? extends R> p1);
        
        @NotNull
        CoroutineContext minusKey(@NotNull final Key<?> p0);
        
        @Metadata(mv = { 1, 7, 1 }, k = 3, xi = 48)
        public static final class DefaultImpls
        {
            @Nullable
            public static <E extends Element> E get(@NotNull final Element $this, @NotNull final Key<E> key) {
                Intrinsics.checkNotNullParameter(key, "key");
                Element element;
                if (Intrinsics.areEqual($this.getKey(), key)) {
                    Intrinsics.checkNotNull($this, "null cannot be cast to non-null type E of kotlin.coroutines.CoroutineContext.Element.get");
                    element = $this;
                }
                else {
                    element = null;
                }
                return (E)element;
            }
            
            public static <R> R fold(@NotNull final Element $this, final R initial, @NotNull final Function2<? super R, ? super Element, ? extends R> operation) {
                Intrinsics.checkNotNullParameter(operation, "operation");
                return (R)operation.invoke(initial, $this);
            }
            
            @NotNull
            public static CoroutineContext minusKey(@NotNull final Element $this, @NotNull final Key<?> key) {
                Intrinsics.checkNotNullParameter(key, "key");
                return (CoroutineContext)(Intrinsics.areEqual($this.getKey(), key) ? ((EmptyCoroutineContext)EmptyCoroutineContext.INSTANCE) : ((Element)$this));
            }
            
            @NotNull
            public static CoroutineContext plus(@NotNull final Element $this, @NotNull final CoroutineContext context) {
                Intrinsics.checkNotNullParameter(context, "context");
                return CoroutineContext.DefaultImpls.plus($this, context);
            }
        }
    }
}
