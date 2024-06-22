const saveProductButton = document.getElementById('save-product');
const productForm = document.getElementById('productForm');
const messageElement = document.getElementById('message');

saveProductButton.addEventListener('click', async () => {
    const formData = new FormData(productForm);

    const productData = {
        nombre: formData.get('nombre'),
        descripcion: formData.get('descripcion'),
        precio: parseFloat(formData.get('precio')),
        cantidadDisponible: parseInt(formData.get('cantidadDisponible')),
        categoriaProducto: { idPCategoria: parseInt(formData.get('idPCategoria')) },
        animal: { idAnimal: parseInt(formData.get('idAnimal')) },
        marca: { id_Marca: parseInt(formData.get('id_Marca')) },
        imagen: formData.get('imagen').name
    };

    formData.append('producto', new Blob([JSON.stringify(productData)], { type: 'application/json' }));

    try {
        const response = await axios.post('/api/productos', formData, {
            headers: {
                'Content-Type': 'multipart/form-data'
            }
        });
        messageElement.textContent = 'Producto agregado exitosamente';
    } catch (error) {
        console.error('Error al agregar producto:', error);
        messageElement.textContent = 'Error al agregar producto: ' + error.message;
    }
});
