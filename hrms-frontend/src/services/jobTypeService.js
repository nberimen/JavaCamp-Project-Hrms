import axios from "axios";

export default class JobTypeService {
getAllJobTypes = () =>{
    return axios.get("http://localhost:8080/api/jobTypes/getAll");
}

}