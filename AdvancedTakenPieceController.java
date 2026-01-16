class AdvancedTakenPieceController extends TakenPieceController implements CloneableTracker, Reportable {
    private String ownerName;

    public AdvancedTakenPieceController(String name) {
        super(); 
        this.ownerName = name;
    }

    @Override
    public void printTakenPieces() {
        System.out.println("Владелец: " + ownerName);
        System.out.println("[Кастомный вывод]");
    }

    public void printFullReport() {
        super.printTakenPieces(); 
        System.out.println("Отчёт завершён.");
    }

    @Override
    public void generateReport() {
        System.out.println("Генерация отчёта для " + ownerName);
        printFullReport();
    }
}