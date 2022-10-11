const e = React.createElement

class LoginForm extends React.Component {
    constructor(props) {
        super(props)
        this.state = {
            username: '',
            password: ''
        }

        this.handleUsername = this.handleUsername.bind(this)
        this.handlePassword = this.handlePassword.bind(this)
        this.handleSubmit = this.handleSubmit.bind(this)
    }

    handleUsername(event) {
        this.setState({username: event.target.value})
    }

    handlePassword(event) {
        this.setState({password: event.target.value})
    }

    handleSubmit(event) {
        fetch('localhost:8080/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(this.state)
        })
        .catch(e => console.error(e))
        event.preventDefault()
    }

    render() {
        return e(
            'form',
            { onSubmit: this.handleSubmit, className: "d-flex flex-column align-items-center" },
            e('h1', null, 'Log In'),
            e('h3', null, 'Username'),
            e('input', { onChange: this.handleUsername, value: this.state.username }),
            e('h3', null, 'Password'),
            e('input', { onChange: this.handlePassword, value: this.state.password, type: 'password' }),
            e('button', { className: 'row w-25' }, 'Submit')
        )
    }
}

const root = ReactDOM.createRoot(document.querySelector('#login-form'))
root.render(e(LoginForm, null, null))
