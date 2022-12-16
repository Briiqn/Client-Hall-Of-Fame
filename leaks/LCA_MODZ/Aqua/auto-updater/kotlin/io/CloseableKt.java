// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.io;

import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import org.jetbrains.annotations.Nullable;
import kotlin.internal.InlineOnly;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import java.io.Closeable;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.JvmName;
import kotlin.Metadata;

@Metadata(mv = { 1, 7, 1 }, k = 2, xi = 48, d1 = { "\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0001\u001aH\u0010\u0005\u001a\u0002H\u0006\"\n\b\u0000\u0010\u0007*\u0004\u0018\u00010\u0002\"\u0004\b\u0001\u0010\u0006*\u0002H\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\u00060\tH\u0087\b\u00f8\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\n\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u000b" }, d2 = { "closeFinally", "", "Ljava/io/Closeable;", "cause", "", "use", "R", "T", "block", "Lkotlin/Function1;", "(Ljava/io/Closeable;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "kotlin-stdlib" })
@JvmName(name = "CloseableKt")
public final class CloseableKt
{
    @InlineOnly
    private static final <T extends Closeable, R> R use(final T $this$use, final Function1<? super T, ? extends R> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        Throwable exception = null;
        try {
            final R invoke = (R)block.invoke($this$use);
            InlineMarker.finallyStart(1);
            if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 1, 0)) {
                closeFinally($this$use, exception);
            }
            else if ($this$use != null) {
                $this$use.close();
            }
            InlineMarker.finallyEnd(1);
            return invoke;
        }
        catch (Throwable e) {
            exception = e;
            throw e;
        }
        finally {
            InlineMarker.finallyStart(1);
            if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 1, 0)) {
                closeFinally($this$use, exception);
            }
            else if ($this$use != null) {
                if (exception == null) {
                    $this$use.close();
                }
                else {
                    try {
                        $this$use.close();
                    }
                    catch (Throwable t) {}
                }
            }
            InlineMarker.finallyEnd(1);
        }
    }
    
    @SinceKotlin(version = "1.1")
    @PublishedApi
    public static final void closeFinally(@Nullable final Closeable $this$closeFinally, @Nullable final Throwable cause) {
        if ($this$closeFinally != null) {
            if (cause == null) {
                $this$closeFinally.close();
            }
            else {
                try {
                    $this$closeFinally.close();
                }
                catch (Throwable closeException) {
                    ExceptionsKt__ExceptionsKt.addSuppressed(cause, closeException);
                }
            }
        }
    }
}
