package com.cs.main;

public class CreateThreadSafeSingleton {

}


// Using Synchronization
// https://javarevisited.blogspot.com/2011/06/volatile-keyword-java-example-tutorial.html
class Singleton {

    private volatile static Singleton _instance;

    private Singleton() {
        // preventing Singleton object instantiation from outside
    }

    /*
     * 1st version: creates multiple instance if two thread access
     * this method simultaneously
     */

    public static Singleton getInstance() {
        if (_instance == null) {
            _instance = new Singleton();
        }
        return _instance;
    }

    /*
     * 2nd version : this definitely thread-safe and only
     * creates one instance of Singleton on concurrent environment
     * but unnecessarily expensive due to cost of synchronization
     * at every call.
     */

    public static synchronized Singleton getInstanceTS() {
        if (_instance == null) {
            _instance = new Singleton();
        }
        return _instance;
    }

    /*
     * 3rd version : An implementation of double checked locking of Singleton.
     * Intention is to minimize cost of synchronization and  improve performance,
     * by only locking critical section of code, the code which creates
 instance of Singleton class.
     * By the way this is still broken, if we don't make _instance volatile,
 as another thread can
     * see a half initialized instance of Singleton.
     */

    public static Singleton getInstanceDC() {
        if (_instance == null) {
            synchronized (Singleton.class) {
                if (_instance == null) {
                    _instance = new Singleton();
                }
            }
        }
        return _instance;
    }
}






enum SingletonENUM{
    INSTANCE;
 
    public void show(){
        System.out.println("Singleton using Enum in Java");
    }
}

//SingletonENUM.INSTANCE.show()






class SingletonSTATIC{
    private static final SingletonSTATIC INSTANCE = new SingletonSTATIC();
 
    private SingletonSTATIC(){ }

    public static SingletonSTATIC getInstance(){
        return INSTANCE;
    }
}
