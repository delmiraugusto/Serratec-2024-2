import React from 'react';
import { Navbar } from '../../components/Navbar';
import { CategoryItem } from '../../components/CategoryItem';
import { Feed } from '../../components/Feed';
import { HomeContainer, CategoriesContainer } from './style';

export const Home = () => (
    <HomeContainer>
        <Navbar />
        <CategoriesContainer>
            {Array(8).fill().map((_, i) => (
                <CategoryItem key={i} text="Gamer" />
            ))}
        </CategoriesContainer>
        <Feed />
    </HomeContainer>
);

