document.querySelector('form').addEventListener('submit', async (e) => {
    e.preventDefault(); // Evitar que se envíe el formulario de forma predeterminada

    const formData = new FormData(e.target); // Obtener datos del formulario
    const formDataJson = Object.fromEntries(formData.entries()); // Convertir a JSON

    try {
        const response = await fetch('/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(formDataJson),
        });

        if (!response.ok) {
            const errorData = await response.json();
            alert(errorData.message || 'Error de autenticación');
            window.location.reload();
        } else {
            const data = await response.json();
            alert(data.message);

            if (data.message === "login exitoso") {
                window.location.href = '/index.html';
            }
        }
    } catch (error) {
        alert('Error: ' + error.message);
    }
});

document.querySelector('#form-register').addEventListener('submit', async (e) => {
    e.preventDefault(); // Evitar que se envíe el formulario de forma predeterminada

    const formData = new FormData(e.target); // Obtener datos del formulario
    const formDataJson = Object.fromEntries(formData.entries()); // Convertir a JSON

    try {
        const response = await fetch('/register', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(formDataJson),
        });

        if (!response.ok) {
            // Si la respuesta no es OK, intenta obtener el mensaje de error
            const errorData = await response.json();
            throw new Error(errorData.message || 'Error al registrar usuario');
        } else {
            const data = await response.json();
            alert(data.message || 'Usuario creado exitosamente');
        }
    } catch (error) {
        alert('Error: ' + error.message);
    }
    window.location.reload();
});



function handleAuthResponse() {
    let hash = window.location.hash.substr(1);
    let result = hash.split('&').reduce((res, item) => {
        let parts = item.split('=');
        res[parts[0]] = parts[1];
        return res;
    }, {});

    if (result.access_token) {
        localStorage.setItem('supabaseToken', result.access_token);
        updateUIForLoggedInUserSupaBase();
        alert('Inicio de sesión exitoso');
    }
}

function updateUIForLoggedInUser() {
    let loginButton = document.getElementById('loginButton');
    let logoutButton = document.getElementById('logoutButton');

    if (localStorage.getItem('supabaseToken')) {
        loginButton.style.display = 'none';
        logoutButton.style.display = 'contents';
    } else {
        loginButton.style.display = 'contents';
        logoutButton.style.display = 'none';
    }
}

// Función para cerrar sesión
function logOut() {
    localStorage.removeItem('supabaseToken');
    alert('Sesión cerrada');
    updateUIForLoggedInUser();
}



