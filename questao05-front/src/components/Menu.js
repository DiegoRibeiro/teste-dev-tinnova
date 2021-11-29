import React from "react";
import "./Menu.css";

class Menu extends React.Component {
	render() {
		return (
			<div className="Menu-background">
				<ul className="Menu-bar">
					<li onClick={() => this.props.onSwitchSection('home')}>Home</li>
					<li onClick={() => this.props.onSwitchSection('registerVeiculo')}>Cadastro de Veículo</li>
					<li onClick={() => this.props.onSwitchSection('findById')}>Procurar por Id</li>
					<li onClick={() => this.props.onSwitchSection('updateVeiculo')}>Atualização de Veículo</li>
					<li onClick={() => this.props.onSwitchSection('deleteVeiculo')}>Excluir Veículo</li>
					<li onClick={() => this.props.onSwitchSection('findByQuery')}>Relatórios</li>
					
				</ul>
			</div>
		);
	}
}

export default Menu;