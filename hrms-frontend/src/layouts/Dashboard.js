import React from 'react'
import { BrowserRouter as Router, Switch, Route } from "react-router-dom";
import JobAdvertPage from '../pages/JobAdvertPage'
import HomePage from '../pages/HomePage';
import SignupPage from '../pages/SignupPage';

export default function Dashboard() {
    return (
        <Router>
            <div>
                <Switch>
                    <Route exact path="/" component={HomePage} />
                    <Route exact path="/home" component={HomePage} />
                    <Route exact path="/advert-job" component={JobAdvertPage} />
                    <Route exact path="/signup" component={SignupPage} />
                </Switch>
            </div>
        </Router>
    );
}