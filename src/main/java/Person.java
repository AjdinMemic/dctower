public class Person {
    /**
    * Every Person has a card that authorize access to the DC Tower
    * after successful entering the person gets an elevator number
    * if there is not a free elevator the person is added to a queue
    *
     */
    private boolean hasCard;
    private Direction direction;
    private int cardToFloorNr;
    private int currentFloor;
    private int personId;
    private static int personsInTower = 0;

    public enum Direction
    {
        DOWN,
        UP
    }

    public Person(boolean hasCard, int cardToFloorNr,Direction direction) {
        currentFloor=0;
        setHasCard(hasCard);
        setCardToFloorNr(cardToFloorNr);
        this.direction=direction;
        personsInTower++;
        setPersonId(personsInTower);
    }

    public boolean getHasCard() {
        return hasCard;
    }

    public void setHasCard(boolean hasCard) {
        this.hasCard = hasCard;
    }

    public int getCardToFloorNr() {
        return cardToFloorNr;
    }

    public void setCardToFloorNr(int cardToFloorNr) {
        this.cardToFloorNr = cardToFloorNr;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public static int getPersonsInTower() {
        return personsInTower;
    }

    public static void setPersonsInTower(int personsInTower) {
        Person.personsInTower = personsInTower;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }
}
