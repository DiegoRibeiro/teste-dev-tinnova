
import React from "react";
import "./Card.css";

class Card extends React.Component {
	render() {

		return (
			<div className="Card-border">
				<div>
					<label>Veículo:</label>
					<span>{this.props.veiculo.nome}</span>
				</div>
				
				<div>
					<label>Marca:</label>
					<span>{this.props.veiculo.marca}</span>
				</div>

				<div>
					<label>Ano:</label>
					<span>{this.props.veiculo.ano}</span>
				</div>

				<div>
					<label>Descrição:</label>
					<span>{this.props.veiculo.descricao}</span>
				</div>

				<div>
					<label>Vendido:</label>
					{this.props.veiculo.vendido ? <span>vendido</span> : <span>não vendido</span>}
				</div>

				<div>
					<label>Created:</label>
					<span>{this.props.veiculo.created}</span>
				</div>

				<div>
					<label>Updated:</label>
					<span>{this.props.veiculo.created}</span>
				</div>
			</div>
		);
	}

	
}

export default Card;