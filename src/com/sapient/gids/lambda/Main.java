package com.sapient.gids.lambda;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Main {

	public static void main(String[] args) {
		JButton button = new JButton();
		MyButton myButton = new MyButton();
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Clicked");
				
			}
		});
		button.addActionListener(event -> System.out.println("Clicked"));
		myButton.addActionListener(new DoesNotMatter() {
			
			@Override
			public void whatIsInTheName(ActionEvent argument) {
				System.out.println("Clicked");
				
			}
		});
		myButton.addActionListener(event -> System.out.println("Clicked"));
		
		ActionListener actionListener = (ActionEvent event) -> System.out.println("Clicked");
		DoesNotMatter doesNotMatter = (ActionEvent event) -> System.out.println("Clicked");
	}

}
