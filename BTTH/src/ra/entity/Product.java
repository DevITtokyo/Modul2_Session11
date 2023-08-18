package ra.entity;

import ra.IShop;

import java.util.List;
import java.util.Scanner;

public class Product implements IShop {
    private String productId;
    private String productName;
    private float price;
    private String title;
    private int catalogId;
    private boolean statusProduct;
    // Các phương thức
    public Product() {
    }
    public Product(String productId, String productName, float price, String title, int catalogId, boolean statusProduct) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.title = title;
        this.catalogId = catalogId;
        this.statusProduct = statusProduct;
    }
    // Getter and Setter
    public String getProductId() {
        return productId;
    }
    public void setProductId(String productId) {
        this.productId = productId;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        this.price = price;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public int getCatalogId() {
        return catalogId;
    }
    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }
    public boolean isStatusProduct() {
        return statusProduct;
    }
    public void setStatus(boolean statusProduct) {
        this.statusProduct = statusProduct;
    }
    // Phương thức kế thừa từ Interface

    @Override
    public void inputData(Scanner scanner, List<Categories> categoriesList, List<Product> productList) {
        // Validate : mã sản phẩm gồm 5 ký tự bắt đầu là P , duy nhất
        System.out.print("Nhập vào mã sản phẩm : ");
        boolean checkProductId = true;
        do {
            this.productId = scanner.nextLine();
            boolean isProductIdExist = false;
            for (Product product : productList)
                if (product.productId.equals(this.productId)) {
                    isProductIdExist = true;
                    break;
                }
            if (isProductIdExist) {
                System.err.println("Mã sản phẩm đã tồn tại vui lòng nhập lại : ");
            } else {
                if (this.productId.length() == 5) {
                    if (this.productId.startsWith("P")) {
                        break;
                    } else {
                        System.err.println(" Mã sản phẩm bắt đầu là P, vui lòng nhập lại");
                    }
                } else {
                    System.err.println(" Mã sản phẩm gồm 5 ký tự, vui lòng nhập lại");
                }
            }
        } while (checkProductId);
        // Validate : tên sản phẩm duy nhất
        System.out.print("Nhập vào tên sản phẩm ");
        boolean checkProductName = true;
        do {
            this.productName = scanner.nextLine();
            boolean isProductNameExist = false;
            for (Product product : productList) {
                if (product.productName.equals(this.productName)) {
                    isProductNameExist = true;
                    break;
                }
            }
            if (isProductNameExist) {
                System.err.println("Tên sản phẩm đã tồn tại vui lòng nhập lại : ");
            } else {
                break;
            }
        }while (checkProductName) ;
        System.out.print("Nhập vào giá sản phẩm : ");
        this.price = Float.parseFloat(scanner.nextLine());
        System.out.print("Nhập vào tiêu đề sản phẩm : ");
        this.title = scanner.nextLine();
        System.out.print("Nhập vào trạng thái sản phẩm : ");
        this.statusProduct = Boolean.parseBoolean(scanner.nextLine());
    }

    @Override
    public void displayData() {
        System.out.printf("Mã sản phẩm: %s - Tên sản phẩm: %s - Giá sản phẩm: %f\n", this.productId, this.productName, this.price);
        System.out.printf("Tiều đề sản phẩm: %s - Mã danh mục mà sản phẩm thuộc về: %d - Trạng thái sản phẩm: %b\n",this.title,this.catalogId,this.statusProduct);
    }
}
