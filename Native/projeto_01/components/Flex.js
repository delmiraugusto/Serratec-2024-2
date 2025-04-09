import { View, Text } from "react-native";

export default function Flex() {
    return (
        <View style={{ flex: 1, backgroundColor: "#121212" }}>
            <View style={{ backgroundColor: "blue", width: 50, height: 40 }}>
                <Text>Oi</Text>
                <Text>Oi</Text>
            </View>
        </View>
    );
}
