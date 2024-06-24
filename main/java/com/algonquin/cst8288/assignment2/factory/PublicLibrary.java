/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.algonquin.cst8288.assignment2.factory;

import com.algonquin.cst8288.assignment2.event.Event;
import com.algonquin.cst8288.assignment2.event.KidsStoryTimeEvent;
import com.algonquin.cst8288.assignment2.event.MovieNightEvent;


/**
 * Factory class for creating public library events.
 */
public class PublicLibrary implements EventFactory{

    @Override
    public Event createEvent(String type) {
        switch (type) {
            case "Movie Night":
                return new MovieNightEvent();
            case "Kids Story Time":
                return new KidsStoryTimeEvent();
            default:
                throw new IllegalArgumentException("Unknown event type");     
            }
        }
    }

