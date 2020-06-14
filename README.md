# Anime LP3 N1

Trabalho N1 de LP3.
Web api desenvolvida em java, com tomcat e banco de dados postgres em nuvem. Para rodar o server é necessário apenas subir o projeto localmente.

# Banco de dados (schema)
![alt text](https://github.com/LucasBoulle/LP3-N1/blob/master/schema-db.png?raw=true)

# Endpoints 
```sh
/UserApi
/RatingApi
/PublisherApi
/TitleApi
```
 - Cada endpoint possui 4 funcções de insert, update, delete e find e são acessados da seguinte forma:
    - Para requisições `PUT` é utilizado para insert e update
    - para requisições `DELETE` é utilizado para delete
    - Para requisições `GET` é utilizado para find
 - Para testes locais utitlize a url base como `http://localhost:9091/LP3-N1`
 - Os formatos das responses são em JSON, exemplo:
 ![alt text](https://github.com/LucasBoulle/LP3-N1/blob/master/lp3Response.png?raw=true)
## Tabela Demographics
Tabela pré -preenchida com os tipos demográficos em que se enquadram os títulos, são eles e seus respectivos ids:
| Nome | id |
| ------ | ------ |
| Shounen | 1 |
| Shoujo | 2 |
| Seinen | 3 |
| Josei | 4 |
| Kodomomuke | 5 |

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
| id | int (opcional, caso seja desejado fazer update no registro em questão ) |



## PublisherApi
Endpoint utilizado para cadastrar, atualizar, deletar e criar editoras do sistema
Exemplo de criação (PUT):
`http://localhost:9091/LP3-N1/PublisherApi?fullName=Shonen%20Jump%20&ownerName=Hiroyuki%20Nakano`

### Parametros:
| Nome | Tipo |
| ------ | ------ |
| fullName | string |
| owner | string |
| id | int (opcional, caso seja desejado fazer update no registro em questão ) |

## TitleApi
Endpoint utilizado para cadastrar, atualizar, deletar e criar títulos do sistema
Exemplo de criação (PUT):
`http://localhost:9091/LP3-N1/TitleApi?title=Naruto&genre=Adventure&demographicId=1&publisherId=2&publishedAt=2002-10-03&bannerImageUrl=https%3A%2F%2Fyt3.ggpht.com%2Fa%2FAGF-l78ZQpzw3j7l7G-zbrZ4truQ9CNcgPDvLvcSJg%3Ds900-c-k-c0xffffffff-no-rj-mo`

### Parametros:
| Nome | Tipo |
| ------ | ------ |
| title | string |
| genre | string |
| demographicId | int (correspondente a tabela demographics |
| publisherId | int |
| publishedAt | string (formato: `yyy-MM-dd`) |
| bannerImageUrl | string (url) |
| id | int (opcional, caso seja desejado fazer update no registro em questão ) |

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
| id | int (opcional, caso seja desejado fazer update no registro em questão ) |
