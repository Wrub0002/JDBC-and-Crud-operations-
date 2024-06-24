/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.algonquin.cst8288.assignment2.event;

import com.algonquin.cst8288.assignment2.constants.Constants;

/**
 * Class representing a Movie Night event.
 */
public class MovieNightEvent extends Event{

    public MovieNightEvent(){
        this.eventName = "Movie Night";
        this.eventDescription = "A movie screening event.";
        this.eventActivities = "Movie screening, popcorn";
    }
    
    @Override
    public void calculateAdmissionFee() {
        this.admissionFees = Constants.MOVIE_NIGHT_RATE * Constants.MOVIE_NIGHT_DURATION;
    }
    
}
