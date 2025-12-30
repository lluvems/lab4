public abstract class BaseTimer {
    protected volatile boolean timerON; // работает ли таймер
    protected long startTime; // время начала отсчета
    protected Thread workerThread; // поток

    protected abstract void timerWorker();

    public BaseTimer() {
        timerON = false;
        startTime = 0;
    }


    //старт
    public void start() {
        if (!timerON) {
            startTime = System.currentTimeMillis() / 1000; // в секундах, как time_t
            timerON = true;
            startThread();
        }
    }

    //стоп
       public void stop() {
        if (timerON) {
            timerON = false;
            stopThread();
        }
    }

    // проверка. включен ли таймер
    public boolean ON_OFF() {
        return timerON;
    }

    // получить прошедшее время
    public long getElapsedSeconds() {
        if (startTime == 0) {
            return 0;
        }
        long now = System.currentTimeMillis() / 1000;
        return now - startTime;
    }

    //запуск потока
    protected void startThread() {
        workerThread = new Thread(this::timerWorker);
        workerThread.start();
    }

    //остановка потока
    protected void stopThread() {
        if (workerThread != null && workerThread.isAlive()) {
            try {
                workerThread.join(); // ждём завершения
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // восстанавливаем флаг прерывания
            }
        }
    }
}