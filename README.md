![imagem local](/imagem_readme/logo.webp)



# Swagger-Open-API

  - [Tecnologias Usadas](#Tecnologias-Usadas)
  - [Sobre](#Sobre)
  - [Inicio](#Inicio)
  - [Configurando e Documentando](#Documentando)


## Tecnologias Usadas

[Java](https://www.java.com/pt-BR/) / [Spring](https://spring.io/projects/spring-boot) / [Docker](https://www.docker.com/) / [PostgresSQL](https://www.postgresql.org/) / [Pgadmin4](https://www.pgadmin.org/download/pgadmin-4-windows/) / [Thymeleaf](https://www.thymeleaf.org/) / [HTML5](https://pt.wikipedia.org/wiki/HTML5)
 / [Postman](https://www.postman.com/) / [Google Cloud](https://cloud.google.com/?hl=pt-BR) / [Swagger/OpenAPI](https://swagger.io/)


## Sobre

Iremos implmentar o swagger para documentar um [projeto](https://github.com/Hugoftf/Spring-Security-Authorization-Service) passado de API em uma pagina web com seus exemplos de seus funcionamentos. O Swagger é um conjunto de ferramentas para projetar, documentar, consumir e testar APIs RESTful.


## Inicio


Para começar iremos adicionar o starter open api para habilitar o swagger:


![imagem local](/imagem_readme/starter-open-api.png)



Depois disso já está habilitado o swwager, como nossa API contem a camada security, precisamos desabilitar a autenticação para as urls do swagger para podemos acessar sem precisar se autenticar:


![imagem local](imagem_readme/config/classe_SecurityConfiguration_Bean_webSecurityCustomizer.png)


Feito isso, podemos acessar o swagger:


![imagem local](/imagem_readme/bowser/acessando_swagger_primeira_vez.png)


Ainda assim para executar alguns funcionamentos precisamos se autenticar. Então os proximos passos iremos editar um pouco dessa interface do swagger e editar para os funcionamentos da página
sejam autenticados automaticamente.



## Documentando


Para começar a configurar e documentar minha API, iremos criar uma classe no pacote confi chamada de OpenAPiConfiguration, ela irá simular a parte inicial da minha Documentação e também para configurações:


![imagem local](/imagem_readme/config/classe_OpenAPIConfiguration.png)


Ela carrega informações iniciais de contatos e titulos.


Em seguida, na camada controller da nossa API de autores, iremos documenta-lá:


![imagem local](/imagem_readme/controller/AutorController/classe_AutorController.png)


A começar pelo corpo da classe, recebendo a anotação @Tag que edita o titulo da aba da nossa API no Swagger. Depois documentando no metodo salvar:


![imagem local](/imagem_readme/controller/AutorController/classe_AutorController_metodo_salvar_swwager.png)


Básicamete iremos descrever a funcionalidade do metodos e cada retorno possivel com codigos de http que nosso podem acontecer no nosso metodo. Com isso o retorno no swagger fica dessa forma:


![imagem local](/imagem_readme/bowser/swagger/titulo_editado_e_contato.png)


Esse é o titulo contendo as informações de contato, meu nome, web site, email, etc. Partindo para API de autor ficou dessa forma:


![imagem local](/imagem_readme/bowser/swagger/aba_autor_metodo_salvar.png)


Contendo mais informações editadas/documentadas mais abaixos.


Agora iremos documentar todos os metodos incluindo o record AutorDTO. A começar pelo record AutorDTO:


![imagem local](/imagem_readme/DTO/record_AutorDTO_classe_e_campos_documentados.png)


Para os DTO's a anotação que usamos tanto para corpo do record quanto para campos é a @Scherma, sua utilidade principal é editar o nome do campo no swagger.


Voltando para a camada controller o proximo metodo a ser editado é o obterDetalhes:


![imagem local](/imagem_readme/controller/AutorController/classe_AutorController_metodo_obterDetalhes_documentado.png)


Agora o metodo deletar:


![imagem local](/imagem_readme/controller/AutorController/classe_AutorController_metodo_deletar_documentado.png)


Metodo Pesquisar:


![imagem local](/imagem_readme/controller/AutorController/classe_AutorController_metodo_pesquisar_documentado.png)


Metodo Atualizar:


![imagem local](/imagem_readme/controller/AutorController/classe_AutorController_metodo_atualizar_documentado.png)



#### Configurando o Security Scherme


Para começar, iremos remover as respostas genericas que o swagger ao escanear nossa API cria baseadas na nossa classe de GlobalExceções que podem ocorrer na API para todas as requisições. Iremos adicionar mais uma prorpriedade no application.yml:


![imagem local](/imagem_readme/app_yamal_springdoc.png)


Depois na classe OpenAPIConfiguration, iremos adicionar configurações adicionais atraves de anotações:



![imagem local](imagem_readme/config/classe_OpenAPIConfiguration_configurando_security_do_swagger.png)


Basicamente essas configurações vão fazer que nosso swagger irá se autenticar via token e passar informações pelo hearder.


O retorno no nosso swagger:


![imagem local](/imagem_readme/bowser/swagger/authorizations_com_via_token.png)


E por fim pode se autenticar via token:


![imagem local](/imagem_readme/bowser/swagger/authorizations_token_value.png)


