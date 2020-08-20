/*
 * Steps for Creating a Singleton.
 * 
 *  First. Declare private the constructor
 *  Second. Declare a static method, and return the static member
 * 	Third. Declare a static member of the same class, and initialize it
 * 	
 * 	Eager initialization
 * 	Initializing before the instance is invoked.
 *
 * 	Alternative to initialize the instance.
 * 	- Static Blocks: 
 * 		static {
 *			instance = new DateUtil();
 * 		}		
 * 
 *  Multithreading could create more than 2 instances,
 *  that's why we have to safe our singleton with synchronized.
 *  
 *  The Serializable makes the objects of the class returned to a stream. 
 *  
 *  Cloneable to make sure that the Objects are not cloneable.
 */

package com.patterns.java.singleton;

import java.io.Serializable;

public class DateUtil implements Serializable, Cloneable {

	private static final long serialVersionUID = 1L;
	private static volatile DateUtil instance; // Third

	private DateUtil() {
	} // First

	public static DateUtil getInstance() {

		if (instance == null) {
			// Class level lock
			synchronized (DateUtil.class) {
				if (instance == null) {
					instance = new DateUtil();
				}
			}
		}

		return instance; // Second
	}

	protected Object readResolve() {
		return instance;
	} // The readResolve needs to use the same instance, and not create a new one.

	@Override
	protected Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	} // We don't want our singleton classes to be cloned.
}

/*
 * E.g. Logger
 * 
 * package com.patterns.java.singleton;
 * 
 * import java.io.Serializable;
 * 
 * public class Logger implements Serializable, Cloneable {
 * 
 * private static final long serialVersionUID = 1L; private static volatile
 * Logger instance;
 * 
 * private Logger() { }
 * 
 * public static Logger getLogger() { if (instance == null) { synchronized
 * (Logger.class) { if (instance == null) { instance = new Logger(); } } }
 * return instance; }
 * 
 * protected void log(String message) { System.out.println(message); }
 * 
 * protected Object readResolve() { return instance; }
 * 
 * @Override protected Object clone() throws CloneNotSupportedException { throw
 * new CloneNotSupportedException(); } }
 */
