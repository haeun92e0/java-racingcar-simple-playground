public class Car {
    private final String name;
    private int position;

    private static final int MIN_FORWARD_NUMBER = 4;

    public Car(String name){
        this.name = name;
        this.position = 0;
    }

    public void move(int randomValue){
        if(randomValue >= MIN_FORWARD_NUMBER){
            this.position++;
        }
    }

    public boolean isAtPosition(int maxPosition){
        return this.position== maxPosition;
    }

    public String getName(){
        return this.name;
    }

    public int getPosition(){
        return this.position;
    }
}
