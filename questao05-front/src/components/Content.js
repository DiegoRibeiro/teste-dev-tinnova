import React from "react";
import axios from "axios";
import "./Content.css";
import Menu from "./Menu";

// import de todas seções da single page app
import AllVeiculos from "./AllVeiculos";
import FindById from "./FindById";
import RegisterVeiculo from "./RegisterVeiculo";
import DeleteVeiculo from "./DeleteVeiculo";
import UpdateVeiculo from "./UpdateVeiculo";
import Relatorios from "./Relatorios";

class Content extends React.Component {
	constructor(props) {
		super(props);
		this.state = {
			veiculos: [],
			page: 'home'
		};
	}

	render() {
		return (

			<div>
				<Menu onSwitchSection={(page) => this.switchSection(page)}/>

				<div className="Content-container">
					{this.state.page === 'home' ? <AllVeiculos veiculos={this.state.veiculos} listVeiculos={() => this.listVeiculos()} />: ''}
					{this.state.page === 'findById' ? <FindById />: ''}
					{this.state.page === 'registerVeiculo' ? <RegisterVeiculo />: ''}
					{this.state.page === 'deleteVeiculo' ? <DeleteVeiculo />: ''}
					{this.state.page === 'updateVeiculo' ? <UpdateVeiculo />: ''}
					{this.state.page === 'findByQuery' ? <Relatorios />: ''}
				</div>
			</div>
		);
	}

	listVeiculos() {
		console.log("list veiculos");
		axios.get("http://localhost:8080/veiculos").then((response) => {
			console.log(response);
			this.setState({
				veiculos: response.data
			})
		}).catch((err) => {
			console.log(err);
		})
	}

	switchSection(sectionName) {
		this.setState({
			page: sectionName
		})
	}
}

export default Content;