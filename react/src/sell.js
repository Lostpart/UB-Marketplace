import './App.css';
import React from 'react';
import Header from './header';
import './home.css';
import './sell.css';
import { handleAPIError } from './errors';

class Sell extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            name: '',
            price: ''
        };
        this.changeName = this.changeName.bind(this);
        this.changePrice = this.changePrice.bind(this);
    }
    
    changeName(event) {
        this.setState({name: event.target.value});
    }

    changePrice(event) {
        // Remove whitespaces
        let price = event.target.value.replace(/\s/g, "");
        // Reject input if it makes the price not a number
        if (isNaN(price)) return;

        // Get the specific dollars/cents
        let [dollars, cents] = price.split('.');
        // Remove leading 0's
        dollars = parseInt(dollars);
        if (cents) {
            // Remove fractions of cents
            if (cents.length > 2) {
                cents = cents.substring(0, 2);
            }
            price = `${dollars}.${cents}`;
        } else {
            // If the most recent character is a period, keep it.
            if (cents === '') {
                price = `${dollars}.`;
            } else price = dollars.toString();
        }
        this.setState({price: price})
    }

    handleSubmit(event) {
        event.preventDefault();
        /*
        const requestOptions = {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ 'hello': 'world' })
        };
        fetch('/api/register', requestOptions)
            .then(response => {
                if (response.status !== 200) {
                    handleAPIError(response);
                } else {
                    this.props.history.push('/login');
                }
            });
        */
    }
    
    render() {
        return (
            <div className="sell">
                <Header />
                <form onSubmit={this.handleSubmit}>
                    <label for="name">Item Name</label>
                    <input type="text" name="name" value={this.state.name} onChange={this.changeName} />

                    <label for="price">Item Price</label>
                    <input type="text" name="price" placeholder='$$$' value={this.state.price} onChange={this.changePrice} />
                    <input type="submit" value="Submit" />
                </form>
            </div>
        );
    }
}

export default Sell;