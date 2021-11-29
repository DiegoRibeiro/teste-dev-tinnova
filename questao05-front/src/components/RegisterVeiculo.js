import React from "react";
import axios from "axios";

class RegisterVeiculo extends React.Component {
	constructor(props) {
		super(props);

		this.state = {
			fields: {}
		};

		this.handleInputChange = this.handleInputChange.bind(this);
		this.handleSubmit = this.handleSubmit.bind(this);
	}

	handleInputChange(event) {
		const target = event.target;
    	const value = target.type === 'checkbox' ? target.checked : target.value;
    	const name = target.name;

		this.setState({
			fields: {
				...this.state.fields,
				[name]: value
			}
		});
	}

	render() {
		return (
			<div>
				<form>
					<div>
						<span>
							<label>Veículo: </label>
							<input name="nome" onChange={this.handleInputChange}></input>
						</span>
						<span>
							<label>Marca: </label>
							<input name="marca" onChange={this.handleInputChange}></input>
						</span>
						<span>
							<label>ano: </label>
							<input name="ano" onChange={this.handleInputChange}></input>
						</span>
					</div>
					
					<div>
						<span>
							<label>Descricao: </label>
							<input name="descricao" onChange={this.handleInputChange}></input>
						</span>
						<span>
							<label>Vendido: </label>
							<input name="vendido" type="checkbox" onChange={this.handleInputChange}></input>
						</span>
						<span>
							<button onClick={this.handleSubmit} type="button">Cadastrar</button>
						</span>
					</div>
					
				</form>
			</div>
		);
	}

	handleSubmit() {
		console.log(this.state.fields);
		axios.post("http://localhost:8080/veiculos", this.state.fields).then((response) => {
			alert("Cadastro realizado com sucesso!");
		}).catch((err) => {
			alert("Erro inesperado");
		});
	}
}

export default RegisterVeiculo;