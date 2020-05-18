package entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.security.InvalidParameterException;

@Data
@AllArgsConstructor
public class Product {
    private static VendingMachine vendingMachine = VendingMachine.getInstance();
    private String name;
    private double price;

    public void productTypeValidation(int shelfNumber, Product product) throws InvalidParameterException {
        Shelf shelfToWitchAdds = vendingMachine.getShelfsMap().get(shelfNumber);
        if (shelfToWitchAdds.getProduct() != null && !shelfToWitchAdds.getProduct().getName().equals(product.getName())) {
            throw new InvalidParameterException("Na półce jest już produkt innego typu. Nie można mieszać produktów na półkach");
        }
    }
}


