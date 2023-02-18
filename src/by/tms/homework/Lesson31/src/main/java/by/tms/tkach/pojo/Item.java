package by.tms.tkach.pojo;

import by.tms.tkach.utils.LogUtil;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class Item implements Serializable {

    @Serial
    private static final long serialVersionUID = -8285169193466776568L;
    private ItemIdentity id;
    private String nameOfItem;
    private int amount;
    private int price;

    public Item(String nameOfItem, int amount, int price) {
        if (nameOfItem.length() > 4 && amount > 0 && price > 0) {
            this.id = new ItemIdentity();
            this.nameOfItem = nameOfItem;
            this.amount = amount;
            this.price = price;
        }
        LogUtil.printInfoLog("Incorrect parameters for Item. Object will create with default fields");
    }

    public ItemIdentity getId() {
        return id;
    }

    public void setId(ItemIdentity id) {
        this.id = id;
    }

    public String getNameOfItem() {
        return nameOfItem;
    }

    public void setNameOfItem(String nameOfItem) {
        this.nameOfItem = nameOfItem;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;
        Item item = (Item) o;
        return amount == item.amount && price == item.price && Objects.equals(id, item.id) && Objects.equals(nameOfItem, item.nameOfItem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nameOfItem, amount, price);
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", nameOfItem='" + nameOfItem + '\'' +
                ", amount=" + amount +
                ", price=" + price +
                '}';
    }
}
