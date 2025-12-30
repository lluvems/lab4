import java.util.List;

public abstract class Piece {
    private boolean isAlive = true;
    private Color color;
    private PieceType type;
    private Coordinates pos;
    private int moves = 0;

    // Конструкторы
    public Piece(PieceType type) {
        this(new Coordinates(0, 0), Color.WHITE, type);
    }

    public Piece(Coordinates pos, Color color, PieceType type) {
        this.pos = pos;
        this.color = color;
        this.type = type;
    }

    // Абстрактный метод — должен быть реализован в подклассах
    public abstract List<Coordinates> getPattern();

    // Геттеры и сеттеры
    public void setPos(Coordinates pos) {
        this.pos = pos;
    }

    public void incMoves() {
        moves++;
    }

    public int getMoves() {
        return moves;
    }

    public boolean isMoved() {
        return moves > 0;
    }

    public Coordinates getPos() {
        if (isAlive) {
            return pos;
        } else {
            return new Coordinates(-1, -1);
        }
    }

    public Color getColor() {
        return color;
    }

    public PieceType getType() {
        return type;
    }

    public void setDead() {
        isAlive = false;
    }

    public boolean isAlive() {
        return isAlive;
    }

    // Вспомогательный метод для вывода информации (аналог printInfo)
    public void printInfo() {
        String typeStr = switch (type) {
            case BISHOP -> "Слон";
            case KING -> "Король";
            case KNIGHT -> "Конь";
            case PAWN -> "Пешка";
            case QUEEN -> "Ферзь";
            case ROOK -> "Ладья";
        };

        String colorStr = (color == Color.WHITE) ? "Белый" : "Черный";

        System.out.println("Тип фигуры: " + typeStr);
        System.out.println("Цвет фигуры: " + colorStr);
        System.out.println("Текущая позиция: " + getPos());
        System.out.println("Живой - " + isAlive());
    }
}