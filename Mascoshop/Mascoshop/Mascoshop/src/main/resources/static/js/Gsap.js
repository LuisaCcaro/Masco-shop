document.addEventListener('DOMContentLoaded', () => {
    const gallery = document.querySelector(".gallery");

    let galleryWidth = gallery.offsetWidth;
    let ammountToScroll = galleryWidth - window.innerWidth;

    gsap.registerPlugin(ScrollTrigger);

    gsap.to(gallery, {
        x: -ammountToScroll,
        ease: "none",
        scrollTrigger: {
            trigger: ".gallery-wrapper",
            start: "top 30px",
            end: "+=" + ammountToScroll,
            pin: true,
            scrub: true,
        }
    });

    const lenis = new Lenis();

    function raf(time) {
        lenis.raf(time);
        requestAnimationFrame(raf);
    }

    requestAnimationFrame(raf);
});
