// ********RoostGPT********
/*
Test generated by RoostGPT for test demoTestGitlab using AI Type Open AI and AI Model gpt-4

1. **Scenario:** Validate the addition of a new `TimeEntry` object to the `entries` list.
   **Test Case:** Create a new `TimeEntry` object and pass it to the `add()` method. Then confirm that the `entries` list contains the new `TimeEntry` object.

2. **Scenario:** Validate the behavior when a `null` value is passed to the `add()` method.
   **Test Case:** Pass a `null` value to the `add()` method and confirm that a `NullPointerException` or a custom exception is thrown.

3. **Scenario:** Validate the behavior when the `entries` list is already full.
   **Test Case:** If there is a limit to the size of the `entries` list, fill the `entries` list to its maximum capacity and then attempt to add another `TimeEntry` object. Confirm that an `IndexOutOfBoundsException` or a custom exception is thrown.

4. **Scenario:** Validate the behavior when the same `TimeEntry` object is added to the `entries` list multiple times.
   **Test Case:** Pass the same `TimeEntry` object to the `add()` method multiple times and confirm that the `entries` list contains multiple instances of the same `TimeEntry` object.

5. **Scenario:** Validate the behavior when the `TimeEntry` object passed to the `add()` method already exists in the `entries` list.
   **Test Case:** Create a new `TimeEntry` object, add it to the `entries` list, and then attempt to add the same `TimeEntry` object to the `entries` list again. Confirm that the `entries` list contains two instances of the same `TimeEntry` object.

6. **Scenario:** Validate the order of the `entries` list after multiple `TimeEntry` objects are added.
   **Test Case:** Create multiple `TimeEntry` objects and add them to the `entries` list in a specific order. Confirm that the `entries` list maintains the same order of `TimeEntry` objects.
*/

// ********RoostGPT********
package training.taylor.timetracker.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import training.taylor.timetracker.core.dao.TimeEntry;
import org.junit.Before;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

public class Tracker_add_7d27642e21_Test {

    private Tracker tracker;
    private TimeEntry entry;

    @Before
    public void setup() {
        tracker = new Tracker();
        entry = new TimeEntry();
    }

    @Test
    public void testAddEntry() {
        tracker.add(entry);
        assertEquals(1, tracker.size());
        assertEquals(entry, tracker.get(0));
    }

    @Test(expected = NullPointerException.class)
    public void testAddNullEntry() {
        tracker.add(null);
    }

    @Test
    public void testAddSameEntryMultipleTimes() {
        tracker.add(entry);
        tracker.add(entry);
        assertEquals(2, tracker.size());
    }

    @Test
    public void testAddEntryAlreadyInList() {
        tracker.add(entry);
        TimeEntry sameEntry = entry;
        tracker.add(sameEntry);
        assertEquals(2, tracker.size());
    }

    @Test
    public void testOrderOfEntries() {
        TimeEntry entry1 = new TimeEntry();
        TimeEntry entry2 = new TimeEntry();
        tracker.add(entry1);
        tracker.add(entry2);
        assertEquals(entry1, tracker.get(0));
        assertEquals(entry2, tracker.get(1));
    }
}
