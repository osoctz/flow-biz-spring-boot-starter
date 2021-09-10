package cn.metaq.flow.constant;

public enum AssigneeType {

    USER(1),
    ROLE(2),
    ORG(3);

    private Integer value;

    private AssigneeType(int value) {
        this.value=value;
    }

    public Integer value(){
        return this.value;
    }
}
