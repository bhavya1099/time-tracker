// ********RoostGPT********
/*
Test generated by RoostGPT for test demoTestGitlab using AI Type Open AI and AI Model gpt-4

1. Scenario: Add a valid TimeEntry to the list.
   Description: In this scenario, a valid TimeEntry object is created and passed to the add method. The test will pass if the TimeEntry object is correctly added to the list.

2. Scenario: Add a null TimeEntry to the list.
   Description: In this scenario, a null TimeEntry object is passed to the add method. The test will pass if the code handles the null parameter properly, either by ignoring it or by throwing an appropriate exception.

3. Scenario: Add multiple valid TimeEntries to the list.
   Description: In this scenario, multiple valid TimeEntry objects are created and each one is passed to the add method. The test will pass if all the TimeEntry objects are correctly added to the list.

4. Scenario: Add a duplicate TimeEntry to the list.
   Description: In this scenario, a valid TimeEntry object is created and passed to the add method twice. The test will pass if the code handles the duplicate entries as expected, either by allowing duplicates or by ignoring the second add operation.

5. Scenario: Add a TimeEntry to a full list.
   Description: In this scenario, a valid TimeEntry object is added to a list that is already at its maximum capacity. The test will pass if the code handles this situation properly, either by expanding the list or by rejecting the new entry.

6. Scenario: Add a TimeEntry when the list is null.
   Description: In this scenario, the list of TimeEntry objects is null when the add method is called. The test will pass if the code handles this situation properly, either by initializing the list or by throwing an appropriate exception.

7. Scenario: Add a TimeEntry after removing an entry.
   Description: In this scenario, a TimeEntry object is added to the list, then removed, then another TimeEntry object is added. The test will pass if the second TimeEntry object is correctly added to the list.
*/

// ********RoostGPT********
package training.taylor.timetracker.core;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import training.taylor.timetracker.core.dao.TimeEntry;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class Tracker_add_7d27642e21_Test {
    private Tracker tracker;
    private TimeEntry mockEntry;

    @Before
    public void setup() {
        tracker = new Tracker();
        mockEntry = Mockito.mock(TimeEntry.class);
    }

    @Test
    public void testAddValidEntry() {
        tracker.add(mockEntry);
        assertEquals(1, tracker.size());
    }

    @Test(expected = NullPointerException.class)
    public void testAddNullEntry() {
        tracker.add(null);
    }

    @Test
    public void testAddMultipleEntries() {
        tracker.add(mockEntry);
        tracker.add(mockEntry);
        assertEquals(2, tracker.size());
    }

    @Test
    public void testAddDuplicateEntry() {
        tracker.add(mockEntry);
        tracker.add(mockEntry);
        assertEquals(2, tracker.size());
    }

    @Test
    public void testAddEntryToFullList() {
        for (int i = 0; i < 10; i++) {
            tracker.add(mockEntry);
        }
        assertEquals(10, tracker.size());
    }

    @Test(expected = NullPointerException.class)
    public void testAddEntryWhenListIsNull() {
        tracker = new Tracker();
        tracker.entries = null;
        tracker.add(mockEntry);
    }

    @Test
    public void testAddEntryAfterRemovingAnEntry() {
        tracker.add(mockEntry);
        tracker.remove(mockEntry);
        tracker.add(mockEntry);
        assertEquals(1, tracker.size());
    }
}
