import { Historico } from "./pages/historicoCompras"
import { Sobre } from "./pages/Sobre"
import { CartProvider } from './context/CartContext';
import React from 'react';
import { Cadastro } from './pages/cadastro';
import { ProductDetails } from './pages/ProductDetails';
import { Login } from './pages/Login';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import { Home } from './pages/home';
import { Cart } from './pages/Cart';
import { NotFound } from "./pages/NotFound";
import { HeaderGeral} from "./components/HeaderGeral";

export const App = () => {
  return (
    <CartProvider>
      <BrowserRouter>
       <HeaderGeral/>
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/home" element={<Home />} />
          <Route path="/login" element={<Login />} />
          <Route path="/products/:id" element={<ProductDetails />} />
          <Route path="/cart" element={<Cart />} />
          <Route path="/cadastro" element={<Cadastro />} />
          <Route path="/historico" element={<Historico />} />
          <Route path="/sobre" element={<Sobre />} />
          <Route path="*" element={<NotFound />} />
        </Routes>
      </BrowserRouter>
    </CartProvider>
  );
}