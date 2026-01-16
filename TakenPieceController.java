public class TakenPieceController {
    private int cutWhiteQueens;
    private int cutWhiteRooks;
    private int cutWhiteBishops;
    private int cutWhiteKnights;
    private int cutWhitePawns;

    private int cutBlackQueens;
    private int cutBlackRooks;
    private int cutBlackBishops;
    private int cutBlackKnights;
    private int cutBlackPawns;

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
        System.out.println("Взятые фигуры:");
        System.out.print("Белые (взятые черными): ");
        System.out.print("Ферзи:" + cutWhiteQueens + " ");
        System.out.print("Ладьи:" + cutWhiteRooks + " ");
        System.out.print("Слоны:" + cutWhiteBishops + " ");
        System.out.print("Кони:" + cutWhiteKnights + " ");
        System.out.println("Пешки:" + cutWhitePawns);

        System.out.print("Черные (взятые белыми): ");
        System.out.print("Ферзи:" + cutBlackQueens + " ");
        System.out.print("Ладьи:" + cutBlackRooks + " ");
        System.out.print("Слоны:" + cutBlackBishops + " ");
        System.out.print("Кони:" + cutBlackKnights + " ");
        System.out.println("Пешки:" + cutBlackPawns);
    }
}

interface CloneableTracker {
    Object shallowClone();
    Object deepClone();
}