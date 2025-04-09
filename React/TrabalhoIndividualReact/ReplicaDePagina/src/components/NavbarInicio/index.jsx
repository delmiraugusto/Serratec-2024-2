import React from 'react';
import { NavbarContainer, Logo, SearchInput, ActionButton } from './style';

export const Navbar = () => (
    <NavbarContainer>
        <Logo>OLX</Logo>
        <SearchInput placeholder="Buscar..." />
        <ActionButton>Entrar</ActionButton>
        <ActionButton>Anunciar grátis</ActionButton>
    </NavbarContainer>
);