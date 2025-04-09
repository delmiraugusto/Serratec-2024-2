import React from "react";
import { LoginForm } from "./pages/LoginOlx";
import { Navbar } from "./components/NavBar/index";
import { AppContainer, ContentWrapper } from "./style";

export const App = () => {
    return (
        <AppContainer>
            <Navbar />
            <ContentWrapper>
                <LoginForm />
            </ContentWrapper>
        </AppContainer>
    );
};