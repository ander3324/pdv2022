/* Script para la generación de valores iniciales */

/* Roles */
INSERT INTO permisos (nombre) VALUES ('ROLE_ADMIN');
INSERT INTO permisos (nombre) VALUES ('ROLE_CAJERO');
INSERT INTO permisos (nombre) VALUES ('ROLE_REPOSITOR');

/* Usuarios - en las pruebas todas las claves son 'usuario' */
INSERT INTO usuarios (activo, nombre, clave, id_permiso) VALUES (1, 'claudio', '$2a$10$nmsnELze.Ca7dMnsbfGIuuczJlKMAk9SGCkgDczmosj91zCAMsFoO', 1);
INSERT INTO usuarios (activo, nombre, clave, id_permiso) VALUES (1, 'alexis', '$2a$10$nmsnELze.Ca7dMnsbfGIuuczJlKMAk9SGCkgDczmosj91zCAMsFoO', 2);
INSERT INTO usuarios (activo, nombre, clave, id_permiso) VALUES (1, 'exequiel', '$2a$10$nmsnELze.Ca7dMnsbfGIuuczJlKMAk9SGCkgDczmosj91zCAMsFoO', 3);

/* Cargar categorías */

INSERT INTO `pdv_db`.`categorias` (`nombre`) VALUES ('Bebidas');
INSERT INTO `pdv_db`.`categorias` (`nombre`) VALUES ('Alimentos');
INSERT INTO `pdv_db`.`categorias` (`nombre`) VALUES ('Perfumería');
INSERT INTO `pdv_db`.`categorias` (`nombre`) VALUES ('Bazar');
INSERT INTO `pdv_db`.`categorias` (`nombre`) VALUES ('Carnes');

/* Cargar Productos */

INSERT INTO `pdv_db`.`productos` (`activo`, `cod_bar`, `descripcion`, `lnk_img`, `precio`, `stock`, `id_categoria`) VALUES (1, '1111111111111', 'Coca Cola 2.25 lts', 'https://jumboargentina.vtexassets.com/arquivos/ids/666397-800-600?v=637674141828470000&width=800&height=600&aspect=true', '350', '500', 1);
INSERT INTO `pdv_db`.`productos` (`activo`, `cod_bar`, `descripcion`, `lnk_img`, `precio`, `stock`, `id_categoria`) VALUES (1, '2222222222222', 'Polenta Albertito', 'https://k62.kn3.net/taringa/1/E/4/7/1/3/vshiru/98D.jpg', '2500', '120', 2);
INSERT INTO `pdv_db`.`productos` (`activo`, `cod_bar`, `descripcion`, `lnk_img`, `precio`, `stock`, `id_categoria`) VALUES (1, '3333333333333', 'Shampoo Pantene', 'https://farmacityar.vteximg.com.br/arquivos/ids/203967-1000-1000/218820_shampoo-pantene-bambu-nutre-y-crece-x-750-ml_imagen-1.jpg?v=637377775423100000', '250', '20', 3);
