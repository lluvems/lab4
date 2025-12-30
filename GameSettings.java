

public class GameSettings {
    private boolean randomTurnOrder; // случайная очередь хода 
    private boolean timeLimitEnabled; // вкл ли ограничение времени
    private long timeLimitSeconds; // лимит времени (в сек)
    private boolean highlightMoves; //подсвечивать ходы
    
    private static int instanceCount = 0;
    
    public static int getInstanceCount() {
        return instanceCount;
    }

    // Настройки по умолчанию
    public GameSettings() {
        randomTurnOrder = false;
        timeLimitEnabled = false;
        highlightMoves = true;
        timeLimitSeconds = 0;
    }

    public boolean getRandomTurnOrder() {
        return randomTurnOrder;
    }

    public boolean getTimeLimitEnabled() {
        return timeLimitEnabled;
    }

    public long getTimeLimitSeconds() {
        return timeLimitSeconds;
    }

    public boolean getHighlightMoves() {
        return highlightMoves;
    }

    public void setRandomTurnOrder(boolean random) {
        this.randomTurnOrder = random;
    }

    public void setTimeLimitEnabled(boolean enabled) {
        this.timeLimitEnabled = enabled;
    }

    public void setTimeLimitSeconds(long seconds) {
        this.timeLimitSeconds = seconds;
    }

    public void setHighlightMoves(boolean highlight) {
        this.highlightMoves = highlight;
    }
}