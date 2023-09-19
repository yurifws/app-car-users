# app-car-users


##  ESTÓRIAS DE USUÁRIO 

- HIS-2023000-arquitetura-inicial
- HIS-2023100-fluxo-de-usuarios
- HIS-2023200-fluxo-de-carros
- HIS-2023300-autenticacao-user
- HIS-2023400-tratamento-exception-e-ajustes-finais

##  SOLUÇÃO

API Rest para gerenciar carros de usuarios Spring Boot Framework

Endpoints REST

para usuarios (Não exigem autenticação);

- /api/signin
Esta rota espera um objeto com os campos login e password, e deve retornar o token
de acesso da API (JWT) com as informações do usuário logado.

- /api/users Listar todos os usuários

- /api/users Cadastrar um novo usuário 

- /api/users/{id} Buscar um usuário pelo id

- /api/users/{id} Remover um usuário pelo id

- /api/users/{id} Atualizar um usuário pelo id 




para carros (Exigem autenticação):
- /api/me
Retornar as informações do usuário logado (firstName, lastName, email, birthday, login,
phone, cars) + createdAt (data da criação do usuário) + lastLogin (data da última vez
que o usuário realizou login). (EM CONSTRUÇÃO)

- /api/cars Listar todos os carros do usuário logado 

- /api/cars Cadastrar um novo carro para o usuário logado 

- /api/cars/{id} Buscar um carro do usuário logado pelo id 

- /api/cars/{id} Remover um carro do usuário logado pelo id

- /api/cars/{id} Atualizar um carro do usuário logado pelo id 

Foi utilizado arquitetura hexagonal para maior desacoplamento, mesmo que so se refira a persistencia em banco. Se tratando de projetos maiores temos comunicação com outros servicos, como kafka(producer, listener), endpoints externos.

Testes unitários utilizando Mockito.

JWT para geração de token

H2 banco em memoria


##  COMO EXECUTAR

Será necessário instalar:

Java 11 (https://www.oracle.com/br/java/technologies/javase/jdk11-archive-downloads.html)
STS, Eclipse ou Intelij (https://spring.io/tools)
Project Lombok (https://projectlombok.org)
Insomnia (https://insomnia.rest/download) - Para executar os endpoints cuja a collection se encontra na raiz do projeto (COLLECTION_CAR_USERS)


Obs:
Geração de usuarios com senha está sem criptografia, deve-se gerar a criptografia antes de inserir (https://bcrypt-generator.com)


