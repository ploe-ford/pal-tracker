package io.pivotal.pal.tracker;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TimeEntryController {

    private TimeEntryRepository timeEntryRepository;

    public TimeEntryController(TimeEntryRepository timeEntryRepository) {
        this.timeEntryRepository = timeEntryRepository;
    }

    @PostMapping(value = "/time-entries")
    public ResponseEntity<TimeEntry> create(@RequestBody TimeEntry timeEntryToCreate) {
        return new ResponseEntity(timeEntryRepository.create(timeEntryToCreate), HttpStatus.CREATED);
    }

    @GetMapping(value = "/time-entries/{id}")
    public ResponseEntity<TimeEntry> read(@PathVariable Long id) {
        TimeEntry timeEntry = timeEntryRepository.find(id);
        if (timeEntry != null)
            return new ResponseEntity(timeEntry, HttpStatus.OK);
        else
            return new ResponseEntity(timeEntry, HttpStatus.NOT_FOUND);
    }

    @GetMapping(path = "/time-entries")
    public ResponseEntity<List<TimeEntry>> list() {
        return new ResponseEntity(timeEntryRepository.list(), HttpStatus.OK);
    }

    @PutMapping(value = "/time-entries/{id}")
    public ResponseEntity update(@PathVariable Long id,
                                 @RequestBody TimeEntry expected) {
        TimeEntry timeEntry = timeEntryRepository.update(id, expected);
        if (timeEntry != null)
            return new ResponseEntity(timeEntry, HttpStatus.OK);
        else
            return new ResponseEntity(timeEntry, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/time-entries/{id}")
    public ResponseEntity<TimeEntry> delete(@PathVariable Long id) {
        TimeEntry timeEntry = timeEntryRepository.delete(id);
        if (timeEntry != null)
            return new ResponseEntity(timeEntry, HttpStatus.NO_CONTENT);
        else
            return new ResponseEntity(timeEntry, HttpStatus.NO_CONTENT);
    }
}
