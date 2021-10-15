import './App.css';
import './account_page.css';
import { handleAPIError } from './errors';
import sha256 from 'js-sha256'
import React from 'react';

class Register extends React.Component {
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
        if (this.state.password !== this.state.confirm) {
             alert("The provided passwords do not match!");
             return;
        }
        if (this.state.password.length < 8) {
            alert("Password provided is too small!")
            return;
        }
        const requestOptions = {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ username: this.state.username, password: sha256(this.state.password) })
        };
        fetch('/api/register', requestOptions)
            .then(response => {
                if (response.status !== 200) {
                    handleAPIError(response);
                } else {
                    this.props.history.push('/login');
                }
            });
    }
    
    render() {
        return (
            <div>
                <h1>UB Marketplace</h1>
                <div className='panel login'>
                    <form onSubmit={this.handleSubmit}>
                        <label for="username">Email</label>
                        <input type="text" name="username" value={this.state.username} onChange={this.changeUsername} />
                        <label for="password">Password</label>
                        <input type="password" name="password" value={this.state.password} onChange={this.changePassword} />
                        <label for="confirm">Confirm Password</label>
                        <input type="password" name="confirm" value={this.state.confirm} onChange={this.changeConfirm} />

                        <input type="submit" value="Submit" />
                    </form>
                </div>
            </div>
        );
    }
}

export default Register;