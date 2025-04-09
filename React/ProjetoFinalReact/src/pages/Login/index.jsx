import { useState } from 'react';
import { Container, Form, Title, Paragraf, Logo } from './style';
import { InputStyle } from "../../components/InputField/style";
import { Link, useNavigate } from 'react-router-dom';
import axios from 'axios';
import { ButtonComponents } from '../../components/Button/style';

const Imagem = new URL("../../assets/images/logo2.png", import.meta.url);

export const Login = () => {
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const navigate = useNavigate();

    const handleLogin = async (e) => {
        e.preventDefault();

        const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

        if (!email || !password) {
            alert("Preencha todos os campos");
            return;
        } else if (!emailRegex.test(email)) {
            alert("Insira um e-mail válido");
            return;
        }


        const url = import.meta.env.VITE_URL_API_V1;

        try {
            const response = await axios.get(url);

            const user = response.data.find((user) => user.email === email && user.password === password);

            if (user) {
                alert("Login Realizado com Sucesso");
                navigate('/home');
            } else {
                alert('Dados inválidos');
            }
        } catch (error) {
            if (error.response && error.response.status === 401) {
                alert('Dados inválidos');
            }
        }
    };

    return (
        <Container>
            <Logo>
                <img src={Imagem} alt="Logo" />
            </Logo>

            <Form onSubmit={handleLogin}>

                <Title>Login</Title>
                <InputStyle
                    type="text"
                    placeholder="E-mail"
                    value={email}
                    onChange={(e) => setEmail(e.target.value)}
                    required
                />
                <InputStyle
                    type="password"
                    placeholder="Senha"
                    value={password}
                    onChange={(e) => setPassword(e.target.value)}
                    required
                />
                <ButtonComponents type="submit">Logar</ButtonComponents>
                <Paragraf>
                    Não possui login?{' '}
                    <Link to="/cadastro">Cadastre-se</Link>
                </Paragraf>
            </Form>
        </Container>
    );
};