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
        console.log(this.state)
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
            { onSubmit: this.handleSubmit },
            // Email input
            e(
                'div', 
                { className: 'form-outline mb-4' },
                e('label', { className: 'form-label', htmlFor: 'form3Example3' }, e('font', { size: '+2' }, 'Email Address:')),
                e('input', { type: 'email', id: 'form3Example3', className: 'form-control form-control-lg', 
                    placeholder: 'Enter a valid email address', onChange: this.handleUsername, value: this.state.username }
                )
            ),

            // Password input
            e(
                'div', 
                { className: 'form-outline mb-3' }, 
                e('label', { className: 'form-label', htmlFor: 'form3Example4' }, e('font', { size: '+2' }, 'Password:')),
                e('input', { type: 'password', id: 'form3Example4', className: 'form-control form-control-lg', 
                    placeholder: 'Enter password', onChange: this.handlePassword, value: this.state.password })
            ),

            // Checkbox container
            e(
                'div',
                { className: 'd-flex justify-content-between align-items-center' },

                // Checkbox
                e(
                    'div',
                    { className: 'form-check mb-0' },
                    e('input', { className: 'form-check-input me-2', type: 'checkbox', value: '', id: 'form2Example3' }),
                    e('label', { className: 'form-check-label', htmlFor: 'form2Example3' }, 'Remember me')
                ),
                e('a', { href: '#!', className: 'text-body' }, 'Forgot password?')
            ),

            // Login button
            e(
                'div', 
                { className: 'text-center text-lg-start mt-4 pt-2' }, 
                e('button', { className: 'btn btn-success btn-lg', style: { paddingLeft: '2.5rem', paddingRight: '2.5rem' }}, 'Login'),
                e(
                    'p', 
                    { className: 'small fw-bold mt-2 pt-1 mb-0' }, 
                    "Don't have an account? ", 
                    e('a', { href: '#!', className: 'link-danger' }, 'Register')
                )
            )
        )
    }
}

const root = ReactDOM.createRoot(document.querySelector('#login-form'))
root.render(e(LoginForm, null, null))
