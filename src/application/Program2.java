package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Program2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("=== TEST 1: findById ===");
        Department dep = departmentDao.findById(3);
        System.out.println(dep);

        System.out.println("\n=== TEST 2: findAll ===");
        List<Department> deps = departmentDao.findAll();
        for (Department obj : deps)
            System.out.println(obj);

        System.out.println("\n=== TEST 3: Department Insert ===");
        Department newDep = new Department (null, "Films");
        departmentDao.insert(newDep);
        System.out.println("Inserted new Department : " + newDep.getName());

        System.out.println("\n=== TEST 4: Department Update ===");
        dep = departmentDao.findById(6);
        dep.setName("Education");
        departmentDao.update(dep);
        System.out.println("Updated Department : " + dep.getName());

        System.out.println("\n=== TEST 5: Department delete ===");
        System.out.println("Enter department Id : ");
        int id = sc.nextInt();
        departmentDao.deleteById(id);
        System.out.println("Department deleted");


        sc.close();
    }


}