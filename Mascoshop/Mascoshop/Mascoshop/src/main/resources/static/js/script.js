function signIn(){
    let oauthEndpoint = "https://accounts.google.com/o/oauth2/v2/auth"

    let form = document.createElement('form')
    form.setAttribute('method', ' GET')
    form.setAttribute('action', oauthEndpoint)


    let params = {
        "client_id":"1032767023549-eceqr0m60drtu1r9m3smnhkht2encr35.apps.googleusercontent.com",
        "redirect_uri":"http://localhost:9090/index.html",
        "response_type":"token",
        "scope":"https://www.googleapis.com/auth/userinfo.profile",
        "include_granted_scopes":"true",
        'state':'pass-through-value'
    }

    for(var p in params){
        let input = document.createElement('input')
        input.setAttribute('type', 'hidden')
        input.setAttribute('name', p)
        input.setAttribute('value', params[p])
        form.appendChild(input)
    }

    document.body.appendChild(form)

    form.submit()
}

function handleAuthResponse() {
    let hash = window.location.hash.substr(1);
    let result = hash.split('&').reduce((res, item) => {
        let parts = item.split('=');
        res[parts[0]] = parts[1];
        return res;
    }, {});

    if (result.access_token) {
        localStorage.setItem('googleToken', result.access_token);
        updateUIForLoggedInUser();
        showMessage('Inicio de sesión exitoso');
    }
}

function updateUIForLoggedInUser() {
    let loginButton = document.getElementById('loginButton');
    let logoutButton = document.getElementById('logoutButton');

    if (localStorage.getItem('googleToken')) {
        loginButton.style.display = 'none';
        logoutButton.style.display = 'contents';
    } else {
        loginButton.style.visibility = 'contents';
        logoutButton.style.display = 'none';
    }
}

function signOut() {
    localStorage.removeItem('googleToken');
    updateUIForLoggedOutUser();
    showMessage('Sesión cerrada');
    cancelSignOut();
}

document.addEventListener('DOMContentLoaded', (event) => {
    handleAuthResponse();
    updateUIForLoggedInUser();
});