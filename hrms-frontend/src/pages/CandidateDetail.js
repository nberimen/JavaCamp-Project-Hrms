import React, { useEffect, useState } from 'react'
import { useParams } from 'react-router'
import { Card, Icon, Image } from 'semantic-ui-react'
import CandidateService from '../services/candidateService'
export default function CandidateDetail() {
    let {id}=useParams()
    
    const [candidate, setCandidate] = useState({})

    useEffect(() => {
        let candidateService =new CandidateService()
        candidateService.getById(id).then(result=>setCandidate(result.data.data))
    }, [])

    return (
        <div>
            <Card>
                <Image src="https://res.cloudinary.com/nberimen/image/upload/v1622709683/sample.jpg" wrapped ui={false} />
                <Card.Content>
                    <Card.Header>{candidate.firstName+" "+candidate.lastName}</Card.Header>
                    <Card.Meta></Card.Meta>
                    <Card.Description>{candidate.dateOfBirth}</Card.Description>
                </Card.Content>
                <Card.Content extra>
                    <Icon name='user' />
                </Card.Content>
            </Card>
        </div>
    )
}
