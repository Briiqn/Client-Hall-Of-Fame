// 
// Decompiled by Procyon v0.5.36
// 

package intent.AquaDev.aqua.utils.shader;

import java.io.InputStream;
import java.io.IOException;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL20;

public class ShaderProgram
{
    private final String vertexName;
    private final String fragmentName;
    private final int vertexStage;
    private final int fragmentStage;
    private int programID;
    
    public ShaderProgram(final String vertexName, final String fragmentName) {
        this.vertexName = vertexName;
        this.fragmentName = fragmentName;
        this.vertexStage = createShaderStage(35633, vertexName);
        this.fragmentStage = createShaderStage(35632, fragmentName);
        if (this.vertexStage != -1 && this.fragmentStage != -1) {
            GL20.glAttachShader(this.programID = GL20.glCreateProgram(), this.vertexStage);
            GL20.glAttachShader(this.programID, this.fragmentStage);
            GL20.glLinkProgram(this.programID);
        }
    }
    
    private static int createShaderStage(final int shaderStage, final String shaderName) {
        final int stageId = GL20.glCreateShader(shaderStage);
        GL20.glShaderSource(stageId, readShader(shaderName));
        GL20.glCompileShader(stageId);
        final boolean compiled = GL20.glGetShaderi(stageId, 35713) == 1;
        if (!compiled) {
            final String shaderLog = GL20.glGetShaderInfoLog(stageId, 2048);
            System.out.printf("Failed to compile shader %s (stage: %s); Message\n%s%n", shaderName, GL11.glGetString(shaderStage), shaderLog);
            return -1;
        }
        return stageId;
    }
    
    private static String readShader(final String fileName) {
        final StringBuilder stringBuilder = new StringBuilder();
        try {
            final InputStream inputStream = ShaderProgram.class.getResourceAsStream(String.format("/shaders/%s", fileName));
            assert inputStream != null;
            final InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            final BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line).append('\n');
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }
    
    public void deleteShaderProgram() {
        GL20.glUseProgram(0);
        GL20.glDeleteProgram(this.programID);
        GL20.glDeleteShader(this.vertexStage);
        GL20.glDeleteShader(this.fragmentStage);
    }
    
    public void init() {
        GL20.glUseProgram(this.programID);
    }
    
    public void doRenderPass(final float width, final float height) {
        GL11.glBegin(7);
        GL11.glTexCoord2f(0.0f, 1.0f);
        GL11.glVertex2d(0.0, 0.0);
        GL11.glTexCoord2f(0.0f, 0.0f);
        GL11.glVertex2d(0.0, height);
        GL11.glTexCoord2f(1.0f, 0.0f);
        GL11.glVertex2d(width, height);
        GL11.glTexCoord2f(1.0f, 1.0f);
        GL11.glVertex2d(width, 0.0);
        GL11.glEnd();
    }
    
    public void uninit() {
        GL20.glUseProgram(0);
    }
    
    public int uniform(final String name) {
        return GL20.glGetUniformLocation(this.programID, name);
    }
}
