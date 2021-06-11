import React from 'react'
import { Grid } from 'semantic-ui-react'
import CandidateList from '../pages/CandidateList';
import JobPosition from './JobPosition'
import { Route } from 'react-router';
import CandidateDetail from '../pages/CandidateDetail';

export default function Dashboard() {
    return (
        <div>
            <Grid>
                <Grid.Row>

                    <Grid.Column width={4}>
                        <JobPosition/>
                    </Grid.Column>

                    <Grid.Column width={12}>
                    <Route exact path="/" component={CandidateList}/>
                    <Route exact path="/candidates" component={CandidateList}/>
                    <Route path="/candidates/:id" component={CandidateDetail}/>

                    </Grid.Column>

                </Grid.Row>
            </Grid>


        </div>


    );
}
