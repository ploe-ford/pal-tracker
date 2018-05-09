package io.pivotal.pal.tracker;

public class IdGenerator {
    private static IdGenerator ourInstance = new IdGenerator();

    private long id = 0L;

    public static IdGenerator getInstance() {
        return ourInstance;
    }

    private IdGenerator() {
    }
    public Long getId() {
        this.id++;
        return id;
    }
    public void reset(){
        this.id=0L;
    }
}
