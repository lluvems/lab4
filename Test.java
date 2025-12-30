public class Test {
    public static void main(String[] args) throws InterruptedException {
        try {
            // Демонстрация таймера
            Timer gameTimer = new Timer();
            System.out.println("Таймер запущен автоматически!");
            Thread.sleep(2000); // Ждем 2 секунды
            gameTimer.printTime();
            Thread.sleep(4000); // Ждем еще 4 секунды
            gameTimer.printTime();

            // Демонстрация шахматных часов
            System.out.println(); // пустая строка для разделения
            ChessClock clock = new ChessClock(60); // 1 минута на игрока
            clock.startWhite();
            System.out.println("Начало игры:");
            clock.printTime();
            Thread.sleep(10000); // Ждем 10 секунд
            clock.switchPlayer(); // Переключаем игрока
            System.out.println("\nПосле 10 секунд:");
            clock.printTime();
            if (clock.isTimeUp()) {
                System.out.println("\nВремя вышло!");
            }

            // Демонстрация контроллера взятых фигур
            System.out.println(); // пустая строка
            TakenPieceController controller = new TakenPieceController();
            System.out.println("Начало игры:");
            controller.printTakenPieces();
            controller.cutQueen(Color.WHITE);   // черные взяли белого ферзя
            controller.cutPawn(Color.WHITE);    // черные взяли белую пешку
            controller.cutPawn(Color.WHITE);    // черные взяли еще одну белую пешку
            controller.cutRook(Color.BLACK);    // белые взяли черную ладью
            controller.cutKnight(Color.BLACK);  // белые взяли черного коня
            System.out.println("\nПосле нескольких ходов:");
            controller.printTakenPieces();

            // Демонстрация Контроллера материального преимущества
            System.out.println(); // пустая строка
            TakenPieceController takenController = new TakenPieceController();
            MaterialSituationController materialController = new MaterialSituationController(takenController);
            takenController.cutQueen(Color.WHITE);   // черные взяли белого ферзя
            takenController.cutPawn(Color.WHITE);    // черные взяли белую пешку
            takenController.cutRook(Color.BLACK);    // белые взяли черную ладью
            materialController.printMaterialSituation();
        } catch (InterruptedException e) {
            System.out.println("Поток прерван: " + e.getMessage());
            Thread.currentThread().interrupt();
        } catch (Exception e) {
            System.out.println("Неожиданная ошибка: " + e.getMessage());
        }
    }
}