const main = (() => {
  let divFederal = document.getElementById("sub-container-federal");
  let divEstatal = document.getElementById("sub-container-estatal");
  let btnFederal = document.getElementById("btn-federal");
  let btnEstatal = document.getElementById("btn-estatal");

  const showFederal = () => {
    divFederal.style.display = "flex";
    divEstatal.style.display = "none";
  };

  const showEstatal = () => {
    divEstatal.style.display = "flex";
    divFederal.style.display = "none";
  };

  const init = () => {
    btnFederal.addEventListener("click", showFederal);
    btnEstatal.addEventListener("click", showEstatal);
  };

  const mouseOverHandler = () => {
    $('.tooltip').tooltipster({ 
        	   animation: 'fade',
			   delay: 100,
			   interactive: true,
			   contentAsHTML: true,
			   arrowColor: "#21409a",
   });
  };
  
  const mouseClickHandler = () => {
    window.open("https://www.w3schools.com/", "nombre de la ventana", "width=400, height=400");
  };

  return { init, mouseOverHandler, mouseClickHandler };
  
})();

document.addEventListener("DOMContentLoaded", main.init);
