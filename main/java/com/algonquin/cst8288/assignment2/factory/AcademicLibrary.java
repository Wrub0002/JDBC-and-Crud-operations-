/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.algonquin.cst8288.assignment2.factory;

import com.algonquin.cst8288.assignment2.event.Event;
import com.algonquin.cst8288.assignment2.event.WorkshopEvent;
import com.algonquin.cst8288.assignment2.event.BookLaunchEvent;

/**
 * Factory class for creating academic library events.
 */
public class AcademicLibrary implements EventFactory{

    @Override
    public Event createEvent(String type) {
        switch (type) {
            case "Workshop":
                return new WorkshopEvent();
            case "Book Launch Event":
                return new BookLaunchEvent();
            default:
                throw new IllegalArgumentException("Unknown event type");
        }
    }
}
