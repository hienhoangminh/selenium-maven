package com.expedia.flightbooking;

import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestNG_Grouping {
	
	//It is not run because it does not belong to any group.
	// Solution : add attribute alwaysRun=true
	@BeforeClass(alwaysRun=true)
	public void setUp() {
		System.out.println("\nThis runs once before class");
		
	}
	
	@AfterClass(alwaysRun=true)
	public void tearDown() {
		System.out.println("\nThis runs once after class");
	}

	@Test(groups= {"cars","suv"})
	public void testBMWX6() {
		System.out.println("\nRunning Test -> BMW X6");
	}

	@Test(groups= {"cars","sedan"})
	public void testAudiA6() {
		System.out.println("\nRunning Test -> Audi A6");
	}
	
	@Test(groups= {"bikes"})
	public void testNinja() {
		System.out.println("\nRunning Test -> Kawasaki Ninja");
	}
	
	@Test(groups= {"bikes"})
	public void testHondaCBR() {
		System.out.println("\nRunning Test -> HondaCBR");
	}

}
