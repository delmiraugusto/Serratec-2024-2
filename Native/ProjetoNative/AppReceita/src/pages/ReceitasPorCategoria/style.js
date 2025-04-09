import { StyleSheet } from "react-native";

export const styles = StyleSheet.create({
    container: {
        flex: 1,
        backgroundColor: '#2b2b2b',
    },
    tituloCategoria: {
        fontFamily: 'Poppins_700Bold',
        fontWeight: 'bold',
        fontSize: 24,
        color: '#fff',
        marginTop: 10,
        marginLeft: 10,
    },
    text: {
        fontFamily: 'Poppins_700Bold',
        fontWeight: 'bold',
        fontSize: 24,
        color: '#fff',
        marginTop: 10,
        marginLeft: 15,
    },
    list: {
        flexDirection: 'row',
        flexWrap: 'wrap',
        justifyContent: 'space-around',
        paddingHorizontal: 5,
        paddingVertical: 20
    },
    receitaImg: {
        width: 175,
        height: 175,
        borderRadius: 10,
    },
    receitaTitle: {
        fontFamily: 'Poppins_700Bold',
        fontSize: 16,
        fontWeight: 'bold',
        color: '#fff',
        textAlign: 'center',
        marginTop: 3,
        marginBottom: 15
    },
    containerAvaliacao: {
        justifyContent: 'center',
        alignItems: 'center',
        flexDirection: 'row',
        backgroundColor: 'rgba(0, 0, 0, 0.6)',
        width: 55,
        height: 20,
        borderRadius: 10,
        position: 'absolute',
        right: 7,
        top: 7,
    },
    iconeAvaliacao: {
        marginRight: 3
    },
    textoAvaliacao: {
        fontFamily: 'Poppins_700Bold',
        fontWeight: 'bold',
        color: '#fff'
    },
});