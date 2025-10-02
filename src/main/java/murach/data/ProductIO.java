package murach.data;

import java.io.*;
import java.util.*;
import murach.business.Product;

public class ProductIO {
    public static List<Product> getProducts(String path) {
        List<Product> products = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = in.readLine()) != null) {
                String[] columns = line.split("\\|");
                if (columns.length >= 3) {
                    String code = columns[0];
                    String description = columns[1];
                    double price = Double.parseDouble(columns[2]);

                    Product p = new Product(code, description, price);
                    products.add(p);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading products file: " + e);
        }
        return products;
    }

    public static Product getProduct(String code, String path) {
        List<Product> products = getProducts(path);
        for (Product p : products) {
            if (p.getCode().equals(code)) {
                return p;
            }
        }
        return null;
    }
}
