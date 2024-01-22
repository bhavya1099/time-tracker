/*
Test generated by RoostGPT for test demoTestGitlab using AI Type Open AI and AI Model gpt-4

Test Scenario 1: Empty List
- Description: Test whether the function returns 0 when the list "entries" is empty. 

Test Scenario 2: Non-empty List
- Description: Test whether the function returns the correct size when the list "entries" is not empty. 

Test Scenario 3: Add Entry
- Description: Test whether the function correctly increments the size after a new entry is added to the list "entries". 

Test Scenario 4: Remove Entry
- Description: Test whether the function correctly decrements the size after an entry is removed from the list "entries". 

Test Scenario 5: Clear List
- Description: Test whether the function returns 0 after all entries are removed from the list "entries". 

Test Scenario 6: Null List
- Description: Test whether the function handles null values correctly. If the list "entries" is null, the function should either return 0 or throw an appropriate exception. 

Test Scenario 7: Large List
- Description: Test whether the function can handle a large number of entries in the list and still return the correct size.

Test Scenario 8: Concurrent Modifications
- Description: Test whether the function returns the correct size when multiple threads are concurrently adding and/or removing entries from the list. 

Test Scenario 9: Duplicate Entries
- Description: Test whether the function counts duplicate entries in the list "entries". 

Test Scenario 10: Entry with Null Values
- Description: Test whether the function counts an entry with null values in the list "entries".
*/
package training.taylor.timetracker.core;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import training.taylor.timetracker.core.dao.TimeEntry;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class Tracker_size_83d847afcf_Test {

    @Mock
    private List<TimeEntry> entries;

    @InjectMocks
    private Tracker tracker;

    @Before
    public void setUp() {
        when(entries.size()).thenReturn(0);
    }

    @Test
    public void testSizeWhenListIsEmpty() {
        assertEquals(0, tracker.size());
    }

    @Test
    public void testSizeWhenListIsNotEmpty() {
        when(entries.size()).thenReturn(5);
        assertEquals(5, tracker.size());
    }

    @Test
    public void testSizeAfterAddingEntry() {
        when(entries.size()).thenReturn(1);
        tracker.add(mock(TimeEntry.class));
        assertEquals(1, tracker.size());
    }

    @Test
    public void testSizeAfterRemovingEntry() {
        when(entries.size()).thenReturn(0);
        tracker.remove(mock(TimeEntry.class));
        assertEquals(0, tracker.size());
    }

    @Test
    public void testSizeAfterClearingList() {
        when(entries.size()).thenReturn(0);
        entries.clear();
        assertEquals(0, tracker.size());
    }

    @Test(expected = NullPointerException.class)
    public void testSizeWhenListIsNull() {
        entries = null;
        tracker.size();
    }

    @Test
    public void testSizeWithLargeList() {
        when(entries.size()).thenReturn(10000);
        assertEquals(10000, tracker.size());
    }

    @Test
    public void testSizeWithConcurrentModifications() {
        when(entries.size()).thenReturn(5);
        new Thread(() -> tracker.add(mock(TimeEntry.class))).start();
        new Thread(() -> tracker.remove(mock(TimeEntry.class))).start();
        assertEquals(5, tracker.size());
    }

    @Test
    public void testSizeWithDuplicateEntries() {
        when(entries.size()).thenReturn(2);
        TimeEntry entry = mock(TimeEntry.class);
        tracker.add(entry);
        tracker.add(entry);
        assertEquals(2, tracker.size());
    }

    @Test
    public void testSizeWithEntryHavingNullValues() {
        when(entries.size()).thenReturn(1);
        TimeEntry entry = mock(TimeEntry.class);
        tracker.add(entry);
        assertEquals(1, tracker.size());
    }
}
