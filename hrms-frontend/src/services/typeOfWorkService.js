import axios from "axios";

export default class TypeOfWorkService {
getAllTypesOfWork = () =>{
    return axios.get("http://localhost:8080/api/typesOfWork/gellAll");
}

}