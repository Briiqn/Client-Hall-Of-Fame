// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.util;

import java.util.regex.Pattern;

public class StringUtils
{
    private static final Pattern patternControlCode;
    
    public static String ticksToElapsedTime(final int ticks) {
        int i = ticks / 20;
        final int j = i / 60;
        i %= 60;
        return (i < 10) ? (j + ":0" + i) : (j + ":" + i);
    }
    
    public static String stripControlCodes(final String text) {
        return StringUtils.patternControlCode.matcher(text).replaceAll("");
    }
    
    public static boolean isNullOrEmpty(final String string) {
        return org.apache.commons.lang3.StringUtils.isEmpty(string);
    }
    
    static {
        patternControlCode = Pattern.compile("(?i)\\u00A7[0-9A-FK-OR]");
    }
}
