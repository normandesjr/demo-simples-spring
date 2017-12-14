CREATE TABLE funcionario (
  codigo bigint primary key auto_increment,
  nome   varchar(100) not null,
  email  varchar(100) not null,
  cpf    varchar(15) not null,
  data_nascimento date);
  