// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.io.path;

import java.nio.file.FileVisitOption;
import java.util.Set;
import java.nio.file.LinkOption;
import org.jetbrains.annotations.NotNull;
import kotlin.Metadata;

@Metadata(mv = { 1, 7, 1 }, k = 1, xi = 48, d1 = { "\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u00c2\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0019\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\r\u001a\u00020\u000eR\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011" }, d2 = { "Lkotlin/io/path/LinkFollowing;", "", "()V", "followLinkOption", "", "Ljava/nio/file/LinkOption;", "[Ljava/nio/file/LinkOption;", "followVisitOption", "", "Ljava/nio/file/FileVisitOption;", "nofollowLinkOption", "nofollowVisitOption", "toLinkOptions", "followLinks", "", "(Z)[Ljava/nio/file/LinkOption;", "toVisitOptions", "kotlin-stdlib-jdk7" })
final class LinkFollowing
{
    @NotNull
    public static final LinkFollowing INSTANCE;
    @NotNull
    private static final LinkOption[] nofollowLinkOption;
    @NotNull
    private static final LinkOption[] followLinkOption;
    @NotNull
    private static final Set<FileVisitOption> nofollowVisitOption;
    @NotNull
    private static final Set<FileVisitOption> followVisitOption;
    
    private LinkFollowing() {
    }
    
    @NotNull
    public final LinkOption[] toLinkOptions(final boolean followLinks) {
        return followLinks ? LinkFollowing.followLinkOption : LinkFollowing.nofollowLinkOption;
    }
    
    @NotNull
    public final Set<FileVisitOption> toVisitOptions(final boolean followLinks) {
        return followLinks ? LinkFollowing.followVisitOption : LinkFollowing.nofollowVisitOption;
    }
    
    static {
        INSTANCE = new LinkFollowing();
        nofollowLinkOption = new LinkOption[] { LinkOption.NOFOLLOW_LINKS };
        final int $i$f$emptyArray = 0;
        followLinkOption = new LinkOption[0];
        nofollowVisitOption = SetsKt__SetsKt.emptySet();
        followVisitOption = SetsKt__SetsJVMKt.setOf(FileVisitOption.FOLLOW_LINKS);
    }
}
