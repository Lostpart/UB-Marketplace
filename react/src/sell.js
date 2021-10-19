import './App.css';
import React from 'react';
import Header from './header';
import './home.css';
import { handleAPIError } from './errors';

class Sell extends React.Component {
    constructor(props) {
        super(props);
        this.state = {username: '', password: ''};
        this.changeUsername = this.changeUsername.bind(this);
        this.changePassword = this.changePassword.bind(this);
        this.changeConfirm = this.changeConfirm.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }
    
    changeUsername(event) {
        this.setState({username: event.target.value});
    }

    changePassword(event) {
        this.setState({password: event.target.value})
    }

    changeConfirm(event) {
        this.setState({confirm: event.target.value})
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
                    <label for="username">Email</label>
                    <input type="text" name="username" value={this.state.username} onChange={this.changeUsername} />

                    <input type="submit" value="Submit" />
                </form>
            </div>
        );
    }
}

export default Sell;