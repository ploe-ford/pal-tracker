package io.pivotal.pal.tracker;

import java.util.*;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {

    Map<Long,TimeEntry> map = new HashMap<>();
    public InMemoryTimeEntryRepository() {
        IdGenerator.getInstance().reset();
    }

    public TimeEntry create(TimeEntry timeEntry) {
        map.put(timeEntry.getId(), timeEntry);
        return timeEntry;
    }

    public TimeEntry find(Long id) {
       return map.get(id);
    }

    public List<TimeEntry> list() {
        return new ArrayList<>(map.values());
    }

    public TimeEntry update(Long lookupId, TimeEntry timeEntry) {
        timeEntry.setId(lookupId);
        map.put(lookupId, timeEntry);
        return timeEntry;
    }

    public TimeEntry delete(Long id) {
        return map.remove(id);
    }
}
