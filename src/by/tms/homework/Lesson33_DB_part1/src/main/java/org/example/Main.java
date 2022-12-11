package org.example;

import lombok.extern.slf4j.Slf4j;
import org.example.repository.AddressRepository;
import org.example.repository.StudentRepository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Slf4j
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        String url = "jdbc:mysql://localhost:3306/university";
        String user = "root";
        String password = "ghblevfyysq gfhjkm}";

        try(Connection connection = DriverManager.getConnection(url, user, password)) {
            AddressRepository addressRepository = new AddressRepository();
            StudentRepository studentRepository = new StudentRepository();
            boolean resultOfCreatingAddressRepository = addressRepository.init(connection);
            if (resultOfCreatingAddressRepository) {
                log.info("Success creation of address repository");
            }

            boolean resultOfStudentRepository = studentRepository.init(connection);
            if (resultOfStudentRepository) {
                log.info("Success creation of student repository");
            }

            log.info("adding address");
            Long newAddressId = addressRepository.addNewAddress(connection, "Belarus", "Minsk", "Gagarina", 111);
            addressRepository.addNewAddress(connection, "Belarus", "Pinsk", "Gagarina", 111);
            addressRepository.addNewAddress(connection, "Minsk", "Brest", "Gagarina", 111);
            log.info("new address id: " + newAddressId);

            log.info("deleting address");
            boolean isDeleted = addressRepository.deleteAddress(connection, "Pinsk");
            log.info("is deleted: " + isDeleted);

            log.info("adding student");
            Long newUserId = studentRepository.addNewStudent(connection, "Grisha", "Tkach", 6L);
            log.info("is added user: " + newUserId);

            log.info("deleting student");
            boolean isDeletedUserId = studentRepository.deleteStudent(connection, 3L);
            log.info("is deleted student: " + isDeletedUserId);

            log.info("information about all users");
            studentRepository.getAllInformationAboutStudents(connection);

        } catch (SQLException e) {
            log.error(e.getMessage());
        }
    }
}