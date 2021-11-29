import React from "react";
import Card from "./Card";
import axios from "axios";

class FindById extends React.Component {
	constructor(props) {
		super(props);

		this.state = {
			veiculo: null,
			inputId: '',
			error: null
		}

		this.handleChange = this.handleChange.bind(this);
	}

	handleChange(event) {
		this.setState({
			inputId: event.target.value
		})
	}

	render() {
		return (
			<div>
				<div>
					<label>Id do Veículo:</label>
					<input value={this.state.inputId} onChange={this.handleChange} type="number" min="1"></input>
					<button onClick={() => this.searchVeiculo()}>Pesquisar</button>
				</div>
				
				<div>
					{this.state.error === null ? '' : <div>{this.state.error}</div>}
					{this.state.veiculo === null ? <h3>Realize sua busca por ID</h3> : <Card veiculo={this.state.veiculo} />}
				</div>
			</div>
		);
	}

	searchVeiculo() {
		axios.get(`http://localhost:8080/veiculos/${this.state.inputId}`).then((response) => {
			console.log(response);
			this.setState({
				veiculo: response.data
			})
		}).catch((err) => {
			this.setState({
				error: "Não foi possível encontrar um veículo com este ID"
			})
		});
	}
}

export default FindById;