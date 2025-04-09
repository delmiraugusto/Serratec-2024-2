import React from 'react';
import { Container, Title, Message, HomeButton } from './style';

export const NotFound = () => {
    const handleGoHome = () => {
        window.location.href = '/';
    };

    return (
        <Container>
            <Title>404 - Página Não Encontrada</Title>
            <Message>Desculpe, mas a página que você está procurando não existe.</Message>
            <HomeButton onClick={handleGoHome}>Voltar para a Página Inicial</HomeButton>
        </Container>
    );
};

export default NotFound;
