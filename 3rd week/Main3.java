package com.example.hibernate;

import jakarta.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String department;
    public Employee() {}
    public Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }
    public int getId() { return id; }
    public String getName() { return name; }
    public String getDepartment() { return department; }

    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setDepartment(String department) { this.department = department; }
    @Override
    public String toString() {
        return "Employee{id=" + id + ", name='" + name + "', department='" + department + "'}";
    }
}
 package com.example.hibernate;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class EmployeeManager {
    private static final SessionFactory factory = new Configuration().configure().buildSessionFactory();

    public Integer addEmployee(Employee employee) {
        Session session = factory.openSession();
        Transaction tx = null;
        Integer employeeID = null;

        try {
            tx = session.beginTransaction();
            employeeID = (Integer) session.save(employee);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return employeeID;
    }

    public void shutdown() {
        factory.close();
    }
}
package com.example.hibernate;

public class Main3 {
    public static void main(String[] args) {
        EmployeeManager manager = new EmployeeManager();

        Employee emp = new Employee("Alice", "IT");
        Integer empId = manager.addEmployee(emp);

        System.out.println("Employee saved with ID: " + empId);

        manager.shutdown();
    }
}


    


