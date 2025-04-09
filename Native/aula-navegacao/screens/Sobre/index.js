import { StyleSheet, Text, View, Button } from "react-native";
import { useNavigation } from "@react-navigation/native";

export default function Home() {
    const navigation = useNavigation();

    function navigationSobre() {
        navigation.navigate("Sobre");
    }

    return (
        <View style={styles.container}>
            <Text>Tela de Sobre</Text>
        </View>
    );
}

const styles = StyleSheet.create({
    container: {
        flex: 1,
        alignItems: "center",
        justifyContent: "center",
    },
});
