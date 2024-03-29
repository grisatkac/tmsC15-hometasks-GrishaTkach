package by.tms.homework.Lesson33.pojo;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;
import java.util.Optional;

public class User implements Serializable, Cloneable {

    @Serial
    private static final long serialVersionUID = -5578520619180516238L;
    private Identity id;
    private String firstName;
    private String lastName;
    private int age;
    private int number;

    public User() {}

    public User(String firstName, String lastName, int age, int number) {
        this.id = new Identity();
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.number = number;
    }

    public Identity getId() {
        return id;
    }

    public void setId(long id) {
        this.id = new Identity(id);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public static User cloneUser(String cloneType, long userId) throws CloneNotSupportedException {
        if (cloneType == null ) {
            return new User();
        }

        Optional<User> foundUser = UserList.usersList.stream()
                .filter(user -> user.getId().getId() == userId)
                .findFirst();

        User newCopiedUser = new User();
        if (foundUser.isPresent()) {
            if (CLONE_TYPE.DEEP.toString().equals(cloneType)) {
                newCopiedUser = foundUser.get().deepClone();
            }

            if (CLONE_TYPE.USUAL.toString().equals(cloneType)) {
                newCopiedUser = foundUser.get().clone();
            }
            return newCopiedUser;
        }

        return new User();
    }

    @Override
    protected User clone() throws CloneNotSupportedException {
        return (User) super.clone();
    }

    public User deepClone() throws CloneNotSupportedException {
        User clonedUser = new User(
                getFirstName(),
                getLastName(),
                getAge(),
                getNumber()
        );
        clonedUser.id = (Identity) id.clone();
        return clonedUser;
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }

        if (object == null || !(getClass().getSimpleName().equals(this.getClass().getSimpleName()))) {
            return false;
        }

        User user = (User)object;
        return  this.id.equals(user.id)
                && this.firstName.equals(user.firstName)
                && this.lastName.equals(user.lastName)
                && this.age == user.age
                && this.number == user.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, age, number);
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append(String.format("Class: %s \n", getClass().getSimpleName()))
                .append(String.format("User id: %s \n", id))
                .append(String.format("First name: %s \n", firstName))
                .append(String.format("Last name: %s \n", lastName))
                .append(String.format("Age: %s \n", age))
                .append(String.format("Contact number: %s \n", number))
                .toString();
    }
}
