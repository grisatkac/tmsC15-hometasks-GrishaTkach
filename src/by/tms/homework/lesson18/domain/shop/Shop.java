package by.tms.homework.lesson18.domain.shop;

import by.tms.homework.lesson18.domain.devices.Device;

import java.util.List;
import java.util.Objects;

public class Shop {

    private List<Device> devices;
    private ShopAddress shopAddress;

    public Shop() {

    }
    public Shop(List<Device> devices, ShopAddress shopAddress) {
        this.devices = devices;
        this.shopAddress = shopAddress;
    }

    public List<Device> getDevices() {
        return devices;
    }

    public void setDevices(List<Device> devices) {
        this.devices = devices;
    }

    public ShopAddress getShopAddress() {
        return shopAddress;
    }

    public void setShopAddress(ShopAddress shopAddress) {
        this.shopAddress = shopAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shop shop = (Shop) o;
        return Objects.equals(devices, shop.devices) && Objects.equals(shopAddress, shop.shopAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(devices, shopAddress);
    }

    @Override
    public String toString() {
        return "Shop{" +
                "devices=" + devices +
                ", shopAddress=" + shopAddress +
                '}';
    }
}
