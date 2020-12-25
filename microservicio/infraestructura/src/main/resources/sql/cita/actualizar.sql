update cita
set servicio_id = :idServicio,
	fecha_hora = :fechaHora,
	sede_id = :idSede,
    cliente_id = :idCliente,
    descuento_id = :idDescuento,
    porcentaje_descuento = :porcentajeDescuento
where id = :id