# Anime LP3 N1

Trabalho N1 de LP3.
Web api desenvolvida em java com tomcat e banco de dados postgres em nuvem

# Banco de dados (schema)


# Endpoints 
```sh
/UserApi
/RatingApi
/PublisherApi
/TitleApi
```
 - Para testes locais utitlize a url base como `http://localhost:9091/LP3-N1`
 - Os formatos das responses são em JSON

## UserApi
Endpoint utilizado para cadastrar, atualizar, deletar e criar usuários do sistema
Exemplo de criação (PUT):
`http://localhost:9091/LP3-N1/UserApi?nickname=Teste&email=teste%40teste.com&profileImageUrl=teste`

### Parametros:
| Nome | Tipo |
| ------ | ------ |
| nickname | string |
| email | string |
| profileImageUrl | string (url) |



## PublisherApi
Endpoint utilizado para cadastrar, atualizar, deletar e criar editoras do sistema
Exemplo de criação (PUT):
`http://localhost:9091/LP3-N1/PublisherApi?fullName=Shonen%20Jump%20&ownerName=Hiroyuki%20Nakano`

### Parametros:
| Nome | Tipo |
| ------ | ------ |
| fullName | string |
| owner | string |

## TitleApi
Endpoint utilizado para cadastrar, atualizar, deletar e criar títulos do sistema
Exemplo de criação (PUT):
`http://localhost:9091/LP3-N1/TitleApi?title=Naruto&genre=Adventure&demographicId=1&publisherId=2&publishedAt=2002-10-03&bannerImageUrl=https%3A%2F%2Fyt3.ggpht.com%2Fa%2FAGF-l78ZQpzw3j7l7G-zbrZ4truQ9CNcgPDvLvcSJg%3Ds900-c-k-c0xffffffff-no-rj-mo`

### Parametros:
| Nome | Tipo |
| ------ | ------ |
| title | string |
| genre | string |
| demographicId | int (correspondente a tabela [demographics][df1]) |
| publisherId | int |
| publishedAt | string (formato: `yyy-MM-dd`) |
| bannerImageUrl | string (url) |

## RatingApi
Endpoint utilizado para cadastrar, atualizar, deletar e criar reviews do sistema
Exemplo de criação (PUT):
`http://localhost:9091/LP3-N1/RatingApi?rating=10&comment=testando%20um%20comentario&userId=1&titleId=5`

### Parametros:
| Nome | Tipo |
| ------ | ------ |
| rating | int (0 à 100) |
| comment | string |
| userId | int |
| titleId | int |



[//]: # (These are reference links used in the body of this note and get stripped out when the markdown processor does its job. There is no need to format nicely because it shouldn't be seen. Thanks SO - http://stackoverflow.com/questions/4823468/store-comments-in-markdown-syntax)


   [dill]: <https://github.com/joemccann/dillinger>
   [git-repo-url]: <https://github.com/joemccann/dillinger.git>
   [john gruber]: <http://daringfireball.net>
   [df1]: <http://daringfireball.net/projects/markdown/>
   [markdown-it]: <https://github.com/markdown-it/markdown-it>
   [Ace Editor]: <http://ace.ajax.org>
   [node.js]: <http://nodejs.org>
   [Twitter Bootstrap]: <http://twitter.github.com/bootstrap/>
   [jQuery]: <http://jquery.com>
   [@tjholowaychuk]: <http://twitter.com/tjholowaychuk>
   [express]: <http://expressjs.com>
   [AngularJS]: <http://angularjs.org>
   [Gulp]: <http://gulpjs.com>

   [PlDb]: <https://github.com/joemccann/dillinger/tree/master/plugins/dropbox/README.md>
   [PlGh]: <https://github.com/joemccann/dillinger/tree/master/plugins/github/README.md>
   [PlGd]: <https://github.com/joemccann/dillinger/tree/master/plugins/googledrive/README.md>
   [PlOd]: <https://github.com/joemccann/dillinger/tree/master/plugins/onedrive/README.md>
   [PlMe]: <https://github.com/joemccann/dillinger/tree/master/plugins/medium/README.md>
   [PlGa]: <https://github.com/RahulHP/dillinger/blob/master/plugins/googleanalytics/README.md>
