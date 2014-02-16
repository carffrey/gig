package com.carffrey.rest.bean;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.carffrey.model.Address;
import com.carffrey.model.Category;
import com.carffrey.model.Feature;
import com.carffrey.model.Venue;
import com.carffrey.model.VenueDetail;

@Singleton
@Startup
public class SetupBean {

	@PersistenceContext
	private EntityManager em;
	
	@PostConstruct
	public void setupDb() {
		
		Venue v1 = new Venue();
		v1.setName("Test2");
		
		Address a = new Address();
		a.setCity("City");
		a.setState("MA");
		a.setStreet("11 Your Street");
		a.setZip("00990");
		
		v1.setAddress(a);
		
		em.persist(v1);
		
		Venue v2 = new Venue();
		v2.setName("Venue 1");
		
		Address a2 = new Address();
		a2.setCity("Boston");
		a2.setState("MA");
		a2.setStreet("1 Turner Rd");
		a2.setZip("19320");
		
		v2.setAddress(a2);
		
		em.persist(v2);
	
		Venue v = newVenue();
		em.persist(v);
	}
	
	private Venue newVenue() {
		Venue v = new Venue();
		v.setAddress(newAddress());
		v.setName("Jeff's Place");
		v.setPhoneNumber("555-555-5555");
		v.setDetail(newVenueDetail());
		
//		Category c = new Category();
//		c.setName("Category");
//		
//		Feature f = new Feature();
//		f.setName("f1");
//		f.setValue("val1");
//		
//		c.getFeatures().add(f);	
//
//		VenueDetail d = new VenueDetail();
//		d.setTest(1);
//		d.getCategories().put("Category",c);
//
//		v.setDetail(d);
		return v;
	}
	
	private Address newAddress() {
		Address a = new Address();
		a.setCity("Westford");
		a.setState("MA");
		a.setStreet("99 The Street");
		a.setZip("90210");
		return a;
	}
	
	private VenueDetail newVenueDetail() {
		Map<String, Category> cs = new HashMap<String, Category>();
		cs.put("Equipment", equipmentCategory("Equipment"));
		cs.put("Venue", venueCategory("Venue"));
		cs.put("Show", showCategory("Show"));
		cs.put("Loading", loadingCategory("Loading"));
		cs.put("Perks", perksCategory("Perks"));
		
		VenueDetail d = new VenueDetail();
		d.setTest(1);
		d.getCategories().putAll(cs);
		return d;
	}
	
	private Category newCategory(String name, Set<Feature> fs) {
		Category c = new Category();
		c.setName(name);
		c.getFeatures().addAll(fs);
		return c;
	}
	
	private Feature newFeature(String name, String value) {
		Feature f = new Feature();
		f.setName(name);
		f.setValue(value);
		return f;
	}
	
	private Category equipmentCategory(String name) {
		Set<Feature> fs = new HashSet<Feature>();

		fs.add(newFeature("Guitar Amps", "0"));
		fs.add(newFeature("Bass Amps", "0"));
		fs.add(newFeature("Drum kit", "1"));
		fs.add(newFeature("Piano", "1"));
		fs.add(newFeature("Keyboard", "1"));
		
		return newCategory(name, fs);
	}
	
	private Category venueCategory(String name) {
		Set<Feature> fs = new HashSet<Feature>();

		fs.add(newFeature("Stage", "Fits 4"));
		fs.add(newFeature("Staff", "Easy to work with"));
		fs.add(newFeature("Sound Guy", "Yes"));
		fs.add(newFeature("Parking", "Has Lot"));
		fs.add(newFeature("Feel", "Rock Divey"));
		
		return newCategory(name, fs);
	}
	
	private Category perksCategory(String name) {
		Set<Feature> fs = new HashSet<Feature>();

		fs.add(newFeature("Drink Tickets", "2 per band member"));
		fs.add(newFeature("Guest List", "1 per band member"));
		fs.add(newFeature("Free Soda", "Yes"));
		fs.add(newFeature("Free Food", "No"));
		
		return newCategory(name, fs);
	}
	
	
	private Category loadingCategory(String name) {
		Set<Feature> fs = new HashSet<Feature>();

		fs.add(newFeature("Dedicated Load Zone", "Y"));
		fs.add(newFeature("Ease of Load", "4"));
		fs.add(newFeature("Free Soda", "Yes"));
		fs.add(newFeature("Free Food", "No"));
		
		return newCategory(name, fs);
	}
	
	private Category showCategory(String name) {
		Set<Feature> fs = new HashSet<Feature>();

		fs.add(newFeature("Lights", "Y"));
		fs.add(newFeature("Room Sound", "Echoey"));
		fs.add(newFeature("Payment", "Based on door"));
		
		return newCategory(name, fs);
	}
}
