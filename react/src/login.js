import './App.css';
import './account_page.css';
import React from 'react';

class Login extends React.Component {
    constructor(props) {
        super(props);
        this.state = {username: '', password: ''};
        this.changeUsername = this.changeUsername.bind(this);
        this.changePassword = this.changePassword.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }
    
    changeUsername(event) {
        this.setState({username: event.target.value});
    }

    changePassword(event) {
        this.setState({password: event.target.value})
    }

    handleSubmit(event) {
        const requestOptions = {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ username: this.state.username, password: this.state.password })
        };
        fetch('/api/login', requestOptions)
            .then(response => response.json())
            .then(data => console.log(data));
        event.preventDefault();
    }
    
    render() {
        return (
            <div className='panel login'>
                <form onSubmit={this.handleSubmit}>
                    <label for="username">Name:</label>
                    <input type="text" name="username" value={this.state.username} onChange={this.changeUsername} />
                    <label for="password">Password</label>
                    <input type="password" name="password" value={this.state.password} onChange={this.changePassword} />

                    <input type="submit" value="Submit" />
                </form>
            </div>
        );
    }
}

export default Login;