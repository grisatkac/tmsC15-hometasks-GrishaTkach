package by.tms.homework.lesson18.domain.shop;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class ShopAddress {

    private String country;
    private String city;
    private String phoneNumber;

    @JsonCreator
    public ShopAddress(
            @JsonProperty("country") String country,
            @JsonProperty("city") String city,
            @JsonProperty("phoneNumber") String phoneNumber) {
        this.country = country;
        this.city = city;
        this.phoneNumber = phoneNumber;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShopAddress that = (ShopAddress) o;
        return phoneNumber == that.phoneNumber && Objects.equals(country, that.country) && Objects.equals(city, that.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(country, city, phoneNumber);
    }

    @Override
    public String toString() {
        return "ShopAddress{" +
                "country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}
