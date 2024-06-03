document.addEventListener('DOMContentLoaded', () => {
    
    const lenis = new Lenis();

    function raf(time) {
        lenis.raf(time);
        requestAnimationFrame(raf);
    }

    requestAnimationFrame(raf);

    var typed = new Typed('.cambio', {
        strings: ['Gatos', 'Perros'],
        typeSpeed: 50,
        backSpeed: 30, 
        loop: true
    });

    // window.addEventListener("scroll", function(){
    //     var nav = document.querySelector("nav");
    //     nav.classList.toggle("sticky", window.scrollY > 5);
    // })



    let animado = document.querySelectorAll(".animado");

    function mostrarScroll(){
        let scrollTop = document.documentElement.scrollTop;
        for(var i = 0; i < animado.length; i++){
            let alturaAnimado = animado[i].offsetTop;
            if(alturaAnimado - 600 < scrollTop){
                animado[i].style.opacity = 1;
            }
        }
    }
    window.addEventListener('scroll', mostrarScroll);

    ScrollReveal({
        reset: false,
        distance: '20px',
        duration: 1800,
        delay: 200
    });
    ScrollReveal().reveal('.atencionCliente', { delay: 400 });
    ScrollReveal().reveal('.logo', { delay: 400 });
    ScrollReveal().reveal('.login', { delay: 400 });
    ScrollReveal().reveal('.wrapper', { delay: 500 });
    ScrollReveal().reveal('.info', { delay: 600 });
    ScrollReveal().reveal('.portada', { delay: 600 });

});

