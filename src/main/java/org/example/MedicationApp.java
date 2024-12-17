package org.example;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * The main application class for managing medicines and their expiration dates.
 */
public final class MedicationApp {

	/**
	 * The entry point of the application.
	 *
	 * @param args command-line arguments (not used)
	 */
	public static void main(final String[] args){
		/**
		 * Creating a medicine object: Paracetamol.
		 * Adding an expiration date.
		 */
		final Medicine paracetamol = new Medicine("Paracetamol");
		paracetamol.addCardboard(new Cardboard(LocalDate.of(2024, 12, 1)));

		/**
		 * Creating a medicine object: Ibuprofen.
		 * Adding an expiration date.
		 */
		final Medicine ibuprofen = new Medicine("Ibuprofen");
		ibuprofen.addCardboard(new Cardboard(LocalDate.of(2024, 11, 15)));

		/**
		 * Creating a list of medicines and adding the created objects to the list.
		 */
		final List<Medicine> medicines = new ArrayList<>();
		medicines.add(paracetamol);
		medicines.add(ibuprofen);

		FileManager.saveFile(medicines);

		final List<Medicine> loadedMedicines = FileManager.loadFile();

		/**
		 * If data was successfully read, print it to the console.
		 */
		if (loadedMedicines != null) {
			for (final Medicine medicine : loadedMedicines) {
				System.out.println("Medicine Name: " + medicine.getName());

				/**
				 * Iterating through the packages of the medicine and printing expiration dates.
				 */
				for (final Cardboard pkg : medicine.getPackages()) {
					System.out.println("Expiration Date: " + pkg.expirationDate());
				}
			}
		}
	}
}
