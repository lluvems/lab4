public class Timer extends BaseTimer {
    private long totalElapsedSeconds; // храним только общее время в секундах (аналог tm)

    // функция потока
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
                totalElapsedSeconds = getElapsedSeconds();
            }
        }
    }

    public Timer() {
        totalElapsedSeconds = 0;
        start(); // автоматический запуск
    }

    // запустить
    @Override
    public void start() {
        super.start();
    }

    // остановить
    @Override
    public void stop() {
        super.stop();
        totalElapsedSeconds = getElapsedSeconds();
    }

    // вывести время 
    public void printTime() {
        if (startTime != 0) {
            long totalSec = totalElapsedSeconds;
            long minutes = totalSec / 60;
            long seconds = totalSec % 60;
            System.out.println("Время игры: " + minutes + ":" + String.format("%02d", seconds));
        } else {
            System.out.println("Время игры: не доступно");
        }
    }
}