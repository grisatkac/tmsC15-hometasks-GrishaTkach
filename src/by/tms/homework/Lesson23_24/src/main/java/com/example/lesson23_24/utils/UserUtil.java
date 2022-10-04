package com.example.lesson23_24.utils;

import com.example.lesson23_24.models.CourseModel;
import com.example.lesson23_24.models.UserModel;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public final class UserUtil {
    public UserUtil() {};

    public static void generateStartUsers(List<UserModel> users) {
        UserModel teacher = new UserModel("Mariya", "teacher@cite.com", "teacher", RoleUtils.TEACHER_ROLE);
        UserModel student = new UserModel("Sasha", "student@cite.com", "student", RoleUtils.STUDENT_ROLE);
        users.add(teacher);
        users.add(student);
    }

    public static boolean loginUser(List<UserModel> users, String email, String password, HttpServletRequest request) {
        List<UserModel> foundUser;
        boolean correctLogin = false;
        if(email == null || email.isEmpty() || password == null || password.isEmpty()) {
            return correctLogin;
        }

        foundUser = users.stream()
                .filter(user -> user.getEmail().equals(email) && user.getPassword().equals(password))
                .collect(Collectors.toList());

        if (!foundUser.isEmpty()) {
            HttpSession session = request.getSession();
            session.setAttribute("Bearer", foundUser.get(0));
            correctLogin = true;
        }

        return correctLogin;
    }

    public static boolean registrateUser(Map<String, String> candidateUser, List<UserModel> users) {
        boolean isUserWasCreated = false;
        boolean isEmailExists = users.stream()
                .anyMatch(user -> user.getEmail().equals(candidateUser.get("email")));
        if (!isEmailExists) {
            UserModel newUser = new UserModel(
                    candidateUser.get("name"),
                    candidateUser.get("email"),
                    candidateUser.get("password"),
                    candidateUser.get("role")
            );
            users.add(newUser);
            isUserWasCreated = true;
        }

        return isUserWasCreated;
    }

    public static boolean addCourseForUser(HttpServletRequest request) {
        boolean isAddedCourse = false;
        String name = request.getParameter("name");
        String language = request.getParameter("language");
        String info = request.getParameter("additional-info");
        String secret = request.getParameter("secret-word");

        if (name == null || language == null || info == null || secret == null) {
            return isAddedCourse;
        }

        UserModel token = (UserModel)request.getSession().getAttribute("Bearer");
        Set<CourseModel> courses = token.getCourses();

        try {
            if (courses.stream().noneMatch(course -> course.getLanguage().equals(language))) {
                List<UserModel> users = (List<UserModel>)request.getServletContext().getAttribute("users");

                for (UserModel user : users) {
                    if (user.equals(token)) {
                        user.getCourses().add(new CourseModel(name, language, info, secret));
                        isAddedCourse = true;
                        break;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return isAddedCourse;
    }
}