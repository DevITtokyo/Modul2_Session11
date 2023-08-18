package ra.run;

import ra.entity.Categories;
import ra.entity.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShopManagement {
    static List<Categories> categoriesList = new ArrayList<>();
    static List<Product> productList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
       do {
           System.out.println("*************************SHOP MANAGEMENT***************");
           System.out.println("1. Quản lý danh mục sản phẩm");
           System.out.println("2. Quản lý sản phẩm");
           System.out.println("3. Thoát");
           System.out.print("Sự lựa chọn của bạn là : ");
           int choice = Integer.parseInt(scanner.nextLine());
           switch (choice){
               case 1:
                   ShopManagement.catalogManagement(scanner);
                   break;
               case 2:
                   ShopManagement.productManagement(scanner);
                   break;
               case 3:
                   System.exit(0);
                   break;
               default:
                   System.err.println("Vui lòng chọn từ 1-3");
           }
       }while (true);
    }
    // Hiển thị danh mục quản lý danh mục
    public static void catalogManagement(Scanner scanner){
        do {
            System.out.println("***************** CATALOG MANAGEMENT**************");
            System.out.println("1. Thêm mới danh mục");
            System.out.println("2. Hiển thị thông tin các danh mục");
            System.out.println("3. Cập nhật tên danh mục theo mã danh mục");
            System.out.println("4. Xóa danh mục theo mã danh mục (Danh mục chưa chứa sản phẩm)");
            System.out.println("5. Thoát (Quay lại Shop Management)");
            System.out.println("Sự lựa chọn của bạn là : ");
            int choiceCatalog = Integer.parseInt(scanner.nextLine());
            switch (choiceCatalog){
                case 1:
                    ShopManagement.addCategory();
                    break;
                case 2:
                    ShopManagement.displayCategory();
                    break;
                case 3:
                    ShopManagement.updateCategory();
                    break;
                case 4:
                    ShopManagement.deleteCategory();
                    break;
                case 5:
                    return;
                default:
                    System.err.println("Vui lòng chọn từ 1-5");
            }
        }while (true);
    }
    // 1. Phương thức thêm mới danh mục
    public static void addCategory(){
        Categories category = new Categories();
        category.inputData(scanner, categoriesList, productList);
        categoriesList.add(category);
        System.out.println("Danh mục mới đã được thêm vào");
    }
    // 2. Phương thức hiển thị danh mục
    public static void displayCategory(){
        System.out.println("Danh sách các mục sản phẩm : ");
        for (Categories category : categoriesList) {
            category.displayData();
            System.out.println("--------------------------------");
        }
    }
    // 3. Phương thức cập nhật danh mục theo mã danh mục
    public static void updateCategory(){
        System.out.print("Nhập mã danh mục cần cập nhật : ");
        int catalogId = Integer.parseInt(scanner.nextLine());
        for (Categories category : categoriesList) {
            if (category.getCatalogId()==catalogId){
                System.out.print("Nhập tên danh mục mới : ");
                String newName = scanner.nextLine();
                // Cập nhật tên danh mục mới
                category.setCatalogName(newName);
                System.out.println("Tên danh mục đã được cập nhật");
                return;
            }
        }
        System.err.println("Không tìm thấy danh mục nào có mã : " + catalogId);
    }
    // 4. Phương thức Xóa danh mục theo mã danh mục (Danh mục chưa chứa sản phẩm)
    public static void deleteCategory(){
        System.out.print("Nhập vào mã danh mục cần xoá : ");
        int catalogId = Integer.parseInt(scanner.nextLine());
        // Tìm danh mục theo mã
        Categories categoryToDelete = null;
        for (Categories category : categoriesList) {
            if (category.getCatalogId()==catalogId){
                categoryToDelete = category;
                break;
            }
        }
        // Nếu tìm thấy danh mục và danh mục k chứa sản phẩm => xoá
        if (categoryToDelete != null && !hasProductInCategory(categoryToDelete.getCatalogId())){
            categoriesList.remove(categoryToDelete);
            System.out.println("Danh mục đã được xoá");
        } else if (categoryToDelete != null) {
            System.out.println("Danh mục vẫn chứa sản phẩm, không thể xoá");
        }else {
            System.out.println("Không tìm thấy danh mục nào có mã : " + catalogId);
        }
    }
    // Phương thức kiểm tra danh mục có chứa sản phẩm hay không
    public static boolean hasProductInCategory (int catalogId){
        for (Product product : productList) {
            if (product.getCatalogId() == catalogId){
                return true;
            }
        }
        return false;
    }

    // Hiển thị danh mục quản lý sản phẩm
    public  static void productManagement(Scanner scanner){
        do {
            System.out.println("***************** PRODUCT MANAGEMENT**************");
            System.out.println("1. Thêm mới sản phẩm");
            System.out.println("2. Hiển thị thông tin sản phẩm");
            System.out.println("3. Cập nhật giá sản phẩm theo mã sản phẩm");
            System.out.println("4. Xóa sản phẩm theo mã sản phẩm");
            System.out.println("5. Sắp xếp sản phẩm theo giá sản phẩm tăng dần");
            System.out.println("6. Sắp xếp sản phẩm theo tên tăng dần");
            System.out.println("7. Thống kê số lượng sản phẩm theo danh mục sản phẩm");
            System.out.println("8. Tìm kiếm sản phẩm theo tên sản phẩm");
            System.out.println("9. Thoát (Quay lại Shop Management)");
            System.out.print("Sự lựa chọn của bạn là : ");
            int choiceProduct = Integer.parseInt(scanner.nextLine());
            switch (choiceProduct){
                case 1:
                    ShopManagement.addProduct();
                    break;
                case 2:
                    ShopManagement.displayProduct();
                    break;
                case 3:
                    ShopManagement.updatePrice();
                    break;
                case 4:
                    ShopManagement.deleteProduct();
                    break;
                case 5:
                    ShopManagement.sortProductByPrice();
                    break;
                case 6:
                    ShopManagement.sortProductByName();
                    break;
                case 7:
                    ShopManagement.countProductByCategory();
                    break;
                case 8:
                    ShopManagement.searchProductByName();
                    break;
                case 9:
                    return;
                default:
                    System.err.println("Vui lòng chọn từ 1-9");
            }
        }while (true);
    }

    // 1. Phương thức thêm mới sản phảm
    public static void addProduct(){
        Product product = new Product();
        product.inputData(scanner, categoriesList, productList);
        for (int i = 0; i < categoriesList.size(); i++) {
            System.out.printf("%d. %s\n",i+1,categoriesList.get(i).getCatalogName());
        }
        System.out.println("Chọn danh mục: ");
        int choiceCatalog = Integer.parseInt(scanner.nextLine());
        int catalogIdChoice = categoriesList.get(choiceCatalog-1).getCatalogId();
        product.setCatalogId(catalogIdChoice);
        productList.add(product);
        System.out.println("Sản phẩm mới đã được thêm vào");
    }
    // 2. Phương thưc hiển thị sản phẩm
    public static void displayProduct(){
        System.out.println("Danh sách các sản phẩm");
        for (Product product : productList) {
            product.displayData();
            System.out.println("-----------------------------------------");
        }
    }
    // 3.Phương thức Cập nhật giá sản phẩm theo mã sản phẩm
    public static void updatePrice(){
        System.out.println("Nhập vào mã sản phẩm cần cập nhật");
        String procductId = scanner.nextLine();
        // Tìm sản phẩm theo mã
        Product productToUpdate = findProductById(procductId);
        if (productToUpdate != null){
            System.out.println("Nhập giá mới cho danh mục cần cập nhập");
            float newPrice = Float.parseFloat(scanner.nextLine());
            System.out.println("Giá sản phẩm đã được cập nhật");
        }else {
            System.out.println("Không tìm thấy sản phẩm nào có mã " + procductId);
        }
    }
    // Phương thức tìm sản phẩm theo mã
    public static Product findProductById(String productId){
        for (Product product : productList) {
            if (product.getProductId().equals(productId)){
                return product;
            }
        }
        return null;
    }
    // 4. Phương thức xoá sản phẩm theo mã sản phẩm
    public static void deleteProduct(){
        System.out.println("Nhập mã sản phẩm cần xoá");
        String productId = scanner.nextLine();
        // Tìm sản phẩm theo mã
        Product productToDelete = findProductById(productId);
        if (productToDelete != null){
            productList.remove(productToDelete);
            System.out.println("Sản phẩm đã được xoá");
        }else{
            System.out.println("Không tìm thấy sản phẩm có mã " + productId);
        }
    }
    // 5. Phương thức Sắp xếp sản phẩm theo giá sản phẩm tăng dần
    public static void sortProductByPrice() {
        productList.sort((product1, product2 ) -> {
            if (product1.getPrice() < product2.getPrice()){
                return -1;
            } else if (product1.getPrice() > product2.getPrice())  {
                return 1;
            }
            // vị trí tương đối của hai sản phẩm trong danh sách không thay đổi sau khi sắp xếp.
            return 0;
        });
        System.out.println("Danh sách đã được sắp xếp theo giá tăng dần");
        for (Product product : productList) {
            product.displayData();
            System.out.println("-----------------------------------------");
        }
    }
    // 6. Phương thức sắp xếp danh sách sản phẩm theo tên
    public static void sortProductByName(){
        int n = productList.size();
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j <n-1 ; j++) {
                Product product1 = productList.get(j);
                Product product2 = productList.get(j+1);
                if (product1.getProductName().compareTo(product2.getProductName()) >0 ){
                    Product temp = productList.get(j);
                    productList.set(j, productList.get(j+1));
                    productList.set(j+1, temp);
                }
            }
        }
        System.out.println("Danh sách sản phẩm đã được sắp xếp theo tên : ");
        for (Product product : productList) {
            product.displayData();
            System.out.println("----------------------------------------");
        }
    }
    // 7. Thống kê số lượng sản phẩm theo danh mục sản phẩm
    public static void countProductByCategory(){
        //  Tạo mảng để lưu số lượng sản phẩm theo mã danh mục
        int[] categoryCount = new int[1000];
        for (Product product : productList) {
            int catalogId = product.getCatalogId();
            categoryCount[catalogId]++;
        }
        System.out.println("Thống kê số lượng sản phẩm theo danh mục sản phẩm : ");
        for (int catalogId = 1; catalogId < categoryCount.length; catalogId++) {
            int productCount = categoryCount[catalogId];
            if (productCount > 0){
                System.out.println("Danh mục " + catalogId + " : " + productCount + " sản phẩm ");
            }
        }
    }
    // 8. Tìm kiếm sản phẩm theo tên sản phẩm
    public static void searchProductByName(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập tên sản phẩm cần tìm : ");
        String searchName = scanner.nextLine();
        boolean isExist = false;
        for (Product product : productList) {
            if (product.getProductName().equalsIgnoreCase(searchName)){
                product.displayData();
                isExist = true;
            }
        }
        if (!isExist){
            System.err.println("Không tìm thấy sản phẩm có tên : " + searchName);
        }
    }
}
