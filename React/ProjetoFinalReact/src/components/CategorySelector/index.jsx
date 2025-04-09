import React from 'react';
import { CategoryContainer, CategoryButton } from '../../pages/home/style';

export const categories = ['Todos', 'Eletrônicos', 'Especiais', 'Pôster', 'Músicas', 'Esportes'];

export const CategorySelector = ({ onCategoryChange }) => (
  <CategoryContainer>
    {categories.map((category, index) => (
      <CategoryButton key={index} onClick={() => onCategoryChange(category)}>
        {category}
      </CategoryButton>
    ))}
  </CategoryContainer>
);
