package com.sapient.gids.lambda;

import javax.swing.event.EventListenerList;

public class MyButton {
	
	protected EventListenerList listenerList = new EventListenerList();
	
	public void addActionListener(DoesNotMatter dnm) {
		listenerList.add(DoesNotMatter.class, dnm);
	}

}
