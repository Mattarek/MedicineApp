package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a medicine with a name and associated packages.
 */
public class Medicine {

	/**
	 * The name of the medicine.
	 */
	private final String name;

	/**
	 * A list of packages associated with the medicine.
	 */
	private final List<Cardboard> packages = new ArrayList<>();

	/**
	 * Constructs a Medicine object with the given name.
	 *
	 * @param name the name of the medicine
	 */
	public Medicine(final String name) {
		this.name = name;
	}

	/**
	 * Retrieves the name of the medicine.
	 *
	 * @return the name of the medicine
	 */
	public String getName() {
		return name;
	}

	/**
	 * Retrieves the list of packages associated with the medicine.
	 *
	 * @return the list of packages
	 */
	public List<Cardboard> getPackages() {
		return packages;
	}

	/**
	 * Adds a package to the list of packages.
	 *
	 * @param packageForMedicine the package to add
	 */
	public void addCardboard(final Cardboard packageForMedicine) {
		packages.add(packageForMedicine);
	}
}
