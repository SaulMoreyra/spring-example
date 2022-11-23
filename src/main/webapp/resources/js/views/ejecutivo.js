const main = (() => {
	let divSecretarias = document.getElementById("container-secretarias");
	let divEstados = document.getElementById("container-estados");
	let btnEstados = document.getElementById("btn-estados");
	let btnSecretarias = document.getElementById("btn-secretarias");

	const showEstados = () => {
		divEstados.style.display = 'flex';
		divSecretarias.style.display = 'none';
	}

	const showSecretarias = () => {
		divSecretarias.style.display = 'flex';
		divEstados.style.display = 'none';
	}

	const init = () => {
		btnEstados.addEventListener('click', showEstados);
		btnSecretarias.addEventListener('click', showSecretarias);
	}
	
	return { init };
})();

document.addEventListener("DOMContentLoaded", main.init);
