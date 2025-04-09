import { ScrollView, Text, View, Image, TouchableOpacity, ActivityIndicator } from 'react-native';
import Banner from '../../components/BannerHome/banner';
import { styles } from './style';
import { GetProduto } from '../../service/apiReceitas';
import { useState, useEffect } from 'react';
import Octicons from 'react-native-vector-icons/Octicons'

export default function Home({ navigation }) {
    const [receitas, setReceitas] = useState([]);
    const [loading, setLoading] = useState(true);


    useEffect(() => {
        async function buscarProdutos() {
            try {
                setLoading(true)
                const response = await GetProduto();
                if (response && response.data) {
                    console.log(response.data);
                    setReceitas(response.data);
                }
            } catch (error) {
                console.error('Erro ao buscar produtos:', error);
            } finally {
                setLoading(false);
            }
        }

        buscarProdutos();
    }, []);

    if (loading) {
        return (
            <View style={[styles.container, { justifyContent: 'center', alignItems: 'center' }]}>
                <ActivityIndicator size="large" color="#e7a74e" />
            </View>
        );
    }

    function filterDesc(desc) {
        if (typeof desc === 'string' && desc.length < 20) {
            return desc;
        }

        return typeof desc === 'string' ? `${desc.substring(0, 20)}...` : '';
    }

    return (
        <View style={styles.container}>
            <ScrollView
                showsVerticalScrollIndicator={false}
            >
                <View style={styles.bannerContainer}>
                    <Banner />
                </View>

                <Text style={styles.text}>Receitas Brasileiras</Text>

                <View style={styles.list}>
                    {receitas.map((receita) => (
                        <View key={receita.id} style={styles.item}>
                            <TouchableOpacity
                                onPress={() => navigation.navigate("Detalhe", {
                                    receita
                                }
                                )}
                            >

                                <Image
                                    style={styles.receitaImg}
                                    source={{ uri: receita.imagem }}
                                />

                                <View style={styles.containerAvaliacao}>
                                    <Octicons
                                        name="star-fill"
                                        size={16}
                                        color={'#e7a74e'}
                                        style={styles.iconeAvaliacao}
                                    />

                                    <Text style={styles.textoAvaliacao}>
                                        {receita.avaliacao}
                                    </Text>
                                </View>

                                <Text style={styles.receitaTitle}>{filterDesc(receita.nome)}</Text>
                            </TouchableOpacity>

                        </View>
                    ))}
                </View>
            </ScrollView>
        </View>
    );
}