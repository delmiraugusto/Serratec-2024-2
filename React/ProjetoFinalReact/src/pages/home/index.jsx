import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';
import { CategorySelector } from '../../components/CategorySelector';

import { ProductCard } from '../../components/ProductCard';
import { fetchProducts } from '../../servicesAPI';
import {
  SearchContainer,
  Container,
  ProductsContainer,
  SearchInput,
  StyledLink,
  Image
} from './style';
export const Home = () => {
  const [selectedCategory, setSelectedCategory] = useState('Todos');
  const [searchTerm, setSearchTerm] = useState('');
  const [products, setProducts] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  const handleCategoryChange = (category) => setSelectedCategory(category);

  const handleSearchChange = (event) => setSearchTerm(event.target.value);

  const loadAPI = async () => {
    setLoading(true);
    setError(null);
    const response = await fetchProducts();
    if (response.status === 200) {
      setProducts(response.data);
    } else {
      console.error('Erro ao buscar produtos', response);
    }
    setLoading(false);
  };

  useEffect(() => {
    loadAPI();
  }, []);

  const filteredProducts = products.filter(
    (product) =>
      (selectedCategory === 'Todos' || product.category === selectedCategory) &&
      product.name.toLowerCase().includes(searchTerm.toLowerCase())
  );

  return (
    <Container>
      <SearchContainer>
        <SearchInput
          type="text"
          placeholder="Buscar produtos..."
          value={searchTerm}
          onChange={handleSearchChange}
          aria-labels="Buscar produtos"
        />
      </SearchContainer>
      <CategorySelector onCategoryChange={handleCategoryChange} />
      <section aria-live="polite">
        <h2>Produtos</h2>
        {loading ? (
          <p aria-live='assertive'>Carregando Produtos...</p>
        ) : error ? (
          <p>{error}</p>
        ) : (
          <ProductsContainer>
            {loading ? (
              <p>Carregando produtos...</p>
            ) : error ? (
              <p>{error}</p>
            ) : (
              filteredProducts.map((product) => (
                <ProductCard
                  key={product.id}
                  product={product}
                />
              ))
            )}
          </ProductsContainer>
        )}
      </section>
    </Container>
  );
};
