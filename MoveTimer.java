public class MoveTimer extends BaseTimer {
    private long limitTime; // лимит времени
    private long currentRemaining; // сколько осталось
    private long totalTimeUsed; // потраченное время

    // ф-ция в отдельном потокe
    @Override
    protected void timerWorker() {
        while (timerON) {
            try {
                Thread.sleep(1000); // 1 секунда
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }

            if (timerON) {
                long timeUsedThisMove = getElapsedSeconds(); // = now - startTime
                long timeUsedThisGame = totalTimeUsed + timeUsedThisMove;
                currentRemaining = limitTime - timeUsedThisGame;

                if (currentRemaining <= 0) {
                    currentRemaining = 0;
                    break;
                }
            }
        }

        if (timerON) {
            timerON = false;
            long thisMoveTime = getElapsedSeconds();
            totalTimeUsed += thisMoveTime;
        }
    }

    public MoveTimer(long limit) {
            if (limit <= 0) {
            throw new IllegalArgumentException("Лимит времени должен быть положительным");
        }
        this.limitTime = limit;
        this.totalTimeUsed = 0;
        this.currentRemaining = limit;
    }

    public MoveTimer() {
        this(300); // лимит по умолчанию — 300 секунд
    }

    //старт
    @Override
    public void start() {
        if (!timerON && currentRemaining > 0) {
            startTime = System.currentTimeMillis() / 1000;
            timerON = true;
            startThread();
        }
    }

    //стоп
    @Override
    public void stop() {
        if (timerON) {
            timerON = false;
            stopThread();

            long thisMoveTime = getElapsedSeconds();
            totalTimeUsed += thisMoveTime;
            currentRemaining = limitTime - totalTimeUsed;
            if (currentRemaining < 0) currentRemaining = 0;
        }
    }

    //ресет
    public void reset() {
        stop();
        totalTimeUsed = 0;
        startTime = 0;
        currentRemaining = limitTime;
    }

    // получение оставшегося времени
    public long getRemainingTimeSec() {
        if (timerON) {
            long timeUsedThisMove = getElapsedSeconds();
            long remaining = limitTime - (totalTimeUsed + timeUsedThisMove);
            return (remaining > 0) ? remaining : 0;
        } else {
            return currentRemaining;
        }
    }

    // получение использованного времени
    public long getUsedTimeSec() {
        if (timerON) {
            return totalTimeUsed + getElapsedSeconds();
        } else {
            return totalTimeUsed;
        }
    }

    // проверка. осталось ли время
    public boolean isTimeUp() {
        return getRemainingTimeSec() <= 0;
    }
}