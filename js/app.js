const menu = document.querySelector(".menu");
const openMenuBtn = document.querySelector(".open-menu-btn");
const closeMenuBtn = document.querySelector(".close-menu-btn"); 

[openMenuBtn, closeMenuBtn].forEach((btn) =>{
   btn.addEventListener("click", () => {
       menu.classList.toggle("open");
       menu.style.transition = "transform 0.5s ease";
   });
});


menu.addEventListener("transitionend", function(){
   this.removeAttribute("style");
});

menu.querySelectorAll(".dropdown > .productos").forEach((arrow) => {
   arrow.addEventListener("click", function() {
       this.closest(".dropdown").classList.toggle("active");
   });
});


// FinMenu

gsap.registerPlugin(ScrollTrigger);

const lenis = new Lenis();

function raf(time) {
    lenis.raf(time);
    requestAnimationFrame(raf);
}

requestAnimationFrame(raf);

document.addEventListener('DOMContentLoaded', function(){
    var typed = new Typed('.cambio', {
        strings: ['Gatos', 'Perros'],
        typeSpeed: 50,
        backSpeed: 30, 
        loop: true
    });
});

window.addEventListener("scroll", function(){
    var header = document.querySelector("nav");
    header.classList.toggle("sticky", window.scrollY > 0);
})


const showMenu = (toggleId, navId) =>{
    const toggle = document.getElementById(toggleId),
          nav = document.getElementById(navId)
 
    toggle.addEventListener('click', () =>{
        // Add show-menu class to nav menu
        nav.classList.toggle('show-menu')
 
        // Add show-icon to show and hide the menu icon
        toggle.classList.toggle('show-icon')
    })
 }
 
 showMenu('nav-toggle','nav-menu')

 /*------------------ Menu --------------*/

 
window.addEventListener("scroll", function(){
    var header = document.querySelector("header");
    header.classList.toggle("sticky", window.scrollY > 0);
});