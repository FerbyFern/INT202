package sit.int202.classicmodelweb.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import sit.int202.classicmodelweb.entities.Customer;
import sit.int202.classicmodelweb.services.EntityManagerService;

import java.util.List;

//public class CustomerRepository {
//    private EntityManager getEntityManager() {
//        return EntityManagerService.getEntityManager();
//    }
//    public Customer findByName(String name) {
//        EntityManager em = getEntityManager();
//        Query query = em.createNamedQuery("FIND_USER");
//        query.setParameter("user_account", name);
//        List<Customer> customers = query.getResultList();
//        em.close();
//        return customers.size()==0? null : customers.get(0);
//    }
//}


public class CustomerRepository {

    private EntityManager getEntityManager(){
        return EntityManagerService.getEntityManager();
    }

    private static final String FIND_USER =
            "SELECT c FROM Customer c WHERE concat(trim(c.contactFirstName), ' ', trim(c.contactLastName)) = :user_account" ;

    public Customer findByName(String name) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery(FIND_USER);
        query.setParameter("user_account", name);
        List<Customer> customers = query.getResultList();
        em.close();
        return customers.size()==0? null : customers.get(0);
    }

    public List<Customer> findAll(){
        EntityManager em = getEntityManager();
        Query query = em.createQuery("select c from Customer c");
        List<Customer> customersList = query.getResultList();
        em.close();
        return customersList;
    }
}