// 
// Decompiled by Procyon v0.5.36
// 

package lombok;

public enum AccessLevel
{
    PUBLIC("PUBLIC", 0), 
    MODULE("MODULE", 1), 
    PROTECTED("PROTECTED", 2), 
    PACKAGE("PACKAGE", 3), 
    PRIVATE("PRIVATE", 4), 
    NONE("NONE", 5);
    
    private AccessLevel(final String name, final int ordinal) {
    }
}
