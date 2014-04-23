package com.sapient.gids.lambda;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.function.Consumer;

public class Main {
	
	@SuppressWarnings("unused")
	public void usage() {
		
		Runnable runnable = () -> System.out.println(this);	
		
		ActionListener actionListener = event -> System.out.println("Clicked");
		
		Comparator<String> lengthComparator = (first, second) -> {
			return first.length() - second.length();
		};
		
		 Consumer<String> b = s -> System.out.println(s);
	}
	
	@SuppressWarnings("unused")
	public void uniqueBehaviour() {		
		ActionListener actionListener = (ActionEvent event) -> System.out.println("Clicked");
		DoesNotMatter doesNotMatter = (ActionEvent event) -> System.out.println("Clicked");		
	}
	
	public void streamExample() throws IOException {
		Files.list(Paths.get(".")).map(Path::getFileName).map(Path::toString).filter(name -> name.endsWith(".java")).sorted().limit(5).forEach(System.out::println);
	}

}
