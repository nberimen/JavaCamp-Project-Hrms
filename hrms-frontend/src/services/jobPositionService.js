import axios from "axios";

export default class JobPositionService {
getAllJobPositions = () =>{
    return axios.get("http://localhost:8080/api/positions/getall");
}

addJobPosition = jobPosition =>{
    return axios.post("http://localhost:8080/api/positions/add",jobPosition);
}
}