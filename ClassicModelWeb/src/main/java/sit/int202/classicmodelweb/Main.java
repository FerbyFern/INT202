package sit.int202.classicmodelweb;

//import jakarta.persistence.EntityManager;
//import jakarta.persistence.EntityManagerFactory;
//import jakarta.persistence.Persistence;
import at.favre.lib.crypto.bcrypt.BCrypt;
import sit.int202.classicmodelweb.entities.Customer;
import sit.int202.classicmodelweb.entities.Office;
import sit.int202.classicmodelweb.repositories.CustomerRepository;
import sit.int202.classicmodelweb.repositories.OfficeRepository;
import sit.int202.classicmodelweb.repositories.ProductRepository;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CustomerRepository customerRepository = new CustomerRepository();
        String password1 = "1234";
        String password2 = "1235";

        Customer customer = customerRepository.findByName("Jean King");
        System.out.println(customer);
        BCrypt.Result result = BCrypt.verifyer().verify(password1.toCharArray(), customer.getPassword());
        System.out.println("Password "+ password1+ (result.verified ? " is Matched": " is NOT matched"));

        customer = customerRepository.findByName("Kwai Lee");
        System.out.println(customer);
        result = BCrypt.verifyer().verify(password2.toCharArray(), customer.getPassword());
        System.out.println("Password "+ password2+ (result.verified ? " is Matched": " is NOT matched"));

        customer = customerRepository.findByName("Khai Tong");
        System.out.println(customer);

//        ProductRepository productRepository = new ProductRepository();
//        System.out.println(productRepository.countAll());
//        System.out.println(productRepository.findAll(1, 15));
/*
//        EntityManagerFactory emf =  Persistence.createEntityManagerFactory("classic-model");
//        EntityManager em = emf.createEntityManager();
//        Office office = em.find(Office.class, "4");
//
    //    OfficeRepository officeRepository = new OfficeRepository();
    //    Office office = officeRepository.find("2");

    //    if(office.getCity().equalsIgnoreCase("bangkok")) {
    //       office.setCity("Vientiane");
    //    } else {
    //        office.setCity("Bangkok");
    //    }
        //officeRepository.update(office);
        //saveOffice(officeRepository);   //<--call saveOffice
    //    deleteOffice(officeRepository);

    //    System.out.println(office);
    //    System.out.println("---------------------");
    //    office.getEmployeeList().forEach(e -> {
    //        System.out.printf("%10d %-10s %-12s %s\n",
    //                e.getId(), e.getFirstName(), e.getLastName(), e.getEmail());
    //    });
//        em.close();*/
    }

    private static void saveOffice (OfficeRepository officeRepository) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter new office id: ");
        String officeCode = sc.next();
        System.out.print("Enter new office city: ");
        String city = sc.next();
        Office newOffice = new Office();
        newOffice.setId(officeCode);
        newOffice.setCity(city);
        newOffice.setCountry("TH");
        newOffice.setAddressLine1("126 Pracha-utit");
        newOffice.setPhone("012-345-6789");
        newOffice.setPostalCode("10140");
        newOffice.setTerritory("NA");
        if (!officeRepository.save(newOffice)) {
            System.out.println("Error: Can't insert new office");
        }
    }

    private static void deleteOffice(OfficeRepository officeRepository) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter office id to delete: ");
        String officeCode = sc.next();
        if(! officeRepository.delete(officeCode)) {
            System.out.println("Error: Can't delete office id"+ officeCode) ;
        } else {
            System.out.println("Office id "+ officeCode + " has been deleted !!");
        }
    }
}
