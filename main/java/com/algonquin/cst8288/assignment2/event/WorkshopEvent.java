/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.algonquin.cst8288.assignment2.event;

import com.algonquin.cst8288.assignment2.constants.Constants;
/**
 * Class representing a Workshop event.
 */
public class WorkshopEvent extends Event{
    
    public WorkshopEvent(){
        this.eventName = "Workshop";
        this.eventActivities = "An educational workshop.";
        this.eventDescription = "Lectures, hands-on activities";
    }

    @Override
    public void calculateAdmissionFee() {
        this.admissionFees = Constants.WORKSHOP_RATE * Constants.WORKSHOP_DURATION;
    }
}
