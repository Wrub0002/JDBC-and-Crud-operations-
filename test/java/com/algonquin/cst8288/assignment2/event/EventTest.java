/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.algonquin.cst8288.assignment2.event;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

    /**
     * Unit tests for event classes in the assignment.
     * Tests the calculateAdmissionFee method for various event types.
     */
public class EventTest {

    /**
     * Test to verify the admission fee calculation for Kids Story Time event.
     */
    @Test
    public void testCalculateAdmissionFeeForKidsStoryTimeEvent() {
        KidsStoryTimeEvent event = new KidsStoryTimeEvent();
        event.calculateAdmissionFee();
        assertEquals("Kids Story Time event fee should be 3.0", 3.0, event.getAdmissionFees(), 0.0);
    }

    /**
     * Test to verify the admission fee calculation for Movie Night event.
     */
    @Test
    public void testCalculateAdmissionFeeForMovieNightEvent() {
        MovieNightEvent event = new MovieNightEvent();
        event.calculateAdmissionFee();
        assertEquals("Movie Night event fee should be 7.5", 7.5, event.getAdmissionFees(), 0.0);
    }

    /**
     * Test to verify the admission fee calculation for Workshop event.
     */
    @Test
    public void testCalculateAdmissionFeeForWorkshopEvent() {
        WorkshopEvent event = new WorkshopEvent();
        event.calculateAdmissionFee();
        assertEquals("Workshop event fee should be 15.0", 15.0, event.getAdmissionFees(), 0.0);
    }

    /**
     * Test to verify the admission fee calculation for Book Launch event.
     */
    @Test
    public void testCalculateAdmissionFeeForBookLaunchEvent() {
        BookLaunchEvent event = new BookLaunchEvent();
        event.calculateAdmissionFee();
        assertEquals("Book Launch event fee should be 20.0", 20.0, event.getAdmissionFees(), 0.0);
    }
}
