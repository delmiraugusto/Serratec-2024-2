import React from 'react';
import { TouchableOpacity, Text } from 'react-native';

export default function ButtonField({ children, style, ...rest }) {
    return (
        <TouchableOpacity style={[style]} {...rest}>
            <Text style={{ color: 'white', fontWeight: 'bold' }}>{children}</Text>
        </TouchableOpacity>
    );
}
