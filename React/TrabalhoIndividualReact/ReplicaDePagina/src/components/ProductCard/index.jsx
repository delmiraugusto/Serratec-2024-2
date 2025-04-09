import React from 'react';
import { Card, Image, Price, Title } from "./style";
import Teclado from "../../assets/teclado.png"

export const ProductCard = ({ title, price }) => (
    <Card>
        <Image src={Teclado} alt={title} />
        <Price>{price}</Price>
        <Title>{title}</Title>
    </Card>
);

