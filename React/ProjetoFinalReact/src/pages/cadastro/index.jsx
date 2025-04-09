import React, { useState } from 'react';
import axios from 'axios';
import { Container, ErrorMessage, Form, SuccessMessage, Title, Logo } from './style'
import { ButtonComponents } from '../../components/Button/style';
import { InputStyle } from "../../components/InputField/style"

const Imagem = new URL("../../assets/images/cadastro.png", import.meta.url);


export const Cadastro = () => {
    const [formData, setFormData] = useState({ name: "", email: '', password: '' });
    const [error, setError] = useState(null);
    const [success, setSuccess] = useState(null);

    const handleSubmit = async (e) => {

        const url = import.meta.env.VITE_URL_USERS
        const key = import.meta.env.VITE_KEY
        const baseURl = `https://${key}.mockapi.io`;
        e.preventDefault();
        setError(null);
        setSuccess(null);

        if (!formData.name || !formData.email || !formData.password) {
            setError("Todos os campos são obrigatórios!");
            return;
        }
        console.log(baseURl + url)
        try {
            const response = await axios.post(baseURl + url, formData);
            setSuccess("Cadastro realizado com sucesso!");
            setFormData({ name: "", email: '', password: '' });
        } catch (error) {
            console.error(error.response ? error.response.data : error.message);
            setError("Erro ao cadastrar usuário. Tente novamente.");
        }
    };

    const handleChange = (e) => {
        const { name, value } = e.target;
        setFormData({ ...formData, [name]: value });
    };

    return (
        <Container>

            <Logo>
            <img src={Imagem} alt="Logo" />
            </Logo>

            <Form onSubmit={handleSubmit}>
                <Title>Cadastro de Usuário</Title>
                <InputStyle
                    type="text"
                    name="name"
                    placeholder="Nome"
                    value={formData.name}
                    onChange={handleChange}
                    required
                />
                <InputStyle
                    type="email"
                    name="email"
                    placeholder="Email"
                    value={formData.email}
                    onChange={handleChange}
                    required
                />
                <InputStyle
                    type="password"
                    name="password"
                    placeholder="Senha"
                    value={formData.password}
                    onChange={handleChange}
                    required
                />
                <ButtonComponents type="submit">Cadastrar</ButtonComponents>

                {error && <ErrorMessage>{error}</ErrorMessage>}
                {success && <SuccessMessage>{success}</SuccessMessage>}
            </Form>
        </Container>
    );
};

