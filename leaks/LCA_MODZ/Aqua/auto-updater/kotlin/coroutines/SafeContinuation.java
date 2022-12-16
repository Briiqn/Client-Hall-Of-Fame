// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.coroutines;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.Result;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.internal.Intrinsics;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.NotNull;
import kotlin.SinceKotlin;
import kotlin.PublishedApi;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;

@Metadata(mv = { 1, 7, 1 }, k = 1, xi = 48, d1 = { "\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0001\u0018\u0000 \u001a*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00020\u0003:\u0001\u001aB\u0015\b\u0011\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0002\u0010\u0005B\u001f\b\u0000\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\n\u0010\u0011\u001a\u0004\u0018\u00010\u0007H\u0001J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u001e\u0010\u0014\u001a\u00020\u00152\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016H\u0016\u00f8\u0001\u0000¢\u0006\u0002\u0010\u0017J\b\u0010\u0018\u001a\u00020\u0019H\u0016R\u0016\u0010\t\u001a\u0004\u0018\u00010\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001b" }, d2 = { "Lkotlin/coroutines/SafeContinuation;", "T", "Lkotlin/coroutines/Continuation;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "delegate", "(Lkotlin/coroutines/Continuation;)V", "initialResult", "", "(Lkotlin/coroutines/Continuation;Ljava/lang/Object;)V", "callerFrame", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "result", "getOrThrow", "getStackTraceElement", "Ljava/lang/StackTraceElement;", "resumeWith", "", "Lkotlin/Result;", "(Ljava/lang/Object;)V", "toString", "", "Companion", "kotlin-stdlib" })
@PublishedApi
@SinceKotlin(version = "1.3")
public final class SafeContinuation<T> implements Continuation<T>, CoroutineStackFrame
{
    @NotNull
    private static final Companion Companion;
    @NotNull
    private final Continuation<T> delegate;
    @Nullable
    private volatile Object result;
    @Deprecated
    private static final AtomicReferenceFieldUpdater<SafeContinuation<?>, Object> RESULT;
    
    public SafeContinuation(@NotNull final Continuation<? super T> delegate, @Nullable final Object initialResult) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.delegate = (Continuation<T>)delegate;
        this.result = initialResult;
    }
    
    @PublishedApi
    public SafeContinuation(@NotNull final Continuation<? super T> delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this(delegate, CoroutineSingletons.UNDECIDED);
    }
    
    @NotNull
    @Override
    public CoroutineContext getContext() {
        return this.delegate.getContext();
    }
    
    @Override
    public void resumeWith(@NotNull final Object result) {
        while (true) {
            final Object cur = this.result;
            if (cur == CoroutineSingletons.UNDECIDED) {
                if (SafeContinuation.RESULT.compareAndSet(this, CoroutineSingletons.UNDECIDED, result)) {
                    return;
                }
                continue;
            }
            else {
                if (cur != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    throw new IllegalStateException("Already resumed");
                }
                if (SafeContinuation.RESULT.compareAndSet(this, IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED(), CoroutineSingletons.RESUMED)) {
                    this.delegate.resumeWith(result);
                    return;
                }
                continue;
            }
        }
    }
    
    @PublishedApi
    @Nullable
    public final Object getOrThrow() {
        Object result = this.result;
        if (result == CoroutineSingletons.UNDECIDED) {
            if (SafeContinuation.RESULT.compareAndSet(this, CoroutineSingletons.UNDECIDED, IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED())) {
                return IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            }
            result = this.result;
        }
        Object coroutine_SUSPENDED;
        if (result == CoroutineSingletons.RESUMED) {
            coroutine_SUSPENDED = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        }
        else {
            if (result instanceof Result.Failure) {
                throw ((Result.Failure)result).exception;
            }
            coroutine_SUSPENDED = result;
        }
        return coroutine_SUSPENDED;
    }
    
    @Nullable
    @Override
    public CoroutineStackFrame getCallerFrame() {
        final Continuation<T> delegate = this.delegate;
        return (delegate instanceof CoroutineStackFrame) ? delegate : null;
    }
    
    @Nullable
    @Override
    public StackTraceElement getStackTraceElement() {
        return null;
    }
    
    @NotNull
    @Override
    public String toString() {
        return "SafeContinuation for " + this.delegate;
    }
    
    static {
        Companion = new Companion(null);
        RESULT = AtomicReferenceFieldUpdater.newUpdater((Class<SafeContinuation<?>>)SafeContinuation.class, Object.class, "result");
    }
    
    @Metadata(mv = { 1, 7, 1 }, k = 1, xi = 48, d1 = { "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002Rd\u0010\u0003\u001aR\u0012\u0014\u0012\u0012\u0012\u0002\b\u0003 \u0006*\b\u0012\u0002\b\u0003\u0018\u00010\u00050\u0005\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00010\u0001 \u0006*(\u0012\u0014\u0012\u0012\u0012\u0002\b\u0003 \u0006*\b\u0012\u0002\b\u0003\u0018\u00010\u00050\u0005\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00010\u0001\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0007\u0010\u0002¨\u0006\b" }, d2 = { "Lkotlin/coroutines/SafeContinuation$Companion;", "", "()V", "RESULT", "Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;", "Lkotlin/coroutines/SafeContinuation;", "kotlin.jvm.PlatformType", "getRESULT$annotations", "kotlin-stdlib" })
    private static final class Companion
    {
    }
}
