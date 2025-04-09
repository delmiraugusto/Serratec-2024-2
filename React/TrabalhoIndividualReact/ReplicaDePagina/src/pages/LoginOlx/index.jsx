import React from "react";
import { Button } from "../../components/Button/index";
import { InputField } from "../../components/Input/index";
import { FormContainer, Title, SocialButtons, SignUpLink, Divider } from "./style"

export const LoginForm = () => {
  return (
    <FormContainer>
      <Title>Acesse a sua conta</Title>
      <InputField placeholder="E-mail" type="email" />
      <Button texto="Continuar" />
      <Divider>Ou conecte com</Divider>
      <SocialButtons>
        <Button texto="Google" />
        <Button texto="Facebook" />
      </SocialButtons>
      <SignUpLink>Não tem uma conta? Cadastre-se</SignUpLink>
    </FormContainer>
  );
};
