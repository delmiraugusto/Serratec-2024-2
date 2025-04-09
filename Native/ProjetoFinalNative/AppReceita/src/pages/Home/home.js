import { ScrollView, Text, View, Image, TouchableOpacity } from 'react-native';
import Banner from '../../components/BannerHome/banner';
import { styles } from './style';
import { GetProduto } from '../../service/apiReceitas';
import { useState, useEffect } from 'react';

export default function Home() {

    const [receitas, setReceitas] = useState([]);

    function filterDesc(desc) {
        if (typeof desc === 'string' && desc.length < 20) {
            return desc;
        }

        return typeof desc === 'string' ? `${desc.substring(0, 20)}...` : '';
    }

    useEffect(() => {
        async function buscarProdutos() {
            const response = await GetProduto();
            if (response && response.data) {
                console.log(response.data);
                setReceitas(response.data);
            }
        }

        buscarProdutos();
    }, []);

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
                            <TouchableOpacity >
                                <Image
                                style={styles.receitaImg}
                                source={{ uri: receita.imagem }}
                                />
                            
                            <Text style={styles.receitaTitle}>{filterDesc(receita.nome)}</Text>

                            </TouchableOpacity>

                        </View>
                    ))}
                </View>

            </ScrollView>
        </View>
    );
}
