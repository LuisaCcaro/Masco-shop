document.addEventListener('DOMContentLoaded', () => {
    
    // const lenis = new Lenis();

    // function raf(time) {
    //     lenis.raf(time);
    //     requestAnimationFrame(raf);
    // }

    // requestAnimationFrame(raf);
    const lenis = new Lenis({
        duration: 1.2,
        easing: (t) => Math.min(1, 1.001 - Math.pow(2, -10 * t)),
        smooth: true,
    });
    
    function raf(time) {
        lenis.raf(time);
        requestAnimationFrame(raf);
    }
    
    requestAnimationFrame(raf);
    
    // Manejo de enlaces de anclaje con Lenis
    document.querySelectorAll('a[href^="#"]').forEach(anchor => {
        anchor.addEventListener('click', function(e) {
            e.preventDefault();
            const targetId = this.getAttribute('href').substring(1);
            const targetElement = document.getElementById(targetId);
    
            if (targetElement) {
                lenis.scrollTo(targetElement);
            }
        });
    });

    var typed = new Typed('.cambio', {
        strings: ['Gatos', 'Perros'],
        typeSpeed: 50,
        backSpeed: 30, 
        loop: true
    });

    //buscador

    //


    // window.addEventListener("scroll", function(){
    //     var nav = document.querySelector("nav");
    //     nav.classList.toggle("sticky", window.scrollY > 5);
    // })



    // let animado = document.querySelectorAll(".animado");

    // function mostrarScroll(){
    //     let scrollTop = document.documentElement.scrollTop;
    //     for(var i = 0; i < animado.length; i++){
    //         let alturaAnimado = animado[i].offsetTop;
    //         if(alturaAnimado - 600 < scrollTop){
    //             animado[i].style.opacity = 1;
    //         }
    //     }
    // }
    // window.addEventListener('scroll', mostrarScroll);

    // ScrollReveal({
    //     reset: false,
    //     distance: '20px',
    //     duration: 1800,
    //     delay: 200
    // });
    // ScrollReveal().reveal('.atencionCliente', { delay: 400 });
    // ScrollReveal().reveal('.logo', { delay: 400 });
    // ScrollReveal().reveal('.login', { delay: 400 });
    // ScrollReveal().reveal('.wrapper', { delay: 500 });
    // ScrollReveal().reveal('.info', { delay: 600 });
    // ScrollReveal().reveal('.portada', { delay: 600 });


    //carrito
    const cartHover = document.getElementById("cart-hover");
    const cartItemsHover = document.getElementById("cart-items-hover");
    const addToCartButtons = document.querySelectorAll(".add-cart");
    const emptyCartMessage = document.querySelector(".empty-cart-message");
    const cartItemCount = document.getElementById("cart-item-count");
    let itemCount = 0;
    
    addToCartButtons.forEach((button) => {
      button.addEventListener("click", () => {
        const productName = button.closest(".content-card-product").querySelector("h3").textContent;
    
        const cartItem = document.createElement("div");
        cartItem.textContent = productName;
        
        const deleteButton = document.createElement("button");
        deleteButton.textContent = "Eliminar";
        deleteButton.classList.add("delete-button"); // Agregar clase para el estilo del botón
        deleteButton.addEventListener("click", () => {
          cartItemsHover.removeChild(cartItem); // Eliminar el producto del carrito
          itemCount--; // Restar el contador de productos
          updateCartCounter(); // Actualizar el contador en el hover del carrito
          if (itemCount === 0) {
            cartHover.style.display = "none"; // Ocultar el hover del carrito si no hay productos
            emptyCartMessage.classList.remove("hidden"); // Mostrar el mensaje de carrito vacío
          }
        });
        
        cartItem.appendChild(deleteButton);
        cartItemsHover.appendChild(cartItem);
        itemCount++; // Incrementar el contador de productos
        updateCartCounter(); // Actualizar el contador en el hover del carrito
        cartHover.style.display = "block"; // Mostrar el hover del carrito
        emptyCartMessage.classList.add("hidden"); // Ocultar el mensaje de carrito vacío
      });
    });
    
    // Función para actualizar el contador de productos en el hover del carrito
    function updateCartCounter() {
      cartItemCount.textContent = itemCount;
    }
});

const searchInput = document.getElementById('search');
const suggestionsContainer = document.getElementById('suggestions');

const data = [
    'Comida secos para perros',
    'Comida secos para gatos',
    'Comida humedos para perros',
    'Comida humedos para gatos',
    'Especial para perros',
    'Especial para gatos',
    'Snacks para perros',
    'Snacks para gatos'
];

searchInput.addEventListener('input', () => {
    const inputValue = searchInput.value.toLowerCase();
    suggestionsContainer.innerHTML = '';
    
    if (inputValue) {
        const filteredData = data.filter(item => item.toLowerCase().includes(inputValue));
        
        filteredData.forEach(item => {
            const suggestionDiv = document.createElement('div');
            suggestionDiv.textContent = item;
            suggestionsContainer.appendChild(suggestionDiv);
            
            suggestionDiv.addEventListener('click', () => {
                searchInput.value = item;
                suggestionsContainer.innerHTML = '';
            });
        });
    }
});

var swiper = new Swiper(".mySwiper", {
    slidesPerView: 3,
    spaceBetween: 30,
    // loop: true,
    // loopFillGroupWithBlank: true,
    pagination: {
      el: ".swiper-pagination",
      clickable: true,
    },
    navigation: {
      nextEl: ".swiper-button-next",
      prevEl: ".swiper-button-prev",
    },
  });