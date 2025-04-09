import React, { createContext, useState } from 'react';

export const CartContext = createContext();

export const CartProvider = ({ children }) => {
    const [cart, setCart] = useState([]);

    const addToCart = (product, quantity) => {
        setCart((prevCart) => {
            const existingItem = prevCart.find((item) => item.product.id === product.id);

            if (existingItem) {
                return prevCart.map((item) =>
                    item.product.id === product.id
                        ? { ...item, quantity: item.quantity + quantity }
                        : item
                );
            }

            return [...prevCart, { product, quantity }];
        });
    };

    const removeFromCart = (product) => {
        setCart((prevCart) => {
            const existingItem = prevCart.find((item) => item.product.id === product.id);

            if (existingItem) {
                if (existingItem.quantity > 1) {
                    return prevCart.map((item) =>
                        item.product.id === product.id
                            ? { ...item, quantity: item.quantity - 1 }
                            : item
                    );
                } else {
                    return prevCart.filter((item) => item.product.id !== product.id);
                }
            }

            return prevCart;
        });
    };

    return (
        <CartContext.Provider value={{ cart, addToCart, removeFromCart }}>
            {children}
        </CartContext.Provider>
    );
};
