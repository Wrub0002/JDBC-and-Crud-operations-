package com.algonquin.cst8288.assignment2.database;

import com.algonquin.cst8288.assignment2.event.Event;
import com.algonquin.cst8288.assignment2.logger.LMSLogger;
import com.algonquin.cst8288.assignment2.logger.LogLevel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * DBOperations class handles the CRUD operations for events.
 */
public class DBOperations {

    private static final Connection connection = DBConnection.getInstance().getConnection();
    private static final LMSLogger logger = LMSLogger.getInstance();

    /**
     * Inserts an event into the database.
     *
     * @param event the event to be inserted
     */
    public static void createEvent(Event event) {
        String sql = "INSERT INTO events (event_name, event_description, event_activities, admission_fees) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, event.getEventName());
            pstmt.setString(2, event.getEventDescription());
            pstmt.setString(3, event.getEventActivities());
            pstmt.setDouble(4, event.getAdmissionFees());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            logger.log(LogLevel.ERROR, "Failed to create event: " + e.getMessage(), e);
        }
    }

    /**
     * Retrieves an event from the database by its ID.
     *
     * @param event_id the ID of the event to retrieve
     * @return the retrieved event or null if not found
     */
    public static Event retrieveEvent(int event_id) {
        String sql = "SELECT * FROM events WHERE event_id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, event_id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                Event event = new Event() {
                    @Override
                    public void calculateAdmissionFee() {
                    }
                };
                event.setEventName(rs.getString("event_name"));
                event.setEventDescription(rs.getString("event_description"));
                event.setEventActivities(rs.getString("event_activities"));
                event.setAdmissionFees(rs.getDouble("admission_fees"));
                return event;
            }
        } catch (SQLException e) {
            logger.log(LogLevel.ERROR, "Failed to retrieve event: " + e.getMessage(), e);
        }
        return null;
    }

    /**
     * Updates an event in the database.
     *
     * @param event the event with updated values
     * @param event_id the ID of the event to update
     */
    public static void updateEvent(Event event, int event_id) {
        String sql = "UPDATE events SET event_name = ?, event_description = ?, event_activities = ?, admission_fees = ? WHERE event_id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, event.getEventName());
            pstmt.setString(2, event.getEventDescription());
            pstmt.setString(3, event.getEventActivities());
            pstmt.setDouble(4, event.getAdmissionFees());
            pstmt.setInt(5, event_id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            logger.log(LogLevel.ERROR, "Failed to update event: " + e.getMessage(), e);
        }
    }

    /**
     * Deletes an event from the database by its ID.
     *
     * @param event_id the ID of the event to delete
     */
    public static void deleteEvent(int event_id) {
        String sql = "DELETE FROM events WHERE event_id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, event_id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            logger.log(LogLevel.ERROR, "Failed to delete event: " + e.getMessage(), e);
        }
    }
}
