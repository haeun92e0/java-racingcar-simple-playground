package Model;

public class Car {
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MIN_FORWARD_NUMBER = 4;

    private final String name;
    private int position;

    public Car(String name) {
        validateNameLength(name);
        this.name = name;
        this.position = 0;
    }

    private void validateNameLength(String name) {
        if (name == null || name.trim().isEmpty() || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 1자 이상 5자 이하만 가능합니다.");
        }
    }

    public void move(int number) {
        if (number >= MIN_FORWARD_NUMBER) {
            this.position++;
        }
    }

    public boolean isAtPosition(int maxPosition) {
        return this.position == maxPosition;
    }

    public String getName() { return name; }
    public int getPosition() { return position; }
}
