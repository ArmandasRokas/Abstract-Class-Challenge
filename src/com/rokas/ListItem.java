package com.rokas;

import java.util.List;

public abstract class ListItem {
    protected Object value;
    protected ListItem rightLink = null;
    protected ListItem leftLink = null;

    public ListItem(Object value){
        this.value = value;
    }

    abstract ListItem next();
    abstract ListItem setNext(ListItem item);
    abstract ListItem previous();
    abstract ListItem setPrevious(ListItem item);

    abstract int compareTo(ListItem item);

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
