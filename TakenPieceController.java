public class TakenPieceController implements CloneableTracker {
    protected int cutWhiteQueens;
    protected int cutWhiteRooks;
    protected int cutWhiteBishops;
    protected int cutWhiteKnights;
    protected int cutWhitePawns;

    protected int cutBlackQueens;
    protected int cutBlackRooks;
    protected int cutBlackBishops;
    protected int cutBlackKnights;
    protected int cutBlackPawns;

    

    public TakenPieceController() {
        initWhite();
        initBlack();
    }

    public void initWhite() {
        cutWhiteQueens = 0;
        cutWhiteRooks = 0;
        cutWhiteBishops = 0;
        cutWhiteKnights = 0;
        cutWhitePawns = 0;
    }

    public void initBlack() {
        cutBlackQueens = 0;
        cutBlackRooks = 0;
        cutBlackBishops = 0;
        cutBlackKnights = 0;
        cutBlackPawns = 0;
    }

    public void cutPiece(Piece piece) {
        PieceType type = piece.getType();
        Color col = piece.getColor();
        switch (type) {
            case QUEEN:
                cutQueen(col);
                break;
            case ROOK:
                cutRook(col);
                break;
            case BISHOP:
                cutBishop(col);
                break;
            case KNIGHT:
                cutKnight(col);
                break;
            case PAWN:
                cutPawn(col);
                break;
            default:
                break;
        }
    }

    public void cutQueen(Color pieceColor) {
        if (pieceColor == Color.WHITE) cutWhiteQueens++;
        else cutBlackQueens++;
    }

    public void cutRook(Color pieceColor) {
        if (pieceColor == Color.WHITE) cutWhiteRooks++;
        else cutBlackRooks++;
    }

    public void cutBishop(Color pieceColor) {
        if (pieceColor == Color.WHITE) cutWhiteBishops++;
        else cutBlackBishops++;
    }

    public void cutKnight(Color pieceColor) {
        if (pieceColor == Color.WHITE) cutWhiteKnights++;
        else cutBlackKnights++;
    }

    public void cutPawn(Color pieceColor) {
        if (pieceColor == Color.WHITE) cutWhitePawns++;
        else cutBlackPawns++;
    }

    public int getCutQueen(Color pieceColor) {
        if (pieceColor == Color.WHITE) return cutWhiteQueens;
        else return cutBlackQueens;
    }

    public int getCutRook(Color pieceColor) {
        if (pieceColor == Color.WHITE) return cutWhiteRooks;
        else return cutBlackRooks;
    }

    public int getCutBishop(Color pieceColor) {
        if (pieceColor == Color.WHITE) return cutWhiteBishops;
        else return cutBlackBishops;
    }

    public int getCutKnight(Color pieceColor) {
        if (pieceColor == Color.WHITE) return cutWhiteKnights;
        else return cutBlackKnights;
    }

    public int getCutPawn(Color pieceColor) {
        if (pieceColor == Color.WHITE) return cutWhitePawns;
        else return cutBlackPawns;
    }

    public void printTakenPieces() {
        System.out.println("Взятые белые фигуры:");
        System.out.println("Ферзи: " + cutWhiteQueens);
        System.out.println("Ладьи: " + cutWhiteRooks);
        System.out.println("Слоны: " + cutWhiteBishops);
        System.out.println("Кони: " + cutWhiteKnights);
        System.out.println("Пешки: " + cutWhitePawns);

        System.out.println("Взятые чёрные фигуры:");
        System.out.println("Ферзи: " + cutBlackQueens);
        System.out.println("Ладьи: " + cutBlackRooks);
        System.out.println("Слоны: " + cutBlackBishops);
        System.out.println("Кони: " + cutBlackKnights);
        System.out.println("Пешки: " + cutBlackPawns);
    }

    public void demonstrateVirtualCall() {
        printTakenPieces();
    }

    @Override
    public Object shallowClone() {
        try {
            return super.clone(); // Object.clone() — поверхностное
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

     @Override
    public Object deepClone() {
        TakenPieceController copy = new TakenPieceController();
        copy.cutWhiteQueens = this.cutWhiteQueens;
        copy.cutWhiteRooks = this.cutWhiteRooks;
        copy.cutWhiteBishops = this.cutWhiteBishops;
        copy.cutWhiteKnights = this.cutWhiteKnights;
        copy.cutWhitePawns = this.cutWhitePawns;
        copy.cutBlackQueens = this.cutBlackQueens;
        copy.cutBlackRooks = this.cutBlackRooks;
        copy.cutBlackBishops = this.cutBlackBishops;
        copy.cutBlackKnights = this.cutBlackKnights;
        copy.cutBlackPawns = this.cutBlackPawns;
        return copy;
    }
}

interface CloneableTracker {
    Object shallowClone();
    Object deepClone();
}

interface Reportable {
    void generateReport();
}