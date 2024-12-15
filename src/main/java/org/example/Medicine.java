package org.example;

import java.util.ArrayList;
import java.util.List;

public class Medicine {
	// Nazwa leku.
	private String name;

	// Lista pakietów powiązanych z lekiem.
	private List<Cardboard> packages;

	// Konstruktor do tworzenia obiektu Medicine z nazwą leku.
	public Medicine(String name) {
		this.name = name;
		this.packages = new ArrayList<>();
	}

	// Getter do pobierania nazwy leku.
	public String getName() {
		return this.name;
	}

	// Getter do pobierania listy pakietów.
	public List<Cardboard> getPackages() {
		return this.packages;
	}

	// Metoda do dodawania pakietu do listy.
	public void addCardboard(Cardboard packageForMedicine) {
		packages.add(packageForMedicine);
	}
}
