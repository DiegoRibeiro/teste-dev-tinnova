import React from "react";
import axios from "axios";
import CardRelatorio from "./CardRelatorio";

class Relatorios extends React.Component {
	constructor(props) {
		super(props);

		this.state = {
			currentList: []
		};

		this.searchNaoVendidos = this.searchNaoVendidos.bind(this);
		this.searchPorDecadas = this.searchPorDecadas.bind(this);
		this.searchPorFabricantes = this.searchPorFabricantes.bind(this);
		this.searchPorUltimaSemana = this.searchPorUltimaSemana.bind(this);
	}

	render() {


		return (
			<div>
				<h2>Relatórios</h2>
				<div>
					<button onClick={this.searchNaoVendidos}>Não vendidos</button>
					<button onClick={this.searchPorDecadas}>Veículos por decadas</button>
					<button onClick={this.searchPorFabricantes}>Veículos por fabricantes</button>
					<button onClick={this.searchPorUltimaSemana}>Registrados ultima semana</button>
				</div>

				<div>
					{this.state.currentList.length > 0 ? <CardRelatorio data={this.state.currentList}/> : <div>sem dados</div>}
				</div>
			</div>
		);
	}

	searchNaoVendidos() {
		axios.get("http://localhost:8080/veiculos/find?q=naovendidos").then((response) => {
			this.setState({
				currentList: response.data
			})
		});
	}

	searchPorDecadas() {
		axios.get("http://localhost:8080/veiculos/find?q=decadafabricacao").then((response) => {
			this.setState({
				currentList: response.data
			})
		});
	}

	searchPorFabricantes() {
		axios.get("http://localhost:8080/veiculos/find?q=fabricante").then((response) => {
			this.setState({
				currentList: response.data
			})
		});
	}

	searchPorUltimaSemana() {
		axios.get("http://localhost:8080/veiculos/find?q=ultimasemana").then((response) => {
			this.setState({
				currentList: response.data
			})
		});
	}
}

export default Relatorios;