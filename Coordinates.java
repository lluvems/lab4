public class Coordinates {
    private int x;
    private int y;

    public static final int BOARD_MAX_X = 7;
    public static final int BOARD_MAX_Y = 7;

    public Coordinates() {
        this(0, 0);
    }

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Coordinates(Coordinates c) {
        this(c.x, c.y);
    }

    public int getX() { return x; }
    public int getY() { return y; }

    public static Coordinates toCoord(String str) {
        if (str == null || str.length() != 2) {
            throw new InvalidMoveException("Неверный ввод. Координаты должны быть вида a1");
        }
        char col = Character.toUpperCase(str.charAt(0));
        char row = str.charAt(1);

        int x = col - 'A';
        int y = row - '0' - 1;

        if (x >= 0 && x <= BOARD_MAX_X && y >= 0 && y <= BOARD_MAX_Y) {
            return new Coordinates(x, y);
        }
        throw new InvalidMoveException("Координаты " + str + " вне доски");
    }

    // Оператор +
    public Coordinates add(Coordinates other) {
        return new Coordinates(this.x + other.x, this.y + other.y);
    }

    // Оператор -
    public Coordinates subtract(Coordinates other) {
        return new Coordinates(this.x - other.x, this.y - other.y);
    }

    // Оператор *
    public Coordinates multiply(int n) {
        return new Coordinates(this.x * n, this.y * n);
    }

    // Оператор ==
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Coordinates)) return false;
        Coordinates c = (Coordinates) obj;
        return this.x == c.x && this.y == c.y;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(x) * 31 + Integer.hashCode(y);
    }

    // Оператор +=
    public Coordinates addToSelf(Coordinates other) {
        this.x += other.x;
        this.y += other.y;
        return this;
    }

    // toString для вывода (аналог operator<<)
    @Override
    public String toString() {
        return String.valueOf((char)('A' + x)) + (y + 1);
    }

    // Проверка границ
    public boolean checkBound() {
        return x >= 0 && x <= BOARD_MAX_X && y >= 0 && y <= BOARD_MAX_Y;
    }
}