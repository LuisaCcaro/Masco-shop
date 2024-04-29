const login = document.getElementById('login'), 
        loginBtn = document.getElementById('btnLogin'),
        loginCls = document.getElementById('clsLogin')

loginBtn.addEventListener('click', () =>{
    login.classList.add('mostrarLogin')
})

clsLogin.addEventListener('click', () =>{
    login.classList.remove('mostrarLogin')
})