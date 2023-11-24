document.addEventListener("DOMContentLoaded", function () {
  const slides = document.querySelectorAll('.slideImg');
  const slideContainer = document.getElementById('slideContainer');
  let currentSlide = 0;

  function showSlide(index) {
    slides.forEach((slide, i) => {
      if (i === index) {
        slide.style.display = 'block';
      } else {
        slide.style.display = 'none';
      }
    });
  }

  function nextSlide() {
    currentSlide = (currentSlide + 1) % slides.length;

    showSlide(currentSlide);
  }

  setInterval(nextSlide, 5000);
});
