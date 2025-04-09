import React, { useState } from 'react';
import { View, Text, TextInput, TouchableOpacity, StyleSheet, Alert } from 'react-native';

export default function Cadastro() {
    const [nome, setNome] = useState('');
    const [email, setEmail] = useState('');
    const [senha, setSenha] = useState('');
    const apiURL = 'https://673fc934a9bc276ec4b996c4.mockapi.io/apicads/api';

    const handleCadastro = async () => {
        if (!nome || !email || !senha) {
            Alert.alert('Erro', 'Preencha todos os campos!');
            return;
        }

        try {
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
                setNome('');
                setEmail('');
                setSenha('');
            } else {
                Alert.alert('Erro', 'Não foi possível cadastrar o usuário.');
            }
        } catch {
            Alert.alert('Erro', 'Ocorreu um erro ao conectar à API.');
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

            <TouchableOpacity style={styles.button} onPress={handleCadastro}>
                <Text style={styles.buttonText}>Cadastrar</Text>
            </TouchableOpacity>
        </View>
    );
}

const styles = StyleSheet.create({
    container: {
        flex: 1,
        backgroundColor: '#2b2b2b',
        alignItems: 'center',
        justifyContent: 'center',
        padding: 20,
    },
    title: {
        fontSize: 24,
        color: '#fff',
        marginBottom: 20,
    },
    input: {
        width: '100%',
        height: 50,
        backgroundColor: '#444',
        borderRadius: 8,
        paddingHorizontal: 10,
        color: '#fff',
        marginBottom: 15,
    },
    button: {
        width: '100%',
        height: 50,
        backgroundColor: '#f45',
        borderRadius: 8,
        alignItems: 'center',
        justifyContent: 'center',
        marginTop: 10,
    },
    buttonText: {
        color: '#fff',
        fontSize: 18,
        fontWeight: 'bold',
    },
});
