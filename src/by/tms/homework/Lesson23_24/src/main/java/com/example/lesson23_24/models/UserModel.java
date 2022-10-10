package com.example.lesson23_24.models;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class UserModel {

    private String name;
    private String email;
    private String password;
    private String role;
    private Set<CourseModel> courses = new HashSet<>();

    public UserModel(String name, String email, String password, String role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public UserModel(String name, String email, String password, String role, Set<CourseModel> courses) {
        this(name, email, password, role);
        this.courses = courses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Set<CourseModel> getCourses() {
        return courses;
    }

    public void setCourses(Set<CourseModel> courses) {
        this.courses = courses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserModel userModel = (UserModel) o;
        return Objects.equals(name, userModel.name) && Objects.equals(email, userModel.email) && Objects.equals(password, userModel.password) && Objects.equals(role, userModel.role) && Objects.equals(courses, userModel.courses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email, password, role, courses);
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", courses=" + courses +
                '}';
    }
}
