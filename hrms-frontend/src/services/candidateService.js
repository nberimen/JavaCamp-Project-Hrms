import axios from 'axios'
export default class CandidateService {
    registerCandidate = candidate => {
        return axios.post("http://localhost:8080/api/candidates/register", candidate);
    }
    getAllCandidates = () => {
        return axios.get("http://localhost:8080/api/candidates/getall");
    }
    createResume = (resume, candidateId) => {
        return axios.post(`http://localhost:8080/api/candidates/createresume/${candidateId}`, resume);

    }
    getById=(id)=>{
        return axios.get("http://localhost:8080/api/candidates/getById?id="+id)
    }
}
