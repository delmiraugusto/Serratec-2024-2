import { Image, View } from 'react-native';
import PagerView from 'react-native-pager-view';
import { styles } from './style';
import { Video } from 'expo-av';
import { useRef } from 'react';

export default function Banner() {
    const videoRef = useRef(null);

    return (
        <View style={styles.container}>
            <PagerView style={{ flex: 1 }} initialPage={0} pageMargin={14}>
                <Video
                    ref={videoRef}
                    source={require('../../../assets/video1.mp4')}
                    style={styles.imageBanner}
                    shouldPlay={true}
                    resizeMode='cover'
                    useNativeControls={false}
                    isLooping={true}
                />

                <Video
                    ref={videoRef}
                    source={require('../../../assets/video2.mp4')}
                    style={styles.imageBanner}
                    shouldPlay={true}
                    resizeMode='cover'
                    useNativeControls={false}
                    isLooping={true}
                />
            </PagerView>
        </View>
    )
}