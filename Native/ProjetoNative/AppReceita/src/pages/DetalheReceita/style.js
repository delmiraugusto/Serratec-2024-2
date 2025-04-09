import { StyleSheet } from "react-native";

export const styles = StyleSheet.create({
    container: {
        flex: 1,
        backgroundColor: '#2b2b2b',
    },
    imagem: {
        width: '100%',
        height: 300,
        borderRadius: 10,
        marginBottom: 10
    },
    titulo: {
        fontSize: 24,
        fontWeight: 'bold',
        color: '#fff',
        marginBottom: 3,
        bottom: 30
    },
    textoAvaliacao: {
        fontFamily: 'Poppins_700Bold',
        fontWeight: 'bold',
        fontSize: 16,
        color: '#fff',
        marginLeft: 8,  
    },
    avaliacaoContainer: {
        flexDirection: 'row',
        alignItems: 'center',  
        bottom: 33
    },
    subTitulo: {
        fontSize: 22,
        fontWeight: 'bold',
        color: '#f38830',
        marginBottom: 10,
    },
    ingrediente: {
        fontSize: 18,
        color: '#fff',
        marginBottom: 8,
    },
    footer: {
        marginTop: 20,
    },
    descricao: {
        fontSize: 18,
        color: '#fff',
        lineHeight: 24,
    },
    buttonHeart: {
        backgroundColor: 'rgba(0, 0, 0, 0.4)',
        borderRadius: 10,
        width: 40,
        height: 35,
        alignItems: 'center',
        justifyContent: 'center',
        bottom: 55,
        left: 385,
    }
});
