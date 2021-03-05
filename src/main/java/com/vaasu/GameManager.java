package com.vaasu;

import com.vaasu.model.Product;

import java.util.List;

public interface GameManager {
    void add(Product product);

    List<Product> getProduct();

    void delete(Product product);

}
