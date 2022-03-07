import java.util.LinkedList;

/**
 * There are up to n (let say 7) elevators that bring people to their offices
 * At the beginning all elevators are on the first floor
 *
 */

public class Elevator extends Thread {

    private static int elevatorNr = 0;
    private int elevatorId;
    private int currentFloor;
    private LinkedList<Person> personsInElevator;

    public Elevator() {
        elevatorNr++;
        setElevatorId(elevatorNr);
        setCurrentFloor(0);
        personsInElevator = new LinkedList<>();
    }

    @Override
    public void run() {
        while (true) {

            try {
                sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Elevator #" + getElevatorId() + " on floor " + getCurrentFloor());

            for (Person p : getPersonsInElevator()) {
                //System.out.println("p.getCardToFloorNr()=" + p.getCardToFloorNr() + " getCurrentFloor()=" + getCurrentFloor());
                if (p.getCardToFloorNr() == getCurrentFloor()) {
                    System.out.println("Person " + p.getPersonId() + " leaves Elevator #" + getElevatorId() + " on floor " + getCurrentFloor());
                    getPersonsInElevator().remove(p);
                    System.out.println("Persons left:" + getPersonsInElevator().size());
                }
            }

            if (personsInElevator.size() == 0) {
                System.out.println("Elevator #" + getElevatorId() + " is empty, stops right now of floor " + getCurrentFloor());
                synchronized (this) {
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                setCurrentFloor(getCurrentFloor() + 1);
            }

            /*while (person.getCurrentFloor() == this.getCurrentFloor()){

            }



            if (person.getCardToFloorNr() == getCurrentFloor()) {
                System.out.println("Person " + person.getPersonId() + " leaves for the " + getCurrentFloor() + " floor");
            } else {
                if (person.getDirection() == Person.Direction.UP) {

                    if (this.getCurrentFloor() < person.getCardToFloorNr()) {
                        setCurrentFloor(getCurrentFloor() + 1);
                    } else {
                        setCurrentFloor(getCurrentFloor() - 1);
                    }

                    if (person.getCardToFloorNr() == getCurrentFloor()) {
                        System.out.println("Person " + person.getPersonId() + " leaves for the " + getCurrentFloor() + " floor");
                    }
                } else if (person.getDirection() == Person.Direction.DOWN) {

                    if (this.getCurrentFloor() < person.getCardToFloorNr()) {
                        setCurrentFloor(getCurrentFloor() + 1);
                    } else {
                        setCurrentFloor(getCurrentFloor() - 1);
                    }

                    if (person.getCardToFloorNr() == getCurrentFloor()) {
                        System.out.println("Person " + person.getPersonId() + " leaves for the " + getCurrentFloor() + " floor");
                    }
                }
            }*/

        }
    }

    public int getElevatorId() {
        return elevatorId;
    }

    public void setElevatorId(int elevatorId) {
        this.elevatorId = elevatorId;
    }

    public static int getElevatorNr() {
        return elevatorNr;
    }

    public static void setElevatorNr(int elevatorNr) {
        Elevator.elevatorNr = elevatorNr;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public LinkedList<Person> getPersonsInElevator() {
        return personsInElevator;
    }

    public void setPersonsInElevator(LinkedList<Person> personsInElevator) {
        this.personsInElevator = personsInElevator;
    }
}
