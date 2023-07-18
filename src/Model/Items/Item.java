package Model.Items;

public class Item {
    int amount;
    String name;
    int booster;    //booster is the amt of hp/stamina restored

    public Item(String name, int booster, int amount){
        this.name = name;
        this.booster = booster;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBooster() {
        return booster;
    }

    public void setBooster(int booster) {
        this.booster = booster;
    }

    @Override
    public String toString() {
        return name;
    }

}
