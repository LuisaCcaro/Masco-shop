gsap.registerPlugin(ScrollTrigger);

const lenis = new Lenis();

function raf(time) {
    lenis.raf(time);
    requestAnimationFrame(raf);
}

requestAnimationFrame(raf);

// window.addEventListener("scroll", function(){
//     var header = document.querySelector("nav");
//     header.classList.toggle("sticky", window.scrollY > 0);
// });

document.addEventListener('DOMContentLoaded', function(){
    var typed = new Typed('.cambio', {
        strings: ['Gatos', 'Perros'],
        typeSpeed: 50,
        backSpeed: 30, 
        loop: true
    });
});