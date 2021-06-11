import React, { useState } from 'react'
import { Container, Menu } from 'semantic-ui-react'
import SignedIn from './SignedIn'
import SignedOut from './SignedOut'
import { useHistory } from 'react-router'
export default function Navi() {

    const [isAuthenticated, setIsAuthenticated] = useState(true)
    const history = useHistory()

    function handleSignOut() {
        setIsAuthenticated(false)
        history.push("/")
    }
    function handleSignIn() {
        setIsAuthenticated(true)
    }

    return (
        <div>

            <Menu inverted >
                <Container>
                    <Menu.Item
                    name="Home"
                    />
                    <Menu.Menu position='right'>
                        {isAuthenticated ? <SignedIn signOut={handleSignOut} /> : <SignedOut signIn={handleSignIn} />}
                    </Menu.Menu>
                </Container>
            </Menu>

        </div>
    )
}
