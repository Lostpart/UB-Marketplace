import './App.css';
import './account_page.css';
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
        /*
        const requestOptions = {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ username: this.state.username, password: this.state.password })
        };
        fetch('/api/register', requestOptions)
            .then(response => response.json())
            .then(data => console.log(data));
        */
        if (this.state.password === this.state.confirm) {
           this.props.history.push('/');
        } else {
            alert("The provided passwords do not match!");
        }
        event.preventDefault();
        
    }
    
    render() {
        return (
            <div>
                <h1>UB Marketplace</h1>
                <div className='panel login'>
                    <form onSubmit={this.handleSubmit}>
                        <label for="username">Username</label>
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