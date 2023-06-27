package de.jcm.discordgamesdk;

public class GameSDKException extends RuntimeException
{
    private Result result;
    
    public GameSDKException(final Result result) {
        super("Game SDK operation failed: " + result);
    }
    
    public Result getResult() {
        return this.result;
    }
}
