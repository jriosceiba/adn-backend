update cliente
set nombre = :nombre,
	email = :email,
	telefono = :telefono,
    ciudad_id = :ciudad
where id = :id