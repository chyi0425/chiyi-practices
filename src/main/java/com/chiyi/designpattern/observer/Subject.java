package com.chiyi.designpattern.observer;

/**
 * Created by 溢
 * subject  (publisher or be observer )
 */
public interface Subject {
    /**
     * register observer
     */
    void registerObserver(Observer observer);

    /**
     * remove observer
     */
    void removeObserver(Observer observer);

    /**
     * notify observers
     */
    void notifyObservers();
}
