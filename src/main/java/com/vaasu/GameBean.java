package com.vaasu;

import com.vaasu.alternatives.GameAnnouncer;
import com.vaasu.interceptor.Logged;
import com.vaasu.model.GameProduct;
import com.vaasu.model.Product;
import com.vaasu.qualifiers.AddGame;
import com.vaasu.qualifiers.DeleteGame;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@RequestScoped
@Named
@Model
public class GameBean {
    private String name;
    private int price;
    private int quantityInStore;
    private String producerCompany;
    private String announcementMessage;

    @Inject
    private GameAnnouncer announcer;
    //Events of  game
    @Inject
    @AddGame
    private Event<Product> addGameProductEvent;

    @Inject
    @DeleteGame
    private Event<Product> deleteGameProductEvent;

    @Inject
    private GameManager gameService;

    @PostConstruct
    public void constructMessage() {
        announcementMessage = announcer.announce();
    }

    public String getAnnouncementMessage() {
        return announcementMessage;
    }

    public List<Product> getProduct() {
        return gameService.getProduct();
    }

    @Logged
    public void addGame() {
        Product product1 = new GameProduct(name,price,quantityInStore,producerCompany);
        addGameProductEvent.fire(product1);
    }
    @Logged
    public void deleteGame() {
        Product product1 = new GameProduct(name,price,quantityInStore,producerCompany);
        deleteGameProductEvent.fire(product1);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantityInStore() {
        return quantityInStore;
    }

    public void setQuantityInStore(int quantityInStore) {
        this.quantityInStore = quantityInStore;
    }

    public String getProducerCompany() {
        return producerCompany;
    }

    public void setProducerCompany(String producerCompany) {
        this.producerCompany = producerCompany;
    }
}

