// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.jvm.internal;

import kotlin.SinceKotlin;
import kotlin.reflect.KClass;
import kotlin.reflect.KDeclarationContainer;

public class MutablePropertyReference2Impl extends MutablePropertyReference2
{
    public MutablePropertyReference2Impl(final KDeclarationContainer owner, final String name, final String signature) {
        super(((ClassBasedDeclarationContainer)owner).getJClass(), name, signature, (owner instanceof KClass) ? 0 : 1);
    }
    
    @SinceKotlin(version = "1.4")
    public MutablePropertyReference2Impl(final Class owner, final String name, final String signature, final int flags) {
        super(owner, name, signature, flags);
    }
    
    @Override
    public Object get(final Object receiver1, final Object receiver2) {
        return this.getGetter().call(receiver1, receiver2);
    }
    
    @Override
    public void set(final Object receiver1, final Object receiver2, final Object value) {
        this.getSetter().call(receiver1, receiver2, value);
    }
}
