package com.carffrey.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.carffrey.model.Venue;


public class VenueTest {

    private static EntityManagerFactory factory;
    private static EntityManager em;

    @Test
    public void venueTest() throws Exception {
        // persist some streams and register for cleanup
        em.getTransaction().begin();

        Venue venue = new Venue();
        venue.setName(generateUniqueName("venue"));
        em.persist(venue);
        
        em.getTransaction().commit();
        
        em.getTransaction().begin();
        em.find(Venue.class, 1L);
        
        em.getTransaction().commit();
    }
    
    @BeforeClass
    public static void setUpTest() {
        factory = Persistence.createEntityManagerFactory("TestGigPersistenceUnit");
        em = factory.createEntityManager();
    }
	
    @After
    public void tearDown() throws Exception {
        em.close();
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
	
    private static String generateUniqueName(String seed) {
        int i = (int)(Math.random() * 100000);
        return seed+i;
    }
}
