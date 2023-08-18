package ra.entity;

import jdk.jfr.Category;
import ra.IShop;

import java.util.List;
import java.util.Scanner;

public class Categories implements IShop {
    // Xây dựng 3 thuộc tính
    private int catalogId;
    private String catalogName;
    private float price;
    private boolean status;
    // Các constructor
    public Categories() {
    }
    public Categories(int catalogId, String catalogName, boolean status) {
        this.catalogId = catalogId;
        this.catalogName = catalogName;
        this.status = status;
    }
    // Phương thức getter / setter
    public int getCatalogId() {
        return catalogId;
    }
    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }
    public String getCatalogName() {
        return catalogName;
    }
    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }
    public boolean isStatus() {
        return status;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }

    // Phương thức kế thừa từ
    @Override
    public void inputData(Scanner scanner, List<Categories> categoriesList, List<Product> productList) {
        // Mã danh mục duy nhất
        System.out.print("Nhập vào mã danh mục sản phẩm : ");
        boolean checkCatalogId = true;
        do {
            this.catalogId = Integer.parseInt(scanner.nextLine());
            boolean isCatalogIdExist = false;
            for (Categories category: categoriesList) {
                if (category.catalogId == this.catalogId){
                    isCatalogIdExist = true;
                    break;
                }
            }
            if (isCatalogIdExist){
                System.err.println("Mã danh mục sản phẩm đã tồn tại, vui lòng nhập lại : ");
            }else {
                break;
            }
        }while (checkCatalogId);
        // Tên sản phẩm duy nhất
        System.out.print("Nhập vào tên danh mục sản phẩm : ");
        boolean checkCatalogName = true;
        do {
            this.catalogName = scanner.nextLine();
            boolean isCatalogNameExist = false;
            for (Categories category : categoriesList) {
                if (category.catalogName.equals(this.catalogName)){
                    isCatalogNameExist = true;
                    break;
                }
            }
            if (isCatalogNameExist){
                System.err.println("Tên danh mục đã tồn tại, vui lòng nhập lại : ");
            }else {
                break;
            }
        }while (checkCatalogName);

        System.out.print("Nhập vào trạng thái danh mục sản phẩm : ");
        status = Boolean.parseBoolean(scanner.nextLine());

    }
    @Override
    public void displayData() {
        System.out.printf("Mã danh mục sản phẩm : %d - Tên sản phẩm : %s - Trạng thái : %b\n",this.catalogId,this.catalogName,this.status);
    }
}
