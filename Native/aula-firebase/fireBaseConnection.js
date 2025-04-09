// Import the functions you need from the SDKs you need
import { initializeApp } from "firebase/app";
import {getFirestore} from "firebase/firestore"
// TODO: Add SDKs for Firebase products that you want to use
// https://firebase.google.com/docs/web/setup#available-libraries

// Your web app's Firebase configuration
const firebaseConfig = {
    apiKey: "AIzaSyBNQ47qw_4BkohLch3eCWY2X1L4agutIIo",
    authDomain: "projeto-firebase-11e1c.firebaseapp.com",
    projectId: "projeto-firebase-11e1c",
    storageBucket: "projeto-firebase-11e1c.firebasestorage.app",
    messagingSenderId: "857221685638",
    appId: "1:857221685638:web:174fc9d2ea919e218d8c07"
};

// Initialize Firebase
const app = initializeApp(firebaseConfig);

const db = getFirestore(app);
export {db};