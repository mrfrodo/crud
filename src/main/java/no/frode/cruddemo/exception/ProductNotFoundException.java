package no.frode.cruddemo.exception;

/**
 *
 * Exception trown when product is not in the database.
 *
 */
public class ProductNotFoundException  extends RuntimeException {

    public ProductNotFoundException(Long id) {
            super("Could not find product with id : " + id);
    }
}

