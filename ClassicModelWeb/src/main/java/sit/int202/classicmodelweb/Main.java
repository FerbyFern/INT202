package sit.int202.classicmodelweb;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import sit.int202.classicmodelweb.entities.Office;
import sit.int202.classicmodelweb.repositories.OfficeRepository;

public class Main {
    public static void main(String[] args) {
//        EntityManagerFactory emf =  Persistence.createEntityManagerFactory("classic-model");
//        EntityManager em = emf.createEntityManager();
//        Office office = em.find(Office.class, "4");
        OfficeRepository officeRepository = new OfficeRepository();
        Office office = officeRepository.find("2");

        if(office.getCity().equalsIgnoreCase("bangkok")) {
            office.setCity("Vientiane");
        } else {
            office.setCity("Bangkok");
        }
        officeRepository.update(office);

        System.out.println(office);
        System.out.println("---------------------");
        office.getEmployeeList().forEach(e -> {
            System.out.printf("%10d %-10s %-12s %s\n",
                    e.getId(), e.getFirstName(), e.getLastName(), e.getEmail());
        });
//        em.close();
    }
}