import axios from 'axios'

export default function EmployerService(){
    getAllEmployers = () => {
        return axios.get("http://localhost:8080/api/employers/getall");
    }
    registerEmployer = employer => {
        return axios.post("http://localhost:8080/api/employers/register", employer);
    }
}