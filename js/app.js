gsap.registerPlugin(ScrollTrigger);

const lenis = new Lenis();

function raf(time) {
    lenis.raf(time);
    requestAnimationFrame(raf);
}

requestAnimationFrame(raf);

document.addEventListener('DOMContentLoaded', function(){
    var typed = new Typed('.cambio', {
        strings: ['Mascotas', 'Gatos', 'Perros'],
        typeSpeed: 50,
        backSpeed: 30, 
        loop: true
    });
});

document.addEventListener("DOMContentLoaded", function(){
    const navbar = document.getElementById("navbar");
    window.addEventListener("scroll", function(){
        if(window.scrollY > 50){
            navbar.classList.add("scrolled");
        }else{
            navbar.classList.remove("scrolled");
        }
    });
});
