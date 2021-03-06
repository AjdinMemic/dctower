import java.util.LinkedList;

/**
 * There are up to n (let say 7) elevators that bring people to their offices
 * At the beginning all elevators are on the first floor
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
                sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            for (Person p : getPersonsInElevator()) {

                if (!p.isInElevator()) {
                    if (p.getCurrentFloor() == this.currentFloor) {
                        p.setInElevator(true);
                        System.out.println("Person "+p.getPersonId()+" enters Elevator #"+getElevatorId()+" on floor "+getCurrentFloor());
                    }
                    if (p.getDirection() == Person.Direction.UP) {
                        if (p.getCurrentFloor() < this.currentFloor) {
                            setCurrentFloor(getCurrentFloor() - 1);
                            System.out.println("Elevator #" + getElevatorId() + " going DOWN, floor " + getCurrentFloor());
                        }else if(p.getCurrentFloor() == this.currentFloor){
                            System.out.println("Elevator #" + getElevatorId() + " going UP, floor " + getCurrentFloor());
                            setCurrentFloor(getCurrentFloor() + 1);
                        }
                    } else if (p.getDirection() == Person.Direction.DOWN) {
                        if (p.getCurrentFloor() < this.currentFloor) {
                            setCurrentFloor(getCurrentFloor() - 1);
                            System.out.println("Elevator #" + getElevatorId() + " going DOWN, floor " + getCurrentFloor());
                        } else if (p.getCurrentFloor() > this.currentFloor) {
                            setCurrentFloor(getCurrentFloor() + 1);
                            System.out.println("Elevator #" + getElevatorId() + " going UP, floor " + getCurrentFloor());
                        }
                    }
                }

                if (p.isInElevator()) {
                    if (p.getDirection() == Person.Direction.UP) {
                        setCurrentFloor(getCurrentFloor() + 1);
                        System.out.println("Elevator #" + getElevatorId() + " going UP, floor " + getCurrentFloor());
                    } else {
                        setCurrentFloor(getCurrentFloor() - 1);
                        System.out.println("Elevator #" + getElevatorId() + " going DOWN, floor " + getCurrentFloor());
                    }
                    if (p.GoingToFloor(p) == getCurrentFloor()) {
                        System.out.println("Person " + p.getPersonId() + " leaves Elevator #" + getElevatorId() + " on floor " + getCurrentFloor());
                        getPersonsInElevator().remove(p);
                        System.out.println("Elevator #" + getElevatorId() + " is empty, stops right now of floor " + getCurrentFloor());
                    }
                }
            }
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
