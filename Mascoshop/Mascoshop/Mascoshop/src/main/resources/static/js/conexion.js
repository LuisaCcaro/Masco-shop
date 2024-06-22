document.querySelector('form').addEventListener('submit', async (e) => {
    e.preventDefault();

    const formData = new FormData(e.target);
    const formDataJson = Object.fromEntries(formData.entries());

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

            if (data.message === "Administrador - login exitoso") {
                window.location.href = '/admin.html';
            }else{
                window.location.href = '/index.html';
            }
        }
    } catch (error) {
        alert('Error: ' + error.message);
    }
});

document.querySelector('#form-register').addEventListener('submit', async (e) => {
    e.preventDefault();

    const formData = new FormData(e.target);
    const formDataJson = Object.fromEntries(formData.entries());

    try {
        const response = await fetch('/register', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(formDataJson),
        });

        if (!response.ok) {
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
function logOut() {
    localStorage.removeItem('supabaseToken');
    alert('Sesión cerrada');
    updateUIForLoggedInUser();
}



