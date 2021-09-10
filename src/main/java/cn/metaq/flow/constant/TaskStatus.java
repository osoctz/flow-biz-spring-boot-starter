package cn.metaq.flow.constant;

public enum TaskStatus {

    TODO(0),
    DONE(1);

    private Integer value;

    private TaskStatus(int value) {
        this.value=value;
    }

    public Integer value(){
        return this.value;
    }
}
