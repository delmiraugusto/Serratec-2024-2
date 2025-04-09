import {View, Text, StyleSheet, Button, Alert, TouchableOpacity, ImageBackground} from 'react-native'
import {useState} from 'react'

export default function App() {

    const [kaito, setKaito] = useState(0)

    function incrementar() {
        setKaito(kaito + 1)
    }

    function zerar(){
        setKaito(0)
    }

    function darParaMil(){
        setKaito(1000)
        Alert.alert("SAFADO", "Kaito já deu para mil homens!")
    }

    return (
        <View style={styles.container}>
            <TouchableOpacity>
                <Text style={styles.container}>Kaitoo já deu o rabo quantas vezes?</Text>
            </TouchableOpacity>
            <Text style={styles.text}>{kaito}</Text>
            <View style={styles.button}>
                <Button title="DAR!!!" onPress={incrementar}></Button>
            </View>
            <View style={styles.button}>
                <Button title="DISDAR!!!" onPress={zerar}></Button>
            </View>
            <View style={styles.button}>
                <Button title="MIL HOMENS!!!" onPress={darParaMil}></Button>
            </View>
        </View>
    )
}

const styles = StyleSheet.create({
    container: {
        paddingTop: 110,
        alignItems: "center",
        justifyContent: 'center',
        color: "green",
        fontSize: 25,
    },

    text:{
        paddingTop: 20,
        fontSize: 29
    },
    button:{
        paddingTop: 20,
        width: '60%'
    }

})
