public class Person {
    /**
     * Every Person has a card that authorize access to the DC Tower
     * after successful entering the person gets an elevator number
     * if there is not a free elevator the person is added to a queue
     */
    private boolean hasCard;
    private final Direction direction;
    private int cardToFloorNr;
    private int currentFloor;
    private int personId;
    private static int personsInTower = 0;
    private boolean isInElevator;

    public enum Direction {
        DOWN,
        UP
    }

    public Person(boolean hasCard, int cardToFloorNr, Direction direction, int currentFloor) {
        isInElevator = false;
        setCurrentFloor(currentFloor);
        setHasCard(hasCard);
        setCardToFloorNr(cardToFloorNr);
        this.direction = direction;
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

    public Direction getDirection() {
        return direction;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public boolean isInElevator() {
        return isInElevator;
    }

    public void setInElevator(boolean inElevator) {
        isInElevator = inElevator;
    }

    public int GoingToFloor(Person p) {
        if (p.getDirection() == Direction.UP) {
            return getCardToFloorNr();
        } else return 0;
    }
}
