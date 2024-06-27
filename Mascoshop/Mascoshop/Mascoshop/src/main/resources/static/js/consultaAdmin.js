document.addEventListener('DOMContentLoaded', function() {
    const tableBody = document.querySelector('#productos-table tbody');

    function loadProductos() {
        fetch('/api/productos')
            .then(response => response.json())
            .then(productos => {
                // Limpia solo el contenido del cuerpo de la tabla
                tableBody.innerHTML = '';
                
                productos.forEach(producto => {
                    const row = document.createElement('tr');
                    row.innerHTML = `
                        <td>${producto.idProducto}</td>
                        <td>${producto.nombre}</td>
                        <td>${producto.descripcion}</td>
                        <td>${producto.precio}</td>
                        <td>${producto.cantidadDisponible}</td>
                        <td>${producto.animal ? producto.animal.nombre : ''}</td>
                        <td>${producto.marca ? producto.marca.nombre : ''}</td>
                        <td>${producto.categoriaProducto ? producto.categoriaProducto.nombre : ''}</td>
                        <td><img src="img/${producto.imagen}" width="50"></td>
                        <td><button>Delete</button></td>
                    `;
                    tableBody.appendChild(row);
                });
            })
            .catch(error => console.error('Error al cargar productos:', error));
    }

    
    loadProductos();

    // Recarga la lista de productos cada 5 segundos
      setInterval(loadProductos, 5000);
});


