// ********RoostGPT********
/*
Test generated by RoostGPT for test demoTestGitlab using AI Type Open AI and AI Model gpt-4

1. Scenario: Removing an existing entry
   Description: Validate if a specific TimeEntry that exists in the entries list is removed successfully.

2. Scenario: Removing a non-existing entry
   Description: Validate the behavior when trying to remove a TimeEntry that does not exist in the entries list. 

3. Scenario: Removing a null entry
   Description: Validate the behavior when trying to remove a null entry from the entries list. 

4. Scenario: Removing an entry from an empty list
   Description: Validate the behavior when trying to remove an entry from an empty entries list. 

5. Scenario: Removing an entry when two identical entries exist
   Description: Validate the behavior when trying to remove a specific TimeEntry that has a duplicate in the entries list. 

6. Scenario: Removing an entry from a list with multiple entries
   Description: Validate if a specific TimeEntry is removed correctly when there are multiple other entries in the list.

7. Scenario: Removing an entry and checking the size of the list
   Description: Validate if the size of the entries list decreases by one after a successful removal operation.

8. Scenario: Removing an entry and checking the order of the remaining entries
   Description: Validate if the order of the remaining TimeEntry elements in the list stays the same after a successful removal operation. 

9. Scenario: Removing the first entry in the list
   Description: Validate if the first TimeEntry in the entries list can be successfully removed.

10. Scenario: Removing the last entry in the list
    Description: Validate if the last TimeEntry in the entries list can be successfully removed.  

Please note that the Java function provided contains a redundant removal operation (entries.remove(entry); is called twice). You should consider removing the redundant line to improve the efficiency of your code.
*/

// ********RoostGPT********
package training.taylor.timetracker.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import training.taylor.timetracker.core.dao.TimeEntry;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class Tracker_remove_bb9b871630_Test {
    private Tracker tracker;
    private List<TimeEntry> entries;

    @BeforeEach
    public void setup() {
        tracker = new Tracker();
        entries = new ArrayList<>();
        Mockito.when(tracker.getEntries()).thenReturn(entries);
    }

    @Test
    public void testRemoveExistingEntry() {
        TimeEntry entry = new TimeEntry();
        entries.add(entry);
        tracker.remove(entry);
        assertFalse(entries.contains(entry));
    }

    @Test
    public void testRemoveNonExistingEntry() {
        TimeEntry entry = new TimeEntry();
        tracker.remove(entry);
        assertFalse(entries.contains(entry));
    }

    @Test
    public void testRemoveNullEntry() {
        entries.add(null);
        tracker.remove(null);
        assertFalse(entries.contains(null));
    }

    @Test
    public void testRemoveEntryFromEmptyList() {
        TimeEntry entry = new TimeEntry();
        tracker.remove(entry);
        assertEquals(0, entries.size());
    }

    @Test
    public void testRemoveDuplicateEntry() {
        TimeEntry entry = new TimeEntry();
        entries.add(entry);
        entries.add(entry);
        tracker.remove(entry);
        assertEquals(1, entries.size());
    }

    @Test
    public void testRemoveEntryFromMultipleEntries() {
        TimeEntry entry1 = new TimeEntry();
        TimeEntry entry2 = new TimeEntry();
        entries.add(entry1);
        entries.add(entry2);
        tracker.remove(entry1);
        assertFalse(entries.contains(entry1));
        assertTrue(entries.contains(entry2));
    }

    @Test
    public void testRemoveEntryCheckListSize() {
        TimeEntry entry = new TimeEntry();
        entries.add(entry);
        tracker.remove(entry);
        assertEquals(0, entries.size());
    }

    @Test
    public void testRemoveEntryCheckOrder() {
        TimeEntry entry1 = new TimeEntry();
        TimeEntry entry2 = new TimeEntry();
        entries.add(entry1);
        entries.add(entry2);
        tracker.remove(entry1);
        assertEquals(entry2, entries.get(0));
    }

    @Test
    public void testRemoveFirstEntry() {
        TimeEntry entry1 = new TimeEntry();
        TimeEntry entry2 = new TimeEntry();
        entries.add(entry1);
        entries.add(entry2);
        tracker.remove(entry1);
        assertFalse(entries.contains(entry1));
    }

    @Test
    public void testRemoveLastEntry() {
        TimeEntry entry1 = new TimeEntry();
        TimeEntry entry2 = new TimeEntry();
        entries.add(entry1);
        entries.add(entry2);
        tracker.remove(entry2);
        assertFalse(entries.contains(entry2));
    }
}
