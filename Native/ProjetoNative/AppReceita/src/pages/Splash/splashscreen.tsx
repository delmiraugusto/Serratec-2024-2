import { AVPlaybackStatus, ResizeMode, Video } from "expo-av";
import { hideAsync } from "expo-splash-screen";
import { StyleSheet } from "react-native";
import { useState } from "react";
import { StatusBar } from "expo-status-bar";

type Props = {
    onComplete: (status: boolean) => void;
}

export function SplashScreen({ onComplete }: Props) {
    const [lastStatus, setStatus] = useState<AVPlaybackStatus>({} as AVPlaybackStatus);

    function onPlaybackStatusUpdate(status: AVPlaybackStatus) {
        if (status.isLoaded) {
            if (lastStatus.isLoaded !== status.isLoaded) {
                hideAsync();
            }

            if (status.didJustFinish) {
                onComplete(true);
            }

            setStatus(status);
        }
    }

    return (
        <>
        <StatusBar style="light" backgroundColor="black" translucent={true} />
        
        <Video
            style={StyleSheet.absoluteFill}
            resizeMode={ResizeMode.COVER}
            source={require('../../../assets/videoSplash.mp4')}
            isLooping={false}
            onPlaybackStatusUpdate={onPlaybackStatusUpdate}
            shouldPlay={true}
        />
        </>
    );
}
