package org.example;

import java.time.LocalDate;

/**
 * Represents a cardboard package with an expiration date.
 *
 * @param expirationDate The expiration date of the package.
 */
public record Cardboard(LocalDate expirationDate) {

}
