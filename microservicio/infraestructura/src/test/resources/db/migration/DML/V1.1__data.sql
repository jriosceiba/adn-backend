insert into usuario(nombre,clave,fecha_creacion) values('test','1234',now());
insert into parametro(nombre,valor,tipo_parametro) values('test','5000','SEDE');
insert into cliente(nombre,email,ciudad_id, fechaCreacion) values('test','test@mail.com',1, '2020-01-01 00:00:00');
insert into cita(servicio_id,fecha_hora,sede_id, cliente_id, descuento_id, porcentaje_descuento) values(1,'2020-01-01 00:00:00',1,1,1,10.00);
