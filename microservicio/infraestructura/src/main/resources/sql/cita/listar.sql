SELECT cita.id as id, servicio.id as id_servicio, servicio.nombre as nombre_servicio, cita.fecha_hora as fecha_hora, sede.id as id_sede, sede.nombre as nombre_sede, cliente.id as id_cliente, cliente.nombre as nombre_cliente, servicio.valor as valor_servicio, coalesce(cita.porcentaje_descuento,0) as descuento, descuento.nombre as nombre_descuento 
FROM cita inner join parametro servicio on servicio.id = cita.servicio_id 
inner join parametro sede on sede.id = cita.sede_id inner join cliente on cliente.id = cita.cliente_id 
left join parametro descuento on descuento.id = cita.descuento_id order by cita.fecha_hora desc