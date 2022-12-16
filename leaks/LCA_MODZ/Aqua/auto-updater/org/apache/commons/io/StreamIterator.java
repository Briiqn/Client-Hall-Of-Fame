// 
// Decompiled by Procyon v0.5.36
// 

package org.apache.commons.io;

import java.util.Objects;
import java.util.stream.Stream;
import java.io.Closeable;
import java.util.Iterator;

class StreamIterator<E> implements Iterator<E>, Closeable
{
    private final Iterator<E> iterator;
    private final Stream<E> stream;
    
    public static <T> Iterator<T> iterator(final Stream<T> stream) {
        return (Iterator<T>)new StreamIterator((Stream<E>)stream).iterator;
    }
    
    private StreamIterator(final Stream<E> stream) {
        this.stream = Objects.requireNonNull(stream, "stream");
        this.iterator = stream.iterator();
    }
    
    @Override
    public boolean hasNext() {
        final boolean hasNext = this.iterator.hasNext();
        if (!hasNext) {
            this.close();
        }
        return hasNext;
    }
    
    @Override
    public E next() {
        final E next = this.iterator.next();
        if (next == null) {
            this.close();
        }
        return next;
    }
    
    @Override
    public void close() {
        this.stream.close();
    }
}
