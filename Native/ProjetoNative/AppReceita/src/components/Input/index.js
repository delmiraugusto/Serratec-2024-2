import React from 'react';
import { TextInput } from 'react-native';

export default function InputField({ style, ...rest }) {
    return <TextInput style={[style]} {...rest} />;
}
