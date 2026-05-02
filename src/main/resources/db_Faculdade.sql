create database db_Faculdade
go
use db_Faculdade
go
--usuario
--123456
go
create user usuario for login usuario
go
alter role db_owner add member usuario
go

create table log_curiosidade (
id int identity(1, 1) not null,
id_curiosidade int not null
primary key(id)
)
go

--Função para verificar se a curiosidade é repetida
create function fn_verificar_repetida (@id_curiosidade int)
returns bit 
as
begin
	declare @existe bit
	set @existe = 0
	if (exists(select 1 from log_curiosidade where id_curiosidade = @id_curiosidade))
	begin
		set @existe = 1
	end
	return @existe
end
go

--`Procedure de login
create procedure sp_validar_login
	@login varchar(50),
	@senha varchar(50)
as 
begin
	set nocount on
	if(@login = 'admin' AND @senha = '$Jej-W+q%')
	begin
		select 1 as resultado
	end 
	else
	begin
		select 0 as resultado
	end
end
go

--Procedure para sortear a curiosidade
create or alter procedure sp_sortear_curiosidade
    @time int
as 
begin
    set nocount on 
    declare @curiosidade_sorteada int 

    select top 1 @curiosidade_sorteada = id 
    from curiosidade
    where id_time = @time
    and dbo.fn_verificar_repetida(id) = 0
    order by newid()

    if (@curiosidade_sorteada is null)
    begin
        select top 1 @curiosidade_sorteada = id 
        from curiosidade 
        where id_time = @time 
        order by newid()
    end

    if (select count(*) from log_curiosidade) >= 3
    begin
        delete from log_curiosidade where id = (select min(id) from log_curiosidade)
    end

    if (@curiosidade_sorteada is not null)
    begin
        insert into log_curiosidade (id_curiosidade) values (@curiosidade_sorteada)
    end

    select @curiosidade_sorteada as id
end
go

--Trigger para o candidato ter data e hora inserida
create trigger tr_data_hora_candidato
on candidato
after insert
as 
begin
	update candidato
	set data_hora = getdate()
	from candidato
	inner join inserted on candidato.id = inserted.id
end
go
--Trigger para proteção dos dados do candidato
create trigger tr_bloq_can_delete_update
on candidato
for update, delete
as 
begin
	if exists (select * from inserted) and exists (select * from deleted)
    begin
        if update(nome_completo) or update(email) or update(telefone_celular)
        begin
            rollback transaction
            print 'erro: os dados do candidato sao imutaveis por regra de negocio'
        end
    end
end
go

--Trigger para proteção dos dados das curiosidades
create trigger tr_bloq_cur_delete_update
on curiosidade
for update, delete
as 
begin
	rollback transaction;
	print 'Erro: De acordo com as regras de negócio, as cursiosidades não podem ser alteradas ou excluídas'
end
go



-- 1. Ver se as tabelas existem
SELECT name FROM sys.tables;

-- 2. Ver se os times foram inseridos (Requisito do PDF)
SELECT * FROM time;

-- 3. Ver se as curiosidades dos TXTs subiram
SELECT * FROM curiosidade;

-- 4. Ver se a tabela de candidatos está pronta (deve estar vazia)
SELECT * FROM candidato;

SELECT t.nome, MIN(c.id) AS primeiro_id, MAX(c.id) AS ultimo_id, COUNT(*) AS total
FROM curiosidade c
JOIN time t ON c.id_time = t.id
GROUP BY t.nome;


