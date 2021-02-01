package Hotel;

public class Customer extends Person {
    private int day;

    private String typeOfRoom;

    public Customer() {
    }

    public Customer(String name, String dateOfBirth, String identity, int day, String typeOfRoom) {
        super(name, dateOfBirth, identity);
        this.day = day;
        this.typeOfRoom = typeOfRoom;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getTypeOfRoom() {
        return typeOfRoom;
    }

    public void setTypeOfRoom(String typeOfRoom) {
        this.typeOfRoom = typeOfRoom;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "day=" + day +
                ", typeOfRoom='" + typeOfRoom + '\'' +
                '}';
    }
}
