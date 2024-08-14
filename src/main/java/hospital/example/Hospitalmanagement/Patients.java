package hospital.example.Hospitalmanagement;

import org.springframework.boot.autoconfigure.amqp.RabbitProperties;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Patients {
    private Connection connection;
    private Scanner scanner;


    public Patients(Connection connection, Scanner scanner) {
        this.connection = connection;
        this.scanner = scanner;


    }

    public void addPatient() {
        System.out.println("Enter Patient Name");
        String name = scanner.next();
        System.out.println("Enter Patient Age");
        int age = scanner.nextInt();
        System.out.println("Enter Patient Gender");
        String gender = scanner.next();


        try {
            String query = "INSERT INTO Patients(name,age,gender)Value(?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, age);
            preparedStatement.setString(3, gender);
            int affectedRow = preparedStatement.executeUpdate();
            if (affectedRow > 0) {
                System.out.println("Patient add successfully");
            } else {
                System.out.println("failed to add patient");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void viewPatient() {
        String query = "Select * from Patients";

    }
}

