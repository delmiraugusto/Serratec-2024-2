import React, { useState } from 'react';
import { View, Text, TextInput, TouchableOpacity, Alert } from 'react-native';
import { styles } from './style';

export default function Cadastro({ navigation }) {
    const [nome, setNome] = useState('');
    const [email, setEmail] = useState('');
    const [senha, setSenha] = useState('');
    const [isLoading, setIsLoading] = useState(false);

    const handleCadastro = async () => {
        setIsLoading(true);

        if (!nome || !email || !senha) {
            Alert.alert('Erro', 'Preencha todos os campos!');
            setIsLoading(false);
            return;
        }

        try {
            const checkResponse = await fetch('https://673fc934a9bc276ec4b996c4.mockapi.io/apicads/api');
            const users = await checkResponse.json();

            const emailExists = users.some((user) => user.Email.toLowerCase() === email.toLowerCase());

            if (emailExists) {
                Alert.alert('Erro', 'Este e-mail já está cadastrado.');
                setIsLoading(false);
                return;
            }

            const response = await fetch('https://673fc934a9bc276ec4b996c4.mockapi.io/apicads/api', {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify({
                    Nome: nome,
                    Email: email,
                    Senha: senha,
                }),
            });

            if (response.ok) {
                Alert.alert('Sucesso', 'Usuário cadastrado com sucesso!');
                navigation.navigate('Login');
                setNome('');
                setEmail('');
                setSenha('');
            } else {
                Alert.alert('Erro', 'Não foi possível cadastrar o usuário.');
            }
        } catch (error) {
            Alert.alert('Erro', 'Ocorreu um erro ao conectar à API.');
            console.error(error);
        } finally {
            setIsLoading(false);
        }
    };



    return (
        <View style={styles.container}>
            <Text style={styles.title}>Cadastro</Text>

            <TextInput
                style={styles.input}
                placeholder="Nome"
                placeholderTextColor="#aaa"
                value={nome}
                onChangeText={setNome}
            />
            <TextInput
                style={styles.input}
                placeholder="E-mail"
                placeholderTextColor="#aaa"
                keyboardType="email-address"
                value={email}
                onChangeText={setEmail}
            />
            <TextInput
                style={styles.input}
                placeholder="Senha"
                placeholderTextColor="#aaa"
                secureTextEntry
                value={senha}
                onChangeText={setSenha}
            />

            <TouchableOpacity style={styles.button} onPress={handleCadastro} disabled={isLoading}>
                <Text style={styles.buttonText}>{isLoading ? "Cadastrando..." : "Cadastrar"}</Text>
            </TouchableOpacity>

            <TouchableOpacity onPress={() => navigation.navigate('Login')}>
                <Text style={styles.linkText}>Você ja tem uma conta? Entre na sua conta.</Text>
            </TouchableOpacity>
        </View>
    );
}
