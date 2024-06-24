/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.algonquin.cst8288.assignment2.event;

import com.algonquin.cst8288.assignment2.constants.Constants;

/**
 * Class representing a Kids Story Time event.
 */
public class KidsStoryTimeEvent extends Event{

    public KidsStoryTimeEvent(){
        this.eventName = "Kids Story Time";
        this.eventDescription = "A fun story time event for kids.";
        this.eventActivities = "Story reading, interactive activities";
    }

    @Override
    public void calculateAdmissionFee() {
        this.admissionFees = Constants.KIDS_STORYTIME_RATE * Constants.KIDS_STORYTIME_DURATION;
    }
    
}
