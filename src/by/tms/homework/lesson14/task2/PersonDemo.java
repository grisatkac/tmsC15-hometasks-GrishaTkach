package by.tms.homework.lesson14.task2;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

public class PersonDemo {

    public static void main(String[] args) {
        Person person = new Person("Ivan", "Ivanovich", 50);
        Person person1 = new Person("Konstantin", "Sidorovich", 100);
        Person person2 = new Person("ALex", "Alexovich", 150);

        Optional<Person> personWithMaxAge = Stream.of(person, person1, person2)
                .filter(pers -> pers.getFirstName().length() + pers.getLastName().length() < 15)
                .max(Comparator.comparing(Person::getAge));

        if (personWithMaxAge.isPresent()) {
            System.out.println(personWithMaxAge.get().getFirstName() + " " + personWithMaxAge.get().getLastName() );
        }
    }
}
