import React from 'react';
import { createBottomTabNavigator } from '@react-navigation/bottom-tabs';
import { createStackNavigator } from '@react-navigation/stack';
import Home from '../pages/Home/home';
import Perfil from '../pages/Perfil/perfil';
import Categoria from '../pages/Categoria/categoria';
import Cadastro from '../pages/Cadastro/cadastro';
import ReceitasPorCategoria from '../pages/ReceitasPorCategoria/receitasPorCategoria';
import AntDesign from 'react-native-vector-icons/AntDesign';
import MaterialCommunityIcons from 'react-native-vector-icons/MaterialCommunityIcons';
import FontAwesome6 from 'react-native-vector-icons/FontAwesome6';
import Feather from 'react-native-vector-icons/Feather';
import Detalhe from '../pages/DetalheReceita/detalhe';
import Login from "../pages/Login/login";

const Tab = createBottomTabNavigator();
const Stack = createStackNavigator();

function CadastroStack() {
    return (
        <Stack.Navigator screenOptions={{ headerShown: false }}>
            <Stack.Screen name="Cadastro" component={Cadastro} />
            <Stack.Screen name="Login" component={Login} />
        </Stack.Navigator>
    );
}

function HomeStack() {
    return (
        <Stack.Navigator screenOptions={{ headerShown: false }}>
            <Stack.Screen name="Home" component={Home} />
            <Stack.Screen name="Detalhe" component={Detalhe} />
        </Stack.Navigator>
    );
}

function CategoriaStack() {
    return (
        <Stack.Navigator screenOptions={{ headerShown: false }}>
            <Stack.Screen name="Categoria" component={Categoria} />
            <Stack.Screen name="ReceitasPorCategoria" component={ReceitasPorCategoria} />
            <Stack.Screen name="Detalhe" component={Detalhe} />
        </Stack.Navigator>
    );
}

function PerfilStack() {
    return (
        <Stack.Navigator screenOptions={{ headerShown: false }}>
            <Stack.Screen name="Perfil" component={Perfil} />
            <Stack.Screen name="Cadastro" component={Cadastro} />
            <Stack.Screen name="Login" component={Login} />
            <Stack.Screen name="Detalhe" component={Detalhe} />
        </Stack.Navigator>
    );
}

export default function Routes() {
    return (
        <Tab.Navigator
            screenOptions={{
                headerShown: false,
                tabBarStyle: {
                    height: 55,
                    backgroundColor: '#1D1C1C',
                    borderTopWidth: 0,
                },
                tabBarLabelStyle: {
                    fontSize: 14,
                    fontWeight: 'bold',
                    position: 'relative',
                    bottom: 5,
                },
                tabBarActiveTintColor: '#ef4418',
                tabBarInactiveTintColor: '#EBE7E7',
            }}
        >
            <Tab.Screen
                name="Início"
                component={HomeStack}
                options={{
                    tabBarIcon: ({ focused }) => (
                        <AntDesign
                            name="home"
                            size={25}
                            color={focused ? '#ef4418' : '#EBE7E7'}
                        />
                    ),
                }}
            />
            <Tab.Screen
                name="Categorias"
                component={CategoriaStack}
                options={{
                    tabBarIcon: ({ focused }) => (
                        <MaterialCommunityIcons
                            name="chef-hat"
                            size={25}
                            color={focused ? '#ef4418' : '#EBE7E7'}
                        />
                    ),
                }}
            />
            <Tab.Screen
                name="Perfil"
                component={PerfilStack}
                options={{
                    tabBarIcon: ({ focused }) => (
                        <FontAwesome6
                            name="user-large"
                            size={22}
                            color={focused ? '#ef4418' : '#EBE7E7'}
                        />
                    ),
                }}
            />
        </Tab.Navigator>
    );
}
