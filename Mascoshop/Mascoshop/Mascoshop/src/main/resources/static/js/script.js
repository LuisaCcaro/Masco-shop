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
function signInSupabase() {
    const oauthEndpoint = "http://localhost:9090.supabase.co/auth/v1/oauth/authorize";

    const form = document.createElement('form');
    form.setAttribute('method', 'GET');
    form.setAttribute('action', oauthEndpoint);
    const params = {
        "client_id": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6InhpaHp5b3hreWRzZnV0YnlnbWZ4Iiwicm9sZSI6ImFub24iLCJpYXQiOjE3MTQzMjQ5OTQsImV4cCI6MjAyOTkwMDk5NH0.aLyIyNYJsup3z3Ly1uxvyBrx9OdmlZFFug6TXuK-rE4",
        "redirect_uri": "http://localhost:9090/index.html",
        "response_type": "token",
        "scope": "openid profile",
        "state": "pass-through-value",
       "apikey": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6InhpaHp5b3hreWRzZnV0YnlnbWZ4Iiwicm9sZSI6InNlcnZpY2Vfcm9sZSIsImlhdCI6MTcxNDMyNDk5NCwiZXhwIjoyMDI5OTAwOTk0fQ.ykSu2KMOl15VVnu5i3A3aNsqRydYm8DZrjFtu9U_dtM"
   };

  for (const key in params) {
        const input = document.createElement('input');
        input.setAttribute('type', 'hidden');
       input.setAttribute('name', key);
       input.setAttribute('value', params[key]);
        form.appendChild(input);
    }

   document.body.appendChild(form);
    form.submit();
}

function handleAuthResponse() {
    let hash = window.location.hash.substr(1);
    let result = hash.split('&').reduce((res, item) => {
        let parts = item.split('=');
        res[parts[0]] = parts[1];
        return res;
    }, {});

    if (result.access_token && !localStorage.getItem('googleToken')) {
        localStorage.setItem('googleToken', result.access_token);
        updateUIForLoggedInUser();
        alert('Inicio de sesión exitoso con Google');
    }else{
        if (result.access_token && !localStorage.getItem('supabaseToken')) {
            localStorage.setItem('supabaseToken', result.access_token);
            updateUIForLoggedInUser();
            alert('Inicio de sesión exitoso con Supabase');
        }
    }
}

function updateUIForLoggedInUser() {
    let loginButton = document.getElementById('loginButton');
    let logoutButton = document.getElementById('logoutButton');

    if (localStorage.getItem('googleToken')) {
        loginButton.style.display = 'none';
        logoutButton.style.display = 'contents';
    } else {
        if (localStorage.getItem('supabaseToken')) {
            loginButton.style.display = 'none';
            logoutButton.style.display = 'contents';
        }else{
            loginButton.style.visibility = 'contents';
            logoutButton.style.display = 'none';
        }
    }
}

function updateUIForLoggedOutUser() {
    let loginButton = document.getElementById('loginButton');
    let logoutButton = document.getElementById('logoutButton');

    loginButton.style.display = 'contents';
    logoutButton.style.display = 'none';
}

function signOut() {
    if (localStorage.getItem('googleToken')) {
        localStorage.removeItem('googleToken');
        alert('Sesión cerrada');
        updateUIForLoggedOutUser();
        window.location.href = 'http://localhost:9090/index.html';
    }else{
        localStorage.removeItem('supabaseToken');
        alert('Sesión cerrada');
        updateUIForLoggedOutUser();
        window.location.href = 'http://localhost:9090/index.html';
    }
    
}


document.addEventListener('DOMContentLoaded', (event) => {
    handleAuthResponse();
    updateUIForLoggedInUser();
});
