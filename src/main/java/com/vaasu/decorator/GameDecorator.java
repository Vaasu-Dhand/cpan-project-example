package com.vaasu.decorator;

import com.vaasu.GameManager;
import com.vaasu.GameService;
import com.vaasu.model.Product;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;
import java.util.List;

@Decorator
public class GameDecorator implements GameManager {
    @Inject
    @Delegate
    private GameService gameServiceVar;

    @Override
    public void add(Product product) {
        gameServiceVar.add(product);
    }

    @Override
    public List<Product> getProduct() {
        return gameServiceVar.getProduct();
    }

    @Override
    public void delete(Product product) {
        gameServiceVar.delete(product);
    }
}
