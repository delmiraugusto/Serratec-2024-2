import { StyleSheet } from "react-native";

export const styles = StyleSheet.create({
    container: {
        flex: 1,
        justifyContent: 'center',
        alignItems: 'center',
        backgroundColor: '#333',
    },
    box: {
        width: '90%',
        padding: 20,
        borderRadius: 10,
        alignItems: 'center',
        backgroundColor: 'grey',
    },
    title: {
        fontSize: 28,
        fontWeight: 'bold',
        color: '#fff',
        marginBottom: 20,
    },
    text: {
        fontSize: 20,
        color: '#fff',
        alignSelf: 'flex-start',
        marginTop: 10,
    },
    input: {
        width: '100%',
        height: 40,
        borderColor: '#555',
        borderRadius: 5,
        backgroundColor: 'black',
        paddingHorizontal: 10,
        marginTop: 5,
        marginBottom: 15,
        color: 'white'
    },
    button: {
        marginTop: 20,
        backgroundColor: '#555',
        paddingVertical: 15,
        paddingHorizontal: 25,
        borderRadius: 5,
    },
    buttonText: {
        color: '#fff',
        fontSize: 16,
        fontWeight: 'bold',
        textAlign: 'center',
    },
    TextNoAccount: {
        marginTop: 10,
        color: '#fff',
        fontSize: 14,
    },
});