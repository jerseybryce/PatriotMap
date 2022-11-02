const e = React.createElement

class SignupForm extends React.Component {
    constructor(props) {
        super(props)
        this.state = {
            email: '',
            confirm: '',
            password: ''
        }

        this.handleEmail = this.handleEmail.bind(this)
        this.handleConfirm = this.handleConfirm.bind(this)
        this.handlePassword = this.handlePassword.bind(this)
        this.handleSubmit = this.handleSubmit.bind(this)
    }

    handleEmail(event) {
        this.setState({email: event.target.value})
    }

    handleConfirm(event) {
        this.setState({confirm: event.target.value})
    }

    handlePassword(event) {
        this.setState({password: event.target.value})
    }

    handleSubmit(event) {
        console.log(this.state)
        fetch('localhost:8080/signup', {
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
                    placeholder: 'Enter a valid email address', onChange: this.handleEmail, value: this.state.email }
                )
            ),

           // Confirm Email
            e(
                'div', 
                { className: 'form-outline mb-3' },
                e('label', { className: 'form-label', htmlFor: 'form3Example4' }, e('font', { size: '+2' }, 'Confirm Email:')),
                e('input', { type: 'email', id: 'form3Example3', className: 'form-control form-control-lg', 
                    placeholder: 'Confirm email', onChange: this.handleConfirm, value: this.state.confirm }
                )
            ),

            // Password input
            e(
                'div', 
                { className: 'form-outline mb-2' }, 
                e('label', { className: 'form-label', htmlFor: 'form3Example5' }, e('font', { size: '+2' }, 'Password:')),
                e('input', { type: 'password', id: 'form3Example4', className: 'form-control form-control-lg', 
                    placeholder: 'Enter password', onChange: this.handlePassword, value: this.state.password })
            ),

            // Submit button
            e(
                'div', 
                { className: 'text-center text-lg-start mt-4 pt-2' }, 
                e('button', { className: 'btn btn-success btn-lg', style: { paddingLeft: '2.5rem', paddingRight: '2.5rem' }}, 'Sign Up'),
                e(
                    'p', 
                    { className: 'small fw-bold mt-2 pt-1 mb-0' }, 
                    "Already have an account? ", 
                    e('a', { href: 'login.html', className: 'link' }, 'Register')
                )
            )
        )
    }
}

const root = ReactDOM.createRoot(document.querySelector('#signup-form'))
root.render(e(SignupForm, null, null))
