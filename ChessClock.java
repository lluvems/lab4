public class ChessClock {
    private MoveTimer whiteTimer; // таймер белых
    private MoveTimer blackTimer; // таймер черных

    // Конструктор с лимитом времени (по умолчанию 5 минут)
    public ChessClock(long timeLimit) {
        this.whiteTimer = new MoveTimer(timeLimit);
        this.blackTimer = new MoveTimer(timeLimit);
    }

    public ChessClock() {
        this(300); // 5 минут по умолчанию
    }

    // начать ход белых
    public void startWhite() {
        blackTimer.stop(); // останавливаем черных 
        whiteTimer.start(); // запускаем белых
    }

    // начать ход черных
    public void startBlack() {
        whiteTimer.stop(); // останавливаем белых
        blackTimer.start(); // запускаем черных
    }

    // переключить игрока (остановить текущего, запустить следующего)
    public void switchPlayer() {
        if (whiteTimer.ON_OFF()) {
            startBlack();
        } else if (blackTimer.ON_OFF()) {
            startWhite();
        } else {
            // Если никто не ходит, начинаем с белых
            startWhite();
        }
    }

    // время белых в секундах
    public long getWhiteTime() {
        return whiteTimer.getRemainingTimeSec();
    }

    // время черных в секундах
    public long getBlackTime() {
        return blackTimer.getRemainingTimeSec();
    }

    // проверить, не закончилось ли время у кого-то
    public boolean isTimeUp() {
        return whiteTimer.isTimeUp() || blackTimer.isTimeUp();
    }

    public void reset() {
        whiteTimer.reset();
        blackTimer.reset();
    }

    public void printTime() {
        long whiteSeconds = whiteTimer.getRemainingTimeSec();
        long blackSeconds = blackTimer.getRemainingTimeSec();

        long whiteMinutes = whiteSeconds / 60;
        long whiteSecs = whiteSeconds % 60;

        long blackMinutes = blackSeconds / 60;
        long blackSecs = blackSeconds % 60;

        System.out.println("=== Время игроков ===");
        System.out.print("Белые: "
            + (whiteMinutes < 10 ? "0" : "") + whiteMinutes + ":"
            + (whiteSecs < 10 ? "0" : "") + whiteSecs);
        if (whiteTimer.ON_OFF()) System.out.print(" [ХОДИТ]");
        System.out.println();

        System.out.print("Черные: "
            + (blackMinutes < 10 ? "0" : "") + blackMinutes + ":"
            + (blackSecs < 10 ? "0" : "") + blackSecs);
        if (blackTimer.ON_OFF()) System.out.print(" [ХОДИТ]");
        System.out.println();
    }
}