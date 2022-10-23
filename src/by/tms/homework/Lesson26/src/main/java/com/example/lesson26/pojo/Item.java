package com.example.lesson26.pojo;

import java.util.Objects;

public class Item {
    private Identity id;
    private String name;
    private int amount;
    private int price;

    public Item(String name, int amount, int price) {
        this.id = new Identity();
        this.name = name;
        this.amount = amount;
        this.price = price;
    }

    public Identity getId() {
        return id;
    }

    public void setId(Identity id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return amount == item.amount && price == item.price && Objects.equals(id, item.id) && Objects.equals(name, item.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, amount, price);
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id.toString() +
                ", name='" + name + '\'' +
                ", amount=" + amount +
                ", price=" + price +
                '}';
    }
}
