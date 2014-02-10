package it.nibbles.test.exceptions;

/**
 *
 * @author Alessandro Polverini
 */
public class UserNotFoundException extends RuntimeException {

  public UserNotFoundException(String name) {
    super(name);
  }
}
