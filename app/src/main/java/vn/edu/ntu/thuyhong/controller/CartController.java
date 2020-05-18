package vn.edu.ntu.thuyhong.controller;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

import vn.edu.ntu.thuyhong.controller.ICartController;
import vn.edu.ntu.thuyhong.model.Product;

public class CartController extends Application implements ICartController {
    List<Product> listProducts = new ArrayList<>();

    public CartController() {
        listProducts.add(new Product("Khoai lang", 24000, "Khoai lang theo tiêu chuẩn VietGap"));
        listProducts.add(new Product("Khoai sọ", 25000, "Khoai lang trồng tại Khánh Hòa"));
        listProducts.add(new Product("Khoai mía", 22000, "Khoai lang trồng tại Ninh Thuận"));
        listProducts.add(new Product("Sầu riêng", 72000, "Sầu riêng trồng tại Bình Thuận"));
        listProducts.add(new Product("Cam", 79000, "Cam trồng tại Khánh Vĩnh"));
        listProducts.add(new Product("Táo", 99000, "Táo trồng tại Khánh Sơn"));
    }

    @Override
    public List<Product> getAllProduct() {
        return listProducts;
    }
}
