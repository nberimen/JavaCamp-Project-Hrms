import React, { useEffect, useState } from 'react'
import CandidateService from '../services/candidateService'
import { Table } from 'semantic-ui-react'
import { Link } from 'react-router-dom'

export default function CandidateList() {
  const [candidates, setCandidates] = useState([])

  useEffect(() => {
    let candidateService = new CandidateService()
    candidateService.getAllCandidates().then(result => setCandidates(result.data.data))
  }, [])
  return (
    <div>
      <Table celled inverted selectable>
        <Table.Header>
          <Table.Row>
            <Table.HeaderCell>Id</Table.HeaderCell>
            <Table.HeaderCell>Name</Table.HeaderCell>
            <Table.HeaderCell>Date of Birth</Table.HeaderCell>
            <Table.HeaderCell>E-Mail</Table.HeaderCell>
            <Table.HeaderCell>GitHub</Table.HeaderCell>
            <Table.HeaderCell>LinkedIn</Table.HeaderCell>
          </Table.Row>
        </Table.Header>
        <Table.Body>
          {
            candidates.map(candidate => (
              <Table.Row key={candidate.id}>
                <Table.Cell><Link to={`/candidates/${candidate.id}`}>{candidate.id}</Link></Table.Cell>
                <Table.Cell>{candidate.firstName + " " + candidate.lastName}</Table.Cell>
                <Table.Cell>{candidate.dateOfBirth}</Table.Cell>
                <Table.Cell>{candidate.email}</Table.Cell>
                { <Table.Cell>{candidate.resume.githubAccount}</Table.Cell>}
                { <Table.Cell>{candidate.resume.linkedinAccount}</Table.Cell>}
              </Table.Row>
            ))
          }

        </Table.Body>
      </Table>
    </div>
  )
}
