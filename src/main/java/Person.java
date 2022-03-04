public class Person {
   private boolean hasCard;
   private int CardToFloorNr;

    public Person(boolean hasCard,int CardToFloorNr){
        setHasCard(hasCard);
        setCardToFloorNr(CardToFloorNr);
    }

    public boolean isHasCard() {
        return hasCard;
    }

    public void setHasCard(boolean hasCard) {
        this.hasCard = hasCard;
    }

    public int getCardToFloorNr() {
        return CardToFloorNr;
    }

    public void setCardToFloorNr(int cardToFloorNr) {
        CardToFloorNr = cardToFloorNr;
    }
}
