import { Image, Pressable, View } from 'react-native';
import PagerView from 'react-native-pager-view';
import { styles } from './style';

export default function Banner() {
    return (
        <View style={styles.container}>
            <PagerView style={{flex: 1}} initialPage={0} pageMargin={14}>
                <Pressable style={styles.imageBanner}>
                    <Image 
                    source={require('../../../assets/Banner1.png')}
                    style={styles.imageBanner}
                    />
                </Pressable>

                <Pressable style={styles.imageBanner}>
                    <Image 
                    source={require('../../../assets/Banner1.png')}
                    style={styles.imageBanner}
                    />
                </Pressable>
            </PagerView>
        </View>
    )
}