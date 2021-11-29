
import React from "react";
import "./Card.css";

class CardRelatorio extends React.Component {
	render() {
		const list = this.props.data.map((data, index) => {
			let items = [];
			let i = 0;
			for(let name in data) {
				items.push(<div key={index+i}>
					<label>{name}: </label>
					<span>{typeof data[name] === 'boolean' ? (data[name] ? 'sim' : 'não') : data[name]}</span>
				</div>)
				i++
			}

			return <div className="Card-border" key={index}>{items}</div>;
		});

		return (
			<div className="Card-border">
				<div>
					{list}
				</div>
				
			</div>
		);
	}

	
}

export default CardRelatorio;