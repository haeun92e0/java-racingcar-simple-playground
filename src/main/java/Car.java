public class Car {
    private final String name;
    private int position;

    public Car(String name){
        this.name = name;
        this.position = 0;
    }

    public void move(int randomValue){
        if(randomValue >= 4){
            this.position++;
        }
    }

    public boolean isAtPosition(int MaxPosition){
        return this.position== MaxPosition;
    }

    public String getName(){
        return this.name;
    }

    public int getPosition(){
        return this.position;
    }
}
