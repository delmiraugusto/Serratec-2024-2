import React from 'react';
import { CategoryContainer, Icon, CategoryText } from './style';
import Play from "../../assets/play.png";

export const CategoryItem = ({ text }) => (
    <CategoryContainer>
        <Icon src={Play} alt="Play" />
        <CategoryText>{text}</CategoryText>
    </CategoryContainer>
);

