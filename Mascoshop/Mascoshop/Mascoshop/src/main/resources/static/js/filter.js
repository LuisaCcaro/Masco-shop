document.addEventListener("DOMContentLoaded", function() {
    const allCheckbox = document.getElementById('all');
    const secosCheckbox = document.getElementById('secos');
    const humedosCheckbox = document.getElementById('humedos');
    const medicadoCheckbox = document.getElementById('especial');
    const snacksCheckbox = document.getElementById('snack');
    const productContainers = document.querySelectorAll('.container-products .card-product');
  
    const checkboxes = [allCheckbox, secosCheckbox, humedosCheckbox, medicadoCheckbox, snacksCheckbox];
  
    checkboxes.forEach(checkbox => {
      checkbox.addEventListener('change', filterProducts);
    });
  
    function filterProducts() {
      let selectedCategories = [];
      if (secosCheckbox.checked) selectedCategories.push('secos');
      if (humedosCheckbox.checked) selectedCategories.push('humedos');
      if (medicadoCheckbox.checked) selectedCategories.push('medicado');
      if (snacksCheckbox.checked) selectedCategories.push('snacks');
  
      productContainers.forEach(product => {
        if (selectedCategories.length === 0 || selectedCategories.some(category => product.classList.contains(category))) {
          product.style.display = 'block';
        } else {
          product.style.display = 'none';
        }
      });
  
      if (allCheckbox.checked) {
        productContainers.forEach(product => {
          product.style.display = 'block';
        });
        checkboxes.forEach(checkbox => {
          if (checkbox !== allCheckbox) {
            checkbox.checked = false;
          }
        });
      } else {
        allCheckbox.checked = false;
      }
    }
  });
  