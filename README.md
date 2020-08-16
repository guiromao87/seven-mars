# Projeto Explorando Marte - Elo7

Api para registrar e controlar sondas que exploram um planalto limitado em Marte.

## Tecnologias utilizadas

    * Java - Versão 1.8
    * Maven
    * Spring Boot, Spring MVC, Devtools
    * Bean Validation
    * Junit para teste unitários
    
## Decisões de negócio

Entendi que o planalto de marte é um plano cartesiano(x,y) que iria receber receber as Sondas em posições específicas, 
e quando mandamos a Sonda se mover, dependendo de sua direção, vamos aumentando o valor do eixo X ou do eixo Y.

Começei com a ideia de criar um planalto sem limite de tamanho e colocar apenas uma sonda no planalto, 
assim foi mais fácil focar em registrar a sonda, alterar suas direção e fazer os movimentos. 
Com isso tive os testes que garantem que a Sonda em si funciona.

Após garantir que a Sonda se movimenta por Marte criei um endpoint que possibilita limitar a região do planalto que 
será explorada, assim caso tente registrar uma Sonda ou fazer uma Sonda já registrada andar fora do limite teremos 
uma excessão.

O próximo passo foi permitir o registro de outras Sondas no planalto que irá receber um mapa de
Sondas(ao invés de uma única Sonda), e para identifica-as cada Sonda vai ter um nome(fiz dessa forma porque a Nasa dá nomes a
Sondas, foguete, etc...).

Até aqui temos um planalto delimitado que pode receber uma ou mais Sondas e movimenta-las dentro desse limite. 

Para resolver o problema colisão entre as Sondas, cada vez que mandamos um movimento(M), pego a Direção e as Coordenadas 
da Sonda assim consigo saber para onde a Sonda iria. Com isso verifico em todas as sondas do planalto se tem um Sonda naquela 
coordenada específica, se não tiver nenhuma, a Sonda pode ir, caso contrário ela vai até um ponto antes da colisão e avisa(com uma excessão) 
que o lugar está ocupado. 

## Decisões técnicas

Como estou trabalhando sozinho nesse primeiro momento fiz meus commits diretamente na master e configuei o github actions 
para rodar os testes após o push. E como o desafio não cobra testes de integração optei por não fazer e tentar entregar mais rápido.

Por não estar trabalhando com nenhuma persistência e entender que o solo de Marte é algo único na aplicação
(limitado para exploração), criei o planalto como um singleton e utilizo o mesmo durante toda a aplicação.  

Tenho 5 endpoints para as ações:
    
    * Registrar limite de exploração do planalto
    * Registrar uma sonda no planalto
    * Buscar uma sonda pelo nome
    * Buscar todas as sondas
    * Mover uma sonda no planalto
    
    * passando as informações necessárias no corpo da requisição

Os endpoints recebem uma representação do json na entrada(form) e criam o objeto de domínio.
Na saída criam outro objeto que representa o json de saída(dto).
Assim mantenho o objeto de dómínio longe das bordas do sistema.


## Para rodar localmente

Como requisito precisamos ter o java(versão 8 no mínimo) instalado, clonar o projeto, ir na raiz e rodar: 

```
./mvnw spring-boot:run
```











