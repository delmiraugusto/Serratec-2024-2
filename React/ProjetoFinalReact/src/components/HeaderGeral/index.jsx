import {
    Header, NavBar, NavButton, StyledLink, LogoContainer, Logo
} from "./style"
import { FaUserCircle, FaRegNewspaper, FaCartPlus, FaHistory, FaInfoCircle } from 'react-icons/fa';
import logo from '../../assets/images/logo.png'

export const HeaderGeral = () => {
    return (
        <Header>
            <LogoContainer>
                <StyledLink to="/home">
                    <Logo src={logo} alt="Logo" />
                </StyledLink>
            </LogoContainer>
            <NavBar>
                <NavButton><FaUserCircle /> <StyledLink to="/login">Login</StyledLink></NavButton>
                <NavButton><FaRegNewspaper /><StyledLink to="/cadastro">Cadastro</StyledLink></NavButton>
                <NavButton><FaCartPlus /> <StyledLink to="/cart">Carrinho</StyledLink></NavButton>
                <NavButton><FaHistory /> <StyledLink to="/historico">Histórico de Compras</StyledLink></NavButton>
                <NavButton><FaInfoCircle /><StyledLink to="/sobre">Sobre nós</StyledLink></NavButton>
            </NavBar>

        </Header>
    )

}