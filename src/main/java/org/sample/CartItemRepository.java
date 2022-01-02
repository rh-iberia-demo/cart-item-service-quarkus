package org.sample;

import javax.enterprise.context.ApplicationScoped;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class CartItemRepository implements PanacheRepository<CartItem> {

    public void deleteById(String id){
        CartItem.deleteById(id);
    }

    public CartItem findById(String id) {
        return CartItem.findById(id);
    }

}
