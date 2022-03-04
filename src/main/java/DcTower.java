public class DcTower {

   private int numbOfElevators;
   private int numbOfFloors;

    public DcTower(int numbOfElevators, int numbOfFloors){

        setNumbOfElevators(numbOfElevators);
        setNumbOfFloors(numbOfFloors);

        setUp();
    }


    private void setUp(){
       printInfo();
    }


    public void printInfo(){
        System.out.println("-----------------------");
        System.out.println("Number of Elevators: "+ getNumbOfElevators());
        System.out.println("Number of Floors:    "+ getNumbOfFloors());
        System.out.println("-----------------------");
    }

    public int getNumbOfElevators() {
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
