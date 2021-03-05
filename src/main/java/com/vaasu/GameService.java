package com.vaasu;

import com.vaasu.model.GameProduct;
import com.vaasu.model.Product;
import com.vaasu.qualifiers.AddGame;
import com.vaasu.qualifiers.DeleteGame;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class GameService implements GameManager {
    private List<Product> games;

    public List<Product> getGames() {
        return games;
    }

    @PostConstruct
    public void addGame() {
        games = new ArrayList<>();
        games.add(new GameProduct("GTA SanAndreas", 50, 500,"Rockstar Games Limited"));
    }
    @Override
    public List<Product> getProduct()
    {
        return games;
    }

    @Override
    public void delete(@Observes @DeleteGame Product product) { // Delete Product

        Product deletedGame = games.stream().filter(game ->
                game.getName().equals(product.getName())).findFirst().orElse(null);
        games.remove(deletedGame);
    }

    @Override
    public void add(@Observes  @AddGame Product product) {
        Product checkProduct = games.stream().filter(game ->
                game.getName().equals(product.getName()))
                .findFirst().orElse(null);

        if (games.contains(checkProduct)) {
            int newQty = checkProduct.getQuantityInStore() + 1; // Increment by one

            product.setQuantityInStore(newQty);

            product.setProducerCompany(checkProduct.getProducerCompany());

            product.setPrice(checkProduct.getPrice());  // Set Product Price

            games.remove(checkProduct); // Remove product by name

            games.add(product); // Add a Product
        }
        else {
            product.setQuantityInStore(1);
            games.add(product);
        }
    }



}
