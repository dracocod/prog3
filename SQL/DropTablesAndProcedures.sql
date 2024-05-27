DROP TABLE IF EXISTS DetallePedido;
DROP TABLE IF EXISTS DetalleFactura;
DROP TABLE IF EXISTS Factura;
DROP TABLE IF EXISTS Pedido;


DROP TABLE IF EXISTS Oferta;
DROP TABLE IF EXISTS Producto;
DROP TABLE IF EXISTS TipoProducto;
DROP TABLE IF EXISTS Almacen;
DROP TABLE IF EXISTS Usuario;

DROP PROCEDURE IF EXISTS InsertaUsuarioNatural;
DROP PROCEDURE IF EXISTS ActualizaUsuarioNatural;
DROP PROCEDURE IF EXISTS EliminaUsuarioNatural;
DROP PROCEDURE IF EXISTS ListaUsuariosNaturales;

DROP PROCEDURE IF EXISTS InsertaUsuarioJuridico;
DROP PROCEDURE IF EXISTS ActualizaUsuarioJuridico;
DROP PROCEDURE IF EXISTS EliminaUsuarioJuridico;
DROP PROCEDURE IF EXISTS ListaUsuariosJuridicos;

DROP PROCEDURE IF EXISTS InsertaAdministrador;
DROP PROCEDURE IF EXISTS ActualizaAdministrador;
DROP PROCEDURE IF EXISTS EliminaAdministrador;
DROP PROCEDURE IF EXISTS ListaAdministradores;

DROP PROCEDURE IF EXISTS ListarUsuariosXNombre;

DROP PROCEDURE IF EXISTS InsertaProducto;
DROP PROCEDURE IF EXISTS ActualizaProducto;
DROP PROCEDURE IF EXISTS EliminaProducto;
DROP PROCEDURE IF EXISTS ListaProductos;
DROP PROCEDURE IF EXISTS LISTAR_PRODUCTOS_POR_NOMBRE;

DROP PROCEDURE IF EXISTS InsertaFactura;
DROP PROCEDURE IF EXISTS ActualizaFactura;
DROP PROCEDURE IF EXISTS EliminaFactura;
DROP PROCEDURE IF EXISTS ListaFacturas;

DROP PROCEDURE IF EXISTS InsertaPedido;
DROP PROCEDURE IF EXISTS ActualizaPedido;
DROP PROCEDURE IF EXISTS EliminaPedido;
DROP PROCEDURE IF EXISTS ListaPedidos;

DROP PROCEDURE IF EXISTS InsertaDetallePedido;
DROP PROCEDURE IF EXISTS ActualizaDetallePedido;
DROP PROCEDURE IF EXISTS EliminaDetallePedido;
DROP PROCEDURE IF EXISTS ListaDetallePedidos;

DROP PROCEDURE IF EXISTS InsertaAlmacen;
DROP PROCEDURE IF EXISTS ActualizaAlmacen;
DROP PROCEDURE IF EXISTS EliminaAlmacen;
DROP PROCEDURE IF EXISTS ListaAlmacenes;

DROP PROCEDURE IF EXISTS InsertaTipoProducto;
DROP PROCEDURE IF EXISTS ActualizaTipoProducto;
DROP PROCEDURE IF EXISTS EliminaTipoProducto;
DROP PROCEDURE IF EXISTS ListaTiposProducto;

DROP PROCEDURE IF EXISTS InsertaOferta;
DROP PROCEDURE IF EXISTS ActualizaOferta;
DROP PROCEDURE IF EXISTS EliminaOferta;
DROP PROCEDURE IF EXISTS ListaOfertas;
