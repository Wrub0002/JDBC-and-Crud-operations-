package com.algonquin.cst8288.assignment2.client;

import com.algonquin.cst8288.assignment2.database.DBOperations;
import com.algonquin.cst8288.assignment2.event.Event;
import com.algonquin.cst8288.assignment2.factory.AcademicLibrary;
import com.algonquin.cst8288.assignment2.factory.EventFactory;
import com.algonquin.cst8288.assignment2.factory.PublicLibrary;
import com.algonquin.cst8288.assignment2.logger.LMSLogger;
import com.algonquin.cst8288.assignment2.logger.LogLevel;

/**
 * Client class for the Library Management System.
 * This class initializes the logger, creates events using factory methods, performs CRUD operations, and logs actions.
 * 
 * @author Leonardo Wrubleski
 * @studentID 041120109
 */
public class Client {

    public static void main(String[] args) {
        // Initialize Logger
        LMSLogger logger = LMSLogger.getInstance();
        logger.log(LogLevel.INFO, "Application started");

        // Create Events using Factory Method for Public Library
        EventFactory publicLibraryFactory = new PublicLibrary();
        Event kidsStoryEvent = publicLibraryFactory.createEvent("Kids Story Time");
        kidsStoryEvent.calculateAdmissionFee();

        Event movieNightEvent = publicLibraryFactory.createEvent("Movie Night");
        movieNightEvent.calculateAdmissionFee();

        // Create Events using Factory Method for Academic Library
        EventFactory academicLibraryFactory = new AcademicLibrary();
        Event workshopEvent = academicLibraryFactory.createEvent("Workshop");
        workshopEvent.calculateAdmissionFee();

        Event bookLaunchEvent = academicLibraryFactory.createEvent("Book Launch Event");
        bookLaunchEvent.calculateAdmissionFee();

        // Log Event Creation
        logger.log(LogLevel.INFO, "Created events: Kids Story Time, Movie Night, Workshop, and Book Launch Event");

        // Perform CRUD Operations
        // Create Events
        DBOperations.createEvent(kidsStoryEvent);
        DBOperations.createEvent(movieNightEvent);
        DBOperations.createEvent(workshopEvent);
        DBOperations.createEvent(bookLaunchEvent);
        logger.log(LogLevel.INFO, "Inserted events into database");

        // Retrieve Event
        Event retrievedEvent = DBOperations.retrieveEvent(1); 
        if (retrievedEvent != null) {
            logger.log(LogLevel.INFO, "Retrieved event: " + retrievedEvent.getEventName());
        } else {
            logger.log(LogLevel.WARN, "Event not found");
        }

        // Update Event
        if (retrievedEvent != null) {
            retrievedEvent.setEventDescription("Updated description");
            DBOperations.updateEvent(retrievedEvent, 1);
            logger.log(LogLevel.INFO, "Updated event description in database");
        }

        // Delete Event
        DBOperations.deleteEvent(1);
        logger.log(LogLevel.INFO, "Deleted event from database");

        // Close Logger
        logger.log(LogLevel.INFO, "Application ended");
        logger.close();
    }
}
