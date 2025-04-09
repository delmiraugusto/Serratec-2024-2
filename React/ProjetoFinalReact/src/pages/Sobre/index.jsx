import { Body, Block, Img, Title, ContentForms, Text, ImgMenor, Footer, Icon, Link, Container} from "./style";
import React from 'react';
import Loja1 from "../../assets/images/Loja1.jpg";
import Loja2 from "../../assets/images/Loja2.jpg";
import Loja3 from "../../assets/images/Loja3.jpg";
import Loja4 from "../../assets/images/Loja4.jpg";
import Loja5 from "../../assets/images/Loja5.jpg";
import Loja6 from "../../assets/images/Loja6.jpg";
import Pessoas from "../../assets/images/Pessoas.jpg";
import Cultura from "../../assets/images/Cultura.png";
import Facebook from "../../assets/icons/facebook.png";
import Instagram from "../../assets/icons/instagram.png";
import Linkedin from "../../assets/icons/linkedin.png";
import Github from "../../assets/icons/github.png";
import Youtube from "../../assets/icons/youtube.png";

export const Sobre = () => {
  return(
    <Container>
      <ContentForms>
        <Block>
          <ImgMenor src={Loja1}/>
          <Text>
            <Title>Sobre Nós</Title>
            <Body>
              A Vintage Collection é uma loja dedicada à paixão por itens colecionáveis 
              de estilo vintage. Celebramos a história, oferecendo peças únicas e 
              autênticas que evocam épocas passadas e trazem um charme nostálgico para 
              quem aprecia o valor das coisas bem-feitas e com histórias para contar.
            </Body>
          </Text>
        </Block>

        <Block>
          <Text>
            <Title>Nossa História</Title>
            <Body>
              Fundada em 2014, a Vintage Collection nasceu do amor por objetos 
              vintage e colecionáveis. Desde o início, nossa missão tem sido 
              curar e preservar peças com personalidade e histórias marcantes, 
              dando a nossos clientes a oportunidade de trazer um toque de 
              nostalgia e elegância para seus espaços.
            </Body>
          </Text>
          <Img src={Loja2}/>
        </Block>
      
        <Block>
          <Img src={Loja3}/>
          <Text>
            <Title>Nossa Visão</Title>
            <Body>
              Ser reconhecida como uma referência em colecionáveis vintage, admirada 
              pela qualidade da nossa curadoria e pelo nosso conhecimento, inspirando 
              as pessoas a valorizarem o estilo e o charme do passado.
            </Body>
          </Text>
        </Block>
        
        <Block>
          <Text>
            <Title>Nossos Valores</Title>
            <Body>
              <span><strong>Paixão pelo Vintage:</strong> Cada peça possui um passado único, e nos orgulhamos de preservá-lo.<br /></span>
              <span><strong>Comprometimento:</strong> Nosso atendimento é personalizado, e estamos sempre prontos para ajudar a encontrar o item perfeito.<br /></span>
              <span><strong>Autenticidade:</strong> Garantimos a originalidade e a qualidade de cada peça em nossa coleção.<br /></span>
              <span><strong>Conservação:</strong> Valorizamos a preservação de objetos históricos, promovendo a durabilidade e o respeito ao design clássico.</span>
            </Body>
          </Text>
          <Img src={Loja4}/>
        </Block>
      
        <Block>
          <ImgMenor src={Loja5}/>
          <Text>
            <Title>Nossa Missão</Title>
            <Body>
              Oferecer uma experiência autêntica para os amantes do vintage, 
              conectando-os com peças raras e originais que traduzem um estilo de 
              vida atemporal. Estamos comprometidos em preservar a cultura e o design 
              de cada época representada em nossa coleção, sempre mantendo o foco na 
              qualidade e na autenticidade.
            </Body>
          </Text>
        </Block>

        <Block>
          <Text>
            <Title>Nossos Produtos</Title>
            <Body>
              Na Vintage Collection, você encontrará uma seleção diversificada de itens 
              vintage: desde acessórios decorativos, discos de vinil, cartazes de época, 
              até objetos icônicos e de coleção. Cada peça é cuidadosamente escolhida 
              para enriquecer a experiência de colecionadores e entusiastas, adicionando 
              um toque de classe e história ao dia a dia.
            </Body>
          </Text>
          <Img src={Loja6}/>
        </Block>

        <Block>
          <Img src={Pessoas}/>
          <Text>
            <Title>Equipe</Title>
            <Body>
              Nossa equipe é composta por especialistas em colecionáveis vintage, 
              apaixonados por cada detalhe e com amplo conhecimento sobre nossas peças. 
              Estamos prontos para compartilhar informações, histórias, e auxiliar na 
              escolha do item ideal para cada cliente.
            </Body>
          </Text>
        </Block>

        <Block>
          <Text>
            <Title>Responsabilidade Social</Title>
            <Body>
              A Vintage Collection participa de iniciativas que promovem a 
              valorização cultural e a sustentabilidade. Acreditamos que 
              valorizar o passado é fundamental para construir um futuro onde a 
              história e o design clássico tenham um papel importante.
            </Body>
          </Text>
          <Img src={Cultura}/>
        </Block>
      </ContentForms>

      <Footer>
        <Title>Fale Conosco</Title>
        <Body>
          Se você deseja saber mais sobre nossa loja, nossa coleção ou tem alguma 
          dúvida, entre em contato conosco! Estamos à disposição para atender você 
          da melhor forma possível.
        </Body>
        
        <Title>Contato</Title>
        <Body>
          Endereço: Av. Cel. João Valério, 694 - Vila Esperanca, Magé - RJ, 25903-587<br />
          Telefone: (21) 2367-0866<br />
          E-mail: AntiquiModerna@gmail.com<br />
        </Body>

        <Link href="https://facebook.com" target="_blank" rel="noopener noreferrer">
          <Icon src={Facebook} alt="Facebook" />
        </Link>
        <Link href="https://instagram.com" target="_blank" rel="noopener noreferrer">
          <Icon src={Instagram} alt="Instagram" />
        </Link>
        <Link href="https://linkedin.com" target="_blank" rel="noopener noreferrer">
          <Icon src={Linkedin} alt="LinkedIn" />
        </Link>
        <Link href="https://github.com/delmiraugusto/projetoReact" target="_blank" rel="noopener noreferrer">
          <Icon src={Github} alt="GitHub" />
        </Link>
        <Link href="https://youtube.com" target="_blank" rel="noopener noreferrer">
          <Icon src={Youtube} alt="YouTube" />
        </Link>
      </Footer>
    </Container>
  );
};