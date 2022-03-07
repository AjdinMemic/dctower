import java.util.LinkedList;

/**
 * DcTower class functions as the "Controller" in the MVC context (Design Pattern)
 * Elevator and Person class act as the Models
 *
 * @author Ajdin Memić
 */

public class DcTower {

    private static int numbOfElevators = 7;
    private int numbOfFloors = 55;
    private static LinkedList<Person> persons = new LinkedList<>();
    private static LinkedList<Elevator> elevators = new LinkedList<Elevator>();
    // private static LinkedList<Person>

    public DcTower() {

        setNumbOfElevators(numbOfElevators);
        setNumbOfFloors(numbOfFloors);

    }

    public static void main(String[] args) {
        setUpElevators();

        addRequest(new Person(true, 2, Person.Direction.UP, 0));
        addRequest(new Person(true, 5, Person.Direction.DOWN, 5));
        addRequest(new Person(true, 14, Person.Direction.UP, 0));
        addRequest(new Person(true, 10, Person.Direction.UP, 0));
        addRequest(new Person(true, 11, Person.Direction.UP, 0));
        addRequest(new Person(true, 18, Person.Direction.UP, 0));
        addRequest(new Person(true, 11, Person.Direction.DOWN, 11));
        addRequest(new Person(true, 3, Person.Direction.UP, 0));
        addRequest(new Person(true, 20, Person.Direction.UP, 0));
        addRequest(new Person(true, 4, Person.Direction.UP, 0));
        addRequest(new Person(true, 4, Person.Direction.UP, 0));
        addRequest(new Person(true, 20, Person.Direction.DOWN, 20));
        addRequest(new Person(true, 5, Person.Direction.DOWN, 5));
        addRequest(new Person(true, 12, Person.Direction.DOWN, 12));
        addRequest(new Person(true, 6, Person.Direction.UP, 0));
    }

    private static void setUpElevators() {
        for (int i = 0; i < getNumbOfElevators(); i++) {
            Elevator e = new Elevator();
            elevators.add(e);
        }
    }

    private static void addRequest(Person p) {

        boolean foundFreeElevator = false;

        if (p.getHasCard()) {
            persons.add(p);
            System.out.println("Person" + p.getPersonId() + " entered the DC Tower.");

            //if there is a free elevator the while loop goes only once
            while (!foundFreeElevator) {
                //see if there is a free elevator to take the person
                for (Elevator e : elevators) {
                    if (!foundFreeElevator) {
                        if (e.getPersonsInElevator().size() == 0) {
                            //p.setInElevator(true);
                            e.getPersonsInElevator().add(p);
                            foundFreeElevator = true;
                            if (!e.isAlive()) {
                                e.start();
                            }
                        }
                    }
                }
            }
        } else {
            System.out.println("Person" + p.getPersonId() + " not authorize access to the DC Tower.");
        }
    }

    public static int getNumbOfElevators() {
        return numbOfElevators;
    }

    public void setNumbOfElevators(int numbOfElevators) {
        this.numbOfElevators = numbOfElevators;
    }

    public int getNumbOfFloors() {
        return numbOfFloors;
    }

    public void setNumbOfFloors(int numbOfFloors) {
        this.numbOfFloors = numbOfFloors;
    }
}
