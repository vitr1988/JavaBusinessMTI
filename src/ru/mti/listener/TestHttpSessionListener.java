package ru.mti.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * Application Lifecycle Listener implementation class TestHttpSessionListener
 *
 */
@WebListener
public class TestHttpSessionListener implements HttpSessionAttributeListener {

  
	/**
     * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
     */
    public void attributeAdded(HttpSessionBindingEvent arg0)  { 
    	System.out.println("Attribute '" + arg0.getName() + "' was added to session with value '" + arg0.getValue() + "'");
    }

	/**
     * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
     */
    public void attributeRemoved(HttpSessionBindingEvent arg0)  { 
         System.out.println("Attribute '" + arg0.getName() + "' was removed from session");
    }

	/**
     * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
     */
    public void attributeReplaced(HttpSessionBindingEvent arg0)  { 
    	System.out.println("Attribute '" + arg0.getName() + "' was replaced in session with value '" + arg0.getValue() + "'");
    }
	
}
