package com.rokas;

public class MyLinkedList implements NodeList {

    private ListItem root = null;

    public MyLinkedList(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return this.root;
    }

    @Override
    public boolean addItem(ListItem newItem) {
        if (this.root == null){
            this.root = newItem;
            return true;
        }

        ListItem currentItem = this.root;
        while(currentItem != null){
            int comparison = currentItem.compareTo(newItem);
            if (comparison < 0){
                if(currentItem.next() != null){
                    currentItem = currentItem.next();
                } else {
                    currentItem.setNext(newItem);
                    newItem.setPrevious(currentItem);
                    return true;
                }
            } else if (comparison > 0){
                if (currentItem.previous() != null){
                    currentItem.previous().setNext(newItem);
                    newItem.setPrevious(currentItem.previous());
                    newItem.setNext(currentItem);
                    currentItem.setPrevious(newItem);
                } else {
                    newItem.setNext(this.root);
                    this.root.setPrevious(newItem);
                    this.root = newItem;
                }
                return true;

            } else {
                System.out.println(newItem.getValue() + " is already present, not added");
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean removeItem(ListItem item) {
        if (item != null){
            System.out.println("Deleting item: " + item.getValue());
        } else {
            System.out.println("Deleting error. Item null.");
            return false;
        }
        ListItem currentItem = this.root;
        while (currentItem != null){
            int comparison = currentItem.compareTo(item);
            if ( comparison == 0) {
                if (currentItem == this.root){
                    if(currentItem.next() != null){
                        this.root = currentItem.next();
                        currentItem.next().setPrevious(null);
                        return true;
                    } else {
                        this.root = null;
                        return true;
                    }
                } else if(currentItem.next() == null){
                    currentItem.previous().setNext(null);
                    return true;

                } else {
                    currentItem.previous().setNext(currentItem.next());
                    currentItem.next().setPrevious(currentItem.previous());
                    return true;
                }
            } else {
                currentItem = currentItem.next();
            }
        }
        return false;
    }

    @Override
    public void traverse(ListItem currentValue) {
        if(currentValue == null){
            System.out.println("The list is empty");
        } else {
            while (currentValue != null){
                System.out.println(currentValue.getValue());
                currentValue = currentValue.next();
            }
        }
    }
}
