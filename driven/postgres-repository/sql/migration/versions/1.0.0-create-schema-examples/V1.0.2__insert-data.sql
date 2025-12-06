INSERT INTO public.aptitudes (descripcion) VALUES
                                             ('Amasar Pan'),
                                             ('Repostería'),
                                             ('Simpatía y Bonhomía '),
                                             ('Matemáticas'),
                                             ('Manejo de armas blancas '),
                                             ('Limpiar pescado'),
                                             ('Fortaleza física'),
                                             ('Alquimia');

INSERT INTO public.orders (customer_name,customer_email,order_date,status,total) VALUES
                                                                                   ('Carlos Fernandez','carlos.fernandez@example.com','2025-12-06 10:47:17.270026+01','PAID',1789.89),
                                                                                   ('Laura Gómez','laura.gomez@example.com','2025-12-06 10:47:17.270026+01','PENDING',289.89),
                                                                                   ('Ana Torres','ana.torres@example.com','2025-12-06 10:47:17.270026+01','SHIPPED',559.4);
INSERT INTO public.products ("name",description,price,stock,created_at) VALUES
                                                                          ('Laptop Pro 15','Portátil de alto rendimiento para profesionales.',1499.99,10,'2025-12-06 10:47:17.270026+01'),
                                                                          ('Auriculares Inalámbricos X2','Cancelación activa de ruido y batería de larga duración.',199.9,50,'2025-12-06 10:47:17.270026+01'),
                                                                          ('Teclado Mecánico RGB','Teclado mecánico con switches rojos.',89.99,30,'2025-12-06 10:47:17.270026+01'),
                                                                          ('Monitor UltraWide 34"','Monitor panorámico ideal para multitarea.',499.5,20,'2025-12-06 10:47:17.270026+01'),
                                                                          ('Ratón Gamer GX','Ratón ergonómico con 8 botones programables.',59.9,45,'2025-12-06 10:47:17.270026+01');

INSERT INTO public.order_lines (order_id,product_id,quantity,unit_price) VALUES
                                                                           (1,1,1,1499.99),
                                                                           (1,2,1,199.9),
                                                                           (1,5,1,59.0),
                                                                           (2,3,1,89.99),
                                                                           (2,5,2,59.95),
                                                                           (3,4,1,499.5),
                                                                           (3,2,1,59.9);

INSERT INTO public.secciones (horas_diarias,nombre) VALUES
                                                      (8,'Horno'),
                                                      (16,'Cajas'),
                                                      (16,'Pescadería'),
                                                      (16,'Verduras '),
                                                      (16,'Droguería');

INSERT INTO public.seccion_aptitud (aptitud_id,seccion_id) VALUES
                                                             (1,1),
                                                             (6,3),
                                                             (7,4),
                                                             (8,5),
                                                             (2,1),
                                                             (3,2),
                                                             (4,2),
                                                             (5,3);

INSERT INTO public.tiendas (direccion,nombre) VALUES
  ('Calle Prueba T','Merca');
INSERT INTO public.trabajadores (dni,nombre,tienda_id) VALUES
                                                         ('Y11111111','Juan',1),
                                                         ('Y2222222','Salva',1),
                                                         ('Y33333333','Carlos',1),
                                                         ('Y44444444','Lucas',1),
                                                         ('Y5555555','Javi',1);
INSERT INTO public.users (username,"password","role") VALUES
  ('zhuquing','pass123','ADMIN');
