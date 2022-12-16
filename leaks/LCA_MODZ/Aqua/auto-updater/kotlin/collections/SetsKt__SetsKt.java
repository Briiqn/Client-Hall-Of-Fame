// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.collections;

import kotlin.ExperimentalStdlibApi;
import kotlin.WasExperimental;
import kotlin.BuilderInference;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.Nullable;
import java.util.HashSet;
import kotlin.SinceKotlin;
import java.util.LinkedHashSet;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import java.util.Set;
import kotlin.Metadata;

@Metadata(mv = { 1, 7, 1 }, k = 5, xi = 49, d1 = { "\u0000J\n\u0000\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010#\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0005\u001aN\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u001f\b\u0001\u0010\u0005\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\tH\u0087\b\u00f8\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001\u001aF\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u001f\b\u0001\u0010\u0005\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\tH\u0087\b\u00f8\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u001a\u0012\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u0001\"\u0004\b\u0000\u0010\u000b\u001a\u001f\u0010\f\u001a\u0012\u0012\u0004\u0012\u0002H\u000b0\rj\b\u0012\u0004\u0012\u0002H\u000b`\u000e\"\u0004\b\u0000\u0010\u000bH\u0087\b\u001a5\u0010\f\u001a\u0012\u0012\u0004\u0012\u0002H\u000b0\rj\b\u0012\u0004\u0012\u0002H\u000b`\u000e\"\u0004\b\u0000\u0010\u000b2\u0012\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u000b0\u0010\"\u0002H\u000b¢\u0006\u0002\u0010\u0011\u001a\u001f\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u0002H\u000b0\u0013j\b\u0012\u0004\u0012\u0002H\u000b`\u0014\"\u0004\b\u0000\u0010\u000bH\u0087\b\u001a5\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u0002H\u000b0\u0013j\b\u0012\u0004\u0012\u0002H\u000b`\u0014\"\u0004\b\u0000\u0010\u000b2\u0012\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u000b0\u0010\"\u0002H\u000b¢\u0006\u0002\u0010\u0015\u001a\u0015\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u0007\"\u0004\b\u0000\u0010\u000bH\u0087\b\u001a+\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u0007\"\u0004\b\u0000\u0010\u000b2\u0012\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u000b0\u0010\"\u0002H\u000b¢\u0006\u0002\u0010\u0017\u001a\u0015\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u0001\"\u0004\b\u0000\u0010\u000bH\u0087\b\u001a+\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u0001\"\u0004\b\u0000\u0010\u000b2\u0012\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u000b0\u0010\"\u0002H\u000b¢\u0006\u0002\u0010\u0017\u001a'\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u0001\"\b\b\u0000\u0010\u000b*\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u0001H\u000bH\u0007¢\u0006\u0002\u0010\u001c\u001a5\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u0001\"\b\b\u0000\u0010\u000b*\u00020\u001a2\u0016\u0010\u000f\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u0001H\u000b0\u0010\"\u0004\u0018\u0001H\u000bH\u0007¢\u0006\u0002\u0010\u0017\u001a\u001e\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u0001\"\u0004\b\u0000\u0010\u000b*\b\u0012\u0004\u0012\u0002H\u000b0\u0001H\u0000\u001a!\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u0001\"\u0004\b\u0000\u0010\u000b*\n\u0012\u0004\u0012\u0002H\u000b\u0018\u00010\u0001H\u0087\b\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001f" }, d2 = { "buildSet", "", "E", "capacity", "", "builderAction", "Lkotlin/Function1;", "", "", "Lkotlin/ExtensionFunctionType;", "emptySet", "T", "hashSetOf", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "elements", "", "([Ljava/lang/Object;)Ljava/util/HashSet;", "linkedSetOf", "Ljava/util/LinkedHashSet;", "Lkotlin/collections/LinkedHashSet;", "([Ljava/lang/Object;)Ljava/util/LinkedHashSet;", "mutableSetOf", "([Ljava/lang/Object;)Ljava/util/Set;", "setOf", "setOfNotNull", "", "element", "(Ljava/lang/Object;)Ljava/util/Set;", "optimizeReadOnlySet", "orEmpty", "kotlin-stdlib" }, xs = "kotlin/collections/SetsKt")
class SetsKt__SetsKt extends SetsKt__SetsJVMKt
{
    @NotNull
    public static final <T> Set<T> emptySet() {
        return (Set<T>)EmptySet.INSTANCE;
    }
    
    @NotNull
    public static final <T> Set<T> setOf(@NotNull final T... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return (elements.length > 0) ? ArraysKt___ArraysKt.toSet(elements) : emptySet();
    }
    
    @InlineOnly
    private static final <T> Set<T> setOf() {
        return (Set<T>)emptySet();
    }
    
    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final <T> Set<T> mutableSetOf() {
        return new LinkedHashSet<T>();
    }
    
    @NotNull
    public static final <T> Set<T> mutableSetOf(@NotNull final T... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return ArraysKt___ArraysKt.toCollection(elements, (Set<T>)new LinkedHashSet<Object>(MapsKt__MapsJVMKt.mapCapacity(elements.length)));
    }
    
    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final <T> HashSet<T> hashSetOf() {
        return new HashSet<T>();
    }
    
    @NotNull
    public static final <T> HashSet<T> hashSetOf(@NotNull final T... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return ArraysKt___ArraysKt.toCollection(elements, (HashSet<T>)new HashSet<Object>(MapsKt__MapsJVMKt.mapCapacity(elements.length)));
    }
    
    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final <T> LinkedHashSet<T> linkedSetOf() {
        return new LinkedHashSet<T>();
    }
    
    @NotNull
    public static final <T> LinkedHashSet<T> linkedSetOf(@NotNull final T... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return ArraysKt___ArraysKt.toCollection(elements, (LinkedHashSet<T>)new LinkedHashSet<Object>(MapsKt__MapsJVMKt.mapCapacity(elements.length)));
    }
    
    @SinceKotlin(version = "1.4")
    @NotNull
    public static final <T> Set<T> setOfNotNull(@Nullable final T element) {
        return (element != null) ? SetsKt__SetsJVMKt.setOf(element) : emptySet();
    }
    
    @SinceKotlin(version = "1.4")
    @NotNull
    public static final <T> Set<T> setOfNotNull(@NotNull final T... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return ArraysKt___ArraysKt.filterNotNullTo(elements, new LinkedHashSet<T>());
    }
    
    @SinceKotlin(version = "1.6")
    @WasExperimental(markerClass = { ExperimentalStdlibApi.class })
    @InlineOnly
    private static final <E> Set<E> buildSet(@BuilderInference final Function1<? super Set<E>, Unit> builderAction) {
        Intrinsics.checkNotNullParameter(builderAction, "builderAction");
        final Set<E> setBuilder = SetsKt__SetsJVMKt.createSetBuilder();
        builderAction.invoke(setBuilder);
        return SetsKt__SetsJVMKt.build(setBuilder);
    }
    
    @SinceKotlin(version = "1.6")
    @WasExperimental(markerClass = { ExperimentalStdlibApi.class })
    @InlineOnly
    private static final <E> Set<E> buildSet(final int capacity, @BuilderInference final Function1<? super Set<E>, Unit> builderAction) {
        Intrinsics.checkNotNullParameter(builderAction, "builderAction");
        final Set<E> setBuilder = SetsKt__SetsJVMKt.createSetBuilder(capacity);
        builderAction.invoke(setBuilder);
        return SetsKt__SetsJVMKt.build(setBuilder);
    }
    
    @InlineOnly
    private static final <T> Set<T> orEmpty(final Set<? extends T> $this$orEmpty) {
        Set<T> emptySet = (Set<T>)$this$orEmpty;
        if ($this$orEmpty == null) {
            emptySet = emptySet();
        }
        return emptySet;
    }
    
    @NotNull
    public static final <T> Set<T> optimizeReadOnlySet(@NotNull final Set<? extends T> $this$optimizeReadOnlySet) {
        Intrinsics.checkNotNullParameter($this$optimizeReadOnlySet, "<this>");
        Object o = null;
        switch ($this$optimizeReadOnlySet.size()) {
            case 0: {
                o = emptySet();
                break;
            }
            case 1: {
                o = SetsKt__SetsJVMKt.setOf($this$optimizeReadOnlySet.iterator().next());
                break;
            }
            default: {
                o = $this$optimizeReadOnlySet;
                break;
            }
        }
        return (Set<T>)o;
    }
    
    public SetsKt__SetsKt() {
    }
}
