package ra;

import jdk.jfr.Category;
import ra.entity.Categories;
import ra.entity.Product;

import java.util.List;
import java.util.Scanner;

public interface IShop {
    // Phương thức kế thừa từ
    void inputData(Scanner scanner, List<Categories> categoriesList, List<Product> productList);
    void displayData();
}
