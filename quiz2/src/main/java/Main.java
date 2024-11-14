import com.google.gson.Gson;

import java.io.InputStreamReader;
import java.io.Reader;

public class Main {
    public static void main(String[] args) {
        try {
            Gson gson = new Gson();

            
            Reader reader = new InputStreamReader(
                    Main.class.getResourceAsStream("/package.json")
            );

            if (reader == null) {
                System.out.println("-----------------------------------------------");
                System.out.println("The JSON file could not be found or is empty.");
                System.out.println("-----------------------------------------------");
            } else {
                EmployeeList company = gson.fromJson(reader, EmployeeList.class);

                System.out.println("-----------------------------------------------");
                System.out.println("Employee Details:");
                System.out.println("-----------------------------------------------");

                for (Employee employee : company.Employees) {
                    System.out.println("-----------------------------------------------");
                    System.out.println("User ID: " + employee.userId);
                    System.out.println("Job Title: " + employee.jobTitleName);
                    System.out.println("Name: " + employee.preferredFullName);
                    System.out.println("Email: " + employee.emailAddress);
                    System.out.println("Phone: " + employee.phoneNumber);
                    System.out.println("Region: " + employee.region);
                    System.out.println("Employee Code: " + employee.employeeCode);
                    System.out.println("-----------------------------------------------");
                }

                reader.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
