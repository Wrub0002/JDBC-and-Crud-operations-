/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LoggerAndDataBaseTest;

import static org.junit.Assert.assertSame;
import com.algonquin.cst8288.assignment2.database.DBConnection;
import com.algonquin.cst8288.assignment2.logger.LMSLogger;
import org.junit.Test;

/**
 * Unit tests for singleton classes in the assignment.
 * Tests the singleton pattern implementation for DBConnection and LMSLogger classes.
 */
public class SingletonTest {

    /**
     * Test to ensure only one instance of DBConnection is created.
     */
    @Test
    public void testDBConnectionSingleton() {
        DBConnection instance1 = DBConnection.getInstance();
        DBConnection instance2 = DBConnection.getInstance();
        assertSame("DBConnection should be a singleton", instance1, instance2);
    }

    /**
     * Test to ensure only one instance of LMSLogger is created.
     */
    @Test
    public void testLMSLoggerSingleton() {
        LMSLogger logger1 = LMSLogger.getInstance();
        LMSLogger logger2 = LMSLogger.getInstance();
        assertSame("LMSLogger should be a singleton", logger1, logger2);
    }
}
