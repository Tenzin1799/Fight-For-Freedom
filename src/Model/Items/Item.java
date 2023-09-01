package Model.Items;

// class is abstract, we never need to create an "Item" object,
// so it's best practice to just make it abstract.
public abstract class Item {
    int amount;
    String name;
    int booster;    //booster is the amt of hp/stamina restored
    int price;

    public Item(String name, int booster, int amount, int price){
        this.name = name;
        this.booster = booster;
        this.amount = amount;
        this.price = price;
    }

    public int getPrice(){
       return price;
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

    public void addAmount(){
        amount++;
    }

    public void minusAmount(){
        amount--;
    }

    public int getAmount(){
        return amount;
    }

    @Override
    public String toString() {
        return name + " - " + amount + " (restores " + booster +")";
    }


}
