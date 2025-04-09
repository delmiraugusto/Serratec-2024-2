import styled from 'styled-components';

export const FormContainer = styled.div`
    display: flex;
    flex-direction: column;
    align-items: center;
    max-width: 400px;
    margin: auto;
    padding: 20px;
    border: 1px solid #ddd;
    border-radius: 8px;
  `;

export const Logo = styled.h1`
    color: #ff6600;
    font-size: 2em;
  `;

export const Title = styled.h2`
    font-size: 1.5em;
    color: #333;
  `;

export const Divider = styled.div`
    margin: 20px 0;
    font-size: 0.9em;
    color: #666;
  `;

export const SocialButtons = styled.div`
    display: flex;
    gap: 10px;
  `;

export const SignUpLink = styled.p`
    color: #0073e6;
    margin-top: 20px;
    cursor: pointer;
    &:hover {
      text-decoration: underline;
    }
  `;
