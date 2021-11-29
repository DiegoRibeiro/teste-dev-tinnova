import React from "react";
import Card from "./Card";

class AllVeiculos extends React.Component {

	render() {
		let secao;
		if(this.props.veiculos.length > 0) {
			secao = this.props.veiculos.map((veiculo) => {
				return <Card veiculo={veiculo} key={veiculo.id}/>
			});
		} else {
			secao = <div>sem dados</div>
		}

		return (

			<div>
				<button onClick={() => this.props.listVeiculos()}>Listar todos veiculos</button>

				<div className="Content-container">{secao}</div>
			</div>
		);
	}
}

export default AllVeiculos;