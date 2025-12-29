public class GameSettings {
    private boolean randomTurnOrder; // случайная очередь хода 
    private boolean timeLimitEnabled; // вкл ли ограничение времени
    private long timeLimitSeconds; // лимит времени (в сек)
    private boolean highlightMoves; //подсвечивать ходы

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
        randomTurnOrder = random;
    }

    public void setTimeLimitEnabled(boolean enabled) {
        timeLimitEnabled = enabled;
    }

    public void setTimeLimitSeconds(long seconds) {
        timeLimitSeconds = seconds;
    }

    public void setHighlightMoves(boolean highlight) {
        highlightMoves = highlight;
    }
}