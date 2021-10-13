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
        this.goToRegistration = this.goToRegistration.bind(this);
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
        /*
        fetch('/api/login', requestOptions)
            .then(response => response.json())
            .then(data => console.log(data));
        */
       this.props.history.push('/')
        event.preventDefault();
        
    }

    goToRegistration(event) {
        localStorage.setItem('hello', 'world')
        this.props.history.push('/register')
    }
    
    render() {
        return (
            <div>
                <h1>UB Marketplace</h1>
                <div className='panel login'>
                    <form onSubmit={this.handleSubmit}>
                        <label htmlFor="username">Email</label>
                        <input type="text" name="username" value={this.state.username} onChange={this.changeUsername} />
                        <label htmlFor="password">Password</label>
                        <input type="password" name="password" value={this.state.password} onChange={this.changePassword} />

                        <div class="options">
                            <input type="submit" value="Submit" />

                            <button onClick={this.goToRegistration}> 
                                Register
                            </button>

                            <a href="forgot.html">
                                <input type="button" value="Forgot Username/Password" />
                            </a>
                        </div>
                    </form>
                </div>
            </div>
        );
    }
}

export default Login;