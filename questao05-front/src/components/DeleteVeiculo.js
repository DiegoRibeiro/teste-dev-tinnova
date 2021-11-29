import React from "react";
import axios from "axios";

class DeleteVeiculo extends React.Component {
	constructor(props) {
		super(props);

		this.state = {
			inputId: ''
		};

		this.handleChange = this.handleChange.bind(this);
		this.deleteVeiculo = this.deleteVeiculo.bind(this);
	}

	handleChange(event) {
		this.setState({
			inputId: event.target.value
		})
		console.log(this.state);
	}

	render() {
		return (
			<div>
				<div>
					<label>Id do Veículo:</label>
					<input value={this.state.inputId} onChange={this.handleChange} type="number" min="1"></input>
					<button onClick={this.deleteVeiculo}>Remover</button>
				</div>
				
				<div>
					<h3>Realize a remoção por ID</h3>
				</div>
			</div>
		);
	}

	deleteVeiculo() {
		console.log(this.state)
		axios.delete(`http://localhost:8080/veiculos/${this.state.inputId}`).then((response) => {
			alert("Veículo removido com sucesso!")
		}).catch((err) => {
			alert("Erro inesperado.");
		});
	}
}

export default DeleteVeiculo;