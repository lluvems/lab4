public class MaterialSituationController {
    private TakenPieceController tpController;
    private int whiteTakenPieces; //белых фигур взято
    private int blackTakenPieces; //черных фигур взято
    private int totalTakenPieces; //всего взято

    public MaterialSituationController(TakenPieceController tpc) {
        this.tpController = tpc;
        this.whiteTakenPieces = 0;
        this.blackTakenPieces = 0;
        this.totalTakenPieces = 0;
    }

    //обновить данные
    public void updateSituation() {
        setWhiteTakenPieces(
            tpController.getCutBishop(Color.WHITE) +
            tpController.getCutKnight(Color.WHITE) +
            tpController.getCutPawn(Color.WHITE) +
            tpController.getCutQueen(Color.WHITE) +
            tpController.getCutRook(Color.WHITE)
        );

        setBlackTakenPieces(
            tpController.getCutBishop(Color.BLACK) +
            tpController.getCutKnight(Color.BLACK) +
            tpController.getCutPawn(Color.BLACK) +
            tpController.getCutQueen(Color.BLACK) +
            tpController.getCutRook(Color.BLACK)
        );

        countTotalTakenPieces();
    }

    //уставновить кол-во взятых белых
    public void setWhiteTakenPieces(int n) {
        whiteTakenPieces = n;
    }

    //установить кол-во взятых черных
    public void setBlackTakenPieces(int n) {
        blackTakenPieces = n;
    }

    //посчитать общее кол-во
    public void countTotalTakenPieces() {
        totalTakenPieces = getWhiteTakenPieces() + getBlackTakenPieces();
    }

    //получить кол-во взятых белых
    public int getWhiteTakenPieces() {
        return whiteTakenPieces;
    }

    //получить кол-во взятых черных
    public int getBlackTakenPieces() {
        return blackTakenPieces;
    }

    //получить общее кол-во
    public int getTotalTakenPieces() {
        return totalTakenPieces;
    }

    //вывод
    public void printMaterialSituation() {
        updateSituation(); // в Java нет const, поэтому можно вызывать напрямую

        System.out.println("=== МАТЕРИАЛЬНОЕ ПОЛОЖЕНИЕ ===");
        System.out.println("Всего взято фигур: " + totalTakenPieces);
        System.out.println("Белых фигур взято: " + whiteTakenPieces);
        System.out.println("Черных фигур взято: " + blackTakenPieces);

        int advantage = blackTakenPieces - whiteTakenPieces;

        if (advantage > 0) {
            System.out.println("Материальное преимущество у БЕЛЫХ: +" + advantage);
        } else if (advantage < 0) {
            System.out.println("Материальное преимущество у ЧЕРНЫХ: +" + (-advantage));
        } else {
            System.out.println("Материальное равенство");
        }
    }
}