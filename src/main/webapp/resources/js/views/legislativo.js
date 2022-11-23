const main = (() => {
	let divOptions = document.getElementById("container-options");
	let divPartidos = document.getElementById("container-partidos");

	let btnSenado = document.getElementById("btn-senado");
	let btnDiputados = document.getElementById("btn-diputados");

	const showOptions = () => {
		divOptions.style.display = 'flex';
	}

	const showPartidos = () => {
		divPartidos.style.display = 'flex';
	}

	const hidePartidos = () => {
		divPartidos.style.display = 'none';
	}

	const init = () => {
		btnSenado.addEventListener('click', showOptions);
		btnDiputados.addEventListener('click', showOptions);
	}

	return { init, showPartidos, hidePartidos };
})();

document.addEventListener("DOMContentLoaded", main.init);