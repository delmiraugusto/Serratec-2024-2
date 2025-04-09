import React from 'react';
import { useNavigate } from 'react-router-dom';
import { Card, Image, Name, Price, AddButton } from './style';

export const ProductCard = ({ product }) => {
  const navigate = useNavigate();

  const handleReadMore = () => {
    navigate(`/products/${product.id}`);
  };

  return (
    <Card>
      <Image src={product.image} alt={product.name} />
      <Name>{product.name}</Name>
      <Price>R$ {product.price}</Price>
      <AddButton onClick={handleReadMore}>Leia Mais</AddButton>
    </Card>
  );
};
