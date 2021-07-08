</br>

### <p align=center>MARVEL COMICS API
<p align=center>Gerenciador de Comics

</br>
</br>
</br>

Fui solicitado para desenvolver uma API REST que gerencia Comics (Livros) de usuários. Dado o desafio, essa API é capaz de cadastrar usuários, sendo obrigatórios os dados: nome, e-mail, CPF e data de nascimento, sendo que e-mail e CPF devem ser únicos. Após o cadastramento do usuário, o mesmo pode cadastrar Comics em seu nome, sendo obrigatório a API salvar os dados: ComicId, Título, Preço, Autores, o ISBN e Descrição. Sendo que o serviço deve consumir a API da MARVEL (https://developer.marvel.com/) para buscar os dados do Comics baseado no ComicId informado. Sua ultima funcionalidade seria retornar um usuário com a lista de todos seus Comics (Livros) cadastrados.

</br>
</br>
</br>

## Construido com
* [Java 11]()
* [Spring Boot]()
* [Spring Web MVC]()
* [Spring Data JPA]()
* [Lombok]()
* [MariaDB]()

</br>
</br>
</br>

## Endpoints
* /users [POST = CADASTRO DE USUÁRIO]
* /users/{id} [GET = LISTA INFORMAÇÕES/COMICS DE UM USUÁRIO]
* /comics [POST = CADASTRO DE COMIC]

</br>
</br>
</br>

## Instalação

### Pré-requisitos
* Java 11
* Maven 3.6
* MariaDB

</br>

### Passos
1. Clone o repositório
```
$ git clone https://github.com/vrochacaio/comics.git
```
2. Instalando com Maven
```
$ mvn clean install
```
