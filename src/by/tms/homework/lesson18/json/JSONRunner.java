package by.tms.homework.lesson18.json;

import by.tms.homework.lesson18.domain.devices.Keyboard;
import by.tms.homework.lesson18.domain.devices.Monitor;
import by.tms.homework.lesson18.domain.devices.Mouse;
import by.tms.homework.lesson18.domain.devices.Type;
import by.tms.homework.lesson18.domain.shop.Shop;
import by.tms.homework.lesson18.domain.shop.ShopAddress;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class JSONRunner {

    public static void main(String[] args) {
        Monitor monitor = new Monitor(23.8, "1100nb", "LG", "Germany", 300,
                new Type(true, 40, false), true);
        Mouse mouse = new Mouse("hj76k", "logitech", "Switzerland", 50,
                new Type(true, 5, false), true, false);
        Keyboard keyboard = new Keyboard("xcmh123", "logitech", "switzerland", 85.9,
                new Type(true, 15, false), true, false);
        ShopAddress shopAddress = new ShopAddress("Belarus", "Minsk", "+375297777777");

        Shop shop = new Shop(List.of(mouse, monitor, keyboard), shopAddress);

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            objectMapper.writerWithDefaultPrettyPrinter()
                    .writeValue(Path.of("resources", "homework", "task18", "shop.json").toFile(), shop);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
        Shop shopFromJSON = objectMapper.readValue(Path.of("resources", "homework", "task18", "shop.json").toFile(), Shop.class);
        System.out.println(shopFromJSON);
        } catch (IOException e) {
        e.printStackTrace();
        }

    }
}
