/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.algonquin.cst8288.assignment2.factory;

import com.algonquin.cst8288.assignment2.event.Event;

/**
 * Interface for event factories.
 */
public interface EventFactory {
    
    /**
     * Creates an event based on the specified type.
     *
     * @param type the type of event to create
     * @return the created event
     */
    Event createEvent(String type);
}
