package com.niit.gadget.service;

import com.niit.gadget.model.Cart;

public interface CartService {

    Cart getCartById(int cartId);

    void update(Cart cart);
}
