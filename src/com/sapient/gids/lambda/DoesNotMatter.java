package com.sapient.gids.lambda;

import java.awt.event.ActionEvent;
import java.util.EventListener;

@FunctionalInterface
public interface DoesNotMatter extends EventListener{

	public void whatIsInTheName(ActionEvent argument);
	
}
