package ch.grundmann.calculator;

public class StampCard {

    private final String id;
    private Integer count;

    public StampCard(String id) {
        this.id = id;
        this.count = 0;
    }

    public StampCard(String id, Integer count) {
        this.id = id;
        this.count = count;
    }

    public String getId() {
        return id;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getCount() {
        return count;
    }
}
