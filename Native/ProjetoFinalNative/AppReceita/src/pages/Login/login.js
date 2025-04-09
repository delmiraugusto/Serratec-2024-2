import React, { useState } from 'react';
import { Text, TextInput, TouchableOpacity, View, Alert } from 'react-native';
import { useNavigation } from '@react-navigation/native';
import axios from 'axios';
import { styles } from './style';

export default function Login() {
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const navigation = useNavigation();

    const handleLogin = async () => {
        try {
            const response = await axios.get('https://673fc934a9bc276ec4b996c4.mockapi.io/apicads/api');


            const user = response.data.find(
                (user) => user.Email.toLowerCase() === email.toLowerCase() && user.Senha === password
            );

            if (user) {
                Alert.alert('Sucesso', `Bem-vindo, ${user.Nome}!`);
                // navigation.navigate('Início');
            } else {
                Alert.alert('Erro', 'Email ou senha incorretos. Tente novamente.');
            }
        } catch (error) {
            console.error('Erro na API:', error.response?.data || error.message);
            Alert.alert(
                'Erro',
                'Não foi possível realizar o login.'
            );
        }
    };


    return (
        <View style={styles.container}>
            <View style={styles.box}>
                <Text style={styles.title}>LOGIN</Text>

                <Text style={styles.text}>EMAIL:</Text>
                <TextInput
                    style={styles.input}
                    placeholder="Digite seu email"
                    placeholderTextColor="#aaa"
                    value={email}
                    onChangeText={setEmail}
                />

                <Text style={styles.text}>SENHA:</Text>
                <TextInput
                    style={styles.input}
                    placeholder="Digite sua senha"
                    placeholderTextColor="#aaa"
                    secureTextEntry
                    value={password}
                    onChangeText={setPassword}
                />

                <Text style={styles.TextNoAccount}>Não possui cadastro?</Text>

                <TouchableOpacity style={styles.button} onPress={() => navigation.navigate('Cadastro')}>
                    <Text style={styles.buttonText}>Criar Conta</Text>
                </TouchableOpacity>

                <TouchableOpacity style={styles.button} onPress={handleLogin}>
                    <Text style={styles.buttonText}>Entrar</Text>
                </TouchableOpacity>
            </View>
        </View>
    );
}
