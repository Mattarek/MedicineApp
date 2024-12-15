package org.example;

import java.time.LocalDate;

public class Cardboard {
	// Data ważności pakietu.
	private LocalDate expirationDate;

	// Konstruktor do tworzenia obiektu Package z datą ważności.
	public Cardboard(LocalDate expirationDate) {
		this.expirationDate = expirationDate;
	}

	// Getter do pobierania daty ważności pakietu.
	public LocalDate getExpirationDate() {
		return expirationDate;
	}
}
