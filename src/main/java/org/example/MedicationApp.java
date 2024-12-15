package org.example;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MedicationApp {
	public static void main(String[] args) {
		// Tworzenie obiektu leku Paracetamol
		Medicine paracetamol = new Medicine("Paracetamol");
		paracetamol.addCardboard(new Cardboard(LocalDate.of(2024, 12, 1)));

		// Tworzenie obiektu leku Ibuprofen
		Medicine ibuprofen = new Medicine("Ibuprofen");
		ibuprofen.addCardboard(new Cardboard(LocalDate.of(2024, 11, 15)));

		Medicine ibu = new Medicine("ibu");
		ibu.addCardboard(new Cardboard(LocalDate.of(2025, 1, 1)));

		Medicine ezz = new Medicine("ezz");
		ezz.addCardboard(new Cardboard(LocalDate.of(2025, 4, 4)));

		// Tworzenie listy obiektów `Medicine` i dodanie do niej leków
		List<Medicine> medicines = new ArrayList<>();

		medicines.add(paracetamol);
		medicines.add(ibuprofen);
		medicines.add(ibu);
		medicines.add(ezz);

		try {
			// Zapisywanie listy obiektów `Medicine` do pliku JSON
			FileManager.saveFile(medicines);

			// Odczytywanie listy obiektów `Medicine` z pliku JSON
			List<Medicine> loadedMedicines = FileManager.loadFile();

			// Jeśli dane zostały poprawnie odczytane, wypisanie ich na konsolę
			if (loadedMedicines != null) {
				for (Medicine medicine : loadedMedicines) {
					System.out.println("Nazwa leku: " + medicine.getName());

					// Iteracja po opakowaniach danego leku i wypisywanie dat ważności
					for (Cardboard pkg : medicine.getPackages()) {
						System.out.println("Data ważności: " + pkg.getExpirationDate());
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
