import React from 'react';
import { ProductCard } from '../ProductCard';
import { FeedContainer } from './style';

export const Feed = () => (
    <FeedContainer>
        {Array(6).fill().map((_, i) => (
            <ProductCard key={i} title="Teclado Gamer Sem Fio Logitech G Pro X com design TKL" price="R$ 999,99" />
        ))}
    </FeedContainer>
);

