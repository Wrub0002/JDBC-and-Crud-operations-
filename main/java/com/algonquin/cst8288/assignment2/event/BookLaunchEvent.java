/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.algonquin.cst8288.assignment2.event;

/**
 * Class representing a Book Launch event.
 */
public class BookLaunchEvent extends Event{

    
    public BookLaunchEvent(){
       this.eventName = "Book Launch Event";
       this.eventDescription = "A book launch event.";
       this.eventActivities = "Author talk, book signing";
    }
    @Override
    public void calculateAdmissionFee() {
       this.admissionFees = 20.0;
    }
    
}
