// ********RoostGPT********
/*
Test generated by RoostGPT for test java-junit4-test using AI Type Open AI and AI Model gpt-4

1. Scenario: Add a valid TimeEntry to the entries list.
   In this scenario, we create a valid TimeEntry and pass it to the add method. We then verify that the TimeEntry was added to the list.

2. Scenario: Add a null TimeEntry to the entries list.
   In this scenario, we pass a null value to the add method. The test should check how the system handles null values and whether it can handle them without crashing.

3. Scenario: Add multiple TimeEntries to the entries list.
   In this scenario, we create several valid TimeEntries and add them to the list one by one. We then verify that all entries have been added to the list.

4. Scenario: Add a duplicate TimeEntry to the entries list.
   In this scenario, we create a valid TimeEntry, add it to the list, and then add it again. The test should verify whether the list allows duplicate entries or not.

5. Scenario: Add a TimeEntry when the entries list is full.
   In this scenario, we fill the entries list to its maximum capacity and then try to add another TimeEntry. The test should verify the system's behavior when the list is full.

6. Scenario: Add a TimeEntry to an uninitialized entries list.
   In this scenario, the entries list is not initialized before we try to add a TimeEntry. The test should verify if the system can handle this situation without crashing.

7. Scenario: Add a TimeEntry with special characters in its fields.
   In this scenario, we create a TimeEntry with special characters in its fields and add it to the list. The test should verify if the system can handle TimeEntries with special characters.

8. Scenario: Add a TimeEntry with very long field values.
   In this scenario, we create a TimeEntry with very long field values and add it to the list. The test should verify if the system can handle TimeEntries with long field values.
*/

// ********RoostGPT********
package training.taylor.timetracker.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import training.taylor.timetracker.core.dao.TimeEntry;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class Tracker_add_7d27642e21_Test {

    private Tracker tracker;
    private TimeEntry timeEntry;

    @BeforeEach
    public void setup() {
        tracker = new Tracker();
        timeEntry = new TimeEntry();
        timeEntry.setProject("Test");
        timeEntry.setStart("10:00");
        timeEntry.setStop("11:00");
        timeEntry.setRate(100);
        timeEntry.setInitials("TT");
    }

    @Test
    public void testAddValidTimeEntry() {
        tracker.add(timeEntry);
        assertEquals(1, tracker.size());
        assertEquals(timeEntry, tracker.get(0));
    }

    @Test
    public void testAddNullTimeEntry() {
        assertThrows(NullPointerException.class, () -> {
            tracker.add(null);
        });
    }

    @Test
    public void testAddMultipleTimeEntries() {
        TimeEntry timeEntry2 = new TimeEntry();
        timeEntry2.setProject("Test2");
        timeEntry2.setStart("12:00");
        timeEntry2.setStop("13:00");
        timeEntry2.setRate(200);
        timeEntry2.setInitials("TT2");

        tracker.add(timeEntry);
        tracker.add(timeEntry2);

        assertEquals(2, tracker.size());
        assertEquals(timeEntry, tracker.get(0));
        assertEquals(timeEntry2, tracker.get(1));
    }

    @Test
    public void testAddDuplicateTimeEntry() {
        tracker.add(timeEntry);
        tracker.add(timeEntry);
        assertEquals(2, tracker.size());
    }

    @Test
    public void testAddTimeEntryWhenListIsFull() {
        for (int i = 0; i < 10; i++) {
            TimeEntry entry = new TimeEntry();
            entry.setProject("Test" + i);
            tracker.add(entry);
        }

        assertThrows(IndexOutOfBoundsException.class, () -> {
            tracker.add(timeEntry);
        });
    }

    @Test
    public void testAddTimeEntryToUninitializedList() {
        assertThrows(NullPointerException.class, () -> {
            Tracker tracker2 = new Tracker();
            tracker2.add(timeEntry);
        });
    }

    @Test
    public void testAddTimeEntryWithSpecialCharacters() {
        timeEntry.setProject("@#$%");
        tracker.add(timeEntry);
        assertEquals(1, tracker.size());
        assertEquals(timeEntry, tracker.get(0));
    }

    @Test
    public void testAddTimeEntryWithLongValues() {
        String longString = new String(new char[1000]).replace("\0", "a");
        timeEntry.setProject(longString);
        tracker.add(timeEntry);
        assertEquals(1, tracker.size());
        assertEquals(timeEntry, tracker.get(0));
    }
}
