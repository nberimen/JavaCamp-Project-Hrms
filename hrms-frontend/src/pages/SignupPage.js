import React from 'react'
import Signup from '../components/Signup'
import signupPng from '../images/signup.png'
const SignupPage = () => {
    return (
        <div className="container mt-3">
            <div className="row">
                <div className="col-md-5">
                    <Signup/>
                </div>
                <div className="col-md-7 my-auto">
                    <img className="img-fluid w-100" src={signupPng} alt="singup png"/>
                </div>
            </div>
        </div>
    )
}

export default SignupPage
