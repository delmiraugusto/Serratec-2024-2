import { View, Image } from 'react-native'
import { StatusBar } from 'expo-status-bar';
import { styles } from './style';
import { SafeAreaView } from 'react-native-safe-area-context';

export default function Navbar() {
    return (
        <SafeAreaView style={styles.navbarContainer}>
            <StatusBar style="light" backgroundColor="black" translucent={true} />
            <View style={styles.navbar}>
                <Image
                    source={require('../../../assets/LogoPrincipalDelicia.png')}
                    style={styles.logo}
                />
            </View>
        </SafeAreaView>
    );
};